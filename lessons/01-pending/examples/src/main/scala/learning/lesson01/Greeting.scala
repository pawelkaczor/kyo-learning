package learning.lesson01

import kyo.*

final case class GreetingConfig(prefix: String)

object Greeting:
    val plain: Int < Any = 42

    def message(name: String): String < Env[GreetingConfig] =
        Env.get[GreetingConfig].map(config => s"${config.prefix}, $name!")

    def announce(name: String): Unit < (Env[GreetingConfig] & Sync) =
        message(name).map(text => Console.printLine(text))

    def announceFor(name: String): Unit < (Env[GreetingConfig] & Sync) =
        for
            text <- message(name)
            _    <- Console.printLine(text)
        yield ()

    def configured(name: String): String < Any =
        Env.run(GreetingConfig("Hello"))(message(name))

    def configuredAnnouncement(name: String): Unit < Sync =
        Env.run(GreetingConfig("Hello"))(announce(name))
end Greeting

object GreetingApp extends KyoApp:
    run {
        Greeting.configuredAnnouncement("Ada")
    }
end GreetingApp
