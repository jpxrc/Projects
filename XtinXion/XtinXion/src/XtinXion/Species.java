package XtinXion;

/**
 * This class is responsible for constructing a Species type
 * @author Jon Patman
 */
public class Species {

    private final String speciesName;
    private final int EnvStrTol;
    private final int PredAvoEva;
    private final int MateAtt;
    private final int Forage;
    private final int TerrDef;
    private int PopLevel;

    /**
     * Constructs the species
     * @param speciesName
     * @param EnvStrTol 
     * @param PredAvoEva
     * @param MateAtt
     * @param Forage
     * @param TerrDef
     * @param PopLevel 
     */
    public Species(String speciesName, int EnvStrTol, int PredAvoEva, 
            int MateAtt, int Forage, int TerrDef, int PopLevel) {
        this.speciesName = speciesName;
        this.EnvStrTol = EnvStrTol;
        this.PredAvoEva = PredAvoEva;
        this.MateAtt = MateAtt;
        this.Forage = Forage;
        this.TerrDef = TerrDef;
        this.PopLevel = PopLevel;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public int getEnvStrTol() {
        return EnvStrTol;
    }

    public int getPredAvoEva() {
        return PredAvoEva;
    }

    public int getMateAtt() {
        return MateAtt;
    }

    public int getForage() {
        return Forage;
    }

    public int getTerrDef() {
        return TerrDef;
    }

    public int getPopLevel() {
        return PopLevel;
    }



}
