# Optional hints

Open only as far as useful.

<details>
<summary>1. Which part is missing?</summary>

The quantity is already an argument. The unit price and delivery charge come from the pending `Env[Pricing]` requirement. Supplying that requirement belongs at the caller or test boundary.
</details>

<details>
<summary>2. Getting an ordinary value</summary>

Inside `Env.get[Pricing].map`, the callback parameter is an ordinary `Pricing`. Use its fields to calculate an ordinary number; Kyo lifts that result.
</details>

<details>
<summary>3. Composing the second computation</summary>

Start `total` from `subtotal(quantity).map`. That callback can return another pending computation. Reading the same environment type again does not introduce a distinct requirement: intersecting a type with itself gives the same type.
</details>

<details>
<summary>4. The important boundary</summary>

Check the quantity when deciding whether to charge delivery. A subtotal of zero could also mean that positive quantities of items are free.
</details>

<details>
<summary>5. Receipt</summary>

Use one generator for `subtotal(quantity)` and another for `total(quantity)`. Format their ordinary results in `yield`.
</details>
