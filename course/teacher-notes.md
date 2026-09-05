# Teacher preparation

## Verified orientation

On 2026-09-05, read the framework's top-level overview and contributor guidance, and the online overview. Indexed top-level module names without opening module READMEs or implementation files.

The course uses a separate JVM consumer build with published artifacts. Scala and FP preliminaries are unnecessary. The teaching skill and file-based progress record are the continuity mechanism between sessions.

## Preparation horizon

- Current: workspace setup and teaching workflow.
- Next to prepare: one complete, verified lesson on pending computations and composition.
- Following outline: typed failure and handlers.
- Distant modules: indexed only.

## Questions to resolve during Lesson 1 preparation

- Check the relevant pending-type operations and the chosen minimal handler against the pinned release, including examples and API details omitted by the overview.
- Choose one small example that does not require teaching runtime internals.
- Verify the test framework setup needed for learner exercises in a standalone consumer build.
- Solve every exercise and check that acceptance tests distinguish an incorrect answer.

## Source caution

The online overview and local checkout are orientation aids. Their API descriptions are not proof of behavior in the pinned Maven release. Confirm each taught claim against matching source and executable evidence. See [sources.md](sources.md).

Preparation notes describe the teacher's evidence. They do not imply that the learner understands the material. Move any future reference answers into their lesson's reference directory rather than displaying them in routine progress summaries.
