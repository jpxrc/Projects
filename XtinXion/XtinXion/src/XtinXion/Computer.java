package XtinXion;


/**
 *  This class is responsible for constructing the Computer Player
 * @author Jon Patman
 */
public class Computer extends Player {


    /**
     * Constructs the Computer Player
     * @param SpeciesName name of the Species for this Player
     * @param EnvStrTol Environmental Stress Tolerance level for this Player
     * @param PredAvoEva Predator Avoidance & Evasion level for this Player
     * @param MateAtt Mate Attraction level for this Player
     * @param Forage Forage level for this Player
     * @param TerrDef Territory Defense for this Player
     * @param PopLevel Population Level for this Player
     */
    public Computer(String SpeciesName, int EnvStrTol, int PredAvoEva, 
            int MateAtt, int Forage, int TerrDef, int PopLevel) {
        super("COMPUTER", SpeciesName, EnvStrTol, PredAvoEva, MateAtt, 
                Forage, TerrDef, PopLevel);
    }

}
