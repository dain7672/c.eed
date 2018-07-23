package gbs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileConverter {
	private static final int ID_POS = 0;
	private static final int NAME_POS = 1;
	private static final int CAM_POS = 2;
	private static final int GBS_POS = 4;
	private static final int MEM_POS = 5;
	private static final int AGE_POS = 6;
	private static final int SEX_POS = 7;
	
	private static final String INPUT_CSV_FILE = "src/data/2018겨울수련회명단.csv";
	private static final String OUTPUT_CSV_FILE = "src/data/GBS조배치 결과.csv";


	
	public static List<Person> generateList() {
		List<Person> personList = new ArrayList<Person>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(INPUT_CSV_FILE));
			String line = reader.readLine();
			line = reader.readLine(); //first line is names of attributes
			while(line != null) {
				personList.add(parseLine(line));
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return personList;
	}
	private static Person parseLine(String line) {
		String[] tokens = line.split(",");
		return new Person(tokens[ID_POS], tokens[NAME_POS],
				tokens[CAM_POS], tokens[GBS_POS], tokens[MEM_POS],
				tokens[AGE_POS], tokens[SEX_POS]);
	}

	public static String writeTeam(Team team) {
		List<Person> members = team.getMembers();
		String output = Person.levelToString(team.getGbsLevel())+","+team.getLeader().getName()
				+"("+team.getLeader().getAge()+"),";
		output+= "="+members.size()+"&\"/\"&"+team.getCampusDiversity();
		for(int i=0; i<members.size();i++) {
			Person member =members.get(i);
			output+= ","+ member.getName()+"("+member.getAge()+")";
		}
		output +="\n";
		return output;
		
	}

	public static String writeMember(Person person) {
		return Person.levelToString(person.getGbsLevel())+","+ person.getName()+","
				+Person.campusToString(person.getCampus())+","
				+Person.positionToString(person.getPosition())+","
				+person.getAge()+","+Person.sexToString(person.getSex())+"\n";
	}
	public static void writeFile(String string) {
		try{
            File file = new File(OUTPUT_CSV_FILE) ;
            FileWriter fw = new FileWriter(file, false) ;
            fw.write(string);
            fw.flush();
            fw.close();
        }catch(Exception e){
            e.printStackTrace();
        }	
	}
	

}
