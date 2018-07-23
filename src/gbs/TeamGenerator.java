package gbs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeamGenerator {
	public static List<Team> generate(List<Person> leaders, List<Person> member_males,
			List<Person> member_females, List<Person> semi_leaders) {
		List<Team> teamList = new ArrayList<Team>();
		for (int i=0; i<leaders.size(); i++) {
			Person leader = leaders.get(i);
			teamList.add(new Team(leader.getGbsLevel(), leader));
		}
		//manual team
		teamList.add(new Team(-99, new Person()));
		
		HashMap<Integer, List<Person>> leaders_map = divideByGbs(leaders);
		HashMap<Integer, List<Person>> member_males_map = divideByGbs(member_males);
		for (int key : member_males_map.keySet()) {
			teamList = group_generate(member_males_map.get(key), teamList);
			System.out.println("male, completed: gbslevel: "+ key);
		}
		HashMap<Integer, List<Person>> member_females_map = divideByGbs(member_females);
		for (int key : member_females_map.keySet()) {
			teamList = group_generate(member_females_map.get(key), teamList);
			System.out.println("female, completed: gbslevel: "+ key);
		}
		
		return teamList;
		
	}
	
	public static HashMap<Integer, List<Person>> divideByGbs(List<Person> people) {
		HashMap<Integer, List<Person>> map = new HashMap<Integer, List<Person>>();
		List<Person> plist = new ArrayList<Person>();
		for (int i=0; i<people.size(); i++) {
			Person person = people.get(i);
			int level = person.getGbsLevel();
			if (i == people.size() - 1) {
				plist.add(person);
				map.put(level, plist);
			}
			else if (person.getGbsLevel() != people.get(i+1).getGbsLevel()) {
				plist.add(people.get(i));
				map.put(level, plist);
				plist = new ArrayList<Person>();
			}
			else {
				plist.add(person);
			}
		}
		return map;
	}
	
	public static List<Team> group_generate(List<Person> members, List<Team> teams) {
		int start_point = 0;
		int size = 0;
		boolean checked = false;
		for (int j=0; j<teams.size();j ++) {
			if (!checked && teams.get(j).getGbsLevel() == members.get(0).getGbsLevel()) {
				start_point = j;
				checked = true;
			}
			else if (checked && teams.get(j).getGbsLevel() != members.get(0).getGbsLevel()) {
				size = j - start_point;
				System.out.println(size);
				checked = false;
				break;
			}
		}
		if (checked) {
			size = teams.size() - start_point;
			System.out.println(size);
		}
		int pos = 0;
		int membersize = members.size();
		while(members.size() > 0) {
			if (pos > membersize * 2) {
				break;
			}
			if (members.get(0).getAge() >= teams.get(start_point + (pos % size)).getLeader().getAge()) {
				if (members.size() > 1)
					members.add(1, members.remove(0));
				//go to back to find older leader
			}
			else {
				teams.get(start_point + pos % size).addMember(members.get(0));
				members.remove(0);
			}
			pos++;
		}
		//people whose age is too large
		while(members.size() > 0 ) {
			//teams.get(start_point + size - 1 - members.size() % 2).addMember(members.remove(0));
			teams.get(teams.size()-1).addMember(members.remove(0));
		}

		return teams;
		
	}

}
