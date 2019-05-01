package city;

public abstract class Building {
    static private float baseModifier= .1f;
    private int [] coordinates;
    private int level;
    protected float fullModifier;


    public Building (int [] coord, int level){
        this.coordinates = coord;
        this.level = level;
        fullModifier = level*baseModifier;
    }

    public abstract void execute(City city);
}
