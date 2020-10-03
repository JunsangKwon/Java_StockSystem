package stocks;

public class Facebok extends Stock{
	
	int basePrice = 10000;
	
	public Facebok() {
		this.presentPrice = basePrice;
	}
	
	void setStockNum(int stockHas) {
		this.stockHas = stockHas;
	}
	
	@Override
	public void showClientBalance() {
		this.clientBalance = this.presentPrice*this.stockHas;
		System.out.println("=====고객님이 갖고 계신 Facebok 의 자산은 "+ this.clientBalance + "원=====");
	}

	@Override
	public void show() {
		System.out.printf(" %4s  %4d  %4d ", "Facebok", this.presentPrice, this.change);
	}

	@Override
	public void changeValue() {
		if(pasan) {
			this.presentPrice = 0;
			this.stockHas = 0;
			this.plusminus = -1;
			this.change = 0;
			return;
		}
		else {
		int updown = (int)(Math.random()*2);
		int value = (int)(Math.random()*500+500);
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
				System.out.println("Facebok이 파산하였습니다. 가진 주식을 모두 잃게 됩니다.");
				pasan = true;
			}
		}
	}
}
}
