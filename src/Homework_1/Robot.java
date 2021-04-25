package Homework_1;

public class Robot implements ICompetitor {
    private int maxDistance;
    private int maxHeight;

    public Robot(int maxDistance, int maxHeight) {
        this.maxDistance = maxDistance;
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean run(int distance) {
        System.out.println("Я побежал.");

        return maxDistance >= distance;
    }

    @Override
    public boolean jump(int height) {
        System.out.println("Я прыгнул.");

        return maxHeight >= height;
    }
}