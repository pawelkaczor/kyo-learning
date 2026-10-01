# Workspace verification

Verified locally on 2026-10-01 with Kyo 1.0.0-RC7, Scala 3.9.0, sbt 1.12.13, Temurin JDK 25.0.4+7-LTS, and the released RC7 native test plugin.

The [Lesson 1 verification record](../lessons/01-pending/verification.md) contains the exact command and classpath checks. The run used a fresh sbt global directory and the existing dependency cache:

- `clean verify` passed. Setup printed `Kyo JVM workspace is ready.`, the greeting app printed `Hello, Ada!`, and all 10 example/reference tests passed.
- The separately requested `lesson01Exercises/test` passed all 5 tests for the current learner implementation.
- Exercise and reference implementations remain on separate classpaths. All resolved Kyo dependencies use RC7.

Both application runs emitted the Scala `LazyVals` deprecation warning about `sun.misc.Unsafe::objectFieldOffset` on JDK 25. Both exited successfully with the expected output.

The GitHub workflow runs `sbt verify` on JDK 25. These are local results; no CI result is claimed.
