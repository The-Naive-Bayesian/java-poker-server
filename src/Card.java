public class Card implements Comparable<Card> {
  public final FaceValue value;
  public final Suite suite;

  public Card(FaceValue value, Suite suite) {
    this.value = value;
    this.suite = suite;
  }

  @Override
  public int compareTo(Card other) {
    return this.value.rank - other.value.rank;
  }
}
