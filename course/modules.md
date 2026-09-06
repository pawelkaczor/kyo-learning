# Ecosystem coverage

Indexed on 2026-09-05 from the top-level README and directory names at orientation commit `404463ca5f4cf7c5e1823d420efa91a0a0cc6a2e`. No individual module documentation or implementation was opened. Categories come from the overview and are navigation aids, not a dependency graph.

Every entry starts `indexed`, which means its name is known, not that it has been studied. Advance to `prepared`, `introduced`, `practised`, or `demonstrated` only with the corresponding teacher or learner evidence. Add lesson links and concrete topic coverage as work proceeds; one lesson rarely establishes mastery of an entire module.

Release availability, JVM requirements, and whether an entry is a published library or supporting project remain unchecked until preparation. Entries absent from the overview need classification then. This inventory is not a promise that all entries ship in RC6. Reconcile published artifact variants at deliberate upgrades, without browsing all module internals.

| Entry | Overview category | Coverage | Lesson/evidence |
|---|---|---|---|
| `kyo-actor` | Concurrency | indexed | None |
| `kyo-aeron` | Specialized tools | indexed | None |
| `kyo-ai` | Applications | indexed | None |
| `kyo-bench` | Dev tools | indexed | None |
| `kyo-browser` | Specialized tools | indexed | None |
| `kyo-caliban` | Applications | indexed | None |
| `kyo-case-app` | Dev tools | indexed | None |
| `kyo-combinators` | Writing style | indexed | None |
| `kyo-compat` | Interop | indexed | None |
| `kyo-compiler` | Specialized tools | indexed | None |
| `kyo-config` | Applications | indexed | None |
| `kyo-core` | Core | introduced (limited) | [Lesson 1](../lessons/01-pending/lesson.md). Console.printLine, Sync in the row, and KyoApp boundary introduced. Learner correctly explained that remaining Sync prevents eval; runtime use not yet practised. |
| `kyo-data` | Core | indexed | None |
| `kyo-direct` | Writing style | indexed | None |
| `kyo-doctest` | Dev tools | indexed | None |
| `kyo-examples` | Dev tools | indexed | None |
| `kyo-ffi` | Specialized tools | indexed | None |
| `kyo-flow` | Applications | indexed | None |
| `kyo-http` | Applications | indexed | None |
| `kyo-i18n` | Applications | indexed | None |
| `kyo-jsonrpc` | Specialized tools | indexed | None |
| `kyo-jsonrpc-http` | Not listed in overview | indexed | None |
| `kyo-kernel` | Core | introduced (limited) | [Lesson 1](../lessons/01-pending/lesson.md). Pending type, pure/effectful map, combined rows, and fully handled eval introduced. Two type predictions reviewed, including the reason eval is unavailable with Sync remaining. Implementation pending. |
| `kyo-logging-jpl` | Observability | indexed | None |
| `kyo-logging-slf4j` | Observability | indexed | None |
| `kyo-lsp` | Specialized tools | indexed | None |
| `kyo-markdown` | Applications | indexed | None |
| `kyo-mcp` | Specialized tools | indexed | None |
| `kyo-net` | Specialized tools | indexed | None |
| `kyo-offheap` | Concurrency | indexed | None |
| `kyo-parse` | Specialized tools | indexed | None |
| `kyo-pod` | Specialized tools | indexed | None |
| `kyo-prelude` | Core | introduced (limited) | [Lesson 1](../lessons/01-pending/lesson.md). Env.get and supplying one configuration with Env.run. Other APIs unstudied. |
| `kyo-reactive-streams` | Interop | indexed | None |
| `kyo-scheduler` | Core | indexed | None |
| `kyo-scheduler-finagle` | Scheduler interop | indexed | None |
| `kyo-scheduler-pekko` | Scheduler interop | indexed | None |
| `kyo-scheduler-zio` | Scheduler interop | indexed | None |
| `kyo-schema` | Applications | indexed | None |
| `kyo-schema-bson` | Applications | indexed | None |
| `kyo-schema-ion` | Applications | indexed | None |
| `kyo-schema-json` | Applications | indexed | None |
| `kyo-schema-msgpack` | Applications | indexed | None |
| `kyo-schema-protobuf` | Applications | indexed | None |
| `kyo-schema-tests` | Not listed in overview | indexed | None |
| `kyo-schema-yaml` | Applications | indexed | None |
| `kyo-slack` | Specialized tools | indexed | None |
| `kyo-sql` | Applications | indexed | None |
| `kyo-sql-mysql` | Applications | indexed | None |
| `kyo-sql-postgres` | Applications | indexed | None |
| `kyo-sql-tests` | Not listed in overview | indexed | None |
| `kyo-stats-machine` | Observability | indexed | None |
| `kyo-stats-otlp` | Observability | indexed | None |
| `kyo-stats-registry` | Observability | indexed | None |
| `kyo-stm` | Concurrency | indexed | None |
| `kyo-system` | Core | indexed | None |
| `kyo-tasty` | Specialized tools | indexed | None |
| `kyo-test` | Testing | indexed | RC6 Maven artifact probe returned 404; use the verified `kyo-zio-test` adapter for Lesson 1. No module study. |
| `kyo-ui` | Applications | indexed | None |
| `kyo-website` | Not listed in overview | indexed | None |
| `kyo-website-bundle` | Not listed in overview | indexed | None |
| `kyo-zio` | Interop | indexed | None |
| `kyo-zio-test` | Testing | prepared (test infrastructure) | [Lesson 1](../lessons/01-pending/lesson.md). RC6 standalone KyoSpecDefault and explicit ZIO sbt runner registration verified. |
