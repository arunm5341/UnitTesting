package SampleTest

import Sample.WordCount

class SparkBatchTest extends TestWordCount {
  "should test WordCount" in {
    val lines = Array("to be or not to be", "that is the question")
    val rdd = sc.parallelize(lines)
    val wordCount = WordCount.count(rdd)
    val wordCountValue = wordCount.collect()
    wordCountValue should contain allOf  (("be", 2), ("is", 1), ("not", 1), ("or", 1), ("question", 1),
      ("that", 1), ("to", 2), ("the",1))
  }

  "should do WordCount on empty rdd" in {
    val lines = Array.empty[String]
    val rdd = sc.parallelize(lines)
    val wordCount = WordCount.count(rdd).collect()
    wordCount shouldBe empty
  }
}


