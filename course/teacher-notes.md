# Teacher preparation

Current baseline: Kyo `1.0.0-RC7`, Scala `3.9.0`, and the released `sbt-kyo-test-publish:1.0.0-RC7` plugin. Read the [verification record](../lessons/01-pending/verification.md) for the passing examples, exercise tests, reference tests, and classpath checks.

## Verified orientation

On 2026-09-05, read the framework's top-level overview and contributor guidance, and the online overview. Indexed top-level module names without opening module READMEs or implementation files.

The course uses a separate JVM consumer build with published artifacts. Scala and FP preliminaries are unnecessary. The teaching skill and file-based progress record are the continuity mechanism between sessions.

## Restore after a session restart

Use repository files as the durable record even when previous conversation context is unavailable. The teaching skill already directs the teacher to this file; follow the links below to restore only the relevant knowledge.

1. Read [progress](progress.md) for the learner's evidence, unresolved prompt, and next action, and [sources](sources.md) for the pinned versions.
2. Read the current lesson's teacher refresher: [Lesson 1](../lessons/01-pending/teacher-notes.md). It links concise verified conclusions to code, source evidence, and important limits.
3. Read the relevant segment of the learner's lesson and its executable source. For review, read the learner's actual attempt and acceptance tests. Reference solutions remain separate and are not shown automatically.
4. Consult the lesson's verification record before treating a behavior as established. Reuse recorded evidence at the same version; a session restart alone does not require repeating the whole source investigation or build. Recheck when code, dependencies, environment, conflicting evidence, or a new claim makes it necessary. Describe old checks as previously verified, never as newly run.
5. Resume at the unresolved learner step. If a needed fact is missing or uncertain, inspect only the matching source or run a focused check, then record the useful conclusion and its evidence.

## Maintaining teacher knowledge

Keep this file a short index and preparation horizon. Maintain a concise `teacher-notes.md` beside each prepared lesson with verified semantic conclusions, evidence links, failed API assumptions worth avoiding, and explicit boundaries or open questions. Update that refresher when teaching or a focused detour adds useful knowledge. Link earlier lessons when knowledge is reused instead of copying whole explanations into every note.

Learner materials also serve as teacher references. Their source files and tests supply executable examples; `verification.md` supplies dated outcomes; `reference/` holds solution-specific reasoning. The reusable skill holds the teaching process rather than a growing Kyo API manual. Store conclusions and evidence, not conversation transcripts or a detailed account of internal reasoning.

## Optional API lookup tool: Cellar

Available for teacher preparation as of 2026-09-07: Cellar `0.1.0-M13` (native executable). Use it for focused JVM dependency signature and source lookup before opening large source files. It is a lookup aid; semantic and runtime claims still need matching source or executable evidence. It does not change the pinned build or replace sbt verification.

Use explicit course-version coordinates for API lookups, for example:

```sh
cellar get-external io.getkyo:kyo-prelude_3:1.0.0-RC7 kyo.Env.get
```

This RC7 lookup command is an example, not a recorded verification result. Native kyo-test shares the RC7 release baseline; consult the current build and resolved project classpath. Use installed command help before an unfamiliar invocation, and retain useful conclusions and evidence in the relevant lesson notes. No whole-module research is implied by tool availability.

## Preparation horizon

- Current: Lesson 1 is prepared and verified; deliver one segment at a time.
- Opening segment: pending result/row, `Env.get`, pure `map`, `Env.run`, and fully handled `.eval`.
- Remaining Lesson 1 segments: effectful `map`, ordinary for-comprehensions, `Console` versus `Sync`, and `KyoApp` as the application boundary. Checkout exercise and isolated reference are ready.
- Next lesson outline only: typed failure with `Abort`, `Result`, and the row remaining after handling.
- Distant modules: indexed only.

## Lesson 1 preparation evidence

The RC7 example tests verify automatic lifting, pure and effectful `map`, equivalent for-comprehension output, configuration provision, remaining effect annotations, and rejection of `.eval` on unhandled effects. Do not imply every Scala expression becomes lazy simply because its expected type is pending.

The native test suites use `kyo.test.Test[Any]`. The released plugin supplies the test runner. Shared acceptance source is compiled independently by the exercises and reference, with no project dependency between them. All 15 example, exercise, and reference tests pass. See [Lesson 1 verification](../lessons/01-pending/verification.md) for commands and outcomes. Keep reference implementation details in its own directory.

## Teaching handoff

The learner has explained the remaining-effect distinction and automatic lifting, and completed the main checkout implementation. The independent configuration/test variation remains pending. Read [progress](progress.md) for the learning evidence and exact next prompt. Preserve the learner's implementation and review the variation before recording completion of the whole lesson.

## Source caution

The online overview and local checkout are orientation aids. Their API descriptions are not proof of behavior in the pinned Maven release. Confirm each taught claim against matching source and executable evidence. See [sources.md](sources.md).

Preparation notes describe the teacher's evidence. They do not imply that the learner understands the material. Move any future reference answers into their lesson's reference directory rather than displaying them in routine progress summaries.
