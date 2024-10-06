package life.animals.carnivores;

import life.Animal;
import pole.Location;

import java.util.Map;
import java.util.Random;

public class Carnivore extends Animal {
    // метод eat() с особеностями именно для хищников
@Override
    public void eat(Location location) {
        Map<Animal, Integer> animalsInLocation = location.getAnimalsQuantity();
        if (getSatiety() < getMaxSatiety()) {
            Random random = new Random();
            for (Animal animal : animalsInLocation.keySet()) {
                if (this != animal) {
                    Integer probability = getFoodPreferences().get(animal.getClass());
                    if (probability != null) {
                        if (probability < random.nextInt(100)) {
                            if (getSatiety() < getMaxSatiety() / 2) {
                                location.removeAnimal(animal);
                                int sat = getSatiety() + animal.getWeight();
                                setSatiety(sat);
                                return;
                            }
                        }
                    }
                }
            }
        }

    }

}
