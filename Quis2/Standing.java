package Quis2;

import java.util.Arrays;
import java.util.Scanner;

public class Standing {
    private Node head;
    private Node tail;
    private Team[] teams;

    public Standing(String[] teamNames) {
        head = null;
        tail = null;
        teams = new Team[teamNames.length];
        initializeTeams(teamNames);
    }

    private void initializeTeams(String[] teamNames) {
        for (int i = 0; i < teamNames.length; i++) {
            teams[i] = new Team(teamNames[i]);
        }
    }

    public Team findTeam(String name) {
        for (Team team : teams) {
            if (team.getName().equalsIgnoreCase(name.trim())) {
                return team;
            }
        }
        return null;
    }

    public void addMatch(int matchNumber, String homeTeamName, String awayTeamName, String winnerName) {
        homeTeamName = homeTeamName.trim();
        awayTeamName = awayTeamName.trim();
        winnerName = winnerName.trim();

        Team homeTeam = findTeam(homeTeamName);
        Team awayTeam = findTeam(awayTeamName);
        Team winner = findTeam(winnerName);

        if (homeTeam == null) {
            System.out.println("Invalid match data: Home team '" + homeTeamName + "' not found.");
            return;
        }
        if (awayTeam == null) {
            System.out.println("Invalid match data: Away team '" + awayTeamName + "' not found.");
            return;
        }
        if (winner == null) {
            System.out.println("Invalid match data: Winner team '" + winnerName + "' not found.");
            return;
        }

        Match match = new Match(homeTeam, awayTeam, winner);
        Node newNode = new Node(match);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
    }
    

    public void printStandings() {
        Team[] sortedTeams = teams.clone();
        Arrays.sort(sortedTeams, (t1, t2) -> {
            int pointCompare = Integer.compare(t2.getPoints(), t1.getPoints());
            if (pointCompare != 0) {
                return pointCompare;
            }
            int winCompare = Integer.compare(t2.Win(), t1.Win());
            if (winCompare != 0) {
                return winCompare;
            }
            return t1.getName().compareTo(t2.getName());
        });
        System.out.println("======================================================================");
        System.out.println(String.format("%-5s %-35s %-10s %-5s %-5s %-5s", "Rank", "Team", "G", "W", "L", "Pts"));
        System.out.println("======================================================================");
        for (int i = 0; i < sortedTeams.length; i++) {
            Team team = sortedTeams[i];
            System.out.println(String.format("%-5d %-35s %-10d %-5d %-5d %-5d", i + 1, team.getName(), team.getGamesPlayed(), team.Win(), team.Los(), team.getPoints()));
            System.out.println("======================================================================");
        }
    }

    public void printTeams() {
        for (Team team : teams) {
            System.out.println(team.getName());
        }
    }

    public void printMatchResult(int matchNumber) {
        Node current = head;
        for (int i = 1; i < matchNumber && current != null; i++) {
            current = current.getNext();
        }
        if (current != null) {
            System.out.println(current.getMatch());
        } else {
            System.out.println("Match number " + matchNumber + " not found.");
        }
    }

