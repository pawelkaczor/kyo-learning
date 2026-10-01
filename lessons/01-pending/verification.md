# Lesson 1 verification

Verified on 2026-10-01 with Kyo 1.0.0-RC7, Scala 3.9.0, sbt 1.12.13, and Temurin JDK 25.0.4+7-LTS. `project/plugins.sbt` pins the released `sbt-kyo-test-publish:1.0.0-RC7`.

Commands actually run:

```sh
java -version
sbt -Dsbt.global.base="$(mktemp -d /tmp/kyo-rc7-sbt.XXXXXX)" clean verify 'lesson01Exercises/test' 'show lesson01Exercises/Test/fullClasspath' 'show lesson01Reference/Test/fullClasspath'
```

Both commands exited 0. The sbt run used a fresh global directory with the existing dependency cache. Setup printed `Kyo JVM workspace is ready.` and the greeting app printed `Hello, Ada!`. All 15 test executions passed: 4 examples, 6 reference tests, and 5 acceptance tests for the preserved learner implementation. Root `verify` still excludes exercises; their tests ran explicitly after it.

The resolved exercise and reference test classpaths contain only RC7 Kyo artifacts, including `kyo-test-api` and `kyo-test-runner`, from the Maven Central cache. Neither contains the other implementation's classes. The RC7 plugin and base plugin release artifacts are also present in the Maven Central cache.

Both forked applications emit the Scala `LazyVals` deprecation warning about `sun.misc.Unsafe::objectFieldOffset` on JDK 25; both exit successfully. This checks the current lesson's executable behavior on RC7, not every framework feature or an RC7 source audit. No learner code, acceptance tests, or reference implementations were changed. No CI result is claimed.

## Behaviors checked

- Automatic lifting of `42` into `Int < Any` and `.eval` back to 42.
- `Env.run` supplies the chosen prefix; the same pending greeting responds to two different supplied configurations. Empty-name formatting was also checked.
- Effectful `map` and a for-comprehension capture identical exact console output.
- Annotated intermediate types compile, including `Unit < (Env[GreetingConfig] & Sync)` before provision and `Unit < Sync` afterward.
- Compile-time checks reject dropping an `Env` requirement and calling `.eval` on unhandled `Env` or `Sync`.
- Checkout acceptance covers two configurations, quantities zero/one/many, delivery charged once, free delivery, free items with paid delivery, and receipt formatting. The reference also passes the independent new-configuration case.
