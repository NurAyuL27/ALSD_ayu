package Quis2;

public class Match {
    private Team homeTeam;
    private Team awayTeam;
    private Team winner;

    public Match(Team homeTeam, Team awayTeam, Team winner) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.winner = winner;
        updatePoints();
    }

    private void updatePoints() {
        if (winner != null) {
            winner.addWin();
            if (winner == homeTeam) {
                awayTeam.addLoss();
            } else {
                homeTeam.addLoss();
            }
        }
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public Team getWinner() {
        return winner;
    }

    @Override
    public String toString() {
        return homeTeam.getName() + " vs " + awayTeam.getName() + " - Winner: " + (winner != null ? winner.getName() : "None");
    }
}
