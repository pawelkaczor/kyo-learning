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

The [Lesson 1 verification record](../lessons/01-pending/verification.md) covers the matching published source files for pending computations, Env, Console, and KyoApp. Each matched the release commit above. The published [Kyo ZIO test adapter POM](https://repo.maven.apache.org/maven2/io/getkyo/kyo-zio-test_3/1.0.0-RC6/kyo-zio-test_3-1.0.0-RC6.pom) pins ZIO 2.1.26. Its `KyoSpecAbstract.scala` and `KyoSpecDefault.scala` source files were read from the matching source jar. The course explicitly pins the consumer's `zio-test-sbt` runner to 2.1.26.
