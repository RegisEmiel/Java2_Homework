package Homework_1;

public class Wall implements IObstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean action(ICompetitor competitor) {
        return competitor.jump(height);
    }
}
