package learning.lesson01

import kyo.*

final case class Pricing(unitPriceCents: Int, deliveryCents: Int)

object Checkout:
    def subtotal(quantity: Int): Int < Env[Pricing] =
        Env.get[Pricing].map { pricing =>
            quantity * pricing.unitPriceCents
        }

    def total(quantity: Int): Int < Env[Pricing] =
        subtotal(quantity).map { sub =>
          if (quantity > 0)
            Env.get[Pricing].map(pricing => sub + pricing.deliveryCents)
          else
            sub
        }

    def receipt(quantity: Int): String < Env[Pricing] =
        for {
          sub <- subtotal(quantity)
          tot <- total(quantity)
        } yield {
          "Items: %s cents; total: %s cents".format(sub, tot)
        }
end Checkout
