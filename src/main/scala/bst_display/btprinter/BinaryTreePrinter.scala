package bst_display.btprinter

import utils.PNode

import scala.collection.immutable.ListMap
import utils.Utils._

case class BinaryTreePrinter(edgeLength : Int, dataLength : Int, paddingString : String, fn : String => Unit = print _) {

  //TODO : add validation, so that, edge length should always be greater then dataLength
  //Also, decide a max upper limit for dataLength and edgeLength

  def printTree[T](dataMap: Map[Int, T]): Unit = {
    val levelToNodesMap = groupByLevel(dataMap)
    //println(dataMap)
    //println(levelToNodesMap)

    val map: Map[Int, List[PNode[T]]] = enrichedMap(levelToNodesMap)(heightOfTree(dataMap))
    displayTree(map)
  }

  private def displayTree[T](levelToNodeMap: Map[Int, List[PNode[T]]]): Unit = {
    val sortedMap = ListMap(levelToNodeMap.toSeq.sortWith(_._1 > _._1): _*)

    sortedMap foreach { case (key, nodes) =>
      //println(s"level is $key, nodes are $nodes")
    }

    sortedMap foreach { case (key, pNodes) =>
      if (key > 0) {
        pNodes foreach { node =>

          val spaceCount = getSpaces(node.height)(dataLength, edgeLength)
          val edgeCount = getEdgeLength(node.height)(dataLength, edgeLength)
          print(" " * spaceCount)
          if (node.isLeftNodePresent) print("_" * edgeCount) else print(" " * edgeCount)

          if (node.isPresent)
            fn(pad(node.getData())(dataLength)(paddingString))
          else
            print(" " * dataLength)

          if (node.isRightNodePresent) print("_" * edgeCount) else print(" " * edgeCount)

          print(" " * spaceCount)

          print(" " * dataLength)
        }
        println()
      } else {
        pNodes foreach { node =>

          if (node.index % 2 == 0) {
            if (node.isPresent)
              fn(pad(node.getData())(dataLength)(paddingString))
            else
              print(" " * dataLength)
            print(" " * edgeLength)
            print(" " * dataLength)
          } else {
            print(" " * edgeLength)
            if (node.isPresent)
              fn(pad(node.getData())(dataLength)(paddingString))
            else
              print(" " * dataLength)
            print(" " * dataLength)
          }
        }
        println()
      }

    }
  }
}