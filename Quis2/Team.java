package Quis2;

public class Team {
    private String name;
    private int points;
    private int gamesPlayed;
    private int wins;
    private int losses;

    public Team(String name) {
        this.name = name;
        this.points = 0;
        this.gamesPlayed = 0;
        this.wins = 0;
        this.losses = 0;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public void addWin() {
        this.wins++;
        this.points += 2;
        this.gamesPlayed++;
    }

    public void addLoss() {
        this.losses++;
        this.gamesPlayed++;
    }
}
