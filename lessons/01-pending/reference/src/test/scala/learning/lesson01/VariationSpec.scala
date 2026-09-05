package learning.lesson01

import kyo.*
import kyo.test.KyoSpecDefault
import zio.test.assertTrue

object VariationSpec extends KyoSpecDefault:
    def spec = suite("Independent variation")(
        test("a new configuration works without changing Checkout") {
            Env.run(Pricing(80, 25))(Checkout.total(4)).map { amount =>
                assertTrue(amount == 345)
            }
        }
    )
end VariationSpec
