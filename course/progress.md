# Learner progress

## Starting point

- Scala and functional programming: already known, as reported by the learner.
- Kyo: start from its basic concepts; no mastery claims yet.
- Platform: JVM.
- Pace: self-paced, no deadlines.
- Feedback default: hints before a full solution; the learner may request a solution at any time.

## Current state

Lesson 1, [pending computations and composition](../lessons/01-pending/lesson.md), is prepared and verified. The opening and remaining-effect predictions have been attempted and reviewed. Pending types, effectful `map`, combined rows, and the distinction between `Console` and `Sync` have been introduced. The equivalent for-comprehension and `KyoApp` boundary are being introduced, followed by the first checkout implementation step.

No implementation exercise has been attempted or reviewed. The checkout starter remains unfinished.

## Evidence

- 2026-09-06, Lesson 1 opening prediction: correctly predicted `String < Any` after supplying the greeting configuration (the submitted type had a spelling typo), and identified the evaluated result as a `String`. The predicted text omitted the interpolation's comma and exclamation mark; feedback supplied the exact value, `"Welcome, Lin!"`.
- 2026-09-06, remaining-effect transfer: correctly predicted `Unit < Sync` after providing the environment to `announce`, and explained that `.eval` cannot be used because `Sync` remains pending. This demonstrates the distinction between handling one requirement and having no effects remaining in this example. The description of `Sync` as an IO-like effect was accepted and refined to synchronous side effects here. No general handler or module mastery is claimed.

## Next session

Wait for the first implementation attempt in the checkout exercise: implement only `subtotal(quantity)` using `Env.get[Pricing]` and `map`, keeping `Int < Env[Pricing]`. Ask for a brief explanation of the pending requirement. The whole acceptance suite will still have failures while `total` and `receipt` are unfinished. Review with a small hint if needed, then proceed to those methods and the independent variation at the learner's pace. Keep reference solutions out of the teaching exchange until requested or appropriate after an attempt.
