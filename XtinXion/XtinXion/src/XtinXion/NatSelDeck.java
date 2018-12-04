package XtinXion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is responsible for constructing the Natural Selection Deck
 * @author Jon Patman
 */
public final class NatSelDeck extends Deck {

    Scanner in;
    String CardNum;
    String title;
    String deck;
    String description;
    String UpCond;
    String LowCond;
    final int DECK_SIZE = 6;

    public NatSelDeck(String deckName) {
        super(deckName);

        for (int k = 1; k <= DECK_SIZE; k++) {
            String cardNum = "#" + Integer.toString(k);
            try {
                readFile(cardNum, deckName);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(NatSelDeck.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void readFile(String cardNum, String deckName) throws FileNotFoundException {
        File deckFile = new File(deckName);
        in = new Scanner(deckFile);
        String SENTINEL = "END";
        Boolean cardStop = false;
        Boolean cardFound = false;

        String value = in.nextLine();

        while (!value.equals(cardNum)) {
            value = in.nextLine(); // Adds card details to ArrayList  
        }
        NScontents.add(value); // Adds card identifier to ArrayList
        while (in.hasNext() && cardStop == false) {
            value = in.nextLine();
            NScontents.add(value);
            if (value.equals(SENTINEL)) {
                cardStop = true;
            } else if (!value.equals(SENTINEL)) {
                String[] ar = value.split(",");
                for (String ar1 : ar) {
                    //System.out.println(ar1);
                }
            }
        }
        for (int i = 0; i < NScontents.size(); i++) {
            String index = NScontents.get(i);
            if (index.contains(cardNum)) {
                CardNum = NScontents.get(i);
                title = NScontents.get(i + 1);
                deck = "Natural Selection Deck";
                description = NScontents.get(i + 2);
                UpCond = NScontents.get(i + 3);
                LowCond = NScontents.get(i + 4);
            }
        }
    }
}
