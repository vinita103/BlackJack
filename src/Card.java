
import java.util.Random;

public class Card {

    private Suits suit;
    private Values value;

    // create arrays for values and suits - need these to generate random cards
    private Values[] values = Values.values();
    private Random randomValues = new Random();
    private Suits[] suits = Suits.values();
    private Random randomSuits = new Random();

    // creating constructor for class card

    public Card(Suits suit, Values value) {

        this.suit = suit;
        this.value = value;
    }

    // random card generated
    public Card() {
        this.suit = getRandomSuit();
        this.value = getRandomValue();
    }

    // Creating method to print suit and value

    public String toString() {
        return this.suit.toString() + "-" + this.value.toString();
    }

    // Creating method to get value of card

    public Values getValue() {
        return this.value;
    }

    // Creating method to get random value of card

    public Values getRandomValue() {
        return values[randomValues.nextInt(values.length)];
    }

    // Creating method to get random suit of card

    public Suits getRandomSuit() {
        return suits[randomSuits.nextInt(values.length)];
    }
}
