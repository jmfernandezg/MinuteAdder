lazy val impl = (project in file("impl"))
  .settings(
    name := "minute-adder",
    version := "0.1",
    scalaVersion := "2.13.12",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.1.1" % "test"
    ),
  )