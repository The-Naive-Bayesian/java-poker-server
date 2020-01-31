import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardTests {
  @Test
  void compareLess() {
    Card card1 = new Card(FaceValue.THREE, Suite.DIAMOND);
    Card card2 = new Card(FaceValue.FIVE, Suite.CLUB);

    assertTrue(card1.compareTo(card2) < 0);
  }

  @Test
  void compareGreater() {
    Card card1 = new Card(FaceValue.KING, Suite.SPADE);
    Card card2 = new Card(FaceValue.TEN, Suite.HEART);

    assertTrue(card1.compareTo(card2) > 0);
  }

  @Test
  void compareEqual() {
    Card card1 = new Card(FaceValue.ACE, Suite.CLUB);
    Card card2 = new Card(FaceValue.ACE, Suite.SPADE);

    assertEquals(card1.compareTo(card2), 0);
  }
}
