package example;

public class OperatorExample {
	public static void main(String[] args) {
		//245678초를 일시분초 형식으로 변환하여 출력하세요.
		int cho=245678;
		System.out.print(cho+"초 >> ");
		
		int day=cho/(24*60*60);//24*60*60 >> 86400
		cho%=86400;//일(몫)을 제외한 정수값을 계산하여 저장
		int hour=cho/3600;
		cho%=3600;
		int min=cho/60;
		int sec=cho%60;
		
		System.out.println(day+"일 "+hour+"시 "+min+"분 "+sec+"초");
		System.out.println("===================================");
		
		//한대의 가격이 1억 5천만인 비행기를 20대 구매할 경우 지불해야될 금액을 계산하여 출력하세요.
		//단, 15대 이상 구매할 경우 1대당 25% 할인율을 적용하여 계산하세요.
		int danga=150_000_000,gae=20;
		long money=(long)(gae>=15?danga*0.75:danga)*gae;
		System.out.println("지불금액 = "+money);
		System.out.println("===================================");
	}
}






