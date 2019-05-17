package city;

import java.util.ArrayList;

public abstract class Building {
    static private float baseModifier= .1f;
    private ArrayList<Integer> coordinates;
    private int level;
    protected float fullModifier;


    public Building (ArrayList<Integer> coord, int level){
        this.coordinates = coord;
        this.level = level;
        fullModifier = level*baseModifier;
    }

    public abstract void execute(City city);
}
