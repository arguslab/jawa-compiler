lazy val `jawa-compiler` = project in file(".")

name := "jawa-compiler"
organization := "ArgusLab"
scalaVersion := "2.11.8"
sbtVersion := "0.13.9"

crossPaths := false

licenses := ("Eclipse-1.0" -> url("http://www.opensource.org/licenses/eclipse-1.0.php")) :: Nil // this is required! otherwise Bintray will reject the code
homepage := Some(url("https://github.com/arguslab/jawa-compiler"))

libraryDependencies += "org.scalactic" %% "scalactic" % "2.2.6"
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"

resolvers += Resolver.bintrayRepo("arguslab", "maven")

libraryDependencies += "org.arguslab" %% "jawa-core" % "1.0.1"


// Bintray
bintrayOrganization := Some("arguslab")
bintrayReleaseOnPublish := false
bintrayRepository := "maven"
bintrayPackage := "jawa-compiler"

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