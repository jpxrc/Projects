package XtinXion;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class creates a Game which is responsible for calling constructors of
 * the Decks, and Board
 *
 * @author Jon Patman
 */
public class Game {

    private GameBoard Board;
    public Human human;
    public Computer computer;
    private String name;
    private String SpeciesName;
    public Card CurrentCard;
    private int HumanLife;
    private int ComputerLife;
    public String WinningPlayer;
    public String compSpecies;
    private int HumanDice;
    private int ComputerDice;
    private int HumanWin;
    private int ComputerWin;
    public int rollValue;
    public int roll;
    public String cardNum;
    public String deckName;
    public String BattleWinner;
    String cardGraphicLocation;
    public boolean GameOver = false;
    public String CurrentPlayer;
    Random compSpeciesRandom = new Random();
    ArrayList<String> CompSpecies = new ArrayList<>();

    private int EnvStrTol;
    private int PredAvoEva;
    private int MateAtt;
    private int Forage;
    private int TerrDef;
    private int PopLevel;

    //Upper Condition variables from Card
    public String firstParamUP;
    public String INCREASE;
    public String secondParamUP;
    public int firstValueUP;
    public int secondValueUP;
    public int yourFirstParamUP;
    public int yourSecondParamUP;

    //Lower Condition variables from Card
    public String firstParamLOW;
    public String DECREASE;
    public String secondParamLOW;
    public int firstValueLOW;
    public int secondValueLOW;
    public int yourFirstParamLOW;
    public int yourSecondParamLOW;

    /**
     * Constructor that creates this Game
     *
     * @param GameBoard the GameBoard on which the game takes place
     * @param name the name of the player
     * @param SpeciesName the name of the player's species
     */
    public Game(GameBoard GameBoard, String name, String SpeciesName) {
        this.Board = GameBoard;
        this.name = name;
        this.SpeciesName = SpeciesName;
        String ComputerSpecies = pickCompSpecies();
        human = new Human(name, SpeciesName, EnvStrTol, PredAvoEva, MateAtt,
                Forage, TerrDef, PopLevel);
        computer = new Computer(ComputerSpecies, EnvStrTol, PredAvoEva,
                MateAtt, Forage, TerrDef, PopLevel);
        System.out.println("\nPlayer Name = " + human.getName());
        System.out.println("Species Name = " + human.getSpeciesName());
        System.out.println("Environmental Stress Tolerance = " 
                + human.getEnvStrTol());
        System.out.println("Predator Avoidance & Evasion = " 
                + human.getPredAvoEva());
        System.out.println("Mate Attraction = " + human.getMateAtt());
        System.out.println("Forage = " + human.getForage());
        System.out.println("Territorial Defense = " + human.getTerrDef());
        System.out.println("Population = " + human.getPopLevel());
        System.out.println("\nComputer has chosen " 
                + computer.getSpeciesName());
    }

