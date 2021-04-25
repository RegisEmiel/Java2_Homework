package Homework_1;

public class Trek implements IObstacle {
    private int distance;

    public Trek(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean action(ICompetitor competitor) {
        return competitor.run(distance);
    }
}