package life;

import life.animals.carnivores.*;
import life.animals.herbivores.*;
import pole.Island;
import pole.Location;

import java.util.*;

public class Animal {

    private int satiety;
    private int maxSatiety;
    private int maxPopulation;
    private String name;
    private int speed;
    private int weight;

    private Map<Class<? extends Animal>, Integer> foodPreferences = new HashMap<>();

    public Animal() {
        initializeFoodPreferences();
    }

    public void reproduction(Location location) {
//         Получаем количество животных текущего вида на локации
        Map<Animal, Integer> animals = location.getAnimalsQuantity();
        // Проверяем, есть ли пара для размножения
        int currentPopulation = animals.getOrDefault(this, 0);
        // Если популяция уже достигла максимума, то размножение невозможно
        if (currentPopulation >= this.getMaxPopulation()) {
            return;
        }

        // Если есть хотя бы два животных этого вида на локации, возможна репродукция
        if (currentPopulation >= 2) {
            Random random = new Random();
            double reproductionChance = 0.0001;  // Вероятность размножения (50% например)

            // Проверяем, произошло ли размножение на основе случайной величины
            if (random.nextDouble() < reproductionChance) {
                // Увеличиваем популяцию на одного представителя данного вида
                location.addAnimal(this);
            }
        }
    }

    public void eat(Location location) {
    }

    public Map<Class<? extends Animal>, Integer> getFoodPreferences() {
        return foodPreferences;
    }

    public void move(Island island, Location location, int locationY, int locationX) {
        int animalX = locationX;
        int animalY = locationY;
        Random random = new Random();
        int direction = (this.getSpeed() > 1) ? random.nextInt(this.getSpeed()) : 1;
        // Определяем направление движения

        switch (random.nextInt(4)) { // 4 направления (вправо, вниз, влево, вверх)
            case 0 -> animalX = locationX + direction; // Вправо
            case 1 -> animalY = locationY + direction; // Вниз
            case 2 -> animalX = locationX - direction; // Влево
            case 3 -> animalY = locationY - direction; // Вверх
        }
        // Проверка границ острова
        if (animalX >= 0 && animalX < island.getX() && animalY >= 0 && animalY < island.getY()) {
            // Перемещаем животное, если новая позиция отличается от текущей
            if (animalX != locationX || animalY != locationY) {
                if (island.getLocation(animalY, animalX).addAnimal(this)) {
                    location.removeAnimal(this);
                }
            }
        }


        // Если выход за пределы острова, просто игнорируем перемещение
    }

    public int getSpeed() {
        return speed;
    }

    public int getMaxPopulation() {
        return maxPopulation;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return maxPopulation == animal.maxPopulation && speed == animal.speed && Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxPopulation, name, speed);
    }

    public void initializeFoodPreferences() {
        if (this instanceof Bear) {
            foodPreferences.put(Boa.class, 80);
            foodPreferences.put(Horse.class, 40);
            foodPreferences.put(Deer.class, 80);
            foodPreferences.put(Rabbit.class, 80);
            foodPreferences.put(Mouse.class, 90);
            foodPreferences.put(Goat.class, 70);
            foodPreferences.put(Sheep.class, 70);
            foodPreferences.put(Boar.class, 50);
            foodPreferences.put(Buffalo.class, 20);
            foodPreferences.put(Duck.class, 10);
        } else if (this instanceof Wolf) {
            foodPreferences.put(Horse.class, 10);
            foodPreferences.put(Deer.class, 15);
            foodPreferences.put(Rabbit.class, 60);
            foodPreferences.put(Mouse.class, 80);
            foodPreferences.put(Goat.class, 60);
            foodPreferences.put(Sheep.class, 70);
            foodPreferences.put(Boar.class, 15);
            foodPreferences.put(Buffalo.class, 10);
            foodPreferences.put(Duck.class, 40);
        } else if (this instanceof Boa) {
            foodPreferences.put(Fox.class, 15);
            foodPreferences.put(Rabbit.class, 20);
            foodPreferences.put(Mouse.class, 40);
            foodPreferences.put(Duck.class, 10);
        } else if (this instanceof Fox) {
            foodPreferences.put(Rabbit.class, 70);
            foodPreferences.put(Mouse.class, 90);
            foodPreferences.put(Duck.class, 60);
            foodPreferences.put(Caterpillar.class, 40);
        } else if (this instanceof Eagle) {
            foodPreferences.put(Fox.class, 10);
            foodPreferences.put(Rabbit.class, 90);
            foodPreferences.put(Mouse.class, 90);
            foodPreferences.put(Duck.class, 80);
        }else  if (this instanceof Mouse){
            foodPreferences.put(Caterpillar.class,90);
        }else if(this instanceof  Duck){
            foodPreferences.put(Caterpillar.class, 90);
        }else if(this instanceof  Boar){
            foodPreferences.put(Caterpillar.class,90);
        }
    }

    public int getSatiety() {
        return satiety;
    }

    public int getMaxSatiety() {
        return maxSatiety;
    }

    public void setSatiety(int satiety) {
        if(satiety<this.getMaxSatiety()){
            this.satiety=satiety;
        }else{
            this.satiety=getMaxSatiety();
        }
    }

    public String getName() {
        return this.toString();
    }
}
