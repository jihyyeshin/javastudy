package Q20;

import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("--------------------------------------------------------");
			System.out.println("1. ���»��� | 2. ���¸�� | 3. ���� | 4. ��� | 5.����");
			System.out.println("--------------------------------------------------------");
			System.out.print("����>");

			int selectNo = scanner.nextInt();

			if (selectNo == 1) {
				createAccount();
			} else if (selectNo == 2) {
				accountList();
			} else if (selectNo == 3) {
				deposit();
			} else if (selectNo == 4) {
				withdraw();
			} else if (selectNo == 5) {
				run = false;
			}
		}
		System.out.println("���α׷� ����");
	}

	private static void withdraw() {
		System.out.println("-------");
		System.out.println("���");
		System.out.println("-------");
		System.out.print("���¹�ȣ: ");
		String ano = scanner.next();
		System.out.println("��ݾ�: ");
		int withD = scanner.nextInt();
		int find = 0;
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i].getAno().equals(ano)) {
				if (accountArray[i].getBalance() - withD > 0) {
					accountArray[i].setBalance(accountArray[i].getBalance() - withD);
					System.out.println("���: ����� �����Ǿ����ϴ�.");
					find = 1;
					break;
				}
			}
		}
		if (find == 0) {
			System.out.println("���°� �����ϴ�.");
		}
	}

	private static void deposit() {
		// TODO Auto-generated method stub
		System.out.println("-------");
		System.out.println("����");
		System.out.println("-------");
		System.out.print("���¹�ȣ: ");
		String ano = scanner.next();
		System.out.println("���ݾ�: ");
		int earn = scanner.nextInt();
		int find = 0;
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i].getAno().equals(ano)) {
				accountArray[i].setBalance(accountArray[i].getBalance() + earn);
				System.out.println("���: ������ �����Ǿ����ϴ�.");
				find = 1;
				break;
			}
		}
		if (find == 0) {
			System.out.println("���°� �����ϴ�.");
		}
	}

	private static void accountList() {
		// TODO Auto-generated method stub
		System.out.println("-------");
		System.out.println("���¸��");
		System.out.println("-------");
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] != null) {
				System.out.print(accountArray[i].getAno() + "/t");
				System.out.print(accountArray[i].getOwner() + "/t");
				System.out.println(accountArray[i].getBalance());
			} else
				break;
		}
	}

	private static void createAccount() {
		System.out.println("-------");
		System.out.println("���»���");
		System.out.println("-------");
		System.out.print("���¹�ȣ: ");
		String ano = scanner.next();
		System.out.print("������: ");
		String owner = scanner.next();
		System.out.print("�ʱ��Աݾ�: ");
		int balance = scanner.nextInt();
		Account ac = new Account(ano, owner, balance);

		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null) {
				accountArray[i] = ac;
				System.out.println("���: ���°� �����Ǿ����ϴ�.");
				break;
			}
		}

	}

	private static Account findAccount(String ano) {
		return null;
	}
}