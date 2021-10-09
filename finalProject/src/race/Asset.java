package race;

// assests a kingdom (or thing) possesses such as wood, population
public class Asset {
    private final Resource resource;
    private double amount = 0.0;
    private double rate = 1.0;
    private double bonus = 1.0;

    Asset(Resource resource) {this.resource = resource;}

    Asset(Resource resource, double startAmount, double rate) {
        this.resource = resource;
        amount = startAmount;
        this.rate = rate;
    }

    public void addToAmount(double amount) { this.amount += amount; }
    public void addToRate(double rate) { this.rate += rate;}
    public void addToBonus(double bonus) { this.bonus += bonus;}

    public
    public double getAmount() {return amount;}
    public double getRate() { return rate; }
    public double getBonus() { return bonus; }

    // grow every tick
    public void grow() {amount += bonus * rate;}
}
