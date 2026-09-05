package learning.lesson01

import kyo.*

final case class Pricing(unitPriceCents: Int, deliveryCents: Int)

object Checkout:
    def subtotal(quantity: Int): Int < Env[Pricing] =
        Env.get[Pricing].map(pricing => quantity * pricing.unitPriceCents)

    def total(quantity: Int): Int < Env[Pricing] =
        subtotal(quantity).map { amount =>
            Env.get[Pricing].map { pricing =>
                if quantity == 0 then 0 else amount + pricing.deliveryCents
            }
        }

    def receipt(quantity: Int): String < Env[Pricing] =
        for
            items <- subtotal(quantity)
            all   <- total(quantity)
        yield s"Items: $items cents; total: $all cents"
end Checkout
