# Sources and versions

Recorded on 2026-09-05.

## Executable baseline

| Component | Pin | Evidence |
|---|---|---|
| Kyo | `1.0.0-RC6` | [Maven metadata](https://repo.maven.apache.org/maven2/io/getkyo/kyo-core_3/maven-metadata.xml) and published POM |
| Scala | `3.8.4` | [Kyo core release POM](https://repo.maven.apache.org/maven2/io/getkyo/kyo-core_3/1.0.0-RC6/kyo-core_3-1.0.0-RC6.pom) declares this Scala library version |
| sbt | `1.12.13` | Pinned in `project/build.properties`; selected from the local framework build tooling |
| JDK | 25 | Selected and checked locally; CI uses Temurin 25 |

Release tag `v1.0.0-RC6` resolves to commit `2e58c0550b209317b85a30fc5787c24b7e4dd63c`. [Release source tree](https://github.com/getkyo/kyo/tree/2e58c0550b209317b85a30fc5787c24b7e4dd63c).

## Orientation sources

- [Online overview](https://getkyo.io/latest/): accessed on the date above; page title identifies RC6, but the URL is mutable.
- [Top-level README at the orientation checkout commit](https://github.com/pawelkaczor/kyo/blob/404463ca5f4cf7c5e1823d420efa91a0a0cc6a2e/README.md): read locally; used for the ecosystem index.
- [Contributor guide at that commit](https://github.com/pawelkaczor/kyo/blob/404463ca5f4cf7c5e1823d420efa91a0a0cc6a2e/CONTRIBUTING.md): contributor conventions and relevant API, style, and testing guidance.

The orientation checkout and published release are different revisions. The module ledger describes the orientation checkout, not a verified list of RC6 artifacts. Some directories may be supporting projects or have different publication status. Check availability when their lesson is prepared.

## Maintenance policy

Keep release versions fixed during a lesson. Use immutable source links for API claims, alongside the lesson's actual commands and results. Current docs can suggest what to investigate; matching source, public API docs, and tests establish what the selected version does.

If an API exists only in a later version, record that fact and discuss a deliberate upgrade before changing the shared course baseline. Never silently substitute a snapshot, `publishLocal`, or a local framework dependency.

An upgrade includes checking artifact availability, compiling and running existing prepared examples and reference solutions, reviewing learner exercise compatibility without overwriting attempts, and updating the module ledger and this record. Keep enough version history for old lesson commits to remain reproducible.

## Lesson 1 release checks

The [Lesson 1 verification record](../lessons/01-pending/verification.md) covers the matching published source files for pending computations, Env, Console, and KyoApp. Each matched the release commit above. The published [Kyo ZIO test adapter POM](https://repo.maven.apache.org/maven2/io/getkyo/kyo-zio-test_3/1.0.0-RC6/kyo-zio-test_3-1.0.0-RC6.pom) pins ZIO 2.1.26. Its `KyoSpecAbstract.scala` and `KyoSpecDefault.scala` source files were read from the matching source jar. The original consumer build explicitly pinned `zio-test-sbt` to 2.1.26; the migration below removes that dependency.

## kyo-test migration, 2026-09-06

The requested migration explicitly permits the locally published test tooling. `project/plugins.sbt` pins `io.getkyo:sbt-kyo-test-publish` to `0.0.0+3296-404463ca+20260906-1812-SNAPSHOT`. Its published source jar was inspected: `SbtKyoTestPlugin` injects `kyo-test-runner_3` at that same version, and its base plugin registers `kyo.test.runner.SbtFramework`. [Build-wiring instructions](https://getkyo.io/latest/kyo-test/#build-wiring) were checked on this date; that mutable page is migration guidance, not RC6 release evidence.

The examples, exercises, and reference projects enable the plugin. Direct `kyo-zio-test` and `zio-test-sbt` dependencies were removed. The locally published test API and runner request snapshot `kyo-core`, `kyo-data`, and `kyo-scheduler`; lesson settings override those three to RC6 to preserve the course baseline. All migrated suites compile and pass with these overrides. The resolved exercise/reference classpaths contain only RC6 non-test Kyo libraries plus the snapshot test API/runner, and no ZIO artifacts. See [migration checks](../lessons/01-pending/verification.md#kyo-test-migration-2026-09-06).

This verifies the current lesson's use of native kyo-test against RC6, not compatibility of every snapshot test-framework feature. The plugin, base plugin, API, and runner snapshot artifacts must be available to a fresh machine or CI; they are not published release dependencies. No sibling framework checkout was modified by this migration.
