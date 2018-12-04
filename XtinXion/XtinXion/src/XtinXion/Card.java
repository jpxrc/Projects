package XtinXion;

import java.net.URL;
import javax.swing.ImageIcon;

public class Card {

    String CardNum;
    String title;
    String deck;
    String description;
    String UpCond;
    String LowCond;
    private final ImageIcon cardIcon;

    /**
     * Constructs a Card
     * @param CardNum Specific number that identifies a card in a given deck
     * @param title title of the card
     * @param deck the deck from which the card resides
     * @param description the description of what the card does
     * @param UpCond the upper condition that the card action compares to
     * @param LowCond the lower condition that the card action compares to
     */
    public Card(String CardNum, String title, String deck, String description, 
            String UpCond, String LowCond) {
        this.CardNum = CardNum;
        this.title = title;
        this.deck = deck;
        this.description = description;
        this.UpCond = UpCond;
        this.LowCond = LowCond;

        URL imgUrl = getClass().getResource("/images/" + title + ".jpg");
        cardIcon = new ImageIcon(imgUrl);

    }

    // Gets the image for this Card
    public ImageIcon getImageIcon() {
        return cardIcon;
    }
    
    // Gets the card number for this Card
    public String getCardNum() {
        return CardNum;
    }
    
    // Gets the title for this Card
    public String getTitle() {
        return title;
    }

    // Gets the deck for this Card
    public String getDeck() {
        return deck;
    }

    // Gets the description for this Card
    public String getDescription() {
        return description;
    }

    // Gets the upper condition for this Card
    public String getUpCond() {
        return UpCond;
    }

    // Gets the lower condition for this Card
    public String getLowCond() {
        return LowCond;
    }

    // Prints the toString method for this Card
    @Override
    public String toString() {
        String string = "\n" + CardNum + "\n" + title + "\n";
////        string += "Deck: " + deck + "\n";
        string += deck + "\n";
        string += description + "\n";
        //string += UpCond + "\n";
        //string += LowCond + "\n";
//        for (int i = 0; i < actions.size(); i++) {
//            string += actions.get(i) + "\n";
//        }
        return string;
    }

}
