import sbt.Keys._
import sbt.{Path, PathFinder, _}

object Common {
  def unmanagedJarsFrom(sdkDirectory: File, subdirectories: String*): Classpath = {
    val sdkPathFinder = subdirectories.foldLeft(PathFinder.empty) { (finder, dir) =>
      finder +++ (sdkDirectory / dir)
    }
    (sdkPathFinder * globFilter("*.jar")).classpath
  }

  def ivyHomeDir: File =
    Option(System.getProperty("sbt.ivy.home")).fold(Path.userHome / ".ivy2")(file)
}