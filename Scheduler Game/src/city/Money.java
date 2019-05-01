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
}
