package gbs;

import java.util.ArrayList;
import java.util.List;

public class Team {
	private int gbsLevel;
	private Person leader;
	private List<Person> members;
	
	
	public Team(int gbsLevel, Person leader) {
		this.gbsLevel = gbsLevel;
		this.leader = leader;
		this.members = new ArrayList<Person>();
	}
	
	public Team(int gbsLevel, Person leader, List<Person> members) {
		this.gbsLevel = gbsLevel;
		this.leader = leader;
		this.members = members;
	}
	
	public void addMember(Person member) {
		this.members.add(member);
	}
	public int getAveAge() {
		int sum =0;
		for (int i=0; i<members.size(); i++) {
			sum += members.get(i).getAge();
		}
		if (members.size() == 0)
			return 0;
		return sum / members.size();
	}
	
	public int getCampusDiversity() {
		List<Integer> camlist = new ArrayList<Integer>();
		for (int i=0; i<members.size(); i++) {
			int cam = members.get(i).getCampus();
			if (!camlist.contains(cam))
				camlist.add(cam);
		}
		//including leader campus
//		if (!camlist.contains(leader.getCampus()))
//				camlist.add(leader.getCampus());
		return camlist.size();
	}
	

	public String toString() {
		String output = "";
		output += "gbs: " + Person.levelToString(gbsLevel) + " | 조장: " + leader.getName()+
				"("+leader.getAge()+") ";
		output += "| 조원/캠퍼스 수: "+ members.size()+ "/" +getCampusDiversity()+ " | 조원: ";
		for (int i=0; i<members.size(); i++) {
			output += members.get(i).getName()+"("+members.get(i).getAge()+") ";
		}
		
		output += "\n";
		return output;
	}

	public int getGbsLevel() {
		return gbsLevel;
	}




	public void setGbsLevel(int gbsLevel) {
		this.gbsLevel = gbsLevel;
	}




	public Person getLeader() {
		return leader;
	}




	public void setLeader(Person leader) {
		this.leader = leader;
	}




	public List<Person> getMembers() {
		return members;
	}




	public void setMembers(List<Person> members) {
		this.members = members;
	}





}
