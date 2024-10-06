package pole;

import life.Animal;
import life.animals.carnivores.*;
import life.animals.herbivores.*;

import java.util.*;
import java.util.function.Supplier;

public class Island {
    private static Location [][] locations;
    private int x;
    private int y;
    private Random random=new Random();

    public Island(int y, int x) {
        this.x = x;
        this.y = y;
    }
    public void createIsland(){
        locations = new Location[y][x];
        for(int i = 0; i < y; i++){
            for( int k = 0; k < x; k++){
                locations[i][k] = new Location(y,x);
                populate(locations[i][k]);
            }
        }
    }
    public void populate(Location location) {
        // Список доступных животных
        List<Supplier<Animal>> animals = List.of(
                Wolf::new,
                Bear::new,
                Rabbit::new,
                Fox::new,
                Boa::new,
                Buffalo::new,
                Caterpillar::new,
                Deer::new,
                Duck::new,
                Eagle::new,
                Goat::new,
                Horse::new,
                Mouse::new,
                Sheep::new
        );
        // Добавляем растения в локацию
        location.addPlant();
        // Заполняем локацию животными
        for (int i = 0; i < 10; i++) {
            // Генерируем случайное животное из списка
            Animal randomAnimal = animals.get(random.nextInt(animals.size())).get();
            location.addAnimal(randomAnimal);  // Добавляем животное на локацию
        }
    }
    public void nextDay() {
        // Первый этап: перемещение всех животных
        for (int i = 0; i < y; i++) {
            for (int k = 0; k < x; k++) {
                for (Animal animal : locations[i][k].getAnimalsQuantity().keySet()) {
                    animal.move(this, locations[i][k], i, k);
                    animal.reproduction(locations[i][k]);
//                    System.out.println(animal);
                    animal.eat(locations[i][k]);
                    locations[i][k].getPlant().setCount(locations[i][k].getPlant().getCount()+1);
                    animal.setSatiety(animal.getSatiety()-(animal.getMaxSatiety()/10));
                }
            }
        }
                cleanMap();
    }

    public void printIslandGrid() {
        for (int i = 0; i < y; i++) {
            for (int k = 0; k < x; k++) {
                Location location = locations[i][k];

                // Если в локации есть животные
                if (!location.getAnimalsQuantity().isEmpty()) {
                    // Находим животное, которое встречается чаще всего
                    Animal maxAnimal = location.getAnimalsQuantity()
                            .entrySet()
                            .stream()
                            .max(Map.Entry.comparingByValue())
                            .get()
                            .getKey();

                    // Выводим животное с максимальным количеством
                    System.out.print(maxAnimal.getName() + " ");  // Используем первую букву имени животного для отображения на карте
                }
                // Если в локации нет животных, но есть растения
                else if (location.getPlant().getCount()>0) {
                    System.out.print(location.getPlant().toString());  // 'P' для растения
                }
                // Если в локации никого нет
                else {
                    System.out.print("n");  // '.' для пустой клетки
                }
            }
            System.out.println();  // Переход на новую строку после каждой линии сетки
        }
        System.out.println();
    }
    public void cleanMap(){
    for (int i = 0; i < y; i++) {
        for (int k = 0; k < x; k++) {
            Iterator<Map.Entry<Animal, Integer>> it = locations[i][k].getAnimalsQuantity().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Animal, Integer> entry = it.next();
                if (entry.getValue() == 0) {
                    it.remove();  // Удаляем животное, если его количество стало 0
                }
            }
            }
        }
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public  Location getLocation(int y,int x) {
        return locations[y][x];
    }
}
