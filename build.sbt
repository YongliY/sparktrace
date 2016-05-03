name		:= "cnrtrace"
version		:= "1.0"
organization	:= "cnr"
scalaVersion	:= "2.10.6"
libraryDependencies += "org.apache.spark" %% "spark-core" % "1.6.1"
libraryDependencies += "org.apache.spark" %% "spark-sql"  % "1.6.1"
libraryDependencies += "com.databricks" %% "spark-csv"  % "1.4.0"
resolvers	+= Resolver.mavenLocal

