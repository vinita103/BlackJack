
import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    // instance variable

    private ArrayList<Card> deck;

    // Creating constructor for class Deck

    public Deck() {
        this.deck = new ArrayList<Card>();
    }

    // Creating method to create full deck

    public void createFullDeck() {
        // generate cards
        for (Suits cardSuit : Suits.values()) {
            for (Values cardValue : Values.values()) {

                // Adding a new card to the deck
                this.deck.add(new Card(cardSuit, cardValue));

            }
        }

    }

    public String toString() {
        String cardListOutput = "";
        for (Card aCard : this.deck) {
            cardListOutput += "\n" + "-" + aCard.toString();

        }
        return cardListOutput;
    }

    // Creating method to shuffle deck

    public void shuffleDeck() {
        Collections.shuffle(deck);

    }

    // method to get card from the deck

    public Card getCard(int i) {
        return this.deck.get(i);
    }

    // method to remove card from the deck

    public void removeCard(int i) {
        this.deck.remove(i);
    }

    // method to add card to deck

    public void addCard(Card addCard) {
        this.deck.add(addCard);
    }

    // Get the size of the deck

    public int deckSize() {
        return this.deck.size();
    }

    // Draws from the deck
    public void draw(Deck comingFrom) {
        this.deck.add(comingFrom.getCard(0));
        comingFrom.removeCard(0);

    }

    // This will move cards back into the deck to continue playing
    public void moveAllToDeck(Deck moveTo) {

        int thisDeckSize = this.deck.size();

        // put cards into moveTo deck

        for (int i = 0; i < thisDeckSize; i++) {

            moveTo.addCard(this.getCard(i));
        }

        for (int i = 0; i < thisDeckSize; i++) {

            this.removeCard(0);

        }

    }

    // Return total value of cards in deck

    public int deckValue() {
        int totalValue = 0;
        int aces = 0;
        for (Card aCard : this.deck) {
            switch (aCard.getValue()) {
                case TWO:
                    totalValue += 2;
                    break;
                case THREE:
                    totalValue += 3;
                    break;
                case FOUR:
                    totalValue += 4;
                    break;
                case FIVE:
                    totalValue += 5;
                    break;
                case SIX:
                    totalValue += 6;
                    break;
                case SEVEN:
                    totalValue += 7;
                    break;
                case EIGHT:
                    totalValue += 8;
                    break;
                case NINE:
                    totalValue += 9;
                    break;
                case TEN:
                    totalValue += 10;
                    break;
                case JACK:
                    totalValue += 10;
                    break;
                case QUEEN:
                    totalValue += 10;
                    break;
                case KING:
                    totalValue += 10;
                    break;
                case ACE:
                    aces += 1;
                    break;

            }

        }

        // Determine value of aces 1 or 11

        for (int i = 0; i < aces; i++) {

            if (totalValue > 10) {
                totalValue += 1;

            } else {
                totalValue += 11;

            }

        }

        return totalValue;

    }

}
