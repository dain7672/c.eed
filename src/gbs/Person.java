package gbs;

public class Person {
	//campus
	public static final int 가천인하 = 1;
	public static final int 강변 = 2;
	public static final int 강북 = 3;
	public static final int 강원 = 4;
	public static final int 남서울 = 5;
	public static final int 대학로 = 6;
	public static final int 방송에바다 = 7;
	public static final int 부인 = 8;
	public static final int 새내기 = 21;
	public static final int 서지전 = 9;
	public static final int 성용 = 10;
	public static final int 신촌 = 11;
	public static final int 예배당 = 12;
	public static final int 천안 = 13;
	public static final int 필레오 = 14;
	

	//gbslevel
	public static final int A = 11;
	public static final int B = 12;
	public static final int C = 13;
	public static final int D = 14;
	public static final int E = 15;
	public static final int F = 16;
	public static final int J = 17;
	public static final int OJ = 21;
	public static final int STAFF = 99;
	public static final int FRESHMAN = 31;
	public static final int WITHBABY = 41;
	
	//position
	public static final int LEADER = 1;
	public static final int MEMBER = 2;
	public static final int SEMI_LEADER = 3;
	
	//sex
	public static final int MALE = 1;
	public static final int FEMALE = 2;

	private int id;
	private String name;
	private int campus;
	private int gbsLevel;
	private int position;
	private int age;
	private int sex;
	
	public Person() {
		
	}
	
	public Person(int id, String name, int campus, int gbsLevel, int position, int age, int sex) {
		this.id = id;
		this.name = name;
		this.campus = campus;
		this.gbsLevel = gbsLevel;
		this.position = position;
		this.age = age;
		this.sex = sex;
	}
	

	public Person(String id, String name, String campus, String gbsLevel, String position, String age, String sex) {
		this.id = Integer.parseInt(id);
		this.name = name;
		setCampus(campus);
		setGbsLevel(gbsLevel);
		setPosition(position);
		setAge(age);
		setSex(sex);
	}
	public void setCampus(String campus) {
		if (campus.contains("가천"))
			setCampus(가천인하);
		else if (campus.contains("강변"))
			setCampus(강변);
		else if (campus.contains("강북"))
			setCampus(강북);
		else if (campus.contains("강원"))
			setCampus(강원);
		else if (campus.contains("남서울"))
			setCampus(남서울);
		else if (campus.contains("대학로"))
			setCampus(대학로);
		else if (campus.contains("방송에바다"))
			setCampus(방송에바다);
		else if (campus.contains("부인"))
			setCampus(부인);
		else if (campus.contains("새내기"))
			setCampus(새내기);
		else if (campus.contains("서지전"))
			setCampus(서지전);
		else if (campus.contains("성용"))
			setCampus(성용);
		else if (campus.contains("신촌"))
			setCampus(신촌);
		else if (campus.contains("예배당"))
			setCampus(예배당);
		else if (campus.contains("천안"))
			setCampus(천안);
		else if (campus.contains("필레오"))
			setCampus(필레오);
		else
			setCampus(-1);

	}
	public void setGbsLevel(String gbsLevel) {
		if (gbsLevel.equals("A"))
			setGbsLevel(A);
		else if (gbsLevel.equals("B"))
			setGbsLevel(B);
		else if (gbsLevel.equals("C"))
			setGbsLevel(C);
		else if (gbsLevel.equals("D"))
			setGbsLevel(D);
		else if (gbsLevel.equals("E"))
			setGbsLevel(E);
		else if (gbsLevel.equals("F"))
			setGbsLevel(F);
		else if (gbsLevel.equals("J"))
			setGbsLevel(J);
		else if (gbsLevel.equals("OJ"))
			setGbsLevel(OJ);
		else if (gbsLevel.equals("STAFF"))
			setGbsLevel(STAFF);
		else if (gbsLevel.equals("새내기"))
			setGbsLevel(FRESHMAN);
		else if (gbsLevel.contains("자모"))
			setGbsLevel(WITHBABY);
		else
			setGbsLevel(-1);


	}
	public void setPosition(String position) {
		if (position.equals("조장"))
			setPosition(LEADER);
		else if (position.equals("조원"))
			setPosition(MEMBER);
		else if (position.equals("부조장"))
			setPosition(SEMI_LEADER);
		else
			setPosition(-1);
		
	}
	public void setAge(String age) {
		setAge(Integer.parseInt(age));
		
	}
	public void setSex(String sex) {
		if (sex.equals("남"))
			setSex(MALE);
		else if(sex.equals("여"))
			setSex(FEMALE);
		else
			setSex(-1);
	}
	public String toString() {
		return (name+ " | gbs: " + levelToString(gbsLevel)
				+ " | "+campusToString(campus)+ " | "  + positionToString(position)
				+ " " +" | age: "+ age +" | "+sexToString(sex) +"\n");
	}
	public static String levelToString(int gbsLevel) {
		switch(gbsLevel) {
			case A:
				return "A";
			case B:
				return "B";
			case C:
				return "C";
			case D:
				return "D";
			case E:
				return "E";
			case F:
				return "F";
			case J:
				return "J";
			case OJ:
				return "OJ";
			case STAFF:
				return "STAFF";
			case FRESHMAN:
				return "새내기";
			case WITHBABY:
				return "자모";
			default:
				return "N/A";
			
		}
	}
	public static String positionToString(int position) {
		switch(position) {
		case LEADER:
			return "조장";
		case SEMI_LEADER:
			return "부조장";
		case MEMBER:
			return "조원";
		default:
			return "N/A";
		}
	}
	public static String campusToString(int campus) {
		switch(campus) {
		case 가천인하:
			return "가천인하";
		case 강변:
			return "강변";
		case 강북:
			return "강북";
		case 강원:
			return "강원";
		case 남서울:
			return "남서울";
		case 대학로:
			return "대학로";
		case 방송에바다:
			return "방송에바다";
		case 부인:
			return "부인";
		case 새내기:
			return "새내기";
		case 서지전:
			return "서지전";
		case 성용:
			return "성용";
		case 신촌:
			return "신촌";
		case 예배당:
			return "예배당";
		case 천안:
			return "천안";
		case 필레오:
			return "필레오";
		default:
			return "N/A";

		}
		
	}
	public static String sexToString(int sex) {
		switch(sex) {
			case MALE:
				return "남";
			case FEMALE:
				return "여";
			default:
				return "N/A";
		}
	}

	

	public int getCampus() {
		return campus;
	}

	public void setCampus(int campus) {
		this.campus = campus;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGbsLevel() {
		return gbsLevel;
	}
	public void setGbsLevel(int gbsLevel) {
		this.gbsLevel = gbsLevel;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}
	
	
	

}
