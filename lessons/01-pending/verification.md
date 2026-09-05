# Lesson 1 verification

Prepared and verified on 2026-09-05. Ready to teach; no learner implementation or mastery is implied.

## Baseline and provenance

- Kyo 1.0.0-RC6, Scala 3.8.4, sbt 1.12.13, Temurin JDK 25.0.4+7-LTS.
- Release commit: `2e58c0550b209317b85a30fc5787c24b7e4dd63c`.
- ZIO test runner: 2.1.26, matching the published Kyo ZIO test adapter POM.
- Published source jars were read for `kyo/kernel/Pending.scala`, `kyo/Env.scala`, the relevant `kyo/Console.scala` methods, and `kyo/KyoApp.scala`. Each file was fetched from the release commit and compared byte for byte with its jar entry; all four matched. Immutable links are in [the lesson](lesson.md).
- Read `KyoSpecAbstract.scala` and `KyoSpecDefault.scala` from the published RC6 `kyo-zio-test` source jar. The adapter POM's runner dependency is test scoped, so a consumer needs its own runner dependency and framework registration. Both are explicit in the root build.
- The `kyo-test_3` source artifact at RC6 returned HTTP 404. No version was changed; the published `kyo-zio-test` adapter was used.

## Commands and observed outcomes

1. `java -version`: Temurin 25.0.4, build 25.0.4+7-LTS.
2. `sbt 'lesson01Examples/test' 'lesson01Exercises/Test/compile' 'lesson01Reference/test'`: the initial development run failed during example-test compilation due to an incorrectly escaped string and a nonexistent console capture method. Corrected to a triple-quoted compile-test string and the release's `Console.withOut` with `Out.stdOut` fields. No behavior assertion was weakened.
3. Repeated the same command after corrections: exit 0. Four example tests passed; the untouched exercise and acceptance sources compiled; five reference acceptance tests passed.
4. `sbt 'lesson01Exercises/test'`: exit 1 as intended. One test passed and four failed. Placeholder zeros satisfy only the zero-items case; subtotal, nonempty delivery, free delivery/free items, and receipt cases fail targeted assertions rather than throwing from unfinished code.
5. `sbt 'lesson01Reference/testOnly learning.lesson01.CheckoutSpec'` with a temporary representative wrong reference: exit 1, four tests passed and one failed. The free-items boundary rejected the wrong implementation. The reference was restored immediately, and the learner starter was never replaced. Mutation details are in [the reference record](reference/README.md).
6. After adding the reference's independent-variation test, ran:

   ```sh
   sbt -Dsbt.global.base="$(mktemp -d)" verify 'show lesson01Exercises/Test/fullClasspath' 'show lesson01Reference/Test/fullClasspath' 'show root/aggregate'
   ```

   Exit 0 with a fresh global sbt directory. Setup printed `Kyo JVM workspace is ready.` Four example tests and six reference tests passed. The greeting app printed `Hello, Ada!` followed by a newline. Explicit test discovery works without user-global plugins.

## Behaviors and isolation checked

- Automatic lifting of `42` into `Int < Any` and `.eval` back to 42.
- `Env.run` supplies the chosen prefix; the same pending greeting responds to two different supplied configurations. Empty-name formatting was also checked.
- Effectful `map` and a for-comprehension capture identical exact console output.
- Annotated intermediate types compile, including `Unit < (Env[GreetingConfig] & Sync)` before provision and `Unit < Sync` afterward.
- Compile-time checks reject dropping an `Env` requirement and calling `.eval` on unhandled `Env` or `Sync`.
- Checkout acceptance covers two configurations, quantities zero/one/many, delivery charged once, free delivery, free items with paid delivery, and receipt formatting. The reference also passes the independent new-configuration case.
- The printed exercise test classpath contains no reference classes, and the reference test classpath contains no exercise classes. Both compile the same acceptance source independently.
- The root build's project aggregate contains setup, examples, and reference. The unfinished exercise is absent from both that aggregate and the `verify` alias. The final command's `show root/aggregate` displays task aggregation settings, so the project-membership claim comes from inspecting the build definition.
- No unsafe bridge was added. Pure tests use `.eval` only after full environment handling; console tests use `KyoSpecDefault`; the runnable example uses `KyoApp`.

The two forked application runs emitted the existing Scala `LazyVals` warning about deprecated `sun.misc.Unsafe::objectFieldOffset` on JDK 25. sbt labels forked stderr `[error]`; both applications exited successfully. The warning remains unsuppressed. There are no remaining preparation blocks. CI was not run or claimed.
