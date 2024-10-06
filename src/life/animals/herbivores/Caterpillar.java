package life.animals.herbivores;

import pole.Island;
import pole.Location;

public class Caterpillar extends Herbivore {
    private int speed= 0;
    private int weight = 1;
    private int maxPopulation = 1000;
    public static final String name = "\uD83D\uDC1B";
    @Override
    public int getWeight() {
        return weight;
    }
    @Override
    public void move(Island island, Location location, int locationY, int locationX) {
        // Не перемещяется
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
    public int hashCode() {
        return super.hashCode();
    }
}
