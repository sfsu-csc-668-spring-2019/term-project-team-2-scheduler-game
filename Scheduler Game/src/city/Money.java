package city;

public class Money {
    float amt;
    float income;

    public Money (float amt){
        this.amt = amt;
        income = 10f;
    }

    public void gainIncome(){
        amt += income;
    }

    public void modifyIncome(float modifier){
        income = income * (1 + modifier);
    }

    public String toString(){
        String moneyString = Float.toString(amt);
        return moneyString;
    }
}
