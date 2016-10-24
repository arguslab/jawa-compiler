lazy val `jawa-compiler` = project in file(".")

name := "jawa-compiler"
organization := "com.github.arguslab"
scalaVersion := "2.11.8"
sbtVersion := "0.13.9"

licenses := ("Eclipse-1.0" -> url("http://www.opensource.org/licenses/eclipse-1.0.php")) :: Nil // this is required! otherwise Bintray will reject the code
homepage := Some(url("https://github.com/arguslab/jawa-compiler"))

libraryDependencies += "org.scalactic" %% "scalactic" % "2.2.6"
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"

libraryDependencies += "com.github.arguslab" %% "jawa-core" % "1.1.5"


// Bintray
bintrayOrganization := Some("arguslab")
bintrayReleaseOnPublish := false
bintrayRepository := "maven"
bintrayPackage := "jawa-compiler"

pomExtra := <scm>
    <url>https://github.com/arguslab/jawa-compiler</url>
    <connection>scm:git:https://github.com/arguslab/jawa-compiler.git</connection>
  </scm>
  <developers>
    <developer>
      <id>fgwei</id>
      <name>Fengguo Wei</name>
      <url>http://fgwei.arguslab.org</url>
    </developer>
  </developers>

import com.typesafe.sbt.pgp.PgpKeys._

lazy val publishSnapshot = taskKey[Unit]("Publish Snapshot -- Custom Task")
publishSnapshot := {
  println("Publishing Snapshot ...")
  val extracted = Project.extract(state.value)
  Project.runTask(publishSigned, extracted.append(Seq(
    publishTo := Some("Artifactory Realm" at "http://oss.jfrog.org/artifactory/oss-snapshot-local"),
    // Only setting the credentials file if it exists (#52)
    credentials := List(Path.userHome / ".bintray" / ".artifactory").filter(_.exists).map(Credentials(_))
  ), state.value), checkCycles = true)
}

// Release
import ReleaseTransformations._
releasePublishArtifactsAction := PgpKeys.publishSigned.value
releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  publishArtifacts,
  releaseStepTask(bintrayRelease in `jawa-compiler`),
  setNextVersion,
  commitNextVersion,
  pushChanges
)