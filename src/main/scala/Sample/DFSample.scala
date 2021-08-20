package Sample
import org.apache.spark.sql.{DataFrame, SparkSession}

object DFSample  extends App{

  def readFileFromSession(sparkSession: SparkSession): DataFrame ={
    return sparkSession.read
      .option("header", "true")
      .csv("src/main/resources/customer.csv")
  }
  def createSparkSession(): SparkSession = {
    val sparkSession = SparkSession.builder
      .master("local")
      .appName("spark session example")
      .getOrCreate()
    sparkSession
  }
}
