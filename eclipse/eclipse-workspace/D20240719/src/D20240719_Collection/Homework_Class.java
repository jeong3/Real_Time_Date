package D20240719_Collection;

public class Homework_Class {
	static int num;
	int balance;
	String ownerName;
	String id;

	public Homework_Class() {
	}

	public Homework_Class(String id, String name, int balance) {
		this.id = id;
		this.ownerName = name;
		this.balance = balance;
	}

	public void print() {
		System.out.print(ownerName + "  ");
		System.out.print(id + "  ");
		System.out.print(balance + "  ");
		System.out.println();
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getId() {
		return id;
	}

	public int getBalance() {
		return balance;
	}
}
