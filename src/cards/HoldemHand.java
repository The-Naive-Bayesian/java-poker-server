package cards;

public abstract class HoldemHand implements Comparable<HoldemHand> {
  protected HoldemHandType type;
  protected CardCollection cards;

  HoldemHandType getType() {
    return type;
  }

  CardCollection getCards() {
    return cards;
  }
}
