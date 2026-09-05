# Learning Kyo

An incremental, JVM-focused course for a Scala programmer who already knows functional programming. We learn Kyo through explanations, small working programs, exercises, and discussion. There is no Scala or FP prerequisite course and no deadline.

## Start here

This repository is independent of the Kyo framework build. It uses published Maven artifacts, not `publishLocal`, a source dependency, or a git submodule.

Use JDK 25 and sbt. From this repository:

```sh
sbt verify
```

The setup check compiles and runs a small Kyo application. Success prints `Kyo JVM workspace is ready.` The pinned versions are Kyo `1.0.0-RC6`, Scala `3.8.4`, and sbt `1.12.13`. JDK 25 is the selected course runtime, not a claim about Kyo's minimum supported JDK.

Open this directory as a separate Codex project. The teaching skill is versioned at [.agents/skills/kyo-teacher/SKILL.md](.agents/skills/kyo-teacher/SKILL.md). A local installation can point to this directory so skill improvements remain in git. The root [AGENTS.md](AGENTS.md) also routes teaching requests to it.

A first teaching request:

> Use $kyo-teacher to prepare and teach our first lesson. Read our progress first. Start with Kyo's pending type and composition.

A later request:

> Use $kyo-teacher to review my exercise. Give me a hint before showing a solution.

## How we work

The teacher prepares and verifies the current lesson before presenting it, and keeps a short outline of the next one. We do not research every module in advance. Explanations distinguish verified behavior from questions still needing investigation.

Each lesson contains learning materials, runnable examples, exercises with observable acceptance criteria, optional hints, and a separate reference solution. Reference solutions stay outside the exercise classpath and are not displayed before an attempt unless requested. Public repository contents are visible to anyone; separation prevents accidental spoilers, not access.

Progress is based on your code and explanations, not on whether the teacher has written a lesson. A session ends by recording what we actually covered and the next useful step. Pauses and revisiting topics are normal.

## Navigation

- [Course roadmap](course/roadmap.md): a provisional sequence, with detail only near the current lesson.
- [Module coverage](course/modules.md): the ecosystem checklist, currently indexed but unstudied.
- [Progress](course/progress.md): learner evidence and next action.
- [Teacher preparation](course/teacher-notes.md): what has been verified and what needs preparation.
- [Sources and versions](course/sources.md): source provenance and the version policy.
- [Workspace verification](course/verification.md): executed checks and their output, including a Scala runtime deprecation warning on JDK 25.

## Layout as lessons arrive

Each `lessons/NN-topic/` directory will contain `lesson.md`, `exercises.md`, `hints.md`, and `verification.md`. Its `examples/`, `exercises/`, and `reference/` directories will be separate sbt subprojects using ordinary `src/main/scala` and `src/test/scala` layouts. We create these only when a lesson needs them.

One root build shares dependency versions. Lessons add only their own dependencies. Root verification covers prepared examples and reference solutions. Exercise checks are run explicitly, so an unfinished exercise cannot break other lessons. The first exercise will introduce its exact commands.

This setup is not Lesson 1. No Kyo module implementation has been studied yet.
