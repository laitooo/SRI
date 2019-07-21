package zxc.laitooo.sri.reputation;

/**
 * Created by Laitooo San on 12/06/2019.
 */

public class Reputation {

    private int level;
    private int votesLimit;
    private double maxPoints;

    public Reputation(int level, int votesLimit, double maxPoints) {
        this.level = level;
        this.votesLimit = votesLimit;
        this.maxPoints = maxPoints;
    }

    public int getLevel() {
        return level;
    }

    public int getVotesLimit() {
        return votesLimit;
    }

    public double getMaxPoints() {
        return maxPoints;
    }
}
