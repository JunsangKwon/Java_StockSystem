package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import stocks.*;

public class Options {
	String name;
	String socialnumber;
	String password;
	Scanner sc = new Scanner(System.in);
	String[] upordown = {"△ ", "▽", "-"};
	Stock samsang = new Samsang();
	Stock kakakao = new Kakakao();
	Stock googled = new Googled();
	Stock netflex = new Netflex();
	Stock facebok = new Facebok();
	Stock hyunday = new Hyunday();
	Stock piapple = new Piapple();
	Stock alivava = new Alivava();
	Stock amazone = new Amazone();
	
	List<Stock> possessStock = new ArrayList<Stock>();
	
	//1. 통장 만들기
	void accountmake(BankAccount bam) {
		System.out.print("사용자의 이름을 적어주세요 >>");
		name = sc.next();
		System.out.print("주민번호를 적어주세요 >>");
		socialnumber = sc.next();
			while(true) {
				System.out.print("계좌 비밀번호를 4자리를 설정해주세요");
				password = sc.next();
				System.out.print("비밀번호를 확인해주세요");
				String passwordConfirm = sc.next();
				if(!password.equals(passwordConfirm)) {
					System.out.println("비밀번호가 다릅니다.");
				}
				else break;
			}	
			bam.setting(name, socialnumber, password);
			System.out.println("생성이 완료되었습니다.");
	}
	
