package bst_displaytest.utils

import org.scalatest.FlatSpecLike
import utils.Utils._

class GroupByLevelTest extends FlatSpecLike with TestData{

  "group by level" should "group treedata" in {
    val treeData = getIntList(7)
    val heightToNodesMap = groupByLevel(treeData)
    println(treeData)
    println(heightToNodesMap)
//    val map = Map(2 -> List((990,1,2)), 1 -> List((214,2,1), (931,3,1)), 0 -> List((285,4,0), (46,5,0), (69,6,0), (180,7,0)))
//    heightToNodesMap should be(map)

    //val sortedKeys = heightToNodesMap.keys.toList.sorted.reverse






    //println(sortedKeys)
  }
}
