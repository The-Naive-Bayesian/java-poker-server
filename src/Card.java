public class Card implements Comparable<Card> {
  final FaceValue value;
  final Suite suite;

  Card(FaceValue value, Suite suite) {
    this.value = value;
    this.suite = suite;
  }

  @Override
  public int compareTo(Card other) {
    return this.value.rank - other.value.rank;
  }
}
