import Dependencies.{logbackClassic, mockito, scalaCheck, scalaTest}
import sbt.Keys._
import sbt.librarymanagement.DependencyBuilders.RepositoryName
import sbt.{Credentials, Project, url}

object implicits {

  implicit class RichProject(project: Project) {
    def tests(scope: String = "test"): Project = project
      .settings(libraryDependencies += scalaTest % scope)
      .settings(libraryDependencies += scalaCheck % scope)
      .settings(libraryDependencies += mockito % scope)
      .settings(libraryDependencies += logbackClassic % scope)

    def publish: Project = project.settings(
      credentials += Credentials("", "nexus-ext.rarible.int", sys.env.get("USERNAME").get, sys.env.get("PASSWORD").get),
      publishTo := Some(("releases": RepositoryName) at "http://nexus-ext.rarible.int/repository/maven-releases/" withAllowInsecureProtocol true)
    )

    def common: Project = publish.settings(
      organization := "com.rarible.rpc",
      licenses += ("MIT", url("http://opensource.org/licenses/MIT")),
      version := "0.1.3",
      scalaVersion := Dependencies.fullScalaVersion
    )

    def transport: Project = common

    def scalether: Project = common.settings(
      organization := "com.rarible.scalether"
    )

    def bitcoin: Project = common.settings(
      organization := "com.rarible.bitcoin.rpc"
    )

    def blockchain: Project = common.settings(
      organization := "com.rarible.blockchain"
    )
  }
}
