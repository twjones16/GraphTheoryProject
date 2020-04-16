import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class League {

	public ArrayList<Team> teams = new ArrayList<Team>();

	// go through a csv and add all of the teams and who they beat
	public League (String aCSVFile) {

		String csvFile = aCSVFile;
		BufferedReader file = null;
		String line = "";
		String splitBy = ",";

		// read through the file and add to an ArrayList tree.
		try {
			file = new BufferedReader(new FileReader(csvFile));
		} catch (FileNotFoundException e) {
			System.out.println("This file could not be found.");;
		}
		try {
			int iterator = 0;
			while ((line = file.readLine()) != null) {
				// use comma as separator and add make a new TreeObservation object if
				// the entry has an id
				String[] data = line.split(splitBy);
				if (iterator == 0) {
					for (int i = 1; i < data.length; i++) {
						Team newTeam = new Team(data[i].substring(4));
						teams.add(newTeam);
					}
				} else {
					Team currTeam = teams.get((iterator - 1) % teams.size());
					int ownScore = 0;
					int oppScore = 0;
					for  (int i = 1; i < data.length; i++) {
						if (!data[i].equals("--")) {

							
							String[] score = data[i].split("-");
	
							
							ownScore = Integer.parseInt(score[0]);
							oppScore = Integer.parseInt(score[1]);
						
							/*if(ownScore == oppScore) {
								currTeam.addTiedTeam(teams.get(i - 1));
							}*/
							if (ownScore > oppScore) {
								currTeam.addBeatTeam(teams.get(i - 1));
							}
						}
					}
				}
				iterator ++;
			}
		} catch (IOException e) {
			System.out.println("This file can not be read.");;
		}
	}
}


