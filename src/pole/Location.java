package pole;
import life.Animal;

import java.util.*;


public class Location extends Island {

    public Location(int y, int x) {
        super(y, x);
    }

    private HashMap<Animal, Integer> animalsQuantity = new HashMap<>();
    private Plant plant = new Plant();


    public boolean addAnimal(Animal animal) {
        // Добавляем животное, если его еще нет в локации
        animalsQuantity.put(animal, animalsQuantity.getOrDefault(animal, 0)+1);
        if (animalsQuantity.get(animal) > animal.getMaxPopulation()) {
            animalsQuantity.put(animal, animal.getMaxPopulation());
            return false;
        }else {

            return true;
        }
    }
    public void removeAnimal(Animal animal) {
        int count = animalsQuantity.getOrDefault(animal, 0);
        if (count > 0) {
            animalsQuantity.put(animal, count - 1);
        }
    }

    public void addPlant() {
        Random random=new Random();
        this.plant.setCount(random.nextInt(this.plant.getMaxCount()));
    }

    public void removePlant() {
    plant.setCount(plant.getCount()-1);
    }



//        @Override
//    public String toString() {
//        return animalsQuantity.entrySet()
//                .stream()
//                .max(Map.Entry.comparingByValue())
//                .map(entry -> entry.getKey().getName()) // Предполагается, что у Animal есть метод getName()
//                .orElse("No animals");
//    }
//    @Override
//    public String toString() {
//        return "Location{" +
//                "animalsQuantity=" + animalsQuantity +
//                ", plantsQuantity=" + plantsQuantity + "}";
//    }
@Override
public String toString() {
    return " "+ animalsQuantity + plant.toString()+""+ plant.getCount();
}
 public int suma(){
     int totalAnimals = animalsQuantity.values().stream()
             .mapToInt(Integer::intValue)  // Преобразуем значения в int
             .sum();  // Суммируем все значения
return totalAnimals;
 }

    public HashMap<Animal, Integer> getAnimalsQuantity() {
        return animalsQuantity;
    }

    public Plant getPlant() {
        return this.plant;
    }
}
