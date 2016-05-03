/**
 * sbt --warn "run loadFile"
 * sbt --warn "run loadFile filename.txt"
 */

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.functions._

object loadFile {
  
  def main(args: Array[String]) {
    //println(args.deep.mkString("\n"))
    if (args.length <= 1) {
      println("usage: loadFile <infile>")
      System.exit(0)
    }
    val infile = args(1)

    val conf = new SparkConf().setMaster("local[4]").setAppName("loadFile")
    val spark = new SparkContext(conf)
    val sqlContext = new SQLContext(spark)

    val df = sqlContext.read
      .format("com.databricks.spark.csv")
      .option("inferSchema", "true") // Automatically infer data types
      .option("delimiter", "\t")
      .option("nullValue", "NULL")
      .load(infile);
      //.option("header", "true") // Use first line of all files as header

    println("schema: ")
    df.printSchema()
    println("df="+df.show())

    println("sorting...")
    val df2 = df.sort(asc("C0"))
    println("done!")

    spark.stop
  }


}



