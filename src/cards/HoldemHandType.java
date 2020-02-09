package cards;

public enum HoldemHandType implements Comparable<HoldemHandType> {
  HIGH_CARD,
  PAIR,
  TWO_PAIR,
  STRAIGHT,
  FLUSH,
  FULL_HOUSE,
  THREE_OF_A_KIND,
  FOUR_OF_A_KIND,
  STRAIGHT_FLUSH;
}
