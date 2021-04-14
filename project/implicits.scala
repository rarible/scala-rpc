import Dependencies.{logbackClassic, mockito, scalaCheck, scalaTest}
import sbt.Keys._
import sbt.{Project, url}
import sbtghpackages.GitHubPackagesKeys._
import sbtghpackages.TokenSource

object implicits {

  implicit class RichProject(project: Project) {
    def tests(scope: String = "test"): Project = project
      .settings(libraryDependencies += scalaTest % scope)
      .settings(libraryDependencies += scalaCheck % scope)
      .settings(libraryDependencies += mockito % scope)
      .settings(libraryDependencies += logbackClassic % scope)

    def common: Project = project.settings(
      organization := "com.rarible.rpc",
      licenses += ("MIT", url("http://opensource.org/licenses/MIT")),
      version := "0.1.2",
      scalaVersion := Dependencies.fullScalaVersion,
      githubOwner := "rariblecom",
      githubRepository := "scala-rpc",
      githubTokenSource := TokenSource.GitConfig("github.token")
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
