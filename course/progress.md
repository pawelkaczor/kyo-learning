# Learner progress

## Starting point

- Scala and functional programming: already known, as reported by the learner.
- Kyo: start from its basic concepts; no mastery claims yet.
- Platform: JVM.
- Pace: self-paced, no deadlines.
- Feedback default: hints before a full solution; the learner may request a solution at any time.

## Current state

Lesson 1, [pending computations and composition](../lessons/01-pending/lesson.md), is prepared and verified. The opening segment introduces `A < S`, an `Env` requirement, and supplying it with a handler. A prediction question is pending. The later composition segment and implementation exercise are prepared for the learner's next turn.

No exercise has been attempted, reviewed, or demonstrated.

## Evidence

No Kyo exercise evidence yet. A successful environment smoke check is not evidence of conceptual mastery.

For later entries, record the lesson, exercise or explanation observed, what the learner demonstrated, remaining confusion, and a useful revisit prompt. Distinguish `prepared`, `introduced`, `attempted`, `reviewed`, and `demonstrated`. Never mark a topic demonstrated just because materials were generated or tests passed.

## Next session

Wait for the opening prediction: supply `GreetingConfig("Welcome")` to `message("Lin")`, then identify the result type after `Env.run` but before `.eval`, the final string, and what the handler changes. Then introduce effectful `map`, the remaining `Sync` requirement, and the checkout exercise. Keep the reference solution out of the teaching exchange until requested or appropriate after an attempt.