    /**
     * This method is responsible for handling the actions in a card
     *
     * @param CurrentCard the card that is drawn
     */
    public void processCardHuman(Card CurrentCard) {
        this.CurrentCard = CurrentCard;

        //Array that breaks up conditions from each card for evaluation
        String UpCond = CurrentCard.getUpCond();
        String[] arUP = UpCond.split(",");
        for (int i = 0; i < arUP.length; i++) {
            firstParamUP = arUP[0];
            INCREASE = arUP[2];
            secondParamUP = arUP[3];
            firstValueUP = Integer.parseInt(arUP[1]);
            secondValueUP = Integer.parseInt(arUP[4]);
        }

        String LowCond = CurrentCard.getLowCond();
        String[] arLOW = LowCond.split(",");
        for (int i = 0; i < arLOW.length; i++) {
            firstParamLOW = arLOW[0];
            DECREASE = arLOW[2];
            secondParamLOW = arLOW[3];
            firstValueLOW = Integer.parseInt(arLOW[1]);
            secondValueLOW = Integer.parseInt(arLOW[4]);
        }

        // First Parameter UP/LOW if-condition
        if (firstParamUP.equals("EnvStrTol")) {
            yourFirstParamUP = human.getEnvStrTol();
            yourFirstParamLOW = human.getEnvStrTol();
        }
        if (firstParamUP.equals("PredAvoEva")) {
            yourFirstParamUP = human.getPredAvoEva();
            yourFirstParamLOW = human.getEnvStrTol();
        }
        if (firstParamUP.equals("MateAtt")) {
            yourFirstParamUP = human.getMateAtt();
            yourFirstParamLOW = human.getMateAtt();
        }
        if (firstParamUP.equals("Forage")) {
            yourFirstParamUP = human.getForage();
            yourFirstParamLOW = human.getForage();
        }
        if (firstParamUP.equals("TerrDef")) {
            yourFirstParamUP = human.getTerrDef();
            yourFirstParamLOW = human.getTerrDef();
        }
        if (firstParamUP.equals("PopLevel")) {
            yourFirstParamUP = human.getPopLevel();
            yourFirstParamLOW = human.getPopLevel();
        }

        if (yourFirstParamUP > firstValueUP) {

            // Second Parameter UP if-condition
            if (secondParamUP.equals("EnvStrTol")) {
                EnvStrTol = secondValueUP;
                human.setEnvStrTol(human.getEnvStrTol() + EnvStrTol);
                System.out.println("Environment Tolerance Level: "
                        + human.getEnvStrTol());
            }
            if (secondParamUP.equals("PredAvoEva")) {
                PredAvoEva = secondValueUP;
                human.setPredAvoEva(human.getPredAvoEva() + PredAvoEva);
                System.out.println("Predator Avoidance & Evasion Level: "
                        + human.getPredAvoEva());
            }
            if (secondParamUP.equals("MateAtt")) {
                MateAtt = secondValueUP;
                human.setMateAtt(human.getMateAtt() + MateAtt);
                System.out.println("Mate Attraction Level: "
                        + human.getMateAtt());
            }
            if (secondParamUP.equals("Forage")) {
                Forage = secondValueUP;
                human.setForage(human.getForage() + Forage);
                System.out.println("Forage Level: " + human.getForage());
            }
            if (secondParamUP.equals("TerrDef")) {
                TerrDef = secondValueUP;
                human.setTerrDef(human.getTerrDef() + TerrDef);
                System.out.println("Territorial Defense Level: "
                        + human.getTerrDef());
            }
            if (secondParamUP.equals("PopLevel")) {
                PopLevel = secondValueUP;
                human.setPopLevel(human.getPopLevel() + PopLevel);
                System.out.println("Population Level: "
                        + human.getPopLevel());
            }
        }
        if (yourFirstParamLOW <= firstValueLOW) {

            // Second Parameter LOW if-condition
            if (secondParamLOW.equals("EnvStrTol")) {
                EnvStrTol = secondValueLOW;
                human.setEnvStrTol(human.getEnvStrTol() + EnvStrTol);
                System.out.println("Environment Tolerance Level: "
                        + human.getEnvStrTol());
            }
            if (secondParamLOW.equals("PredAvoEva")) {
                PredAvoEva = secondValueLOW;
                human.setPredAvoEva(human.getPredAvoEva() + PredAvoEva);
                System.out.println("Predator Avoidance & Evasion Level: "
                        + human.getPredAvoEva());
            }
            if (secondParamLOW.equals("MateAtt")) {
                MateAtt = secondValueLOW;
                human.setMateAtt(human.getMateAtt() + MateAtt);
                System.out.println("Mate Attraction Level: "
                        + human.getMateAtt());
            }
            if (secondParamLOW.equals("Forage")) {
                Forage = secondValueLOW;
                human.setForage(human.getForage() + Forage);
                System.out.println("Forage Level: "
                        + human.getForage());
            }
            if (secondParamLOW.equals("TerrDef")) {
                TerrDef = secondValueLOW;
                human.setTerrDef(human.getTerrDef() + TerrDef);
                System.out.println("Territorial Defense Level: "
                        + human.getTerrDef());
            }
            if (secondParamLOW.equals("PopLevel")) {
                PopLevel = secondValueLOW;
                human.setPopLevel(human.getPopLevel() + PopLevel);
                System.out.println("Population Level: "
                        + human.getPopLevel());
            }
        }
    }

