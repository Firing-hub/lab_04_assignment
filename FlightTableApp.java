import java.util.*;

class Match {
    private String location;
    private String team1;
    private String team2;
    private String timing;

    public Match(String location, String team1, String team2, String timing) {
        this.location = location;
        this.team1 = team1;
        this.team2 = team2;
        this.timing = timing;
    }

    public String getLocation() {
        return location;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public String getTiming() {
        return timing;
    }
}

class FlightTable {
    private List<Match> matches = new ArrayList<>();

    public void addMatch(Match match) {
        matches.add(match);
    }

    public List<Match> getMatchesByTeam(String team) {
        List<Match> result = new ArrayList<>();
        for (Match match : matches) {
            if (match.getTeam1().equals(team) || match.getTeam2().equals(team)) {
                result.add(match);
            }
        }
        return result;
    }

    public List<Match> getMatchesByLocation(String location) {
        List<Match> result = new ArrayList<>();
        for (Match match : matches) {
            if (match.getLocation().equals(location)) {
                result.add(match);
            }
        }
        return result;
    }

    public List<Match> getMatchesByTiming(String timing) {
        List<Match> result = new ArrayList<>();
        for (Match match : matches) {
            if (match.getTiming().equals(timing)) {
                result.add(match);
            }
        }
        return result;
    }
}

public class FlightTableApp {
    public static void main(String[] args) {
        FlightTable flightTable = new FlightTable();

        flightTable.addMatch(new Match("Mumbai", "India", "Sri Lanka", "DAY"));
        flightTable.addMatch(new Match("Delhi", "England", "Australia", "DAY-NIGHT"));
        flightTable.addMatch(new Match("Chennai", "India", "South Africa", "DAY"));
        flightTable.addMatch(new Match("Indore", "England", "Sri Lanka", "DAY-NIGHT"));
        flightTable.addMatch(new Match("Mohali", "Australia", "South Africa", "DAY-NIGHT"));
        flightTable.addMatch(new Match("Delhi", "India", "Australia", "DAY"));

        Scanner sc = new Scanner(System.in);
        System.out.println("Choose search parameter:");
        System.out.println("1. List of all matches of a Team");
        System.out.println("2. List of Matches on a Location");
        System.out.println("3. List of Matches based on timing");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter team name:");
                sc.nextLine();
                String team = sc.nextLine();
                List<Match> teamMatches = flightTable.getMatchesByTeam(team);
                for (Match match : teamMatches) {
                    System.out.println(match.getLocation() + " - " + match.getTeam1() + " vs " + match.getTeam2() + " (" + match.getTiming() + ")");
                }
                break;
            case 2:
                System.out.println("Enter location:");
                sc.nextLine();
                String location = sc.nextLine();
                List<Match> locationMatches = flightTable.getMatchesByLocation(location);
                for (Match match : locationMatches) {
                    System.out.println(match.getLocation() + " - " + match.getTeam1() + " vs " + match.getTeam2() + " (" + match.getTiming() + ")");
                }
                break;
            case 3:
                System.out.println("Enter timing:");
                sc.nextLine();
                String timing = sc.nextLine();
                List<Match> timingMatches = flightTable.getMatchesByTiming(timing);
                for (Match match : timingMatches) {
                    System.out.println(match.getLocation() + " - " + match.getTeam1() + " vs " + match.getTeam2() + " (" + match.getTiming() + ")");
                }
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
