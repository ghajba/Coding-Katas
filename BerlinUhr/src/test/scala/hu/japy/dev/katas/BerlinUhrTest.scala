package hu.japy.dev.katas

import org.junit._
import Assert._

@Test
class BerlinUhrTest {

  val berlin = new BerlinUhrClass

  @Test
  def test000000() = assertEquals("YOOOOOOOOOOOOOOOOOOOOOOO", berlin.berlinUhrAsSingleString("00:00:00"))

  @Test
  def test165006() = assertEquals("YRRROROOOYYRYYRYYRYOOOOO", berlin.berlinUhrAsSingleString("16:50:06"))

  @Test
  def test235959() = assertEquals("ORRRRRRROYYRYYRYYRYYYYYY", berlin.berlinUhrAsSingleString("23:59:59"))

  @Test
  def test113701() = assertEquals("ORROOROOOYYRYYRYOOOOYYOO", berlin.berlinUhrAsSingleString("11:37:01"))

}


