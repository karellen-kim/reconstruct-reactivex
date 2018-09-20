name := "training-reactivex"

version := "0.1"

scalaVersion := "2.12.6"

lazy val versions = new {
  val scalatest = "3.0.5"
  val junit = "4.10"
}

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % versions.scalatest,
  "junit" % "junit" % versions.junit % Test
)