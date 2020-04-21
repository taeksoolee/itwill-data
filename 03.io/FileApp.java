package site.itwill.io;

import java.io.File;
import java.io.IOException;

//File 클래스 : 파일정보를 저장하기 위한 클래스 - 파일 관련 기능 제공
// => 폴더(디렉토리)도 파일로 인식되어 처리 가능
public class FileApp {
	public static void main(String[] args) throws IOException {
		//File(String pathName) : 파일경로를 전달받아 File 인스턴스를 생성하는 생성자
		//파일경로 : 파일 위치를 표현하기 위한 표현방법 - 절대경로 또는 상대경로
		//Windows 운영체제는 저장장치에 대한 드라이브에 파일 존재 - 파일 구분자로 \ 사용(Java에서는 \\로 사용)
		//Linux(Mac) 운영체제는 저장장치에 대한 연결 디렉토리(/)에 파일 존재 - 파일 구분자로 / 사용  
		File fileOne=new File("c:\\data");
		
		//File.exists() : File 인스턴스에 저장된 파일경로에 파일이 없는 경우
		//false 반환하고 존재할 경우 true를 반환하는 메소드
		if(fileOne.exists()) {
			System.out.println("c:\\data 폴더(디렉토리)가 존재합니다.");
		} else {
			//File.mkdir() : File 인스턴스에 저장된 파일경로로 디렉토리를 생성하는 메소드
			fileOne.mkdir();
			System.out.println("c:\\data 폴더(디렉토리)를 생성 하였습니다.");
		}
		System.out.println("============================================");
		//File fileTwo=new File("c:\\data\\abc.txt");
		//파일 구분자를 \\ 구분자 대신 / 구분자로 사용하는 것을 권장 
		File fileTwo=new File("c:/data/abc.txt");
		
		if(fileTwo.exists()) {
			System.out.println("c:\\data\\abc.txt 파일이 존재합니다.");
		} else {
			//File.createNewFile() : File 인스턴스에 저장된 파일경로로 파일을 생성하는 메소드
			// => IOException 발생 - 예외처리
			fileTwo.createNewFile();
			System.out.println("c:\\data\\abc.txt 파일을 생성 하였습니다.");
		}
		System.out.println("============================================");
		//File fileThree=new File("c:/data/xyz.txt");
		
		//File(File parent, String child) : 파일경로를 부모(디렉토리)와 
		//자식(파일)으로 전달하여 File 인스턴스를 생성하는 생성자
		//File fileThree=new File(fileOne,"xyz.txt");
		
		//File(String parent, String child) : 파일경로를 부모(디렉토리)와 
		//자식(파일)으로 전달하여 File 인스턴스를 생성하는 생성자
		File fileThree=new File("c:/data","xyz.txt");
		
		if(fileThree.exists()) {
			//File.delete() : File 인스턴스에 저장된 파일경로로 파일을 삭제하는 메소드
			fileThree.delete();
			System.out.println("c:\\data\\xyz.txt 파일을 삭제 하였습니다.");
		} else {
			System.out.println("c:\\data\\xyz.txt 파일이 존재하지 않습니다.");
		}
		System.out.println("============================================");
		//절대경로 표현방법 : 드라이브 또는 최상위 디렉토리(/)를 기준으로 파일경로 표현
		//File fileFour=new File("c:/java/workspace/java-3/src");

		//상대경로 표현방법 : 현재 작업디렉토리를 기준으로 파일경로 표현
		// => 이클립스의 현재 작업디렉토리 : 프로젝트 디렉토리
		File fileFour=new File("src");
		
		if(fileFour.exists()) {
			//File.toString() : File 인스턴스에 저장된 파일경로를 문자열로 변환하여 반환하는 메소드
			// => 참조변수를 출력할 경우 toString() 메소드 호출 생략 가능
			//System.out.println("파일경로 = "+fileFour.toString());
			System.out.println("파일경로 = "+fileFour);

			//File.getAbsolutePath() : File 인스턴스에 저장된 파일경로를 
			//절대경로 표현방법의 문자열로 변환하여 반환하는 메소드
			System.out.println("파일경로 = "+fileFour.getAbsolutePath());
		} else {
			System.out.println("파일(디렉토리)이 존재하지 않습니다.");
		}
		System.out.println("============================================");
		File fileFive=new File("c:/");
		
		//File.isDirectory() : File 인스턴스에 저장된 파일경로의 파일이 디렉토리가 
		//아닌 경우 false 반환하고 디렉토리인 경우 true 반환하는 메소드
		if(fileFive.isDirectory()) {
			//File.listFiles() : File 인스턴스에 저장된 파일경로의 자식 
			//파일 목록을 File 인스턴스 배열로 반환하는 메소드
			File[] subFile=fileFive.listFiles();
			
			System.out.println(fileFive+" 디렉토리의 자식목록 >>");
			for(File file:subFile) {
				//File.isFile() : File 인스턴스에 저장된 파일경로의 파일이 파일이 
				//아닌 경우 false 반환하고 파일인 경우 true 반환하는 메소드
				if(file.isFile()) {
					System.out.println("일반파일 = "+file);
				} else {
					System.out.println("디렉토리 = "+file);
				}
			}
		}
		System.out.println("============================================");
		
	}
}
