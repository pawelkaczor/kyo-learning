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

lazy val root = project.in(file(".")).aggregate(setup).settings(
  name := "kyo-learning"
)

addCommandAlias("verify", ";setup/compile;setup/runMain learning.SetupCheck")