    /**
     * This method is responsible for handling the actions in a card
     *
     * @param CurrentCard the card that is drawn
     */
    public void processCardComputer(Card CurrentCard) {
        this.CurrentCard = CurrentCard;

        //Array that breaks up conditions from each card for evaluation
        String UpCond = CurrentCard.getUpCond();
        String[] arUP = UpCond.split(",");
        for (int i = 0; i < arUP.length; i++) {
            firstParamUP = arUP[0];
            INCREASE = arUP[2];
            secondParamUP = arUP[3];
            firstValueUP = Integer.parseInt(arUP[1]);
            secondValueUP = Integer.parseInt(arUP[4]);
        }

        String LowCond = CurrentCard.getLowCond();
        String[] arLOW = LowCond.split(",");
        for (int i = 0; i < arLOW.length; i++) {
            firstParamLOW = arLOW[0];
            DECREASE = arLOW[2];
            secondParamLOW = arLOW[3];
            firstValueLOW = Integer.parseInt(arLOW[1]);
            secondValueLOW = Integer.parseInt(arLOW[4]);
        }

        // First Parameter UP/LOW if-condition
        if (firstParamUP.equals("EnvStrTol")) {
            yourFirstParamUP = computer.getEnvStrTol();
            yourFirstParamLOW = computer.getEnvStrTol();
        }
        if (firstParamUP.equals("PredAvoEva")) {
            yourFirstParamUP = computer.getPredAvoEva();
            yourFirstParamLOW = computer.getEnvStrTol();
        }
        if (firstParamUP.equals("MateAtt")) {
            yourFirstParamUP = computer.getMateAtt();
            yourFirstParamLOW = computer.getMateAtt();
        }
        if (firstParamUP.equals("Forage")) {
            yourFirstParamUP = computer.getForage();
            yourFirstParamLOW = computer.getForage();
        }
        if (firstParamUP.equals("TerrDef")) {
            yourFirstParamUP = computer.getTerrDef();
            yourFirstParamLOW = computer.getTerrDef();
        }
        if (firstParamUP.equals("PopLevel")) {
            yourFirstParamUP = computer.getPopLevel();
            yourFirstParamLOW = computer.getPopLevel();
        }

        if (yourFirstParamUP > firstValueUP) {

            // Second Parameter UP if-condition
            if (secondParamUP.equals("EnvStrTol")) {
                EnvStrTol = secondValueUP;
                computer.setEnvStrTol(computer.getEnvStrTol() + EnvStrTol);
                System.out.println("Environment Tolerance Level: "
                        + computer.getEnvStrTol());
            }
            if (secondParamUP.equals("PredAvoEva")) {
                PredAvoEva = secondValueUP;
                computer.setPredAvoEva(computer.getPredAvoEva() + PredAvoEva);
                System.out.println("Predator Avoidance & Evasion Level: "
                        + computer.getPredAvoEva());
            }
            if (secondParamUP.equals("MateAtt")) {
                MateAtt = secondValueUP;
                computer.setMateAtt(computer.getMateAtt() + MateAtt);
                System.out.println("Mate Attraction Level: "
                        + computer.getMateAtt());
            }
            if (secondParamUP.equals("Forage")) {
                Forage = secondValueUP;
                computer.setForage(computer.getForage() + Forage);
                System.out.println("Forage Level: "
                        + computer.getForage());
            }
            if (secondParamUP.equals("TerrDef")) {
                TerrDef = secondValueUP;
                computer.setTerrDef(computer.getTerrDef() + TerrDef);
                System.out.println("Territorial Defense Level: "
                        + computer.getTerrDef());
            }
            if (secondParamUP.equals("PopLevel")) {
                PopLevel = secondValueUP;
                computer.setPopLevel(computer.getPopLevel() + PopLevel);
                System.out.println("Population Level: "
                        + computer.getPopLevel());
            }
        }
        if (yourFirstParamLOW <= firstValueLOW) {

            // Second Parameter LOW if-condition
            if (secondParamLOW.equals("EnvStrTol")) {
                EnvStrTol = secondValueLOW;
                computer.setEnvStrTol(computer.getEnvStrTol() + EnvStrTol);
                System.out.println("Environment Tolerance Level: "
                        + computer.getEnvStrTol());
            }
            if (secondParamLOW.equals("PredAvoEva")) {
                PredAvoEva = secondValueLOW;
                computer.setPredAvoEva(computer.getPredAvoEva() + PredAvoEva);
                System.out.println("Predator Avoidance & Evasion Level: "
                        + computer.getPredAvoEva());
            }
            if (secondParamLOW.equals("MateAtt")) {
                MateAtt = secondValueLOW;
                computer.setMateAtt(computer.getMateAtt() + MateAtt);
                System.out.println("Mate Attraction Level: "
                        + computer.getMateAtt());
            }
            if (secondParamLOW.equals("Forage")) {
                Forage = secondValueLOW;
                computer.setForage(computer.getForage() + Forage);
                System.out.println("Forage Level: "
                        + computer.getForage());
            }
            if (secondParamLOW.equals("TerrDef")) {
                TerrDef = secondValueLOW;
                computer.setTerrDef(computer.getTerrDef() + TerrDef);
                System.out.println("Territorial Defense Level: "
                        + computer.getTerrDef());
            }
            if (secondParamLOW.equals("PopLevel")) {
                PopLevel = secondValueLOW;
                computer.setPopLevel(computer.getPopLevel() + PopLevel);
                System.out.println("Population Level: "
                        + computer.getPopLevel());
            }
        }
    }

