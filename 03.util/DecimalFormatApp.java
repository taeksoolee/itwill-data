package site.itwill.util;

import java.text.DecimalFormat;

//DecimalFormat : 숫자를 표현하기 위한 패턴정보를 저장하기 위한 클래스  
public class DecimalFormatApp {
	public static void main(String[] args) {
		//패턴문자 : #(숫자)  0(숫자)  .  , 등
		DecimalFormat df=new DecimalFormat("###,###,##0");
		
		int number=100000000;
		
		System.out.println("number = "+number+"원");
		
		//DecimalFormat.format(Object number) : 전달받은 값(숫자)을 DecimalFormat
		//인스턴스에 저장된 패턴정보의 문자열로 변환하여 반환하는 메소드
		System.out.println("number = "+df.format(number)+"원");
		
		//DecimalFormat.getInstance() : 기본 패턴정보가 저장된 DecimalFormat 
		//인스턴스를 반환하는 메소드
		System.out.println("number = "
				+DecimalFormat.getInstance().format(number)+"원");
	
		//DecimalFormat.getCurrencyInstance() : 화폐 관련 패턴정보가 저장된
		//DecimalFormat 인스턴스를 반환하는 메소드
		System.out.println("number = "
				+DecimalFormat.getCurrencyInstance().format(number));
	}
}
