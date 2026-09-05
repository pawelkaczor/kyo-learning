# Workspace verification

Verified locally on 2026-09-05 with Temurin JDK 25.0.4, sbt 1.12.13, Scala 3.8.4, and published Kyo 1.0.0-RC6.

- `sbt verify`: passed, exit code 0. Compiled `learning.SetupCheck`, ran its forked JVM, and observed `Kyo JVM workspace is ready.`
- Repeated `clean` and `verify` with `-Dsbt.global.base` pointing to a fresh temporary directory: passed, exit code 0. No user-global sbt plugins were required.
- Skill creator's `quick_validate.py`: passed for `kyo-teacher`.
- Relative Markdown links: all targets exist.
- Ecosystem index: 63 entries from top-level names only. No individual module source or README opened.

Both JVM application runs emitted a deprecation warning for `sun.misc.Unsafe::objectFieldOffset` called by `scala.runtime.LazyVals$` in Scala's runtime jar. sbt prefixes forked stderr with `[error]`, but both processes exited successfully and produced the expected output. The warning was not suppressed. No assertion, compilation failure, or runtime exception occurred. These checks establish that the consumer workspace works; they do not establish any learner mastery or validate future lessons.

The GitHub workflow runs the same `sbt verify` command on JDK 25. CI results are available on the repository's Actions page; do not infer a CI pass from the local results above.
