package life.animals.herbivores;

import pole.Island;
import pole.Location;

import java.util.Random;

public class Duck extends Herbivore {
    private int speed= 4;
    private int weight = 1;
    private int maxPopulation = 200;
    public static final String name = "\uD83E\uDD86";

    private int satiety;
    private int maxSatiety = 1;

    public Duck() {
        setSatiety();
    }

    @Override
    public void setSatiety(int satiety) {
        super.setSatiety(satiety);
    }

    @Override
    public void eat(Location location) {
        super.eat(location);
        super.eat(location);
        super.eat(location);
    }

    @Override
    public int getSatiety() {
        return this.satiety;
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

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
