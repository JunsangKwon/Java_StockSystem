package main;

// 통장 생성 클래스가 아니라 통장
public class BankAccount {
	private String name;
	private String socialnumber;
	private String password;
	private int balance;
	private int stockbalance;
	private int profitloss;
	
	 BankAccount() {
		this.balance = 0;
	}
	
	public String getName() {
		return this.name;
	}


	public String getSocialnumber() {
		return this.socialnumber;
	}


	public String getPassword() {
		return this.password;
	}


	public int getBalance() {
		return this.balance;
	}

	public int getStockbalance() {
		return this.stockbalance;
	}
	
	public int getTotalBalance(int totalStockMoney) {
		return this.balance + totalStockMoney;
	}

	void setting(String name, String socialnumber, String password) {
		this.name = name;
		this.socialnumber = socialnumber;
		this.password = password;
	}
	
	void addBal(int money) {
		this.balance += money;
		this.profitloss = this.balance;
	}
	
	public int getProfitLoss() {
		return this.profitloss; 
	}
	
	void buyStock(int money) {
		this.balance -= money;
	}
	
	void sellStock(int money) {
		this.balance += money;
	}
	
	String printBankAccount() {
		return "==="+ this.name + "의 통장 === "+ "주민번호: "+ this.socialnumber + 
				" 통장잔고: "+ this.balance + "원";
	}
	
}
