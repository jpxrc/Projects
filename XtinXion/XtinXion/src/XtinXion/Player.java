package XtinXion;

/**
 * This class is responsible for constructing a Player
 * @author Jon Patman
 */
public abstract class Player {

    public String name;
    private String SpeciesName;
    private int EnvStrTol;
    private int PredAvoEva;
    private int MateAtt;
    private int Forage;
    private int TerrDef;
    private int PopLevel;
    

    public Player(String name, String SpeciesName,
            int EnvStrTol, int PredAvoEva, int MateAtt,
            int Forage, int TerrDef, int PopLevel) {
        this.name = name;
        this.SpeciesName = SpeciesName;
        this.EnvStrTol = EnvStrTol;
        this.PredAvoEva = PredAvoEva;
        this.MateAtt = MateAtt;
        this.Forage = Forage;
        this.TerrDef = TerrDef;
        this.PopLevel = PopLevel;

        if (SpeciesName.equals("Species I")) {
            Species SpeciesI = new Species("Species I", 4, 7, 3, 7, 3, 10);
            this.EnvStrTol = SpeciesI.getEnvStrTol();
            this.PredAvoEva = SpeciesI.getPredAvoEva();
            this.MateAtt = SpeciesI.getMateAtt();
            this.Forage = SpeciesI.getForage();
            this.TerrDef = SpeciesI.getTerrDef();
            this.PopLevel = SpeciesI.getPopLevel();
        }
        if (SpeciesName.equals("Species II")) {
            Species SpeciesII = new Species("Species II", 5, 5, 6, 5, 3, 10);
            this.EnvStrTol = SpeciesII.getEnvStrTol();
            this.PredAvoEva = SpeciesII.getPredAvoEva();
            this.MateAtt = SpeciesII.getMateAtt();
            this.Forage = SpeciesII.getForage();
            this.TerrDef = SpeciesII.getTerrDef();
            this.PopLevel = SpeciesII.getPopLevel();
        }
        if (SpeciesName.equals("Species III")) {
            Species SpeciesIII = new Species("Species III", 6, 3, 4, 4, 7, 10);
            this.EnvStrTol = SpeciesIII.getEnvStrTol();
            this.PredAvoEva = SpeciesIII.getPredAvoEva();
            this.MateAtt = SpeciesIII.getMateAtt();
            this.Forage = SpeciesIII.getForage();
            this.TerrDef = SpeciesIII.getTerrDef();
            this.PopLevel = SpeciesIII.getPopLevel();
        }
        if (SpeciesName.equals("Species IV")) {
            Species SpeciesIV = new Species("Species IV", 4, 5, 5, 6, 4, 10);
            this.EnvStrTol = SpeciesIV.getEnvStrTol();
            this.PredAvoEva = SpeciesIV.getPredAvoEva();
            this.MateAtt = SpeciesIV.getMateAtt();
            this.Forage = SpeciesIV.getForage();
            this.TerrDef = SpeciesIV.getTerrDef();
            this.PopLevel = SpeciesIV.getPopLevel();
        }

    }

    public String getName() {
        return name;
    }

    public String getSpeciesName() {
        return SpeciesName;
    }

    public void setSpeciesName(String SpeciesName) {
        this.SpeciesName = SpeciesName;
    }

    public int getEnvStrTol() {
        return EnvStrTol;
    }

    public void setEnvStrTol(int EnvStrTol) {
        this.EnvStrTol = EnvStrTol;
    }

    public int getPredAvoEva() {
        return PredAvoEva;
    }

    public void setPredAvoEva(int PredAvoEva) {
        this.PredAvoEva = PredAvoEva;
    }

    public int getMateAtt() {
        return MateAtt;
    }

    public void setMateAtt(int MateAtt) {
        this.MateAtt = MateAtt;
    }

    public int getForage() {
        return Forage;
    }

    public void setForage(int Forage) {
        this.Forage = Forage;
    }

    public int getTerrDef() {
        return TerrDef;
    }

    public void setTerrDef(int TerrDef) {
        this.TerrDef = TerrDef;
    }

    public int getPopLevel() {
        return PopLevel;
    }

    public void setPopLevel(int popLevel) {
        this.PopLevel = popLevel;
    }

}
