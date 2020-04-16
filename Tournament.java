import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Tournament {
	
	public HashMap<Team, Long> teamsOne = new HashMap<Team, Long>();
	private HashMap<Team, Long> teamsTwo = new HashMap<Team, Long>();
	String aCSV = "src/data.csv";
	boolean first = true;
	
	public Tournament () {
		League league = new League(aCSV);
		
		for (Team currTeam : league.teams) {
			long score = currTeam.getScore();
			teamsOne.put(currTeam, score);
			teamsTwo.put(currTeam, score);
		}

		int converge = 0;

		while (converge < 6) {
			Set<Team> keySet = teamsOne.keySet();;
			
			for (Team currTeam : keySet) {
				long newScore = 0;
				ArrayList<Team> beat = currTeam.getBeatTeams();
				ArrayList<Team> ties = currTeam.getTiedTeams();
				for (Team beatTeam : beat) {
					
					if (first) {
						newScore += teamsOne.get(beatTeam);
					} else {
						newScore += teamsTwo.get(beatTeam);
					}
					
				}
				for(Team tiedTeam:ties) {
					if(!tiedTeam.getName().equals(currTeam.getName())){
						if(first) {
							newScore += teamsOne.get(tiedTeam)/2;
						} else {
							newScore += teamsTwo.get(tiedTeam)/2;
						}
					}
				}
				if (first) {
					teamsTwo.replace(currTeam, newScore);
				} else {
					teamsOne.replace(currTeam, newScore);
				}
				currTeam.setScore(newScore);
			}
			first = !first;
			converge ++;
			
		}
		double total = 0; 
		for(Team aTeam : league.teams) {
			total += aTeam.getScore();
			
		}
		
		league.teams.sort(null);
		
		
		
		
		for (Team x : league.teams) {
			double score = x.getScore();
			double result = ((double)Math.round((score/total) * 100000))/1000;
			
			System.out.println(x.getName() + ", "+ result );
		
		}
		
		
	}


	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		Tournament tournament = new Tournament ();
			
	}
	
}


