package SampleTest

import org.apache.spark.sql.SparkSession
import org.scalatest._
import Sample.DFBasic._

class TestDFBasic extends FunSuite with BeforeAndAfterAll {

  @transient var spark: SparkSession = _

  override def beforeAll(): Unit = {
    spark = SparkSession.builder().appName("DFBasics").master("local").getOrCreate()
  }

  override def afterAll(): Unit = {
    spark.stop()
  }
  test ("Data File loading") {

    val sampleDF = loadEmployee(spark,"src/main/resources/customer.csv")
    val countDF = sampleDF.count()
    assert(countDF==8, "record should be 8")
  }

  test("")
}
