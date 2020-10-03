package stocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import main.BankAccount;

public class Stock implements StockManual {
	protected int presentPrice;
	protected int stockHas;
	protected int basePrice;
	protected int change;
	protected int plusminus;
	protected int clientBalance;
	protected boolean pasan = false;
	public List<Integer[]> totalChart = new ArrayList<Integer[]>();
	
	public int getClientBalance() {
		this.clientBalance = this.presentPrice*this.stockHas;
		return clientBalance;
	}
	
	@Override
	public void showClientBalance() {
		this.clientBalance = this.presentPrice*this.stockHas;
		System.out.println("=====고객님이 갖고 계신 Stock의 자산은 "+ clientBalance + "원=====");
	}

	public int getChange() {
		return change;
	}

	public int getPlusminus() {
		return plusminus;
	}

	public int getPresentPrice() {
		return presentPrice;
	}

	public int getStockHas() {
		return stockHas;
	}
	
	public void setStockHas(int stockHas) {
		this.stockHas = stockHas;
	}
	
	public void soldStockHas(int stockSell) {
		this.stockHas = this.stockHas - stockSell;
	}

	public Stock() {
		this.presentPrice = basePrice;
	}
	
	Scanner sc = new Scanner(System.in);
	
	public void show() {
		System.out.println("현재 주식 시가는 "+presentPrice+ "원 입니다.");
	}

	@Override
	public void changeValue() {
		int updown = (int)(Math.random()*2);
		int value = (int)(Math.random());
		this.change = value;
		this.plusminus = updown;
		Integer[] valueUpdown = {this.change, this.plusminus};
		totalChart.add(valueUpdown);
		if(updown == 0) {
			this.presentPrice = this.presentPrice + value;
		}
		else {
			this.presentPrice = this.presentPrice - value;
			if(this.presentPrice <= 0) {
				System.out.println("회사가 파산하였습니다. 가진 주식을 모두 잃게 됩니다.");
				pasan = true;
			}
		}
	}
}
