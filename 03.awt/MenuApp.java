package site.itwill.awt;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.TextArea;
import java.awt.event.KeyEvent;

public class MenuApp extends Frame {
	private static final long serialVersionUID = 1L;

	public MenuApp(String title) {
		super(title);
		
		//MenuBar : Menu 컴퍼넌트를 부착하기 위한 컨테이너 
		// => Frame 컨테이너에 부착
		MenuBar mb=new MenuBar();
		
		//Menu : MenuItem 컴퍼넌트를 부착하기 위한 컨테이너
		// => MenuBar 컨테이너에 부착
		Menu file=new Menu("파일");
		Menu help=new Menu("도움말");
		
		//MenuItem : 선택 기능을 제공하기 위한 컴퍼넌트
		// => Menu 컨테이너에 부착
		// => MenuShortcut 클래스를 이용하여 단축키 등록 - [Ctrl] + [?]
		//KeyEvent : 키보드 관련 이벤트 정보를 저장하기 위한 클래스
		// => 키보드에 대한 고유값이 상수필드로 제공
		MenuItem open=new MenuItem("열기",new MenuShortcut(KeyEvent.VK_O));
		MenuItem save=new MenuItem("저장",new MenuShortcut(KeyEvent.VK_S));
		MenuItem exit=new MenuItem("끝내기");
		
		MenuItem view=new MenuItem("도움말 보기");
		MenuItem info=new MenuItem("메모장 정보");
		
		//MenuItem >> Menu >> MenuBar >> Frame
		file.add(open);
		file.add(save);
		//Menu.addSeparator() : 구분선를 부착하는 메소드
		file.addSeparator();
		file.add(exit);
		
		help.add(view);
		help.addSeparator();
		help.add(info);
		
		mb.add(file);
		mb.add(help);
		
		setMenuBar(mb);
		
		//Frame 컨테이너에 TextArea 컴퍼넌트 부착
		TextArea area=new TextArea();
		area.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
		add(area);//중앙
		
		setBounds(300, 100, 800, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MenuApp("Menu");
	}
}
