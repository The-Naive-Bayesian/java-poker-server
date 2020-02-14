import cards.CardCollection;

public class Player {
  CardCollection holeCards;
  final String name;

  Player(String name) {
    this.name = name;
  }

  public void setHoleCards(CardCollection holeCards) {
    this.holeCards = holeCards;
  }
}
