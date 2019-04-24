package city;

public class Money {
    int amt;
    int income;

    public Money (int amt){
        this.amt = amt;
        income = 10;
    }

    public void gainIncome(){
        amt += income;
    }
}
