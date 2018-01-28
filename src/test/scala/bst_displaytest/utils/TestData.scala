package bst_displaytest.utils

trait TestData {
  implicit class TreeListExtension[T](treeData : Map[Int, T]){
    def dropNodes(indexes : Int*) : Map[Int, T] = {
      treeData filter { t => !indexes.contains(t._1) }
    }
  }

  def getIntList(length : Int) : Map[Int, Int] = {
    val random = scala.util.Random
    def nextVal = random.nextInt(99) + 1
    val array = Array.tabulate(length){i => (i + 1, nextVal)}
    array.toMap
  }
}