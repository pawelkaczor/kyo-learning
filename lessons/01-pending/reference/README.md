# Reference solution: spoilers

Open this directory when ready to compare. The implementation is in [Checkout.scala](src/main/scala/learning/lesson01/Checkout.scala).

The first `map` turns the requested pricing into an amount. In `total`, an effectful callback reads the delivery price and keeps the environment requirement pending. The row remains `Env[Pricing]`: repeating a requirement does not multiply it. Check quantity rather than subtotal for the empty-order rule, since free items still incur delivery.

The receipt uses ordinary for-comprehension syntax. Both bound calls require the same environment. The test boundary supplies it; the functions do not hard-code one.

The independent variation expects 345 cents: four items at 80 cents plus delivery of 25 cents. The reference's extra test verifies this case.

```sh
sbt 'lesson01Reference/test'
```

This project compiles the same acceptance source as the exercises, but has its own implementation and classpath. Neither project depends on the other.

## Acceptance mutation check

Temporarily changed the empty-order branch from checking `quantity == 0` to checking `amount == 0`. This incorrectly makes a positive quantity of free items avoid delivery. The shared free-items test failed with actual 0 versus expected 100. The original implementation was restored before final verification, which passed all six reference tests.
