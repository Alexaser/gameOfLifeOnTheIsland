package life.animals.herbivores;

import pole.Island;
import pole.Location;

import java.util.Random;

public class Boar extends Herbivore {
    private int speed= 2;
    private int weight = 400;
    private int maxPopulation = 50;
    private int satiety;
    private int maxSatiety = 50;
    private String name = "\uD83D\uDC17";

    @Override
    public String getName() {
        return name;
    }

    public Boar() {
        setSatiety();
    }

    @Override
    public void eat(Location location) {
        super.eat(location);
    }

    @Override
    public void setSatiety(int satiety) {
        super.setSatiety(satiety);
    }

    @Override
    public int getSatiety() {
        return satiety;
    }
    @Override
    public int getMaxSatiety() {
        return maxSatiety;
    }
    private void setSatiety(){
        Random random = new Random();
        this.satiety = random.nextInt(this.maxSatiety);
    }

    @Override
    public int getWeight() {
        return weight;
    }
    @Override
    public void move(Island island, Location location, int locationY, int locationX) {
        super.move(island, location, locationY, locationX);
    }
    @Override
    public int getSpeed() {
        return speed;
    }
    @Override
    public int getMaxPopulation() {
        return maxPopulation;
    }

    @Override
    public String toString() {
        return name;
    }

}
