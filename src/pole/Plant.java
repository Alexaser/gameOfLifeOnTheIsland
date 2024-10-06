package pole;

import java.util.Objects;

public class Plant {
    private String image = "\uD83C\uDF3F";
    private int weight = 1;
    private int count;
    private int maxCount = 500;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if(count<=maxCount) {
            this.count = count;
        }
    }

    public int getMaxCount(){
        return maxCount;
    }
    @Override
    public String toString() {
        return image;
    }

}
