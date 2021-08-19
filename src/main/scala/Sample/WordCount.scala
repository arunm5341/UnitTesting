package Sample

import org.apache.spark.rdd.RDD

object WordCount extends App {
  def count(lines: RDD[String]): RDD[(String, Int)] = {
    lines.flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .reduceByKey(_ + _)
  }
}
