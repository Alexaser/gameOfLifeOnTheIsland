package life.animals.herbivores;

import pole.Island;
import pole.Location;

import java.util.Random;

public class Sheep extends Herbivore {
    private int speed= 3;
    private int weight = 70;
    private int maxPopulation = 140;
    public static final String name = "\uD83D\uDC11";
    private int satiety;
    private int maxSatiety = 15;

    @Override
    public void eat(Location location) {
        super.eat(location);
    }

    public Sheep() {
        setSatiety();
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

    public void setSatiety(int newSatiety){
        this.satiety=newSatiety;
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
