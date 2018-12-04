package XtinXion;

import java.util.ArrayList;

/**
 * This class is responsible for creating the GameBoard for which the decks &
 * slot locations reside
 * @author Jon Patman
 */
public class GameBoard {

    Deck NatSelDeck;
    Deck GenDriftDeck;
    Deck MutationDeck;
    String NatSelSlot = "NatSelDeck";
    String GenDriftSlot = "GenDriftDeck";
    String MutationSlot = "MutationDeck";
    String BattleSlot = "Battle";
    public Card CurrentCard;
    Game BattleGame;
    public int boardIndex;
    public int HumanPosition = 0;
    public int ComputerPosition;
    private int initialComputerPosition = 20;
    int humanBoardIndex;
    int compBoardIndex;
    private int initialRoll;
    public String CurrentPlayer;
    private int compFirstPlay = 0;

    // The arraylist that simulates a physical game board
    ArrayList<String> GameBoard = new ArrayList<>();

    /**
     * This method is responsible for building the GameBoard
     */
    public GameBoard() {
        NatSelDeck = new Deck("NatSelDeck");
        GenDriftDeck = new Deck("GenDriftDeck");
        MutationDeck = new Deck("MutationDeck");
        
        // Number of "slots" on gameboard
        GameBoard.add(GenDriftSlot);
        GameBoard.add(NatSelSlot);
        GameBoard.add(BattleSlot);
        GameBoard.add(MutationSlot);
        GameBoard.add(GenDriftSlot);
        GameBoard.add(NatSelSlot);
        GameBoard.add(NatSelSlot);
        GameBoard.add(BattleSlot);
        GameBoard.add(MutationSlot);
        GameBoard.add(NatSelSlot);
        GameBoard.add(GenDriftSlot);
        GameBoard.add(NatSelSlot);
        GameBoard.add(BattleSlot);
        GameBoard.add(NatSelSlot);
        GameBoard.add(GenDriftSlot);
        GameBoard.add(MutationSlot);
        GameBoard.add(NatSelSlot);
        GameBoard.add(BattleSlot);
        GameBoard.add(GenDriftSlot);
        GameBoard.add(NatSelSlot);
        GameBoard.add(MutationSlot);
        GameBoard.add(NatSelSlot);
        GameBoard.add(BattleSlot);
        GameBoard.add(NatSelSlot);
        GameBoard.add(NatSelSlot);
        GameBoard.add(MutationSlot);
        GameBoard.add(NatSelSlot);
        GameBoard.add(BattleSlot);
        GameBoard.add(GenDriftSlot);
        GameBoard.add(NatSelSlot);
        GameBoard.add(MutationSlot);
        GameBoard.add(NatSelSlot);
        GameBoard.add(BattleSlot);
        GameBoard.add(GenDriftSlot);
        GameBoard.add(NatSelSlot);
        GameBoard.add(NatSelSlot);
        GameBoard.add(MutationSlot);
        GameBoard.add(BattleSlot);
        GameBoard.add(GenDriftSlot);
        GameBoard.add(MutationSlot);
    }

    /**
     * Simulates landing on a spot on the gameboard
     * @param CurrentPlayer the current player
     * @return returns a card corresponding to a location on the gameboard
     */
    public Card playBoard(String CurrentPlayer) {
        this.CurrentPlayer = CurrentPlayer;
        String randSlot = "";
        Card randCard = null;
        
        if (CurrentPlayer.equals("HUMAN")){
        initialRoll = (int)(Math.random()*4)+1;
        System.out.println("human roll = " + initialRoll);
        HumanPosition += initialRoll;
        if (HumanPosition > 39) {
            HumanPosition = HumanPosition - 40;
        }
        boardIndex = HumanPosition;
        randSlot = GameBoard.get(boardIndex);
        
        }
        else if(CurrentPlayer.equals("COMPUTER")){
        initialRoll = (int)(Math.random()*4)+1;
        System.out.println("computer roll = " + initialRoll);
        
        if(compFirstPlay == 0){
        initialComputerPosition += initialRoll;
        boardIndex = initialComputerPosition;
        ComputerPosition = boardIndex;
        compFirstPlay = 1;
        }
        else if(compFirstPlay == 1){
        ComputerPosition = initialRoll;
        if (ComputerPosition > 39) {
            ComputerPosition = ComputerPosition - 40;
        }
        boardIndex = ComputerPosition;
        compFirstPlay = 1;
        }

        }
        if (boardIndex > -1) {
            randSlot = GameBoard.get(boardIndex);
        }
        if (randSlot.equals("NatSelDeck")) {
            randCard = NatSelDeck.drawCard("NatSelDeck");
        }
        if (randSlot.equals("GenDriftDeck")) {
            randCard = GenDriftDeck.drawCard("GenDriftDeck");
        }
        if (randSlot.equals("MutationDeck")) {
            randCard = MutationDeck.drawCard("MutationDeck");
        }
        if (randSlot.equals("Battle")) {
            System.out.println("Battle Time!");
            Card BattleCard = new Card(" ", "BattleCard", " ", 
                    " ", "PopLevel,0,INCREASE,PopLevel,0", 
                    "PopLevel,0,INCREASE,PopLevel,0");
            randCard = BattleCard;
        }

        System.out.println("Move spaces = " + initialRoll);
        return randCard;
    }

    /**
     * Gets the Natural Selection Deck
     * @return returns the deck
     */
    public Deck getNatSelDeck() {
        return NatSelDeck;
    }

    /**
     * Gets the Genetic Drift Deck
     * @return returns the deck
     */
    public Deck getGenDrift() {
        return GenDriftDeck;
    }

    /**
     * Gets the Mutation Deck
     * @return returns the deck
     */
    public Deck getMutationDeck() {
        return MutationDeck;
    }

    /**
     * Gets the human board index
     * @return returns the index
     */
    public int getHumanBoardIndex() {
        humanBoardIndex = boardIndex;

        if (humanBoardIndex > 39) {
            humanBoardIndex = humanBoardIndex - 40;
        }
        return humanBoardIndex;
    }

    /**
     * Gets the computer board index
     * @return returns the index
     */
    public int getCompBoardIndex() {
        compBoardIndex += boardIndex;

        if (compBoardIndex > 39) {
            compBoardIndex = compBoardIndex - 40;
        }
        return compBoardIndex;
    }
    /**
     * Gets value for the initial dice rolled
     * @return returns the initial value of the dice
     */
    public int getInitialRoll(){
        return initialRoll;
    }

}
