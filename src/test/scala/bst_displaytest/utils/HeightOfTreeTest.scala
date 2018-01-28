package bst_displaytest.utils

import org.scalatest.FlatSpecLike
import org.scalatest.Matchers._
import utils.Utils._

class HeightOfTreeTest extends FlatSpecLike with TestData{


  "height of tree having level 0 nodes only" should "be 0" in {
    val data = getIntList(1)
    heightOfTree(data) should be(0)
  }

  "height of tree having level 1 nodes only" should "be 1" in {
    val data = getIntList(3)
    heightOfTree(data) should be(1)
    val data2 = data.dropNodes(2)
    heightOfTree(data2) should be(1)
    val data3 = data.dropNodes(3)
    heightOfTree(data3) should be(1)
    val data4 = data.dropNodes(2, 3)
    heightOfTree(data4) should be(0)
  }

  "height of tree having level 2 nodes only" should "be 2" in {
    val data = getIntList(7)
    heightOfTree(data) should be(2)
    val data2 = data.dropNodes(6)
    heightOfTree(data2) should be(2)
    val data3 = data.dropNodes(4, 5, 6)
    heightOfTree(data3) should be(2)
    val data4 = data.dropNodes(4, 5, 6, 7)
    heightOfTree(data4) should be(1)
  }
}
