package Question;

/*
2019�� 4�� 18�� _ 16��: ��Ʈ���� ���� ó�� ����
(�ð��� ���´ٸ�, �� ������ ���� ������������ ó�� ������ �ۼ����ּ���.)

1.
���ڿ��� �ܾ �����ϼ���! ��, �ҹ��ڷ� ������ �� �ߺ��� �����Ͻÿ�.

String[] str = {
"He who makes no mistakes makes nothing",
"He that promises too much means nothing",
};

2. 
3�г� �л����� ���� ����� ����, 1����� �������ּ���!

<����>
1) student Ŭ������ �����ϰ�,
public static int Fresh=1;
public static int Sopho=2;
public static int Junior=3;
public static int Senior=4;
�� �������ּ���.
2) student Ŭ������ �ʵ�� �̸�, �г�, ��� �Դϴ�.
3) 3�г� �л����� ���� ���ο� List�� ���� �� ����� ����, �������ּ���.

new Student("����", Students.Fresh, 100)
new Student("�ٶ�", Students.Junior, 88)
new Student("����", Students.Junior, 15)
new Student("���", Students.Junior, 99)
new Student("����", Students.Sopho, 49)
new Student("īŸ", Students.Junior, 20)
new Student("����", Students.Senior, 70)
*/

/*��Ʈ���� �÷����� ���� ��Ҹ� �ϳ��� �����ؼ� ���ٽ����� ó���� �� �ֵ��� ���ִ� �ݺ����̴�!*/

/*
 * ��Ʈ���� �����ϴ� �⺻���� ��� 
 * collection.stream()
 * stream.of()
 * arrays.stream(�迭)
 * */
import java.util.*;
import java.util.stream.*;

public class Example {
	public static void main(String[] args) {
		// 1��
		String[] str = { "He who makes no mistakes makes nothing", "He that promises too much means nothing", };

		Stream<String> ls = Arrays.stream(str);
		ls.flatMap(l -> Stream.of(l.split(" ")))//string�� ��Ҹ� �� ����, �� ���� ���� ��ҷ� ������ ��Ʈ������ �����Ѵ�.
												//stream.of�� stream�� ���� �����ϴ� ����̴�.
				.map(String::toLowerCase)//��Ҹ� ��ü�ϴ� ����� ��Ʈ���� ����
				.distinct()//�ߺ� ����
				.sorted()//������ �߰�ó�� ��Ʈ��, ������������ ���ĵ� ��Ʈ���� �����Ѵ�.
				.forEach(System.out::println);//forEach�� ��� ��ü�� �ݺ��ϴ� ���� ó�� �޼ҵ�
		System.out.println();

		// 2��
		List<Student> sl = Arrays.asList(new Student("����", Student.Fresh, 100),
										new Student("�ٶ�", Student.Junior, 88), 
										new Student("����", Student.Junior, 15),
										new Student("���", Student.Junior, 99), 
										new Student("����", Student.Sopho, 49),
										new Student("īŸ", Student.Junior, 20), 
										new Student("����", Student.Senior, 70));

		// ����������(���� ���� ��Ʈ���� ����Ǿ� �ִ� ����)
		// �������� ��Ʈ������, �߰� ó�� ��Ʈ����� ���� ó���� �������� �̾��� �ִ� ����!
		List<Student> jList = sl.stream()//original stream
				.filter(s -> s.getGrade() == Student.Junior)//���͸��� �߰�ó�� ��Ʈ��, 3�г� ��ü�� ��ҷ� �ϴ� ��Ʈ���� �����Ѵ�.
				.sorted(Comparator.reverseOrder())//������ �߰�ó�� ��Ʈ��, ������������ ���ĵ� ��Ʈ���� �����Ѵ�.
				.collect(Collectors.toList());//���� ó�� �޼ҵ� collect(). �ʿ��� ���(3�г�)�� �÷������� �����´�.

		double avgScore = jList.stream()//original stream
							.mapToInt(Student::getScore)//������ �߰�ó�� ��Ʈ��, student��ü�� score������ �����ؼ� ���ο� ��Ʈ���� �����Ѵ�.
							.average()//��հ��� ���� ó��
							.getAsDouble();//average�� ���� ���� original double�̱� ������ getasdouble�޼ҵ带 ȣ���ؼ� ����� ��� ���� �д´�.

		System.out.println("3�г� ģ������ ��� ����: " + avgScore);

		System.out.println("3�г� ģ������ ����� ������ �����ϴ�.");
		jList.stream()
			.forEach(s -> System.out.println(s));//����� �� tostring�� �������Ͽ���.
	}
}

class Student implements Comparable<Student> {
	public static int Fresh = 1;
	public static int Sopho = 2;
	public static int Junior = 3;
	public static int Senior = 4;

	private String name;
	private int grade;
	private int score;

	Student(String name, int grade, int score) {
		this.name = name;
		this.grade = grade;
		this.score = score;
	}

	String getName() {
		return name;
	}

	int getGrade() {
		return grade;
	}

	int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return name + " (" + score + ")";
	}

	@Override
	public int compareTo(Student s) {
		return Integer.compare(score, s.getScore());
	}
}