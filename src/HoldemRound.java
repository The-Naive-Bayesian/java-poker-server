import cards.*;

import java.util.ArrayList;
import java.util.Comparator;

public class HoldemRound {
  Deck deck;
  CardCollection boardCards;
  Player[] players;

  HoldemRound(Player[] players) {
    deck = new Deck();
    boardCards = new CardCollection();
    this.players = players;
  }

  void play() {
    // TODO: handle cases where not all stages happen
    playPreFlop();
    playFlop();
    playTurn();
    playRiver();
    playShowdown();
  }

  // TODO: handle blinds
  private void playPreFlop() {
    for (Player player : players) {
      dealHoleCards(player);
    }
  }

  private void dealHoleCards(Player player) {
    CardCollection holeCards = new CardCollection();
    holeCards.add(deck.drawCard());
    holeCards.add(deck.drawCard());

    player.setHoleCards(holeCards);
  }

  private void playFlop() {
    drawFlopCards();
  }

  private void drawFlopCards() {
    for (int i=0; i<3; i++) {
      boardCards.add(deck.drawCard());
    }
  }

  private void playTurn() {
    boardCards.add(deck.drawCard());
  }

  private void playRiver() {
    boardCards.add(deck.drawCard());
  }

  private void playShowdown() {
    ArrayList<HoldemHand> hands = getPlayerHands(players);

    // Associate hands to players before sorting
    hands.sort(Comparator.reverseOrder());
  }

  private ArrayList<HoldemHand> getPlayerHands(Player[] players) {
    ArrayList<HoldemHand> hands = new ArrayList<>();

    for (Player player : players) {
      CardCollection potentialHandCards = new CardCollection();

      for (Card card : boardCards) {
        potentialHandCards.add(card);
      }
      for (Card card : player.holeCards) {
        potentialHandCards.add(card);
      }

      HoldemHand playerHand = HoldemHandService.getBestHand(potentialHandCards);
      hands.add(playerHand);
    }

    return hands;
  }
}
