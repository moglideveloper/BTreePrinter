package bst_displaytest.utils

import org.scalatest.FlatSpecLike
import org.scalatest.Matchers._
import utils.Utils._

class GetSpacesTest extends FlatSpecLike{

  val dataSize = 3
  val edgeLength = 5

  s"spaces for node at height 1, data-size $dataSize, edge-length $edgeLength" should s"be 3" in {
    val spaces = getSpaces(1)(dataSize, edgeLength)
    spaces should be(3)
  }

  s"spaces for node at height 2, data-size $dataSize, edge-length $edgeLength" should s"be 11" in {
    val spaces = getSpaces(2)(dataSize, edgeLength)
    spaces should be(11)
  }

  s"spaces for node at height 3, data-size $dataSize, edge-length $edgeLength" should s"be 22" in {
    val spaces = getSpaces(3)(dataSize, edgeLength)
    spaces should be(22)
  }

  s"spaces for node at height 4, data-size $dataSize, edge-length $edgeLength" should s"be 44" in {
    val spaces = getSpaces(4)(dataSize, edgeLength)
    spaces should be(44)
  }

  s"spaces for node at height 5, data-size $dataSize, edge-length $edgeLength" should s"be 88" in {
    val spaces = getSpaces(5)(dataSize, edgeLength)
    spaces should be(88)
  }
}
