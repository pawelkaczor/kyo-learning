package learning.lesson01

import kyo.*
import kyo.test.*

class CheckoutSpec extends Test[Any]:
    "Checkout acceptance" - {
        "subtotal uses quantity and supplied unit price" in {
            assert(Env.run(Pricing(250, 100))(Checkout.subtotal(3)).eval == 750)
            assert(Env.run(Pricing(120, 70))(Checkout.subtotal(2)).eval == 240)
        }
        "delivery is charged once on a nonempty order" in {
            assert(Env.run(Pricing(250, 100))(Checkout.total(3)).eval == 850)
            assert(Env.run(Pricing(120, 70))(Checkout.total(1)).eval == 190)
        }
        "zero items cost zero including delivery" in {
            assert(Env.run(Pricing(250, 100))(Checkout.subtotal(0)).eval == 0)
            assert(Env.run(Pricing(250, 100))(Checkout.total(0)).eval == 0)
        }
        "free delivery and free items retain their separate meanings" in {
            assert(Env.run(Pricing(250, 0))(Checkout.total(2)).eval == 500)
            assert(Env.run(Pricing(0, 100))(Checkout.total(2)).eval == 100)
        }
        "receipt reports both amounts under the same configuration" in {
            assert(Env.run(Pricing(250, 100))(Checkout.receipt(3)).eval == "Items: 750 cents; total: 850 cents")
            assert(Env.run(Pricing(120, 70))(Checkout.receipt(2)).eval == "Items: 240 cents; total: 310 cents")
            assert(Env.run(Pricing(250, 100))(Checkout.receipt(0)).eval == "Items: 0 cents; total: 0 cents")
        }
    }
end CheckoutSpec
