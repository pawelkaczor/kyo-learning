package learning.lesson01

import kyo.*

final case class Pricing(unitPriceCents: Int, deliveryCents: Int)

object Checkout:
    // TODO: read Pricing with Env.get and calculate the subtotal using map.
    def subtotal(quantity: Int): Int < Env[Pricing] = 0

    // TODO: compose subtotal with another Env read using effectful map.
    // Delivery is charged once for positive quantities; zero items cost zero.
    def total(quantity: Int): Int < Env[Pricing] = 0

    // TODO: use a for-comprehension to combine subtotal and total.
    def receipt(quantity: Int): String < Env[Pricing] = "TODO"
end Checkout
