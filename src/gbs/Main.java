package gbs;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import gbs.FileConverter;

public class Main {
	private static final int POSSIBLE_AGE_GAP = 2;
	
	public static void main(String[] args) {
		List<Person> personList = FileConverter.generateList();
		System.out.println("----------Function-TEST---------------");
		System.out.println(personList.size());
		System.out.println("9th person: " + personList.get(8).getName());
		
		Comparator<Person> customComparator = new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				if (o1.getGbsLevel() == o2.getGbsLevel()) {
					if (Math.abs(o1.getAge() - o2.getAge()) < POSSIBLE_AGE_GAP) {
						return o1.getCampus() - o2.getCampus();
					}
					return o1.getAge() - o2.getAge();
				}
				return o1.getGbsLevel() - o2.getGbsLevel();
			}
		};
		Collections.shuffle(personList);
		Collections.sort(personList, customComparator);
		System.out.println(personList.size());
		List<Person> member_males = personList.stream()
								.filter(p -> p.getSex() == Person.MALE)
								.filter(p -> p.getPosition() == Person.MEMBER)
								.collect(Collectors.toList());
		List<Person> member_females = personList.stream()
				.filter(p -> p.getSex() == Person.FEMALE)
				.filter(p -> p.getPosition() == Person.MEMBER)
				.collect(Collectors.toList());
		List<Person> leaders = personList.stream()
				.filter(p -> p.getPosition() == Person.LEADER)
				.collect(Collectors.toList());
		List<Person> semi_leaders = personList.stream()
				.filter(p -> p.getPosition() == Person.SEMI_LEADER)
				.collect(Collectors.toList());
		
		//printAllMembers(member_males, member_females, leaders, semi_leaders);
		
		List<Team> teamList = 
				TeamGenerator.generate(leaders, member_males, member_females, semi_leaders);
		
		StringBuilder sb = new StringBuilder();
		StringBuilder sb_csv = new StringBuilder();
		sb.append("\n------------GBS 조 배치 결과 ------------------\n");
		sb_csv.append("gbs,조장,조원/캠퍼스 수,조원\n");
		//exclude manual team(수동배치팀은 제외)
		for (int i=0; i< teamList.size() - 1; i++) {
			sb.append(teamList.get(i));
			sb_csv.append(FileConverter.writeTeam(teamList.get(i)));
		}
		sb.append("\n-------------수동배치-------------------\n");
		sb_csv.append("\n수동배치\n");
		sb_csv.append("gbs,이름,캠퍼스,구분,나이,성별\n");
		for (int i=0; i<semi_leaders.size(); i++) {
			sb.append(semi_leaders.get(i));
			sb_csv.append(FileConverter.writeMember(semi_leaders.get(i)));
		}
		Team manualTeam = teamList.get(teamList.size()-1);
		List<Person> manualTeamMembers = manualTeam.getMembers();
		for (int i=0; i<manualTeamMembers.size(); i++) {
			sb.append(manualTeamMembers.get(i));
			sb_csv.append(FileConverter.writeMember(manualTeamMembers.get(i)));
		}
		
		//printing result
		System.out.println(sb.toString());
		
		//writing file
		FileConverter.writeFile(sb_csv.toString());
		
		
	}

	private static void printAllMembers(List<Person> member_males, List<Person> member_females, List<Person> leaders,
			List<Person> semi_leaders) {
		System.out.println(member_males.size()+ "----------------");
		member_males.forEach(System.out::println);
		System.out.println(member_females.size()+ "----------------");
		member_females.forEach(System.out::println);
		System.out.println(leaders.size()+ "----------------");
		leaders.forEach(System.out::println);
		System.out.println(semi_leaders.size()+ "----------------");
		semi_leaders.forEach(System.out::println);
	}

}
