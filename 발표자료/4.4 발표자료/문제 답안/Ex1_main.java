package kkkk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex1_main {
	static HashMap<Integer, ex1> list = new HashMap<Integer, ex1>();
	static HashSet<Integer> list_search = new HashSet<Integer>();
	
	public static void main(String[] args) {
		System.out.println("DB TERM PRJECT");
		System.out.println("1: ��ȸ�ϱ�");
		System.out.println("2: �߰��ϱ�");
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("�Է�: ");

			int number = sc.nextInt();
			
			Runnable runnable = () -> {
				//createUser.getList();
				try {
					Thread.sleep(10000);
					if(list != null && list_search != null) {
						Iterator<Integer> it = list_search.iterator(); // iterator ����
						
						while(it.hasNext()){
							int check = it.next();
							if(list.containsKey(check)) {
								System.out.println("�ش� �����͸� ã�ҽ��ϴ�");
								System.out.print("�л� �̸�: "+ list.get(check).getName()+"  ");
								System.out.print("�г�: "+ list.get(check).getGrade()+"  ");
								System.out.print("�ּ�: "+ list.get(check).getAddress()+"  ");
								System.out.println("��ȭ��ȣ: "+ list.get(check).getNumber());	
								list_search.remove(check);
							}
						}
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
			Thread thread = new Thread(runnable);
			thread.start();
			sc.nextLine();
			if(number == 1) {
				// ��ȸ�ϱ�
				// ��ȭ��ȣ �Է� �ޱ�
				int input = sc.nextInt();
				
				// Ű �� ã��
				if(list.containsKey(input)) {
					System.out.println("�ش� �����͸� ã�ҽ��ϴ�");
					System.out.print("�л� �̸�: "+ list.get(input).getName()+"  ");
					System.out.print("�г�: "+ list.get(input).getGrade()+"  ");
					System.out.print("�ּ�: "+ list.get(input).getAddress()+"  ");
					System.out.println("��ȭ��ȣ: "+ list.get(input).getNumber());
				}else {
					System.out.println("�ش� �����͸� ã�� �� �����ϴ�");
					list_search.add(input);
				}
				
			}
			
			else if (number == 2) {
				// �߰��ϱ� 
				// �л� ���� �Է�
				System.out.print("�߰��ϱ�: ");
				String input = sc.nextLine();
				StringTokenizer st = new StringTokenizer(input);
				String student[] = new String[4];
				int i = 0;
				while(st.hasMoreTokens()) {
					student[i] = (String)st.nextToken();
					i++;
				}
				
				// ��� Ȯ��
				//i = 0;
				//for(; i < student.length; i++)
					//System.out.println(student[i]);
				
				// key�� ���� 
				if(list.containsKey(Integer.parseInt(student[3]))) {
					System.out.println("�����Ͱ� �̹� ���� �մϴ�");
					continue;
				}
				
				// student ��ü ����
				ex1 student_info = new ex1(student);
				// list �߰� 
				list.put(Integer.parseInt(student[3]), student_info); // string ��ü�� Integer wrapperŬ������ ��ȯ
				
				// �߰� Ȯ�� �ϱ� 
				// System.out.println(list.get(Integer.parseInt(student[3])).getName());
				System.out.println("�߰� �Ϸ�");
			}
			
			else {
				System.out.println("Bye Bye~~");
				break;
			}
		}
	}
}
