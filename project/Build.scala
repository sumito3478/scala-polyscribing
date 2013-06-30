import sbt._
import Keys._

object Build extends Build {
  lazy val defaultSettings = Seq(
    javaOptions := Seq("-Xmx1024m"),
    organization := "info.sumito3478",
    scalaVersion := "2.10.2",
    crossScalaVersions := Seq("2.10.2", "2.11.0-M3"),
    autoCompilerPlugins := true,
    scalacOptions ++= Seq(
      "-target:jvm-1.7",
      "-feature",
      "-deprecation",
      "-unchecked"),
    resolvers ++= Seq(
      "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases",
      "Typesafe Snapshots" at "http://repo.typesafe.com/typesafe/snapshots",
      "Sonatype OSS Releases" at "http://oss.sonatype.org/content/repositories/releases",
      "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots"),
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "2.0.+" % "test"))

  lazy val client = Project("web-client", file(".")).settings(defaultSettings: _*).aggregate(
    core)

  lazy val core = Project("web-client-core", file("core")).settings(defaultSettings: _*).settings(
    libraryDependencies ++= Seq(
      "net.databinder.dispatch" %% "dispatch-core" % "0.10.+"))
}
