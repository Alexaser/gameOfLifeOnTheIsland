package life.animals.carnivores;

import pole.Island;
import pole.Location;

import java.util.Random;

public class Boa extends Carnivore { // Удав
    private int speed = 1;
    public static final String name = "\uD83D\uDC0D";
    private int weight = 15;
    private int maxPopulation = 30;

    private int satiety;
    private int maxSatiety = 3;

    public Boa() {
        setSatiety();
    }


    @Override
    public void eat(Location location) {
        super.eat(location);
    }

    @Override
    public int getSatiety() {
        return satiety;
    }

    @Override
    public int getMaxSatiety() {
        return maxSatiety;
    }

    private void setSatiety() {
        Random random = new Random();
        this.satiety = random.nextInt(this.maxSatiety);
    }

    @Override
    public void setSatiety(int satiety) {
        if (satiety < this.getMaxSatiety()) {
            this.satiety = satiety;
        } else {
            this.satiety = getMaxSatiety();
        }
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

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


}
