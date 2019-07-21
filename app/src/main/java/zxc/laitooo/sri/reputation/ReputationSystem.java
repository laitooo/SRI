package zxc.laitooo.sri.reputation;

import java.util.ArrayList;

/**
 * Created by Laitooo San on 12/06/2019.
 */

public class ReputationSystem {

    private ArrayList<Reputation> list;
    private int votesLimit,nextLevel;
    double pointsNextLevel,points;

    public ReputationSystem(double currentPoints) {
        points = currentPoints;
        list = new ArrayList<>();
        list.add(new Reputation(1,1,40.0));
        list.add(new Reputation(2,3,80.0));
        list.add(new Reputation(3,5,120.0));
        list.add(new Reputation(4,7,160.0));
        list.add(new Reputation(5,10,200.0));
        for (int i=0;i<list.size();i++){
            if (currentPoints < list.get(i).getMaxPoints()){
                pointsNextLevel = list.get(i).getMaxPoints()-currentPoints;
                votesLimit = list.get(i).getVotesLimit();
                nextLevel = list.get(i+1).getLevel();
                break;
            }
        }
    }

    public int getVotesLimit() {
        return votesLimit;
    }

    public int getNextLevel() {
        return nextLevel;
    }

    public double getPointsNextLevel() {
        return pointsNextLevel;
    }

    public Reputation getReputation(int level){
        for (int i=0;i<list.size();i++) {
            if (list.get(i).getLevel() == level) {
                return list.get(i);
            }
        }
        return null;
    }

    public double getMyThisLevelPoints(){
        if (getNextLevel()==2)
            return points;
        return  points - getReputation(nextLevel-2).getMaxPoints();
    }

    public double getAllThisLevelPoints(){
        if (getNextLevel()==2)
            return getReputation(1).getMaxPoints();
        return  getReputation(nextLevel-1).getMaxPoints() - getReputation(nextLevel-2).getMaxPoints();
    }
}
