package life.animals.herbivores;

import life.Animal;
import life.animals.herbivores.Caterpillar;
import pole.Location;

import java.util.Random;

public class Herbivore  extends Animal {
@Override
    public void eat(Location location){

        if(location.getPlant().getCount()>0 && this.getClass() != Caterpillar.class){
            Random random = new Random();
            int count =random.nextInt(this.getMaxSatiety()-this.getSatiety());
            for(int i = 0;i<count;i++) {
                if(location.getPlant().getCount()>0) {
                    this.setSatiety(this.getSatiety() + 1);
                    location.removePlant();
                }
            }
        }
    }

}
