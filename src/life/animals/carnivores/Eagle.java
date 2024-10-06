package life.animals.carnivores;

import pole.Island;
import pole.Location;

import java.util.Random;

public class Eagle extends Carnivore {
    private int speed = 3;
    public static final String name = "\uD83E\uDD85";
    private int weight = 6;
    private int maxPopulation = 20;
    private int satiety;
    private int maxSatiety = 1;

    public Eagle() {
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
    public void eat(Location location) {
        super.eat(location);
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
