package utils

object Utils {

  val dataLength = 7

  def depthFromIndex(index: Int): Int = {
    val binary = Integer.toBinaryString(index)
    binary.length - 1
  }

  def heightOfTree[T](treeData: Map[Int, T]): Int = {
    val maxIndex = treeData.keys.max
    Integer.toBinaryString(maxIndex).length - 1
  }

  def pad[T](s: T)(width: Int)(paddingString : String): String = {
    val padLength = width - s.toString.length

    if (padLength > 0) {
      val us = paddingString * padLength
      us + s
    }else{
      s.toString.substring(0, width)
    }
  }

  def groupByLevel[T](treeData : Map[Int, T]): Map[Int, List[DataPNode[T]]] = {
    val treeHeight = heightOfTree(treeData)
    val data = treeData map { case(index, data) => DataPNode(data, index, treeHeight - depthFromIndex(index), true, treeData.contains(2 * index), treeData.contains(2 * index + 1)) }
    val mapOfLeveltoListOfNodes = data.toList groupBy { data => data.height }
    mapOfLeveltoListOfNodes
  }

  def enrichedMap[T](levelToNodesMap: Map[Int, List[DataPNode[T]]])(heightOfTree : Int): Map[Int, List[PNode[T]]] = {
    val map: Map[Int, List[PNode[T]]] = levelToNodesMap map { case (levelInTree, levelNodes) =>
      val pNodes = enrichMissingNodes(heightOfTree, levelInTree, levelNodes)
      (levelInTree -> pNodes)
    }
    map
  }

  def getSpaces(currentNodeHeightInTree : Int)(wordSize : Int, edgeLength : Int) : Int = {
    (currentNodeHeightInTree == 1) match {
      case true => 1 * wordSize + 0 * edgeLength
      case false => scala.math.pow(2, currentNodeHeightInTree - 1).toInt * wordSize + scala.math.pow(2, currentNodeHeightInTree - 2).toInt * edgeLength
    }
  }

  def getEdgeLength(currentNodeHeightInTree : Int)(wordSize : Int, edgeLength : Int) : Int = {
    (currentNodeHeightInTree == 1) match {
      case true => 0 * wordSize + 1 * edgeLength
      case false => (scala.math.pow(2, currentNodeHeightInTree - 1).toInt - 1) * wordSize + scala.math.pow(2, currentNodeHeightInTree - 2).toInt * edgeLength
    }
  }

  def enrichMissingNodes[T](heightOfTree : Int, levelOfNodeInTree : Int, nodes : List[PNode[T]]) : List[PNode[T]] = {

    //TODO : check weather existing nodes belongs to passed level or not

    val existingIndexes = nodes map { node => node.index }

    val factor = scala.math.pow(2, heightOfTree - levelOfNodeInTree).toInt

    val expectedIndexes = (factor to 2 * factor - 1) filter ( ei => !existingIndexes.contains(ei) )

    val expectedNodes: List[PNode[T]] = (expectedIndexes map { i => EmptyPNode[T](dataLength, i, levelOfNodeInTree, false, false, false) }).toList

    val totalNodes = (nodes ++ expectedNodes).sortBy(_.index)

    //println("level is " + level + ", expectedIndexes : " + totalNodes)

    totalNodes
  }
}

trait PNode[T]{
  def index : Int
  def height : Int
  def isPresent : Boolean
  def isLeftNodePresent : Boolean
  def isRightNodePresent : Boolean

  def getData() : String
}

case class EmptyPNode[T](dataLength : Int, index : Int, height : Int, isPresent : Boolean, isLeftNodePresent : Boolean, isRightNodePresent : Boolean) extends PNode[T]{
  override def getData(): String = " " * dataLength
}

case class DataPNode[T](data : T, index : Int, height : Int, isPresent : Boolean, isLeftNodePresent : Boolean, isRightNodePresent : Boolean) extends PNode[T]{
  override def getData(): String = data.toString
}