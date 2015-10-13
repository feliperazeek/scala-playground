name := "scala-playground"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

// fork a new JVM for 'run' and 'test:run'
fork := true

// fork a new JVM for 'test:run', but not 'run'
fork in Test := true

// add a JVM option to use when forking a JVM for 'run'
javaOptions += "-Xss2g"
javaOptions += "-Xmx4g"
javaOptions += "-Xms4g"

