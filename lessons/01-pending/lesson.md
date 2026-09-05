# Lesson 1: pending computations and composition

Goal: read a pending type, compose a small program, and explain what remains after handling a requirement. Prerequisites: Scala and FP experience. No previous Kyo lesson is needed. Work through one segment at a time with the teacher.

## 1. A result with requirements

Read `A < S` as “a computation producing an `A`, with effects described by `S` still to handle.” The right side is called the pending effect row. It describes possible requirements, not a log of operations already performed.

A configured greeting is a small example: the function needs a prefix, but its caller chooses which prefix to provide. Open [Greeting.scala](examples/src/main/scala/learning/lesson01/Greeting.scala). This excerpt matches that source:

```scala
final case class GreetingConfig(prefix: String)

def message(name: String): String < Env[GreetingConfig] =
    Env.get[GreetingConfig].map(config => s"${config.prefix}, $name!")
```

`Env.get[GreetingConfig]` has type `GreetingConfig < Env[GreetingConfig]`. It requests a value by type. Inside `map`, `config` is an ordinary `GreetingConfig`, so string interpolation is ordinary Scala. The resulting computation produces a `String` and still requires `Env[GreetingConfig]`. Mapping has not supplied the configuration.

`Env.run(GreetingConfig("Hello"))(message("Ada"))` supplies that requirement. Its type is `String < Any`. In the effect position, `Any` means no remaining effect requirements. It is the identity for intersection: `S & Any` is `S`. It does not mean “any effect is allowed.”

A fully handled computation supports `.eval`, returning its ordinary value. Here the value is `Hello, Ada!`. The tests verify that the same greeting computation can also be supplied with a different prefix. `.eval` is appropriate here because the row is empty; it cannot be used to execute the later `Sync` example.

Plain values can be lifted automatically. The source's `val plain: Int < Any = 42` compiles without a constructor. A pending type does not imply that every Scala expression is lazy. Keep arbitrary side effects out of ordinary callbacks; use the relevant Kyo operation when an effect is intended.

Pause for a prediction: after providing `GreetingConfig("Welcome")` to `message("Lin")`, what are the result type before `.eval` and the final string? Explain what changed on each side of `<`.

## 2. Kyo's map can be effectful

In the same source:

```scala
def announce(name: String): Unit < (Env[GreetingConfig] & Sync) =
    message(name).map(text => Console.printLine(text))
```

`message` requires `Env[GreetingConfig]`. The callback returns `Unit < Sync`, because `Console.printLine` performs synchronous output. Kyo's `map` composes and flattens this next computation. The result is `Unit < (Env[GreetingConfig] & Sync)`, without a nested pending value.

A simplified type sketch, omitting contextual parameters, is:

```text
(A < S).map(A => B < S2)  =>  B < (S & S2)
```

Unlike `List.map` or `Option.map`, this is a bind operation. A pure callback works too because its result lifts automatically. Kyo also provides `flatMap` with the same composition behavior, supporting ordinary Scala for-comprehensions. `announceFor` is the verified equivalent. `&` combines possible effects; their order in a type does not determine execution order. The sequence in the program does.

Distinguish the API from the effect: `Console` is the API called here; `Sync` is the effect recorded in the row. An API name is not necessarily an effect name.

## 3. Handling one requirement leaves the others

`configuredAnnouncement` supplies `GreetingConfig`, leaving `Unit < Sync`. It has not handled synchronous output. [GreetingApp](examples/src/main/scala/learning/lesson01/Greeting.scala) submits this remaining computation through `KyoApp`'s `run` application boundary:

```sh
sbt 'lesson01Examples/runMain learning.lesson01.GreetingApp'
```

Output: `Hello, Ada!` followed by a newline. No custom unsafe runner is needed. In tests, `KyoSpecDefault` supplies the test runtime; `Console.withOut` captures output so assertions can check it. The adapter's internals are outside this lesson.

Common mistake: treating `Env.run` as a universal executor, or reading `Any` as permission to ignore effects. A handler discharges its own requirement. Only a row with no requirements supports `.eval`. Compile-time checks reject attempts to drop `Env` or call `.eval` on unhandled `Env` or `Sync`.

Transfer question: if you supply the greeting configuration to `announce("Lin")`, what remains in its row, and why can you not replace the application boundary with `.eval`?

Continue with [the exercise](exercises.md). [Hints](hints.md) are optional. Do not open `reference/` until you want to compare a solution.

## Release evidence

The lesson uses Kyo RC6. Sources checked: [pending type and composition](https://github.com/getkyo/kyo/blob/2e58c0550b209317b85a30fc5787c24b7e4dd63c/kyo-kernel/shared/src/main/scala/kyo/kernel/Pending.scala), [Env.get and Env.run](https://github.com/getkyo/kyo/blob/2e58c0550b209317b85a30fc5787c24b7e4dd63c/kyo-prelude/shared/src/main/scala/kyo/Env.scala), [Console](https://github.com/getkyo/kyo/blob/2e58c0550b209317b85a30fc5787c24b7e4dd63c/kyo-core/shared/src/main/scala/kyo/Console.scala), and [KyoApp](https://github.com/getkyo/kyo/blob/2e58c0550b209317b85a30fc5787c24b7e4dd63c/kyo-core/shared/src/main/scala/kyo/KyoApp.scala). See [verification](verification.md) for executable evidence.
