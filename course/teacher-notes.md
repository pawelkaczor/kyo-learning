# Teacher preparation

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

## Preparation horizon

- Current: Lesson 1 is prepared and verified; deliver one segment at a time.
- Opening segment: pending result/row, `Env.get`, pure `map`, `Env.run`, and fully handled `.eval`.
- Remaining Lesson 1 segments: effectful `map`, ordinary for-comprehensions, `Console` versus `Sync`, and `KyoApp` as the application boundary. Checkout exercise and isolated reference are ready.
- Next lesson outline only: typed failure with `Abort`, `Result`, and the row remaining after handling.
- Distant modules: indexed only.

## Lesson 1 preparation evidence

On 2026-09-05, inspected only RC6 pending-type operations, `Env`, the relevant `Console` methods, `KyoApp`, and the test adapter. The four framework source files were compared with the immutable release commit and matched the published source jars byte for byte. No sibling checkout was modified.

Verified automatic lifting, pure and effectful `map`, equivalent for-comprehension output, configuration provision, remaining effect annotations, and rejection of `.eval` on unhandled effects. Do not imply every Scala expression becomes lazy simply because its expected type is pending.

`kyo-test_3:1.0.0-RC6` returned HTTP 404. The published `kyo-zio-test` adapter provides `kyo.test.KyoSpecDefault`. Its POM puts `zio-test-sbt` in test scope, which is not inherited by consumers. Added explicit `zio-test-sbt:2.1.26` and `zio.test.sbt.ZTestFramework` registration. A fresh sbt global directory verifies that tests are discovered without global plugins.

The exercise starter compiles and has targeted expected failures. The shared acceptance source is compiled independently by the exercises and reference, with no project dependency between them. The reference solves the main exercise and independent variation. A representative wrong answer was rejected, then restored. See [Lesson 1 verification](../lessons/01-pending/verification.md) for commands and outcomes. Keep reference implementation details in its own directory.

## Teaching update, 2026-09-06

Reviewed the opening prediction and continued with the already verified effectful `map` example. The post-handler type prediction was correct; exact string punctuation needed correction. Use the remaining-effect transfer question to check the explanation behind the type answer. See [progress](progress.md) for the pending prompt.

Restored Lesson 1 knowledge from the teacher refresher and existing source. No API changes, new source investigation, or new test runs were needed. Verification remains the recorded 2026-09-05 result. The learner subsequently answered the remaining-effect transfer correctly, including why `.eval` is unavailable. Introduce the prepared for-comprehension and `KyoApp` boundary, then offer only `subtotal` as the first implementation step. The rest of the exercise remains available in the written instructions. No additional source investigation or execution was needed for this continuation.

## Checkout review, 2026-09-06

The learner moved ahead to all three functions; review them together and adapt the pace. Ran `sbt 'lesson01Exercises/test'` on the actual learner source: compilation succeeded, four acceptance tests passed, the receipt-format test failed, exit 1. The only observed acceptance mismatch is the requested exact output format. Effect composition and arithmetic, including the zero/free-item boundaries, are correct within the exercise domain. Preserve the learner's conditional implementation and formatting choice as their attempt; request the contract correction without rewriting it.

Use the plain-value versus pending-computation branches in the learner's own `total` as the next short explanation question. No new framework investigation was needed. The earlier preparation verification remains dated separately; this run is learner-review evidence. The independent variation is still pending.

## Checkout follow-up, 2026-09-06

The learner corrected receipt formatting and identified automatic lifting in the conditional branches. Re-ran `sbt 'lesson01Exercises/test'`: compilation succeeded, all five acceptance tests passed, exit 0. The main implementation is complete; the independent test variation remains pending. Explain lifting as adapting the plain value to the expected pending type without introducing a new effect operation. The overall `total` still requires the environment, including through `subtotal` on the zero-quantity path. This uses already verified lesson semantics; no new framework investigation was needed.

## Source caution

The online overview and local checkout are orientation aids. Their API descriptions are not proof of behavior in the pinned Maven release. Confirm each taught claim against matching source and executable evidence. See [sources.md](sources.md).

Preparation notes describe the teacher's evidence. They do not imply that the learner understands the material. Move any future reference answers into their lesson's reference directory rather than displaying them in routine progress summaries.
