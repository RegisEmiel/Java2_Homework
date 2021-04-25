package Homework_1;

public class Homework_1 {
    private static final int OBSTACLES_COUNT = 7;
    private static final int COMPETITORS_COUNT = 3;

    public static void main(String[] args) {
        System.out.println("Java2 Homework 1");

        IObstacle[] obstacles = new IObstacle[OBSTACLES_COUNT];
        obstacles[0] = new Trek(300);
        obstacles[1] = new Wall(100);
        obstacles[2] = new Trek(500);
        obstacles[3] = new Wall(150);
        obstacles[4] = new Trek(700);
        obstacles[5] = new Wall(200);
        obstacles[6] = new Trek(1500);

        ICompetitor[] competitors = new ICompetitor[COMPETITORS_COUNT];
        competitors[0] = new Cat(500, 300);
        competitors[1] = new Human(3000, 200);
        competitors[2] = new Robot(10000, 100);

        for (int i = 0; i < COMPETITORS_COUNT; i++) {
            System.out.println("\nНа полосу препятствий выходит участник соревнований №" + (i + 1));

            for (int j = 0; j < OBSTACLES_COUNT; j++) {
                boolean isPassed = obstacles[j].action(competitors[i]);

                if (isPassed) {
                    System.out.println("Преодолевает препятствие: " + (j + 1));
                }
                else {
                    System.out.println("Не преодолевает препятствие: " + (j + 1) + " и сходит с дистанции!");

                    break;
                }
            }
        }
    }
}
