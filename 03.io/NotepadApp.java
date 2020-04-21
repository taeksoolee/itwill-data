package site.itwill.io;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

//텍스트 파일 편집기 프로그램 - 메모장
public class NotepadApp extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JMenuItem init,open,save,exit;
	private JTextArea area;
	private FileDialog openDialog, saveDialog;
	
	//현재 작업중인 파일 경로를 저장하기 위한 필드
	private String filePath;
	
	//JTextArea 컴퍼넌트의 내용 변경 상태를 저장하기 위한 필드
	// => false : 미변경, true : 변경
	private boolean state;
	
	public NotepadApp(String title) {
		super(title);
		
		JMenuBar bar=new JMenuBar();
		JMenu menu=new JMenu("파일(F)");
		menu.setMnemonic('F');
		init=new JMenuItem("새로 만들기(N)", 'N');
		open=new JMenuItem("열기(O)", 'O');
		save=new JMenuItem("저장(S)", 'S');
		exit=new JMenuItem("끝내기(X)", 'X');
		init.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));		
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));		
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		menu.add(init);
		menu.add(open);
		menu.add(save);
		menu.addSeparator();
		menu.add(exit);
		bar.add(menu);
		setJMenuBar(bar);
		
		area=new JTextArea();
		area.setFont(new Font("굴림", Font.PLAIN, 16));
		JScrollPane pane=new JScrollPane(area);
		getContentPane().add(pane, BorderLayout.CENTER);
		
		openDialog=new FileDialog(this, "열기", FileDialog.LOAD);
		saveDialog=new FileDialog(this, "저장", FileDialog.SAVE);
		
		init.addActionListener(this);
		open.addActionListener(this);
		save.addActionListener(this);
		exit.addActionListener(this);
		
		//JTextArea 컴퍼넌트에서 키보드 관련 이벤트가 발생된 경우 이벤트를 처리할 이벤트 핸들러 등록
		area.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//이벤트 발생 키보드의 문자값이 NULL 문자가 아닌 경우 
				if(e.getKeyChar()!='\0') {
					state=true;
				}
			}
		});
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(saveConfirm()) System.exit(0);
			}
		});
		
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setBounds(150, 50, 1000, 600);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new NotepadApp("제목 없음 - 메모장");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object eventSource=e.getSource();
		
		if(eventSource==init) {
			if(saveConfirm()) {
				//JTextArea 컴퍼넌트 초기화
				area.setText("");
				//JFrame 컴퍼넌트의 제목 초기화
				setTitle("제목 없음 - 메모장");
				//작업 파일을 저장하는 필드값 초기값
				filePath=null;
			}
		} else if(eventSource==open) {
			if(!saveConfirm()) return;
			
			//열기 관련 FileDialog 컴퍼넌트를 화면에 출력
			// => 파일을 선택하거나 취소한 경우 FileDialog 컴퍼넌트는 자동으로 숨겨진다.
			//FileDialog.getDirectory() : 선택 파일이 존재하는 디렉토리 경로를 반환하는 메소드 
			//FileDialog.getFile() : 선택 파일을 반환하는 메소드
			openDialog.setVisible(true);
			
			//FileDialog 컴퍼넌트에서 취소를 선택한 경우 이벤트 핸들러 메소드 명령
			if(openDialog.getFile()==null) return;
			
			//선택 파일의 대한 경로를 반환받아 필드값으로 저장
			filePath=openDialog.getDirectory()+openDialog.getFile();
			
			//JFrame 컴퍼넌트의 제목 변경
			setTitle(openDialog.getFile()+" - 메모장");
			
			//JTextArea 컴퍼넌트 초기화
			area.setText("");
			
			try {
				//파일 입력스트림을 대용량 입력스트림으로 확장하여 생성
				BufferedReader in=new BufferedReader(new FileReader(filePath));
				
				//파일에 저장된 내용을 한 줄씩 읽어 JTextArea 컴퍼넌트에 추가
				while(true) {
					//엔터전까지의 문자들을 읽어 문자열로 반환 - 한 줄씩 읽어와 저장 
					String text=in.readLine();
					if(text==null) break;
					area.append(text+"\n");
				}
				
				in.close();
			} catch (FileNotFoundException e1) {
				JOptionPane.showMessageDialog(this, "선택한 파일이 존재하지 않습니다."
					, "에러", JOptionPane.ERROR_MESSAGE);
			} catch (IOException e2) {
				JOptionPane.showMessageDialog(this, "프로그램에 문제가 발생 하였습니다."
					, "에러", JOptionPane.ERROR_MESSAGE);
			}
		} else if(eventSource==save) {
			//현재 작업 중인 파일이 없는 경우
			if(filePath==null) {
				//저장 관련 FileDialog 컴퍼넌트를 화면에 출력
				saveDialog.setVisible(true);
				if(saveDialog.getFile()==null) return;
				filePath=saveDialog.getDirectory()+saveDialog.getFile();
				setTitle(saveDialog.getFile()+" - 메모장");
			}
			
			try {
				//파일 출력스트림을 대용량 출력스트림으로 확장하여 생성
				BufferedWriter out=new BufferedWriter(new FileWriter(filePath));
				
				//JTextArea 컴퍼넌트의 모든 문자열을 반환받아 저장
				String text=area.getText();
				
				//Windows 운영체제에서는 엔터를 "\n"이 아닌 "\r\n"으로 표현
				//String text=area.getText().replace("\n", "\r\n");
				
				//파일 출력스트림에 문자열을 전달 => 파일 저장
				out.write(text);
				
				out.close();

				//JTextArea 컴퍼넌트의 내용 변경 상태 초기화
				state=false;
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(this, "프로그램에 문제가 발생 하였습니다."
						, "에러", JOptionPane.ERROR_MESSAGE);
			}
		} else if(eventSource==exit) {
			if(saveConfirm()) System.exit(0);
		}
	}
	
	//JTextArea 컴퍼넌트의 내용이 변경된 경우 특정 이벤트에서 JTextArea
	//컴퍼넌트의 변경내용에 대한 저장 유무를 선택 처리하기 위한 메소드
	// => 반환값 - false : 취소 선택, true : 저장 또는 미저장 선택
	public boolean saveConfirm() {
		//JTextArea 컴퍼넌트의 내용이 변경된 경우
		if(state) {
			//JOptionPane.showConfirmDialog(Component parentComponent
			//, Object message, String title, int optionType) :
			//선택 다이얼로그를 출력하는 메소드 - 선택 결과값 반환
			int choice=JOptionPane.showConfirmDialog(this, "변경된 내용을 저장 하시겠습니까?"
				, "확인", JOptionPane.YES_NO_CANCEL_OPTION);
			
			//변경 저장을 선택한 경우
			if(choice==JOptionPane.YES_OPTION) {
				if(filePath==null) {
					saveDialog.setVisible(true);
					if(saveDialog.getFile()==null) return false;
					filePath=saveDialog.getDirectory()+saveDialog.getFile();
					setTitle(saveDialog.getFile()+" - 메모장");
				}
				
				try {
					BufferedWriter out=new BufferedWriter(new FileWriter(filePath));
					String text=area.getText();
					out.write(text);
					out.close();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(this, "프로그램에 문제가 발생 하였습니다."
							, "에러", JOptionPane.ERROR_MESSAGE);
				} 
			} else if(choice==JOptionPane.CANCEL_OPTION) {//취소를 선택한 경우
				return false;
			} 
		}
		
		//JTextArea 컴퍼넌트의 내용 변경 상태 초기화
		state=false;
		
		//저장 또는 미저장을 선택한 경우
		return true;
	}
}








