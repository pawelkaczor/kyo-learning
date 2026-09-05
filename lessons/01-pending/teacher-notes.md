# Teacher refresher: Lesson 1

Scope: Kyo 1.0.0-RC6, Scala 3.8.4, JVM. Verified on 2026-09-05 against release commit `2e58c0550b209317b85a30fc5787c24b7e4dd63c`. This is a concise retrieval aid for the teacher. The linked lesson, code, and verification record remain the detailed evidence. These notes contain no exercise solution.

## Restore the conceptual model

| Conclusion to restore | Evidence and boundary |
|---|---|
| `A < S` describes a possible result and pending effects. `Any` in the effect position means no remaining requirements. Ordinary values lift automatically. | [Greeting.scala](examples/src/main/scala/learning/lesson01/Greeting.scala): `plain`, `message`, `configured`; [GreetingSpec](examples/src/test/scala/learning/lesson01/GreetingSpec.scala): plain/fully handled values and compile-time rejection checks. |
| Kyo's `map` is bind: its callback may return another pending computation; the resulting row combines the two rows with `&`. `flatMap` supports ordinary for-comprehensions with the same composition behavior. | Release `Pending.scala`, linked from [lesson sources](lesson.md#release-evidence); `announce` and `announceFor` compile with the same row and pass an exact captured-output comparison. The lesson's general signature is a simplified type sketch with contextual parameters omitted. |
| `Env.get[R]` requests an `R`; mapping its value does not supply the requirement. Providing the configuration with `Env.run` removes the supplied requirement. | `message` and `configured`; the same greeting computation was checked under two different prefixes. The full release signature supports more than the one-configuration use taught here; do not extrapolate to untested handler combinations. |
| Handling `Env` leaves other effects pending. `.eval` requires `A < Any`. | `configuredAnnouncement` compiles as `Unit < Sync`. Compile-time tests reject `.eval` on unhandled `Env` and `Sync`, and reject dropping an `Env` requirement. |
| An API name need not appear as an effect in the row. | RC6 `Console.printLine` returns `Unit < Sync`. `GreetingApp` submits the remaining computation to `KyoApp.run`; no custom unsafe runner was added. |
| A pending type is not a promise that arbitrary Scala expressions become lazy. | Source inspection: the pending representation admits ordinary values and lifting; `map` has a plain-value path. Timing/laziness beyond this caution was not an experiment in this lesson. Investigate a concrete timing claim before teaching it. |

## Operational facts worth retaining

Use `kyo-zio-test` at the course pin. Its published source provides `kyo.test.KyoSpecDefault`. The standalone build explicitly includes `zio-test-sbt:2.1.26` and registers `zio.test.sbt.ZTestFramework`. The adapter POM's test-scoped runner dependency does not supply a consumer runner. A fresh sbt global directory verified actual test discovery.

The verified console capture API is `Console.withOut`, returning an `Out` whose output fields are `stdOut` and `stdErr`. `Console.collect` was a rejected guess during preparation. Do not repeat it.

[Verification](verification.md) records commands, exact outputs, four example tests, six reference tests, the starter's one pass/four expected failures, and rejection of a representative wrong reference. Read the [build](../../build.sbt) for actual command definitions. Root `verify` excludes the learner project. Exercise and reference classpaths are separate; their acceptance source is shared without sharing implementations.

## Teaching handoff

Read [learner progress](../../course/progress.md) for the actual stopping point. It is authoritative for what has been introduced or demonstrated; this prepared refresher is not learner evidence. Lesson 1 is divided into the initial pending/Env model, effectful composition, then the application boundary and checkout exercise.

Use [lesson.md](lesson.md) for the explanation, [exercises.md](exercises.md) for acceptance criteria, and progressive hints only as needed. Consult `reference/` for teacher preparation or review, keeping solution content out of routine responses.

## Limits and next investigation

Do not infer mastery or preparation of whole modules from this lesson. `Abort`, `Result`, handler ordering, multiple distinct environment requirements, scheduling, resource lifetime, and runtime internals have not been prepared here. The next lesson remains an outline on typed failure and handling. Keep new investigation focused on the learner's next question or that lesson.
