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
		
		//MenuBar : Menu ���۳�Ʈ�� �����ϱ� ���� �����̳� 
		// => Frame �����̳ʿ� ����
		MenuBar mb=new MenuBar();
		
		//Menu : MenuItem ���۳�Ʈ�� �����ϱ� ���� �����̳�
		// => MenuBar �����̳ʿ� ����
		Menu file=new Menu("����");
		Menu help=new Menu("����");
		
		//MenuItem : ���� ����� �����ϱ� ���� ���۳�Ʈ
		// => Menu �����̳ʿ� ����
		// => MenuShortcut Ŭ������ �̿��Ͽ� ����Ű ��� - [Ctrl] + [?]
		//KeyEvent : Ű���� ���� �̺�Ʈ ������ �����ϱ� ���� Ŭ����
		// => Ű���忡 ���� �������� ����ʵ�� ����
		MenuItem open=new MenuItem("����",new MenuShortcut(KeyEvent.VK_O));
		MenuItem save=new MenuItem("����",new MenuShortcut(KeyEvent.VK_S));
		MenuItem exit=new MenuItem("������");
		
		MenuItem view=new MenuItem("���� ����");
		MenuItem info=new MenuItem("�޸��� ����");
		
		//MenuItem >> Menu >> MenuBar >> Frame
		file.add(open);
		file.add(save);
		//Menu.addSeparator() : ���м��� �����ϴ� �޼ҵ�
		file.addSeparator();
		file.add(exit);
		
		help.add(view);
		help.addSeparator();
		help.add(info);
		
		mb.add(file);
		mb.add(help);
		
		setMenuBar(mb);
		
		//Frame �����̳ʿ� TextArea ���۳�Ʈ ����
		TextArea area=new TextArea();
		area.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
		add(area);//�߾�
		
		setBounds(300, 100, 800, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MenuApp("Menu");
	}
}
