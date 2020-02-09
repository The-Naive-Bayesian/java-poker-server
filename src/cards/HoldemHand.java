package cards;

abstract class HoldemHand implements Comparable<HoldemHand> {
  private HoldemHandType type;
  private CardCollection cards;

  HoldemHandType getType() {
    return type;
  }

  CardCollection getCards() {
    return cards;
  }
}
