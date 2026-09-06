package learning.lesson01

import kyo.*
import kyo.test.*

class GreetingSpec extends Test[Any]:
    "Pending computations" - {
        "plain values and fully handled Env can be evaluated" in {
            assert(Greeting.plain.eval == 42)
            assert(Greeting.configured("Ada").eval == "Hello, Ada!")
        }
        "the handler supplies the requested configuration" in {
            val program = Greeting.message("Ada")
            assert(Env.run(GreetingConfig("Hello"))(program).eval == "Hello, Ada!")
            assert(Env.run(GreetingConfig("Welcome"))(program).eval == "Welcome, Ada!")
            assert(Env.run(GreetingConfig("Hi"))(Greeting.message("")).eval == "Hi, !")
        }
        "effectful map and for-comprehension produce the same output" in {
            Console.withOut(
                Env.run(GreetingConfig("Hello"))(Greeting.announce("Ada"))
            ).map { case (mapped, _) =>
                Console.withOut(Env.run(GreetingConfig("Hello"))(Greeting.announceFor("Ada"))).map { case (bound, _) =>
                    assert(mapped.stdOut == "Hello, Ada!\n")
                    assert(bound.stdOut == mapped.stdOut)
                }
            }
        }
        "Env cannot be dropped and eval requires no remaining effects" in {
            typeCheckFailure("import kyo.*; val value: String < Any = Env.get[String]")
            typeCheckFailure("import kyo.*; Env.get[String].eval")
            typeCheckFailure("""import kyo.*; Console.printLine("hello").eval""")
        }
    }
end GreetingSpec
