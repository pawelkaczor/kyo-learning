package learning.lesson01

import kyo.*
import kyo.test.KyoSpecDefault
import scala.compiletime.testing.typeChecks
import zio.test.assertTrue

object GreetingSpec extends KyoSpecDefault:
    def spec = suite("Pending computations")(
        test("plain values and fully handled Env can be evaluated") {
            assertTrue(
                Greeting.plain.eval == 42, 
                Greeting.configured("Ada").eval == "Hello, Ada!"
            )
        },
        test("the handler supplies the requested configuration") {
            val program = Greeting.message("Ada")
            assertTrue(
                Env.run(GreetingConfig("Hello"))(program).eval == "Hello, Ada!",
                Env.run(GreetingConfig("Welcome"))(program).eval == "Welcome, Ada!",
                Env.run(GreetingConfig("Hi"))(Greeting.message("")).eval == "Hi, !"
            )
        },
        test("effectful map and for-comprehension produce the same output") {
            Console.withOut(
                Env.run(GreetingConfig("Hello"))(Greeting.announce("Ada"))
            ).map { case (mapped, _) =>
                Console.withOut(Env.run(GreetingConfig("Hello"))(Greeting.announceFor("Ada"))).map { case (bound, _) =>
                    assertTrue(mapped.stdOut == "Hello, Ada!\n", bound.stdOut == mapped.stdOut)
                }
            }
        },
        test("Env cannot be dropped and eval requires no remaining effects") {
            assertTrue(
                !typeChecks("import kyo.*; val value: String < Any = Env.get[String]"),
                !typeChecks("import kyo.*; Env.get[String].eval"),
                !typeChecks("""import kyo.*; Console.printLine("hello").eval""")
            )
        }
    )
end GreetingSpec
