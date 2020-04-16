import java.util.ArrayList;

public class Team implements Comparable<Team> {
	private ArrayList<Team> beatTeams = new ArrayList<Team> ();
	private ArrayList<Team> tiedTeams = new ArrayList<Team>();
	private long score;
	private String name;
	private long percent;
	
	public Team (String aName) {
		name = aName;
		score = 1;
		
	}

	public ArrayList<Team> getBeatTeams() {
		return beatTeams;
	}
	public ArrayList<Team> getTiedTeams(){
		return tiedTeams;
	}

	public void addBeatTeam(Team beatTeam) {
		this.beatTeams.add(beatTeam);
		score ++;
	}
	public void addTiedTeam(Team tiedTeam) {
		this.tiedTeams.add(tiedTeam);
	}

	public long getScore() {
		return score;
	}
	
	public void setScore(long aScore) {
		score = aScore;
	}
	
	
	
	public String getName() {
		return name;
	}



	@Override
	public int compareTo(Team aTeam) {
		return (int) (aTeam.score - score);
	
	}
	
}