	//2. 잔고 추가
	void addBalance(BankAccount bam) {
		
		while(true) {
		System.out.println("비밀번호를 입력 해주세요");
		String passwordConfirm = sc.next();
		if(!passwordConfirm.equals(bam.getPassword())) {
			System.out.println("비밀번호가 틀렸습니다.");
			break;
		}
		System.out.println("입금하실 금액을 말해주세요.");
		int money = sc.nextInt();
		bam.addBal(money);
		System.out.println(money + "원이 충전 되었습니다.");
		System.out.println("=====현재 통장 잔고 : "+bam.getBalance()+"원=====");
		break;
	}
		
	}
	//3. 잔고 및 손익확인
	void checkBalance(BankAccount bam) {
		System.out.println("=====고객님의 현재 통장 잔고 :"+bam.getBalance()+"원=====");
		int totalStockBalance = 0;
		for(Stock s : possessStock) {
			s.showClientBalance();
			totalStockBalance += s.getClientBalance();
		}
		System.out.println("=====고객님의 총 자산은 "+bam.getTotalBalance(totalStockBalance)+"원 입니다.=====");
		int s = bam.getTotalBalance(totalStockBalance) - bam.getProfitLoss();  
		System.out.println("=====현재 얻으신 손익은 "+s+"원 입니다.=====");
	}
	//4. 주식 매수
	void buyStock(BankAccount bam) {
		
		while(true) {
			System.out.println("비밀번호를 입력 해주세요");
			String passwordConfirm = sc.next();
			if(!passwordConfirm.equals(bam.getPassword())) {
				System.out.println("비밀번호가 틀렸습니다.");
				break;
			}
			System.out.println("어떤 주식을 사시겠습니까?");
			System.out.println("번호로 입력해주세요");
			System.out.println("==============================");
			System.out.printf("%4s%10s%10s\n", "주식 이름", "현재 주가", "등락");
			System.out.println("==============================");
			System.out.printf("1 %4s  %4d  %4d %s\n", "Samsang", samsang.getPresentPrice(), samsang.getChange(),
					detUpDown(samsang));
			System.out.printf("2 %4s  %4d   %4d %s\n", "Kakakao", kakakao.getPresentPrice(), kakakao.getChange(),
					detUpDown(kakakao));
			System.out.printf("3 %4s  %4d   %4d %s\n", "Googled", googled.getPresentPrice(), googled.getChange(),
					detUpDown(googled));
			System.out.printf("4 %4s  %4d   %4d %s\n", "Netflex", netflex.getPresentPrice(), netflex.getChange(),
					detUpDown(netflex));
			System.out.printf("5 %4s  %4d   %4d %s\n", "Facebok", facebok.getPresentPrice(), facebok.getChange(),
					detUpDown(facebok));
			System.out.printf("6 %4s  %4d    %4d %s\n", "Hyunday", hyunday.getPresentPrice(), hyunday.getChange(),
					detUpDown(hyunday));
			System.out.printf("7 %4s  %4d    %4d %s\n", "Piapple", piapple.getPresentPrice(), piapple.getChange(),
					detUpDown(piapple));
			System.out.printf("8 %4s  %4d    %4d %s\n", "Alivava", alivava.getPresentPrice(), alivava.getChange(),
					detUpDown(alivava));
			System.out.printf("9 %4s  %4d    %4d %s\n", "Amazone", amazone.getPresentPrice(), amazone.getChange(),
					detUpDown(amazone));
			int menu = sc.nextInt();
			System.out.println("몇 주를 사시겠습니까?");
			int stockNum = sc.nextInt();
			switch(menu) {
			case 1:
				if(bam.getBalance() < (stockNum * samsang.getPresentPrice())) {
					System.out.println("잔고가 부족합니다.");
					break;
				}
				bam.buyStock(stockNum*samsang.getPresentPrice());
				samsang.setStockHas(stockNum);
				System.out.println("구매가 완료되었습니다.");
				possessStock.add(samsang);
				break;
				
			case 2:
				if(bam.getBalance() < (stockNum * kakakao.getPresentPrice())) {
					System.out.println("잔고가 부족합니다.");
					break;
				}
				bam.buyStock(stockNum*kakakao.getPresentPrice());
				kakakao.setStockHas(stockNum);
				System.out.println("구매가 완료되었습니다.");
				possessStock.add(kakakao);
				break;
				
			case 3:
				if(bam.getBalance() < (stockNum * googled.getPresentPrice())) {
					System.out.println("잔고가 부족합니다.");
					break;
				}
				bam.buyStock(stockNum*googled.getPresentPrice());
				googled.setStockHas(stockNum);
				System.out.println("구매가 완료되었습니다.");
				possessStock.add(googled);
				break;
				
			case 4:
				if(bam.getBalance() < (stockNum * netflex.getPresentPrice())) {
					System.out.println("잔고가 부족합니다.");
					break;
				}
				bam.buyStock(stockNum*netflex.getPresentPrice());
				netflex.setStockHas(stockNum);
				System.out.println("구매가 완료되었습니다.");
				possessStock.add(netflex);
				break;
				
			case 5:
				if(bam.getBalance() < (stockNum * facebok.getPresentPrice())) {
					System.out.println("잔고가 부족합니다.");
					break;
				}
				bam.buyStock(stockNum*facebok.getPresentPrice());
				facebok.setStockHas(stockNum);
				System.out.println("구매가 완료되었습니다.");
				possessStock.add(facebok);
				break;
				
			case 6:
				if(bam.getBalance() < (stockNum * hyunday.getPresentPrice())) {
					System.out.println("잔고가 부족합니다.");
					break;
				}
				bam.buyStock(stockNum*hyunday.getPresentPrice());
				hyunday.setStockHas(stockNum);
				System.out.println("구매가 완료되었습니다.");
				possessStock.add(hyunday);
				break;
				
			case 7:
				if(bam.getBalance() < (stockNum * piapple.getPresentPrice())) {
					System.out.println("잔고가 부족합니다.");
					break;
				}
				bam.buyStock(stockNum*piapple.getPresentPrice());
				piapple.setStockHas(stockNum);
				System.out.println("구매가 완료되었습니다.");
				possessStock.add(piapple);
				break;
			
			case 8:
				if(bam.getBalance() < (stockNum * alivava.getPresentPrice())) {
					System.out.println("잔고가 부족합니다.");
					break;
				}
				bam.buyStock(stockNum*alivava.getPresentPrice());
				alivava.setStockHas(stockNum);
				System.out.println("구매가 완료되었습니다.");
				possessStock.add(alivava);
				break;
				
			case 9:
				if(bam.getBalance() < (stockNum * amazone.getPresentPrice())) {
					System.out.println("잔고가 부족합니다.");
					break;
				}
				bam.buyStock(stockNum*amazone.getPresentPrice());
				amazone.setStockHas(stockNum);
				System.out.println("구매가 완료되었습니다.");
				possessStock.add(amazone);
				break;
			}
			break;
		}
		
	}
	//5. 주식 매도
	void sellStock(BankAccount bam) {
		while(true) {
			System.out.println("비밀번호를 입력 해주세요");
			String passwordConfirm = sc.next();
			if(!passwordConfirm.equals(bam.getPassword())) {
				System.out.println("비밀번호가 틀렸습니다.");
				break;
			}
			//조건문으로 안샀을 경우 걸러줘야댐
			if(possessStock.isEmpty()) {
				System.out.println("산 주식이 없습니다.");
				break;
			}
			System.out.println("어떤 주식을 파시겠습니까?");
			System.out.println("번호로 입력해주세요");
			System.out.println("==============================");
			System.out.printf("%4s%10s%10s\n", "주식 이름", "현재 주가", "등락");
			System.out.println("==============================");
			int i= 1;

			for(Stock s : possessStock) {
				System.out.print(i);
				s.show();
				System.out.println(" "+detUpDown(s));
				i++;
			}
			int menu = sc.nextInt();
			System.out.println("몇 주를 파시겠습니까?");
			int stockNum = sc.nextInt();
			if(possessStock.get(menu-1).getStockHas()<stockNum) {
				System.out.println("갖고 계신 주 보다 많은 주를 선택하셨습니다.");
				break;
			}
			else if(possessStock.get(menu-1).getStockHas()>stockNum) {
				System.out.println(stockNum+"개의 주식을 팝니다.");
				possessStock.get(menu-1).soldStockHas(stockNum);
				bam.sellStock(possessStock.get(menu-1).getPresentPrice()*stockNum);
			}
			else {
				System.out.println(stockNum+"개의 주식을 팝니다.");
				possessStock.get(menu-1).soldStockHas(stockNum);
				bam.sellStock(possessStock.get(menu-1).getPresentPrice()*stockNum);
				possessStock.remove(possessStock.get(menu-1));						
				}
			break;
			}
		}

