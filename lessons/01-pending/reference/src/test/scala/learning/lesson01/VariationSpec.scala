package learning.lesson01

import kyo.*
import kyo.test.*

class VariationSpec extends Test[Any]:
    "Independent variation" - {
        "a new configuration works without changing Checkout" in {
            Env.run(Pricing(80, 25))(Checkout.total(4)).map { amount =>
                assert(amount == 345)
            }
        }
    }
end VariationSpec
