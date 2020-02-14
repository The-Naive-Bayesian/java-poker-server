package cards;

public class HoldemHandService {
  // TODO: include more than high card hands
  public static HoldemHand getBestHand(CardCollection cards) {
    return buildHighCardHand(cards);
  }

  private static HoldemHand buildHighCardHand(CardCollection cards) {
    // NOTE: the CardCollection iterator goes highest -> lowest by default
    // TODO: remove this assumption
    CardCollection handCards = new CardCollection();

    int i=0;
    for (Card card : cards) {
      handCards.add(card);

      if (++i == 5) break;
    }

    return new HighCardHand(handCards);
  }
}
