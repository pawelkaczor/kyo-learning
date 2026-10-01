# Sources and versions

Updated on 2026-10-01.

## Executable baseline

| Component | Pin | Evidence |
|---|---|---|
| Kyo | `1.0.0-RC7` | Pinned in [build.sbt](../build.sbt) |
| Native test plugin | `1.0.0-RC7` | `io.getkyo:sbt-kyo-test-publish`, pinned in [project/plugins.sbt](../project/plugins.sbt) |
| Scala | `3.9.0` | Pinned in [build.sbt](../build.sbt) |
| sbt | `1.12.13` | Pinned in `project/build.properties`; selected from the local framework build tooling |
| JDK | 25 | Selected and checked locally; CI uses Temurin 25 |

The examples, exercises, and reference projects enable `SbtKyoTestPlugin`. The released plugin supplies the matching RC7 native test API and runner. Application dependencies also use RC7. See [Lesson 1 verification](../lessons/01-pending/verification.md) for executed checks and resolved classpath evidence.

## Orientation sources

- [Online overview](https://getkyo.io/latest/): navigation aid; this URL is mutable, so check API claims against the pinned release.
- [Top-level README at the orientation checkout commit](https://github.com/pawelkaczor/kyo/blob/404463ca5f4cf7c5e1823d420efa91a0a0cc6a2e/README.md): read locally; used for the ecosystem index.
- [Contributor guide at that commit](https://github.com/pawelkaczor/kyo/blob/404463ca5f4cf7c5e1823d420efa91a0a0cc6a2e/CONTRIBUTING.md): contributor conventions and relevant API, style, and testing guidance.

The orientation checkout and published release are different revisions. The module ledger describes the orientation checkout, not a verified list of RC7 artifacts. Some directories may be supporting projects or have different publication status. Check availability when their lesson is prepared.

## Maintenance policy

Keep release versions fixed during a lesson. Use matching release source and focused executable checks for API claims. Current online docs can suggest what to investigate; the pinned build establishes the course's dependency versions.

If an API requires a later version, discuss a deliberate upgrade before changing the course baseline. Use published release dependencies for the shared build.

An upgrade includes checking artifact availability, compiling and running prepared examples and reference solutions, reviewing exercise compatibility without overwriting learner attempts, and updating the module ledger and current documentation. Replace obsolete version guidance and verification records rather than retaining migration history.
