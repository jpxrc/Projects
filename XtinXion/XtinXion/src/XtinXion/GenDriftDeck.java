package XtinXion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class Constructs the Genetic Drift Deck
 * @author Jon Patman
 */
public final class GenDriftDeck extends Deck {

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
    public GenDriftDeck(String deckName) {
        super(deckName);

        for (int k = 1; k <= DECK_SIZE; k++) {
            String cardNum = "#" + Integer.toString(k);
            try {
                readFile(cardNum, deckName);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GenDriftDeck.class.getName())
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
        GDcontents.add(value); // Adds card identifier to ArrayList
        while (in.hasNext() && cardStop == false) {
            value = in.nextLine();
            GDcontents.add(value);
            if (value.equals(SENTINEL)) {
                cardStop = true;
            } else if (!value.equals(SENTINEL)) {
                String[] ar = value.split(",");
                for (String ar1 : ar) {
                    //System.out.println(ar1);
                }
            }
        }
        for (int i = 0; i < GDcontents.size(); i++) {
            String index = GDcontents.get(i);
            if (index.contains(cardNum)) {
                CardNum = GDcontents.get(i);
                title = GDcontents.get(i + 1);
                deck = "Genetic Drift Deck";
                description = GDcontents.get(i + 2);
                UpCond = GDcontents.get(i + 3);
                LowCond = GDcontents.get(i + 4);

            }
        }
    }
}
