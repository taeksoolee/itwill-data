package site.itwill.student;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

//정규표현식(Regular Expression) : 메타문자등을 이용하여 일정한 규칙의 문자열 표현하는 방법
/*
^문자열 : 문자열로 시작됨을 의미
문자열$ : 문자열로 종료됨을 의미
. : 임의의 하나의 문자를 의미(\ 문자는 표현 불가능)
[문자1문자2문자3] : 나열된 문자들 중 하나를 의미
[^문자1문자2문자3] : 나열된 문자들이 아닌 것중 하나를 의미
[문자1-문자2] : 문자1부터 문자2까지의 문자들 중 하나를 의미
(문자열1|문자열2) : 나열된 문자열들 중 하나를 의미
문자열+ : 문자열이 1번 이상 반복됨을 의미
문자열* : 문자열이 0번 이상 반복됨을 의미
문자열? : 문자열이 0번 또는 1번이 존재함을 의미
문자열{숫자} : 문자열의 숫자만큼의 반복됨을 의미
문자열{숫자1,숫자2} : 문자열이 숫자1부터 숫자2까지를 반복됨을 의미

\s : 공백이 존재하는 문자열을 의미
\S : 공백이 존재하지 않는 문자열을 의미
\w : 영문자, 숫자, _의 문자로만 표현되는 문자열을 의미
\W : 영문자, 숫자, _의 문자를 제외한 문자로 표현되는 문자열을 의미
\d : 숫자 형태의 문자로만 표현되는 문자열을 의미
\D : 숫자 형태의 문자를 제외한 문자로 표현되는 문자열을 의미
\메타문자 : 메타문자를 문자로 표현

(?!)문자열 : 문자열에서 대소문자를 구분하지 않음을 의미
(?=문자열) : 문자열을 포함하고 있음을 의미
(?!문자열) : 문자열을 포함하고 있지 않음을 의미
*/

//키보드로 입력받은 값에 대한 검증 프로그램
public class ValidationApp {
	public static void main(String[] args) throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		/*
		System.out.print("아이디 입력 >> ");
		String id=in.readLine();
		
		//기본 유효성 검사 >> 입력값 존재 유무에 대한 검사
		if(id==null || id.equals("")) {
			System.out.println("[에러]아이디를 반드시 입력해 주세요.");
			System.exit(0);
		}
		
		//입력규칙에 의한 유효성 검사 >> 아이디는 영문자로 시작되며 영문자
		//,숫자,특수문자(_)의 조합으로 6~20 범위의 문자로 입력되도록 설정 
		// => 정규표현식을 이용한 입력값의 유효성 검사

		//Pattern.matches(String reg, CharSequence input) : 정규표현식의
		//문자열과 입력값을 비교하여 boolean 결과를 반환하는 메소드
		// => false : 불일치, true : 일치
		
		//if(!Pattern.matches("^[a-zA-Z][a-zA-Z0-9_]{5,19}$", id)) {
		//	System.out.println("[에러]입력된 아이디가 형식에 맞지 않습니다.");
		//	System.exit(0);
		//}
		
		
		//Pattern 클래스 : 정규표현식을 저장하기 위한 클래스
		//Pattern.compile(String reg) : 문자열을 전달받아 정규표현식으로 
		//변환하여 Pattern 인스턴스로 반환하는 메소드  
		//Pattern idPattern=Pattern.compile("^[a-zA-Z][a-zA-Z0-9_]{5,19}$");
		Pattern idPattern=Pattern.compile("^[a-zA-Z]\\w{5,19}$");
		
		//Matcher 클래스 : 정규표현식과 문자열을 비교 처리 기능을 제공하기 위한 클래스
		//Pattern.matcher(CharSequence input) : Pattern 인스턴스에 저장된
		//정규표현식과 비교할 입력값을 전달받아 비교 처리하기 위한  
		//Matcher 인스턴스를 반환하는 메소드
		Matcher idMatcher=idPattern.matcher(id);
		
		//Matcher.matches() : 정규표현식과 입력값을 비교하여 boolean 결과를 반환하는 메소드
		// => false : 불일치, true : 일치
		if(!idMatcher.matches()) {
			System.out.println("[에러]입력된 아이디가 형식에 맞지 않습니다.");
			System.exit(0);
		}

		System.out.println("[메세지]정상적인 값을 입력 하였습니다.");
		*/
		
		/*
		System.out.print("비밀번호 입력 >> ");
		String password=in.readLine();
		
		if(password==null || password.equals("")) {
			System.out.println("[에러]비밀번호를 반드시 입력해 주세요.");
			System.exit(0);
		}
		
		//비밀번호는 영문자,숫자,특수문자를 반드시 1개 이상 포함하여 
		//8~30 범위의 문자로 입력되도록 설정
		String passwordReg="^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{8,30}";
		if(!Pattern.matches(passwordReg, password)) {
			System.out.println("[에러]입력된 비밀번호가 형식에 맞지 않습니다.");
			System.exit(0);
		}
		
		System.out.println("[메세지]정상적인 값을 입력 하였습니다.");
     	*/
		
		System.out.print("이메일 입력 >> ");
		String email=in.readLine();
		
		if(email==null || email.equals("")) {
			System.out.println("[에러]이메일을 반드시 입력해 주세요.");
			System.exit(0);
		}
		
		//이메일은 [사용자이름@도메인] 형식의 문자로 입력되도록 설정
		String emailReg="^([a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9-]+)+)*$";
		if(!Pattern.matches(emailReg, email)) {
			System.out.println("[에러]입력된 이메일이 형식에 맞지 않습니다.");
			System.exit(0);
		}
		
		System.out.println("[메세지]정상적인 값을 입력 하였습니다.");

	}
}






