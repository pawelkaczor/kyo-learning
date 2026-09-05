ThisBuild / scalaVersion := "3.8.4"
ThisBuild / organization := "learning.kyo"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / publish / skip := true

ThisBuild / scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-unchecked",
  "-Wvalue-discard",
  "-Wnonunit-statement",
  "-Wconf:msg=(unused.*value|discarded.*value|pure.*statement):error",
  "-language:strictEquality"
)

val kyoVersion = "1.0.0-RC6"

lazy val setup = project.in(file("setup")).settings(
  name := "kyo-learning-setup",
  libraryDependencies += "io.getkyo" %% "kyo-core" % kyoVersion,
  Compile / run / fork := true
)

val zioVersion = "2.1.26"

lazy val lesson01Settings = Seq(
  libraryDependencies ++= Seq(
    "io.getkyo" %% "kyo-core" % kyoVersion,
    "io.getkyo" %% "kyo-zio-test" % kyoVersion % Test,
    "dev.zio" %% "zio-test-sbt" % zioVersion % Test
  ),
  testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework"),
  Compile / run / fork := true
)

lazy val lesson01Examples = project.in(file("lessons/01-pending/examples"))
  .settings(lesson01Settings)

lazy val lesson01Exercises = project.in(file("lessons/01-pending/exercises"))
  .settings(lesson01Settings)
  .settings(Test / unmanagedSourceDirectories +=
    baseDirectory.value.getParentFile / "acceptance" / "src" / "test" / "scala")

lazy val lesson01Reference = project.in(file("lessons/01-pending/reference"))
  .settings(lesson01Settings)
  .settings(Test / unmanagedSourceDirectories +=
    baseDirectory.value.getParentFile / "acceptance" / "src" / "test" / "scala")

lazy val root = project.in(file(".")).aggregate(setup, lesson01Examples, lesson01Reference).settings(
  name := "kyo-learning"
)

addCommandAlias("verify", ";setup/compile;setup/runMain learning.SetupCheck;lesson01Examples/test;lesson01Examples/runMain learning.lesson01.GreetingApp;lesson01Reference/test")
