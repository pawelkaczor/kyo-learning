# Learner progress

## Starting point

- Scala and functional programming: already known, as reported by the learner.
- Kyo: start from its basic concepts; no mastery claims yet.
- Platform: JVM.
- Pace: self-paced, no deadlines.
- Feedback default: hints before a full solution; the learner may request a solution at any time.

## Current state

Lesson 1, [pending computations and composition](../lessons/01-pending/lesson.md), is prepared and verified. The opening and remaining-effect predictions have been attempted and reviewed. Pending types, effectful `map`, combined rows, and the distinction between `Console` and `Sync` have been introduced. The equivalent for-comprehension and `KyoApp` boundary have been introduced. The learner implemented all three checkout methods and requested review together.

The main checkout implementation is complete and reviewed: all five acceptance tests pass. The learner correctly identified automatic lifting as the reason plain and pending branch results compose. The independent configuration/test variation remains pending. The learner implementation has been preserved.

## Evidence

- 2026-09-06, Lesson 1 opening prediction: correctly predicted `String < Any` after supplying the greeting configuration (the submitted type had a spelling typo), and identified the evaluated result as a `String`. The predicted text omitted the interpolation's comma and exclamation mark; feedback supplied the exact value, `"Welcome, Lin!"`.
- 2026-09-06, remaining-effect transfer: correctly predicted `Unit < Sync` after providing the environment to `announce`, and explained that `.eval` cannot be used because `Sync` remains pending. This demonstrates the distinction between handling one requirement and having no effects remaining in this example. The description of `Sync` as an IO-like effect was accepted and refined to synchronous side effects here. No general handler or module mastery is claimed.

- 2026-09-06, checkout review: ran `sbt 'lesson01Exercises/test'`; compilation succeeded, four tests passed and one failed, exit 1. `subtotal` reads supplied pricing and uses pure `map`; `total` composes via effectful `map`, charges delivery only for positive quantities, and correctly handles zero items and free items. `receipt` correctly composes both computations with a for-comprehension, but its multiline format fails the exact single-line contract in all three receipt assertions. Effect signatures remain pending as requested. No learner source or acceptance tests were changed.
- Code demonstrates practical use of pure/effectful `map`, conditional composition, and for-comprehensions. At the initial review, the explanation for mixing a plain value and a pending computation in the two `total` branches was still pending. The independent variation has not been attempted.

- 2026-09-06, receipt correction and lifting explanation: the learner changed the receipt to the exact single-line contract and identified automatic lifting as the reason the plain `sub` branch is accepted alongside the pending branch. Re-ran `sbt 'lesson01Exercises/test'`: compilation succeeded, all five tests passed, exit 0. This combines correct implementation with a relevant explanation of lifting. No learner code or acceptance tests were edited by the teacher.

## Next session

Wait for the independent variation: predict `Checkout.total(4)` with `Pricing(80, 25)`, add a test in the exercise project's own `src/test/scala` directory that supplies this configuration at the boundary, and explain why no change to Checkout is needed. The learner can use the shared acceptance suite as a testing-style example without editing it. Review the new test and explanation before recording completion of the whole lesson. Keep reference solutions out of routine feedback.
