import cards.CardCollection;
import cards.Deck;

public class HoldemRound {
  Deck deck;
  CardCollection boardCards;

  HoldemRound() {
    deck = new Deck();
    boardCards = new CardCollection();
  }

  void play() {
    // TODO: handle cases where not all stages happen
    playPreflop();
    playFlop();
    playTurn();
    playRiver();
    playShowdown();
    settleRound();
  }

  private void playPreflop() { }

  private void playFlop() { }

  private void playTurn() { }

  private void playRiver() { }

  private void playShowdown() { }

  private void settleRound() { }
}