	//6. 차트 확인
	void checkChart() {
		System.out.println("==============================");
		System.out.printf("%4s%10s%10s\n", "주식 이름", "현재 주가", "등락");
		System.out.println("==============================");
		System.out.printf("1 %4s  %4d  %4d %s\n", "Samsang", samsang.getPresentPrice(), samsang.getChange(),
				detUpDown(samsang));
		System.out.printf("2 %4s  %4d   %4d %s\n", "Kakakao", kakakao.getPresentPrice(), kakakao.getChange(),
				detUpDown(kakakao));
		System.out.printf("3 %4s  %4d   %4d %s\n", "Googled", googled.getPresentPrice(), googled.getChange(),
				detUpDown(googled));
		System.out.printf("4 %4s  %4d   %4d %s\n", "Netflex", netflex.getPresentPrice(), netflex.getChange(),
				detUpDown(netflex));
		System.out.printf("5 %4s  %4d   %4d %s\n", "Facebok", facebok.getPresentPrice(), facebok.getChange(),
				detUpDown(facebok));
		System.out.printf("6 %4s  %4d    %4d %s\n", "Hyunday", hyunday.getPresentPrice(), hyunday.getChange(),
				detUpDown(hyunday));
		System.out.printf("7 %4s  %4d    %4d %s\n", "Piapple", piapple.getPresentPrice(), piapple.getChange(),
				detUpDown(piapple));
		System.out.printf("8 %4s  %4d    %4d %s\n", "Alivava", alivava.getPresentPrice(), alivava.getChange(),
				detUpDown(alivava));
		System.out.printf("9 %4s  %4d    %4d %s\n", "Amazone", amazone.getPresentPrice(), amazone.getChange(),
				detUpDown(amazone));
	}
	//7. 주가 변동(하루 경과)
	void oneDayLater() {
		samsang.changeValue();
		kakakao.changeValue();
		googled.changeValue();
		netflex.changeValue();
		facebok.changeValue();
		hyunday.changeValue();
		piapple.changeValue();
		alivava.changeValue();
		amazone.changeValue();
		System.out.println("하루가 지나, 주가가 변동되었습니다!");
		//이제 잔고가 바뀌는것을 구현 해봅시다...
	}
	//8. 장기 투자(1년 경과)
	void oneYearLater() {
		for(int i=0; i< 366; i++) {
			samsang.changeValue();
			kakakao.changeValue();
			googled.changeValue();
			netflex.changeValue();
			facebok.changeValue();
			hyunday.changeValue();
			piapple.changeValue();
			alivava.changeValue();
			amazone.changeValue();
		}
		System.out.println("1년이 지났습니다, 주가가 상당히 많이 변했습니다!");
		System.out.println("==============================");
		System.out.printf("%4s%10s%10s\n", "주식 이름", "현재 주가", "등락");
		System.out.println("==============================");
		System.out.printf("1 %4s  %4d  %4d %s\n", "Samsang", samsang.getPresentPrice(), samsang.getChange(),
				detUpDown(samsang));
		System.out.printf("2 %4s  %4d   %4d %s\n", "Kakakao", kakakao.getPresentPrice(), kakakao.getChange(),
				detUpDown(kakakao));
		System.out.printf("3 %4s  %4d   %4d %s\n", "Googled", googled.getPresentPrice(), googled.getChange(),
				detUpDown(googled));
		System.out.printf("4 %4s  %4d   %4d %s\n", "Netflex", netflex.getPresentPrice(), netflex.getChange(),
				detUpDown(netflex));
		System.out.printf("5 %4s  %4d   %4d %s\n", "Facebok", facebok.getPresentPrice(), facebok.getChange(),
				detUpDown(facebok));
		System.out.printf("6 %4s  %4d    %4d %s\n", "Hyunday", hyunday.getPresentPrice(), hyunday.getChange(),
				detUpDown(hyunday));
		System.out.printf("7 %4s  %4d    %4d %s\n", "Piapple", piapple.getPresentPrice(), piapple.getChange(),
				detUpDown(piapple));
		System.out.printf("8 %4s  %4d    %4d %s\n", "Alivava", alivava.getPresentPrice(), alivava.getChange(),
				detUpDown(alivava));
		System.out.printf("9 %4s  %4d    %4d %s\n", "Amazone", amazone.getPresentPrice(), amazone.getChange(),
				detUpDown(amazone));
	}
	//상승, 하락 보여주기 위한 함수
	String detUpDown(Stock s) {
		if(s.getPlusminus()==0) {return upordown[0];}
		else if(s.getPlusminus()==1){return upordown[1];}
		else {return upordown[2];}
	}
	//9. 주식 변동 조회 
	void searchStock () {
		System.out.println("어떤 주식을 검색하시겠습니까?");
		System.out.println("번호로 입력해주세요");
		System.out.println("==============================");
		System.out.printf("%4s\n", "주식 이름");
		System.out.println("==============================");
		System.out.printf("1 %4s\n", "Samsang");
		System.out.printf("2 %4s\n", "Kakakao");
		System.out.printf("3 %4s\n", "Googled");
		System.out.printf("4 %4s\n", "Netflex");
		System.out.printf("5 %4s\n", "Facebok");
		System.out.printf("6 %4s\n", "Hyunday");
		System.out.printf("7 %4s\n", "Piapple");
		System.out.printf("8 %4s\n", "Alivava");
		System.out.printf("9 %4s\n", "Amazone");
		int menu = sc.nextInt();
		switch(menu) {
		case 1:
			System.out.println("=====Samsang의 정보=====");
			int i= 1;
			for(Integer[] a : samsang.totalChart) {
				System.out.print(i + "일차 정보: ");
				System.out.print(a[0]+"원 ");
				if(a[1] == 0) {
					System.out.println("증가!");
				}
				else {
					System.out.println("감소...");
				}
				i++;
			}
			break;
		
		case 2:
			System.out.println("=====Kakakao의 정보=====");
			int i2= 1;
			for(Integer[] a : kakakao.totalChart) {
				System.out.print(i2 + "일차 정보: ");
				System.out.print(a[0]+"원 ");
				if(a[1] == 0) {
					System.out.println("증가!");
				}
				else {
					System.out.println("감소...");
				}
				i2++;
			}
			break;
		
		case 3:
			System.out.println("=====Googled의 정보=====");
			int i3= 1;
			for(Integer[] a : googled.totalChart) {
				System.out.print(i3 + "일차 정보: ");
				System.out.print(a[0]+"원 ");
				if(a[1] == 0) {
					System.out.println("증가!");
				}
				else {
					System.out.println("감소...");
				}
				i3++;
			}
			break;
		
		case 4:
			System.out.println("=====Netflex의 정보=====");
			int i4= 1;
			for(Integer[] a : netflex.totalChart) {
				System.out.print(i4 + "일차 정보: ");
				System.out.print(a[0]+"원 ");
				if(a[1] == 0) {
					System.out.println("증가!");
				}
				else {
					System.out.println("감소...");
				}
				i4++;
			}
			break;
		
		case 5:
			System.out.println("=====Facebok의 정보=====");
			int i5= 1;
			for(Integer[] a : facebok.totalChart) {
				System.out.print(i5 + "일차 정보: ");
				System.out.print(a[0]+"원 ");
				if(a[1] == 0) {
					System.out.println("증가!");
				}
				else {
					System.out.println("감소...");
				}
				i5++;
			}
			break;
		
		case 6:
			System.out.println("=====Hyunday의 정보=====");
			int i6= 1;
			for(Integer[] a : hyunday.totalChart) {
				System.out.print(i6 + "일차 정보: ");
				System.out.print(a[0]+"원 ");
				if(a[1] == 0) {
					System.out.println("증가!");
				}
				else {
					System.out.println("감소...");
				}
				i6++;
			}
			break;
		
		case 7:
			System.out.println("=====Piapple의 정보=====");
			int i7= 1;
			for(Integer[] a : piapple.totalChart) {
				System.out.print(i7 + "일차 정보: ");
				System.out.print(a[0]+"원 ");
				if(a[1] == 0) {
					System.out.println("증가!");
				}
				else {
					System.out.println("감소...");
				}
				i7++;
			}
			break;
			
		case 8:
			System.out.println("=====Alivava의 정보=====");
			int i8= 1;
			for(Integer[] a : alivava.totalChart) {
				System.out.print(i8 + "일차 정보: ");
				System.out.print(a[0]+"원 ");
				if(a[1] == 0) {
					System.out.println("증가!");
				}
				else {
					System.out.println("감소...");
				}
				i8++;
			}
			break;
			
		case 9:
			System.out.println("=====Amazone의 정보=====");
			int i9= 1;
			for(Integer[] a : amazone.totalChart) {
				System.out.print(i9 + "일차 정보: ");
				System.out.print(a[0]+"원 ");
				if(a[1] == 0) {
					System.out.println("증가!");
				}
				else {
					System.out.println("감소...");
				}
				i9++;
			}
			break;
		}
	}	
}
