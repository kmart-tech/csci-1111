package race;

// resources a kingdom has, not tiles
public class Resource {
    private final String name;
    private double amount = 0.0;
    private double rate = 1.0;
    private double bonus = 1.0;

    Resource(String name) {this.name = name;}

    Resource(String name, double startAmount, double rate) {
        this.name = name;
        amount = startAmount;
        this.rate = rate;
    }

    public void addToAmount(double amount) { this.amount += amount; }
    public void addToRate(double rate) { this.rate += rate;}
    public void addToBonus(double bonus) { this.bonus += bonus;}

    public String getName() { return name; }
    public double getAmount() {return amount;}
    public double getRate() { return rate; }
    public double getBonus() { return bonus; }

    // grow every tick
    public void grow() {amount += bonus * rate;}
}
