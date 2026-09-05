# Exercise 1: a configured checkout

Edit only [Checkout.scala](exercises/src/main/scala/learning/lesson01/Checkout.scala). Keep the signatures. Use integer cents. Inputs are nonnegative, and all arithmetic fits in `Int`; validation and overflow handling are outside this exercise.

## Predict first

Read the starter's types. What value does `subtotal` produce, and which requirement does it leave pending? If `total` reads `Pricing` twice through composition, does its row need two separate copies of `Env[Pricing]`? Explain your reasoning before or alongside your code.

## Guided application

1. Implement `subtotal(quantity)` using `Env.get[Pricing]` and `map`. Multiply quantity by the configured unit price.
2. Implement `total(quantity)` by composing `subtotal` with another configuration read using effectful `map`. Charge delivery once when quantity is positive. For zero items, the total is zero, even if delivery has a price. Do not supply a hard-coded configuration inside either function.
3. Implement `receipt(quantity)` with a for-comprehension using `subtotal` and `total`. Return exactly `Items: X cents; total: Y cents`, replacing X and Y with the calculated amounts.

For `Pricing(250, 100)` and quantity 3, the subtotal is 750 and total is 850. The receipt is `Items: 750 cents; total: 850 cents`.

## Commands and acceptance

```sh
sbt 'lesson01Exercises/Test/compile'
sbt 'lesson01Exercises/test'
```

The untouched starter compiles. Four of its five acceptance tests intentionally fail: subtotal, delivery on a nonempty order, free delivery/free items, and receipt. The zero-items test already passes with the placeholder zero values. Passing only that test is not completion.

The [shared acceptance tests](acceptance/src/test/scala/learning/lesson01/CheckoutSpec.scala) cover different configurations, zero items, free delivery, free items with paid delivery, and receipt formatting. Do not change the acceptance tests. Root `sbt verify` deliberately excludes this unfinished project.

In review, we also check that you composed the functions as requested, kept configuration pending, and can explain the signatures. Tests alone cannot establish that reasoning.

## Small independent variation

After your tests pass, add a test with `Pricing(80, 25)` and quantity 4 in your exercise project's own `src/test/scala` directory. Predict the total first, then supply the configuration at the test boundary. Explain why supplying a different configuration does not require rewriting `Checkout`.

Send your attempt and a brief explanation when ready. [Optional progressive hints](hints.md).
