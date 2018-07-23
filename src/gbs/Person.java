package gbs;

public class Person {
	//campus
	public static final int ��õ���� = 1;
	public static final int ���� = 2;
	public static final int ���� = 3;
	public static final int ���� = 4;
	public static final int ������ = 5;
	public static final int ���з� = 6;
	public static final int ��ۿ��ٴ� = 7;
	public static final int ���� = 8;
	public static final int ������ = 21;
	public static final int ������ = 9;
	public static final int ���� = 10;
	public static final int ���� = 11;
	public static final int ����� = 12;
	public static final int õ�� = 13;
	public static final int �ʷ��� = 14;
	

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
		if (campus.contains("��õ"))
			setCampus(��õ����);
		else if (campus.contains("����"))
			setCampus(����);
		else if (campus.contains("����"))
			setCampus(����);
		else if (campus.contains("����"))
			setCampus(����);
		else if (campus.contains("������"))
			setCampus(������);
		else if (campus.contains("���з�"))
			setCampus(���з�);
		else if (campus.contains("��ۿ��ٴ�"))
			setCampus(��ۿ��ٴ�);
		else if (campus.contains("����"))
			setCampus(����);
		else if (campus.contains("������"))
			setCampus(������);
		else if (campus.contains("������"))
			setCampus(������);
		else if (campus.contains("����"))
			setCampus(����);
		else if (campus.contains("����"))
			setCampus(����);
		else if (campus.contains("�����"))
			setCampus(�����);
		else if (campus.contains("õ��"))
			setCampus(õ��);
		else if (campus.contains("�ʷ���"))
			setCampus(�ʷ���);
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
		else if (gbsLevel.equals("������"))
			setGbsLevel(FRESHMAN);
		else if (gbsLevel.contains("�ڸ�"))
			setGbsLevel(WITHBABY);
		else
			setGbsLevel(-1);


	}
	public void setPosition(String position) {
		if (position.equals("����"))
			setPosition(LEADER);
		else if (position.equals("����"))
			setPosition(MEMBER);
		else if (position.equals("������"))
			setPosition(SEMI_LEADER);
		else
			setPosition(-1);
		
	}
	public void setAge(String age) {
		setAge(Integer.parseInt(age));
		
	}
	public void setSex(String sex) {
		if (sex.equals("��"))
			setSex(MALE);
		else if(sex.equals("��"))
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
				return "������";
			case WITHBABY:
				return "�ڸ�";
			default:
				return "N/A";
			
		}
	}
	public static String positionToString(int position) {
		switch(position) {
		case LEADER:
			return "����";
		case SEMI_LEADER:
			return "������";
		case MEMBER:
			return "����";
		default:
			return "N/A";
		}
	}
	public static String campusToString(int campus) {
		switch(campus) {
		case ��õ����:
			return "��õ����";
		case ����:
			return "����";
		case ����:
			return "����";
		case ����:
			return "����";
		case ������:
			return "������";
		case ���з�:
			return "���з�";
		case ��ۿ��ٴ�:
			return "��ۿ��ٴ�";
		case ����:
			return "����";
		case ������:
			return "������";
		case ������:
			return "������";
		case ����:
			return "����";
		case ����:
			return "����";
		case �����:
			return "�����";
		case õ��:
			return "õ��";
		case �ʷ���:
			return "�ʷ���";
		default:
			return "N/A";

		}
		
	}
	public static String sexToString(int sex) {
		switch(sex) {
			case MALE:
				return "��";
			case FEMALE:
				return "��";
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
