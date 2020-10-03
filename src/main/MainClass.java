package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); 
		int menu;
		boolean bankbookHave = false;
		String bankbook;
		
		BankAccount bam = new BankAccount();
		Options option = new Options();
		//인트로
		System.out.println("=====인생 한방 증권에 오신 걸 환영합니다!!=====");
		System.out.println("=====당신은 투자를 통해 돈을 왕창 벌 수도 전부 잃을수도 있습니다.=====");
		System.out.println("=====저희 증권은 다른 증권들과 다르게 하루에 한번 주가가 변동되오니 이 점 참고 부탁드립니다.=====");
		System.out.println("=====처음 오셨다면 통장 개설부터 해주세요=====");
		
		//메인화면
		while(true) {
		System.out.println("=====메뉴를 선택해주세요=====");
		System.out.println("1. 통장개설, 2. 입금 , 3. 자산/손익 확인, 4. 주식매수, 5. 주식매도, 6. 차트확인, 7. 주식변동(하루 경과)");
		System.out.println("8. 장기투자(1년 경과), 9. 주식 변동 조회, 10. 통장갱신, 11. 통장읽기, 12. 종료");
		menu = sc.nextInt();
		//프로그램 종료
		if(menu == 12) {
			System.out.println("프로그램을 종료합니다. [Y / N]");
	    	  String yesno = sc.next();
	    	  if(yesno.equals("y"))
	    			  {
	    		  		break;
	    			  }
	    	  else
	    	  {
	    		  System.out.println("프로그램 종료를 취소합니다.");
	    		  continue;
	    	  }
			
		}
		//통장 개설 안되있는 경우
		if(menu != 1) {
			if(!bankbookHave) {
				System.out.println("통장 개설이 안되어있습니다. 통장 개설 먼저 해주세요.");
				continue;
			}
		}
		//통장 개설이 되있는데 또 만들려고 하는 경우
		if(menu == 1) {
			if(bankbookHave) {
				System.out.println("이미 만들어져있습니다. 다른 메뉴를 선택해주세요");
				continue;
			}
		}

		switch(menu) {
		case 1:
			//통장 만들기
			option.accountmake(bam);
			bankbookHave = true;
			try {
			    OutputStream output = new FileOutputStream("./src/myAccount.txt");
			    String n = bam.printBankAccount();
			    byte[] by=n.getBytes();
			    output.write(by);
					
			} catch (Exception e) {
		            e.getStackTrace();
			}
			break;
		case 2:
			//통장에 입금하기
			option.addBalance(bam);
			break;
		case 3:
			//자산/손익확인
			option.checkBalance(bam);
			break;
		case 4:
			//주식사기
			option.buyStock(bam);
			break;
		case 5:
			//주식팔기
			option.sellStock(bam);
			break;
		case 6:
			//차트보기
			option.checkChart();
			break;
		case 7:
			//주가변동
			option.oneDayLater();
			break;
		case 8:
			//장기투자
			option.oneYearLater();
			break;
		case 9:
			//주식변동검색
			option.searchStock();
			break;
		case 10:
			//통장갱신
			try {
			    OutputStream output = new FileOutputStream("./src/myAccount.txt");
			    String n = bam.printBankAccount();
			    byte[] by=n.getBytes();
			    output.write(by);					
			} catch (Exception e) {
		            e.getStackTrace();
			}
			System.out.println("갱신이 완료되었습니다.");
			break;
		case 11:
	        try{
	            //파일 객체 생성
	            File file = new File("./src/myAccount.txt");
	             //입력 스트림 생성
	             FileReader file_reader = new FileReader(file);
	             int cur = 0;
	             while((cur = file_reader.read()) != -1){
	                System.out.print((char)cur);
	             }
	             System.out.println();
	             file_reader.close();
	            }catch (FileNotFoundException e) {
	                e.getStackTrace();
	            }catch(IOException e){
	                e.getStackTrace();
	            }
	        break;
		}		
	}
}
}

