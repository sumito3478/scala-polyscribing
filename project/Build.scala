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

  lazy val polyscribing = Project("polyscribing", file(".")).settings(defaultSettings: _*).aggregate(
    core)

  lazy val core = Project("polyscribing-core", file("core")).settings(defaultSettings: _*).settings(
    libraryDependencies ++= Seq(
      "com.typesafe" %% "scalalogging-slf4j" % "1.0.+",
      "org.slf4j" % "slf4j-api" % "1.7.+",
      "ch.qos.logback" % "logback-classic" % "1.0.+",
      "org.json4s" %% "json4s-native" % "3.2.+",
      "net.databinder.dispatch" %% "dispatch-core" % "0.10.+"))
}
