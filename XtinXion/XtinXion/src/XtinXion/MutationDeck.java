package XtinXion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is responsible for constructing the Mutation Deck
 *
 * @author Jon Patman
 */
public final class MutationDeck extends Deck {

    Scanner in;
    String CardNum;
    String title;
    String deck;
    String description;
    String UpCond;
    String LowCond;
    final int DECK_SIZE = 5;

    //public ArrayList<String> contents;
    //ArrayList contains all details about a Card
    //index 0 - CardNum
    //index 1 - title
    //index 2 - description
    //index 3 - Upper condition
    //index 4 - Lower condition
    //index 5 - SENTINEL
    public MutationDeck(String deckName) {
        super(deckName);

        for (int k = 1; k <= DECK_SIZE; k++) {
            String cardNum = "#" + Integer.toString(k);
            try {
                readFile(cardNum, deckName);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MutationDeck.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
    }

    public void readFile(String cardNum, String deckName)
            throws FileNotFoundException {
        File deckFile = new File(deckName);
        in = new Scanner(deckFile);
        String SENTINEL = "END";
        Boolean cardStop = false;
        Boolean cardFound = false;

        String value = in.nextLine();

        while (!value.equals(cardNum)) {
            value = in.nextLine(); // Adds card details to ArrayList  
        }
        MDcontents.add(value); // Adds card identifier to ArrayList
        while (in.hasNext() && cardStop == false) {
            value = in.nextLine();
            MDcontents.add(value);
            if (value.equals(SENTINEL)) {
                cardStop = true;
            } else if (!value.equals(SENTINEL)) {
                String[] ar = value.split(",");
                for (String ar1 : ar) {
                    //System.out.println(ar1);
                }
            }
        }
        for (int i = 0; i < MDcontents.size(); i++) {
            String index = MDcontents.get(i);
            if (index.contains(cardNum)) {
                CardNum = MDcontents.get(i);
                title = MDcontents.get(i + 1);
                deck = "Mutation Deck";
                description = MDcontents.get(i + 2);
                UpCond = MDcontents.get(i + 3);
                LowCond = MDcontents.get(i + 4);
            }
        }
    }
}
