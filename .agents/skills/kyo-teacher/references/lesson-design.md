# Lesson design and verification

Use this reference when creating or revising a lesson. Keep the scope small enough that the teacher can explain and verify every introduced API.

## Learner materials

`lessons/NN-topic/lesson.md` should state the learning goal and actual prerequisites, explain why the concept exists, and walk through a small program. Annotate important intermediate types and outcomes. Link the complete runnable source and exact run command. Explain a common misconception and end with a short transfer question and links to matching authoritative sources.

`exercises.md` should give a precise task, file to edit, exact compile/test command, expected behavior, and acceptance criteria. Include prediction or explanation as well as implementation. Start with guided application and add a small independent variation. Avoid introducing several unfamiliar modules in one exercise. Optional challenges must be clearly optional.

`hints.md` should order hints from conceptual guidance to more specific pointers. Link it as an optional resource instead of embedding the full answer beside the question.

The `reference/` project contains the teacher's verified implementation and reasoning. Keep it separate from `exercises/`, with no dependency from the learner project to the reference project. Share acceptance tests only in a way that cannot expose a reference implementation on the learner classpath.

The learner can browse public reference files. Do not describe a directory as private or hidden. Avoid showing answers in routine summaries, terminal output, or progress files.

## Build shape

Use a root sbt build with centralized versions. Create `lessonNNExamples`, `lessonNNExercises`, and `lessonNNReference` subprojects only as needed. Each uses ordinary Scala source/test layouts under its corresponding lesson directory. Scope module dependencies to the lesson. Do not create another framework checkout or rely on unpublished artifacts.

Extend root `verify` to run all prepared example/reference checks. Leave unfinished learner projects out of root verification and the root aggregate. Provide explicit commands such as `sbt 'lesson01Exercises/test'` once that project actually exists. Verify command names from the build rather than copying proposed names blindly.

Verify the chosen Kyo test framework's standalone registration and dependencies against the pinned release when first adding tests. A source-checkout test convention is not proof that a consumer build needs no extra configuration.

Exercise starters should compile where practical and fail targeted behavior checks rather than crash on `???`. If the concept itself is a compile error, isolate the snippet or use an appropriate compile-time assertion and explain the expected diagnostic. Never leave an intentionally broken source in the normal examples build.

## Verification record

In `verification.md`, record:

- Kyo, Scala, sbt and JDK versions, plus source revision used for the API.
- Commands actually run and their outcomes.
- Concrete example outputs and assertions checked.
- Starter checks expected to fail and the observed reason.
- Reference solution results, and evidence the acceptance check rejects a representative wrong answer.
- Any remaining preparation block. A required unchecked behavior means the lesson is not ready.

Avoid untested Scala snippets in explanatory prose. Use links to tested files or explicitly label a type sketch or intentionally invalid example. If prose includes executable excerpts, verify that they match tested source.

## Completion evidence

A lesson can be ready for teaching while the learner has not started it. Record these separately. A useful learner milestone combines a correct implementation with an explanation or successful variation. Preserve the learner's own wording where helpful without retaining personal conversation details. Revisit a concept when evidence suggests confusion, not according to an arbitrary calendar.
