package learning.lesson01

import kyo.*
import kyo.test.KyoSpecDefault
import zio.test.assertTrue

object CheckoutSpec extends KyoSpecDefault:
    def spec = suite("Checkout acceptance")(
        test("subtotal uses quantity and supplied unit price") {
            assertTrue(
                Env.run(Pricing(250, 100))(Checkout.subtotal(3)).eval == 750,
                Env.run(Pricing(120, 70))(Checkout.subtotal(2)).eval == 240
            )
        },
        test("delivery is charged once on a nonempty order") {
            assertTrue(
                Env.run(Pricing(250, 100))(Checkout.total(3)).eval == 850,
                Env.run(Pricing(120, 70))(Checkout.total(1)).eval == 190
            )
        },
        test("zero items cost zero including delivery") {
            assertTrue(
                Env.run(Pricing(250, 100))(Checkout.subtotal(0)).eval == 0,
                Env.run(Pricing(250, 100))(Checkout.total(0)).eval == 0
            )
        },
        test("free delivery and free items retain their separate meanings") {
            assertTrue(
                Env.run(Pricing(250, 0))(Checkout.total(2)).eval == 500,
                Env.run(Pricing(0, 100))(Checkout.total(2)).eval == 100
            )
        },
        test("receipt reports both amounts under the same configuration") {
            assertTrue(
                Env.run(Pricing(250, 100))(Checkout.receipt(3)).eval == "Items: 750 cents; total: 850 cents",
                Env.run(Pricing(120, 70))(Checkout.receipt(2)).eval == "Items: 240 cents; total: 310 cents",
                Env.run(Pricing(250, 100))(Checkout.receipt(0)).eval == "Items: 0 cents; total: 0 cents"
            )
        }
    )
end CheckoutSpec
