# Course roadmap

The learner already knows Scala and functional programming. Start with Kyo's distinct model. Topics below are a planning hypothesis, not a fixed schedule or a claim that their APIs have been studied.

## Near horizon

1. **Pending computations and composition.** Read `A < S`, combine computations, understand Kyo's `map` and ordinary for-comprehensions, and identify what a handler must remove. Use the smallest set of effects needed for a concrete example. Exercise direction: predict types and values, then compose a small computation yourself.
2. **Typed failure and handling.** Introduce `Abort` and the relevant `Result` cases; reason about what remains after handling. Exercise direction: model and handle a small validation failure without erasing its type.

[Lesson 1](../lessons/01-pending/lesson.md) is prepared and verified. Delivery begins with pending computations and one environment requirement; effectful composition and the checkout exercise follow after the learner's prediction. Lesson 2 remains an outline.

## Later dependencies

After the initial vocabulary, grow toward:

- Dependency provision and state, then combinations where handler ordering matters.
- Side effects, entrypoints, scoped resources, and deterministic testing.
- Fibers, structured concurrency, cancellation, coordination, and time.
- Streaming and backpressure.
- Application modules and integrations, introduced through small practical projects.
- Advanced internals, custom effects, scheduler behavior, tooling, and runtime bridges once the earlier model is secure.

This is a dependency sketch. Resolve the actual prerequisite order when preparing a topic. Introduce data types at their first use rather than requiring a data-type survey first. Introduce testing early enough to support exercises, with infrastructure explained only as needed.

## Whole-ecosystem coverage

Use [modules.md](modules.md) as the coverage ledger. Every indexed entry eventually gets an orientation, its prerequisites and JVM relevance checked, a lesson or explicit explanation of its supporting role, and an appropriate practical check. Several related modules can share a lesson. A build-support directory may need explanation rather than a fictitious application API.

JVM is the execution focus. Explain a browser-only feature or other platform-specific boundary honestly; do not invent a JVM exercise or claim cross-platform tests were run. Keep those entries visible so JVM focus does not silently remove them from the ecosystem map.

Reconcile the ledger with top-level module and artifact listings at deliberate version upgrades. Newly discovered entries remain unstudied until their turn. Do not pre-write a complete course or study distant modules to fill the table.