    public static void main(String[] args) {
        String[] teamNames = {
            "Pelita Jaya Jakarta", "Dewa United Banten", "Kesatria Bengawan Solo", "Bali United Basketball",
            "Rajawali Medan", "Prawira Harum Bandung", "RANS Simba Bogor", "Satria Muda Pertamina Jakarta",
            "Borneo Hornbills", "Amartha Hangtuah Jakarta", "Satya Wacana Salatiga", "Bima Perkasa Jogja",
            "Tangerang Hawks Basketball Club", "Pacific Caesar Surabaya"
        };

        Standing standing = new Standing(teamNames);
        Scanner scanner = new Scanner(System.in);

        String[][] matches = {
            {"Bali United Basketball", "Amartha Hangtuah Jakarta", "Bali United Basketball"},
            {"Pacific Caesar Surabaya", "Rajawali Medan", "Rajawali Medan"},
            {"Satria Muda Pertamina Jakarta", "Borneo Hornbills", "Satria Muda Pertamina Jakarta"},
            {"Prawira Harum Bandung", "Pelita Jaya Jakarta", "Pelita Jaya Jakarta"},
            {"Bali United Basketball", "Bima Perkasa Jogja", "Bali United Basketball"},
            {"Pacific Caesar Surabaya", "Tangerang Hawks Basketball Club", "Tangerang Hawks Basketball Club"},
            {"Satria Muda Pertamina Jakarta", "Dewa United Banten", "Dewa United Banten"},
            {"Prawira Harum Bandung", "Kesatria Bengawan Solo", "Amartha Hangtuah Jakarta"},
            {"Satya Wacana Salatiga", "Rajawali Medan", "Kesatria Bengawan Solo"},
            {"Pelita Jaya Jakarta", "Tangerang Hawks Basketball Club", "Bima Perkasa Jogja"},
            {"Bima Perkasa Jogja", "Dewa United Banten", "Prawira Harum Bandung"},
            {"RANS Simba Bogor", "Bali United Basketball", "Rajawali Medan"},
            {"Borneo Hornbills", "Tangerang Hawks Basketball Club", "Satya Wacana Salatiga"},
            {"Pelita Jaya Jakarta", "Satria Muda Pertamina Jakarta", "Satya Wacana Salatiga"},
            {"Satya Wacana Salatiga", "Amartha Hangtuah Jakarta", "Bali United Basketball"},
            {"RANS Simba Bogor", "Satria Muda Pertamina Jakarta", "Dewa United Banten"},
            {"Borneo Hornbills", "Bali United Basketball", "Tangerang Hawks Basketball Club"},
            {"Bima Perkasa Jogja", "Rajawali Medan", "Satria Muda Pertamina Jakarta"},
            {"Dewa United Banten", "Tangerang Hawks Basketball Club", "Borneo Hornbills"},
            {"Amartha Hangtuah Jakarta", "Pacific Caesar Surabaya", "Borneo Hornbills"},
            {"Kesatria Bengawan Solo", "Rajawali Medan", "Bali United Basketball"},
            {"Satya Wacana Salatiga", "Pelita Jaya Jakarta", "Pelita Jaya Jakarta"},
            {"Borneo Hornbills", "RANS Simba Bogor", "Kesatria Bengawan Solo"},
            {"Amartha Hangtuah Jakarta", "Prawira Harum Bandung", "Dewa United Banten"},
            {"Pacific Caesar Surabaya", "Bima Perkasa Jogja", "Dewa United Banten"},
            {"Kesatria Bengawan Solo", "Satya Wacana Salatiga", "Bima Perkasa Jogja"},
            {"Tangerang Hawks Basketball Club", "RANS Simba Bogor", "Pelita Jaya Jakarta"},
            {"Dewa United Banten", "Prawira Harum Bandung", "Prawira Harum Bandung"},
            {"Pelita Jaya Jakarta", "Pacific Caesar Surabaya", "Satria Muda Pertamina Jakarta"},
            {"Rajawali Medan", "Amartha Hangtuah Jakarta", "RANS Simba Bogor"},
            {"Borneo Hornbills", "Pacific Caesar Surabaya", "Amartha Hangtuah Jakarta"},
            {"Bali United Basketball", "Prawira Harum Bandung", "Rajawali Medan"},
            {"Bima Perkasa Jogja", "Satria Muda Pertamina Jakarta", "Satya Wacana Salatiga"},
            {"Kesatria Bengawan Solo", "RANS Simba Bogor", "Tangerang Hawks Basketball Club"},
            {"Rajawali Medan", "Dewa United Banten", "Rajawali Medan"},
            {"Satya Wacana Salatiga", "Borneo Hornbills", "Borneo Hornbills"},
            {"Satya Wacana Salatiga", "Tangerang Hawks Basketball Club", "Kesatria Bengawan Solo"},
            {"Satria Muda Pertamina Jakarta", "Bima Perkasa Jogja", "Satya Wacana Salatiga"},
            {"Prawira Harum Bandung", "Borneo Hornbills", "Bali United Basketball"},
            {"Rajawali Medan", "Pelita Jaya Jakarta", "RANS Simba Bogor"},
            {"Satya Wacana Salatiga", "Kesatria Bengawan Solo", "Pelita Jaya Jakarta"},
            {"Amartha Hangtuah Jakarta", "Bima Perkasa Jogja", "Dewa United Banten"},
            {"Prawira Harum Bandung", "Pacific Caesar Surabaya", "Bima Perkasa Jogja"},
            {"Rajawali Medan", "RANS Simba Bogor", "Pelita Jaya Jakarta"},
            {"Satria Muda Pertamina Jakarta", "Bali United Basketball", "Satya Wacana Salatiga"},
            {"Amartha Hangtuah Jakarta", "Dewa United Banten", "Tangerang Hawks Basketball Club"},
            {"Dewa United Banten", "Pacific Caesar Surabaya", "Bali United Basketball"},
            {"Tangerang Hawks Basketball Club", "Bali United Basketball", "RANS Simba Bogor"},
            {"Pelita Jaya Jakarta", "Satya Wacana Salatiga", "Borneo Hornbills"},
            {"Tangerang Hawks Basketball Club", "Pacific Caesar Surabaya", "Pacific Caesar Surabaya"},
            {"Satria Muda Pertamina Jakarta", "Rajawali Medan", "Pelita Jaya Jakarta"},
            {"Bima Perkasa Jogja", "Kesatria Bengawan Solo", "Kesatria Bengawan Solo"},
            {"RANS Simba Bogor", "Amartha Hangtuah Jakarta", "Borneo Hornbills"},
            {"Pelita Jaya Jakarta", "Bali United Basketball", "Bima Perkasa Jogja"},
            {"Satria Muda Pertamina Jakarta", "Prawira Harum Bandung", "Pelita Jaya Jakarta"},
            {"Bima Perkasa Jogja", "Borneo Hornbills", "Satya Wacana Salatiga"},
            {"Dewa United Banten", "Satya Wacana Salatiga", "Dewa United Banten"},
            {"RANS Simba Bogor", "Rajawali Medan", "Bima Perkasa Jogja"},
            {"Kesatria Bengawan Solo", "Borneo Hornbills", "Pelita Jaya Jakarta"},
            {"Pacific Caesar Surabaya", "Satria Muda Pertamina Jakarta", "Bali United Basketball"},
            {"Bali United Basketball", "Satya Wacana Salatiga", "RANS Simba Bogor"},
            {"Kesatria Bengawan Solo", "Bima Perkasa Jogja", "Bima Perkasa Jogja"},
            {"Bali United Basketball", "Satria Muda Pertamina Jakarta", "Pelita Jaya Jakarta"},
            {"Pacific Caesar Surabaya", "Borneo Hornbills", "Satya Wacana Salatiga"},
            {"RANS Simba Bogor", "Bima Perkasa Jogja", "Dewa United Banten"},
            {"Rajawali Medan", "Bali United Basketball", "Borneo Hornbills"},
            {"Tangerang Hawks Basketball Club", "Amartha Hangtuah Jakarta", "Rajawali Medan"},
            {"RANS Simba Bogor", "Pelita Jaya Jakarta", "RANS Simba Bogor"},
            {"Rajawali Medan", "Satya Wacana Salatiga", "Satya Wacana Salatiga"},
            {"Tangerang Hawks Basketball Club", "Borneo Hornbills", "Dewa United Banten"},
            {"Bima Perkasa Jogja", "Tangerang Hawks Basketball Club", "Bima Perkasa Jogja"},
            {"Prawira Harum Bandung", "Bali United Basketball", "Pelita Jaya Jakarta"},
            {"Borneo Hornbills", "Rajawali Medan", "Bali United Basketball"},
            {"Bima Perkasa Jogja", "Pelita Jaya Jakarta", "Satya Wacana Salatiga"},
            {"Prawira Harum Bandung", "Bali United Basketball", "Satria Muda Pertamina Jakarta"},
            {"Amartha Hangtuah Jakarta", "Kesatria Bengawan Solo", "RANS Simba Bogor"},
            {"Dewa United Banten", "Rajawali Medan", "Dewa United Banten"},
            {"Satria Muda Pertamina Jakarta", "Satya Wacana Salatiga", "Satya Wacana Salatiga"},
            {"Prawira Harum Bandung", "RANS Simba Bogor", "Bali United Basketball"},
            {"Borneo Hornbills", "Pelita Jaya Jakarta", "Kesatria Bengawan Solo"},
            {"Dewa United Banten", "Bali United Basketball", "Pelita Jaya Jakarta"},
            {"Amartha Hangtuah Jakarta", "Satya Wacana Salatiga", "Bali United Basketball"},
            {"Satria Muda Pertamina Jakarta", "Kesatria Bengawan Solo", "Dewa United Banten"},
            {"Pacific Caesar Surabaya", "Dewa United Banten", "Satya Wacana Salatiga"},
            {"Pelita Jaya Jakarta", "Rajawali Medan", "Pelita Jaya Jakarta"},
            {"Kesatria Bengawan Solo", "Amartha Hangtuah Jakarta", "Kesatria Bengawan Solo"},
            {"Pelita Jaya Jakarta", "Borneo Hornbills", "Pelita Jaya Jakarta"},
            {"Satya Wacana Salatiga", "Dewa United Banten", "Satya Wacana Salatiga"},
            {"Tangerang Hawks Basketball Club", "Rajawali Medan", "Tangerang Hawks Basketball Club"},
            {"Kesatria Bengawan Solo", "Bali United Basketball", "Pelita Jaya Jakarta"}
        };

        for (int i = 0; i < matches.length; i++) {
            standing.addMatch(i + 1, matches[i][0], matches[i][1], matches[i][2]);
        }

        while (true) {
            System.out.println("=================================");
            System.out.println("     INDONESIA BASKET LEAGUE     ");
            System.out.println("=================================");
            System.out.println("\nMenu:");
            System.out.println("1. Print Standings");
            System.out.println("2. Print Teams");
            System.out.println("3. Print Match Result");
            System.out.println("4. Exit");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    standing.printStandings();
                    break;
                case 2:
                    standing.printTeams();
                    break;
                case 3:
                    System.out.print("Masukkan nomor match: ");
                    int matchNumber = scanner.nextInt();
                    standing.printMatchResult(matchNumber);
                    break;
                case 4:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
