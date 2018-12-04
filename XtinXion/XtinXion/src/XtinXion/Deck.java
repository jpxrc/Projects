package XtinXion;

import java.util.ArrayList;
import java.util.Random;

public class Deck extends ArrayList<Card> {

    String deckName;

    //ArrayList contains all details about a Card
    //index 0 - CardNum
    //index 1 - title
    //index 2 - description
    //index 3 - Upper condition
    //index 4 - Lower condition
    //index 5 - SENTINEL
    public ArrayList<String> NScontents = new ArrayList<>();
    public ArrayList<String> GDcontents = new ArrayList<>();
    public ArrayList<String> MDcontents = new ArrayList<>();
    NatSelDeck NSD;
    GenDriftDeck GDD;
    MutationDeck MD;

    /**
     * Constructor that builds a Deck
     *
     * @param deckName Name of this deck
     */
    public Deck(String deckName) {
        this.deckName = deckName;

        // Creates Natural Selection Deck
        if (deckName.equals("NatSelDeck")) {
            NSD = new NatSelDeck("NatSelDeck.txt");
            for (int i = 0; i < 1; i++) {
                NSD.add(new Card(NSD.NScontents.get(i), 
                        NSD.NScontents.get(i + 1),
                        deckName, NSD.NScontents.get(i + 2), 
                        NSD.NScontents.get(i + 3),
                        NSD.NScontents.get(i + 4)));
            }
            for (int i = 6; i < 7; i++) {
                NSD.add(new Card(NSD.NScontents.get(i), 
                        NSD.NScontents.get(i + 1),
                        deckName, NSD.NScontents.get(i + 2), 
                        NSD.NScontents.get(i + 3),
                        NSD.NScontents.get(i + 4)));
            }
            for (int i = 12; i < 13; i++) {
                NSD.add(new Card(NSD.NScontents.get(i), 
                        NSD.NScontents.get(i + 1),
                        deckName, NSD.NScontents.get(i + 2), 
                        NSD.NScontents.get(i + 3),
                        NSD.NScontents.get(i + 4)));
            }
            for (int i = 18; i < 19; i++) {
                NSD.add(new Card(NSD.NScontents.get(i), 
                        NSD.NScontents.get(i + 1),
                        deckName, NSD.NScontents.get(i + 2), 
                        NSD.NScontents.get(i + 3),
                        NSD.NScontents.get(i + 4)));
            }
            for (int i = 24; i < 25; i++) {
                NSD.add(new Card(NSD.NScontents.get(i), 
                        NSD.NScontents.get(i + 1),
                        deckName, NSD.NScontents.get(i + 2), 
                        NSD.NScontents.get(i + 3),
                        NSD.NScontents.get(i + 4)));
            }
            for (int i = 30; i < 31; i++) {
                NSD.add(new Card(NSD.NScontents.get(i), 
                        NSD.NScontents.get(i + 1),
                        deckName, NSD.NScontents.get(i + 2), 
                        NSD.NScontents.get(i + 3),
                        NSD.NScontents.get(i + 4)));
            }
        }

        // Creates Genetic Drift Deck
        if (deckName.equals("GenDriftDeck")) {
            GDD = new GenDriftDeck("GenDriftDeck.txt");
            for (int i = 0; i < 1; i++) {
                GDD.add(new Card(GDD.GDcontents.get(i), 
                        GDD.GDcontents.get(i + 1),
                        deckName, GDD.GDcontents.get(i + 2), 
                        GDD.GDcontents.get(i + 3),
                        GDD.GDcontents.get(i + 4)));
            }
            for (int i = 6; i < 7; i++) {
                GDD.add(new Card(GDD.GDcontents.get(i), 
                        GDD.GDcontents.get(i + 1),
                        deckName, GDD.GDcontents.get(i + 2), 
                        GDD.GDcontents.get(i + 3),
                        GDD.GDcontents.get(i + 4)));
            }
            for (int i = 12; i < 13; i++) {
                GDD.add(new Card(GDD.GDcontents.get(i), 
                        GDD.GDcontents.get(i + 1),
                        deckName, GDD.GDcontents.get(i + 2), 
                        GDD.GDcontents.get(i + 3),
                        GDD.GDcontents.get(i + 4)));
            }
            for (int i = 18; i < 19; i++) {
                GDD.add(new Card(GDD.GDcontents.get(i), 
                        GDD.GDcontents.get(i + 1),
                        deckName, GDD.GDcontents.get(i + 2), 
                        GDD.GDcontents.get(i + 3),
                        GDD.GDcontents.get(i + 4)));
            }
            for (int i = 24; i < 25; i++) {
                GDD.add(new Card(GDD.GDcontents.get(i), 
                        GDD.GDcontents.get(i + 1),
                        deckName, GDD.GDcontents.get(i + 2), 
                        GDD.GDcontents.get(i + 3),
                        GDD.GDcontents.get(i + 4)));
            }
        }

        // Creates Mutation Deck
        if (deckName.equals("MutationDeck")) {
            MD = new MutationDeck("MutationDeck.txt");
            for (int i = 0; i < 1; i++) {
                MD.add(new Card(MD.MDcontents.get(i), 
                        MD.MDcontents.get(i + 1),
                        deckName, MD.MDcontents.get(i + 2), 
                        MD.MDcontents.get(i + 3),
                        MD.MDcontents.get(i + 4)));
            }
            for (int i = 6; i < 7; i++) {
                MD.add(new Card(MD.MDcontents.get(i), MD.MDcontents.get(i + 1),
                        deckName, MD.MDcontents.get(i + 2), 
                        MD.MDcontents.get(i + 3),
                        MD.MDcontents.get(i + 4)));
            }
            for (int i = 12; i < 13; i++) {
                MD.add(new Card(MD.MDcontents.get(i), MD.MDcontents.get(i + 1),
                        deckName, MD.MDcontents.get(i + 2), 
                        MD.MDcontents.get(i + 3),
                        MD.MDcontents.get(i + 4)));
            }
            for (int i = 18; i < 19; i++) {
                MD.add(new Card(MD.MDcontents.get(i), MD.MDcontents.get(i + 1),
                        deckName, MD.MDcontents.get(i + 2), 
                        MD.MDcontents.get(i + 3),
                        MD.MDcontents.get(i + 4)));
            }
            for (int i = 24; i < 25; i++) {
                MD.add(new Card(MD.MDcontents.get(i), MD.MDcontents.get(i + 1),
                        deckName, MD.MDcontents.get(i + 2), 
                        MD.MDcontents.get(i + 3),
                        MD.MDcontents.get(i + 4)));
            }
        }
    }

    /**
     * Draws a random card from the specified deck
     * @param deckName the name of this Deck
     * @return returns a Card from this Deck
     */
    public Card drawCard(String deckName) {
        this.deckName = deckName;
        Random draw = new Random();
        int index;
        Card randCard = null;

        if (deckName.equals("NatSelDeck")) {
            index = draw.nextInt(NSD.size());
            if (index > -1) {
                randCard = NSD.get(index);
            }
        }
        if (deckName.equals("GenDriftDeck")) {
            index = draw.nextInt(GDD.size());
            if (index > -1) {
                randCard = GDD.get(index);
            }
        }
        if (deckName.equals("MutationDeck")) {
            index = draw.nextInt(MD.size());
            if (index > -1) {
                randCard = MD.get(index);
            }
        }

        return randCard;
    }

}
