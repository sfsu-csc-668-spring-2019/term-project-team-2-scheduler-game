package city;

import java.util.Random;

public class EventManager {
    private float eventChance;
    private float eventIncrease;
    private Random rand;

    public EventManager (float eventChance){
        this.eventChance = eventChance;
        this.rand = new Random();
    }

    public void modifyIncrease(float modifier){
        eventIncrease = eventIncrease * (1 + modifier);
    }

    public void rollEvent(){
        int eventRoll = (int)(Math.random() * 10 + 1);
        //Regardless of sign of eventchance, trigger events if roll falls within range
        //Only decide if bad or good after
        if (Math.abs(eventChance)  >= eventRoll) {
            if (eventChance > 0) {
                triggerGoodEvent();
            } else {
                triggerBadEvent();
            }
        }
    }

    private void triggerGoodEvent(){
        System.out.println("Good event!");
    }

    private void triggerBadEvent(){
        System.out.println("Bad Event!");
    }

}
