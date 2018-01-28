name := "BTreePrinter"

scalaVersion := "2.11.7"

unmanagedSourceDirectories in Test ++=  Seq("jira_04", "jira_03_01", "jira_03_02", "jira_02", "jira_01", "misc").map { src => (baseDirectory in Test).value / src }

// https://mvnrepository.com/artifact/org.scalatest/scalatest
//libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0"

libraryDependencies += "org.scalamock" %% "scalamock-scalatest-support" % "3.2.2"
