import life.Animal;
import pole.Island;

public class Main {
    public static void main(String[] args) {
        int x = 100;
        int y = 20;
        Island island = new Island(y, x);
        island.createIsland();

        // Поток для метода nextDay(), который работает бесконечно
        Thread nextDayThread = new Thread(() -> {
            while (true) {
                island.nextDay();
                try {
                    Thread.sleep(2000);  // Ожидание 2 секунды перед следующим днём
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Поток для метода printIslandGrid(), который работает бесконечно
        Thread printGridThread = new Thread(() -> {
            while (true) {
                island.printIslandGrid();
                try {
                    Thread.sleep(2000);  // Ожидание 2 секунды перед следующим выводом
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Запуск обоих потоков
        nextDayThread.start();
        printGridThread.start();
    }
}
//



