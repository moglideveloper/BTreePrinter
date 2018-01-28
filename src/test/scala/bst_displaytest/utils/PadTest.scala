package bst_displaytest.utils

import org.scalatest.FlatSpecLike
import org.scalatest.Matchers._
import utils.Utils._

class PadTest extends FlatSpecLike{

  "for width greater then data size, padding" should "be added" in {
    val i = 12
    val result = pad(i + "")(5)("_")
    result should be("___12")
  }

  "for data size greater then width, data" should "be trimmed" in {
    val s = "abcdefghi"
    val result = pad(s)(5)("_")
    result should be("abcde")
  }
}