    /**
     * Method handles the actions for when a player lands on the BattleSlot
     * @return returns the name of the winner of the battle
     */
    public String Battle() {
        System.out.println("You have encountered the other opponent. "
                + "\nThe player who loses two or more of three rounds"
                + " will lose a Population level point."
                + "\nThe computer player has the advantage of winning"
                + " the round if there is a tie.\n");
        int numRounds = 0;
        HumanWin = 0;
        ComputerWin = 0;
        int GAMEOVER = 0;
        int ENDROUND = 0;
        if (human.getPopLevel() != 0 || computer.getPopLevel() != 0) {
            for (int i = 1; i <= 3; i++) {
                HumanDice = (int) (6.0 * Math.random() + 1);
                ComputerDice = (int) (6.0 * Math.random() + 1);
                System.out.println(name + " rolled a " + HumanDice);
                System.out.println("Computer rolled a " + ComputerDice);
                if (HumanDice > ComputerDice) {
                    HumanWin += 1;
                } else if (HumanDice <= ComputerDice) {
                    ComputerWin += 1;
                }
            }
        }

        if (HumanWin < ComputerWin) {
            System.out.println("Your opponent has beaten you!");
            BattleWinner = "COMPUTER";
            int humanLife = human.getPopLevel();
            human.setPopLevel(humanLife - 1);
            if (human.getPopLevel() == 0) {
                ENDROUND = 1;
            }
        } else if (HumanWin > ComputerWin) {
            System.out.println("You have beaten your opponent!");
            BattleWinner = "HUMAN";
            int compLife = computer.getPopLevel();
            computer.setPopLevel(compLife - 1);
            if (computer.getPopLevel() == 0) {
                ENDROUND = 1;
            }
        }
        return BattleWinner;
    }

    /**
     * This method is responsible for randomly picking the computer species
     * @return returns the randomly selected species for the computer player
     */
    private String pickCompSpecies() {
        CompSpecies.add("Species I");
        CompSpecies.add("Species II");
        CompSpecies.add("Species III");
        CompSpecies.add("Species IV");
        int compSpeciesIndex = compSpeciesRandom.nextInt(CompSpecies.size());
        SpeciesName = CompSpecies.get(compSpeciesIndex);

        return SpeciesName;
    }
}
