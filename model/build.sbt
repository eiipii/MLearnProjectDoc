import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.eiipii.mlearn",
      scalaVersion := "2.12.6",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "model",
    libraryDependencies += scalaURI,
    libraryDependencies += scalaTest % Test
  )
