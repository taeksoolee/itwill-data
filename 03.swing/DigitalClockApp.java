package site.itwill.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DigitalClockApp extends JFrame {
	private static final long serialVersionUID = 1L;

	private JLabel clockLabel;//날짜와 시간을 출력하는 컴퍼넌트
	private JButton startBtn, stopBtn;	
	
	//날짜와 시간정보 출력 스레드의 실행 상태를 저장하기 위한 필드
	// => false : 중지상태, true : 실행상태(기본) 
	private boolean isRun;
	
	public DigitalClockApp(String title) {
		super(title);
		
		isRun=true;
		
		//clockLabel=new JLabel("2019년 11월 15일 10시 28분 32초", JLabel.CENTER);
		clockLabel=new JLabel("", JLabel.CENTER);
		clockLabel.setFont(new Font("굴림", Font.BOLD, 30));
		clockLabel.setForeground(Color.DARK_GRAY);
		
		startBtn=new JButton("다시실행");
		stopBtn=new JButton("일시중지");
		JPanel panel=new JPanel();
		panel.add(startBtn);
		panel.add(stopBtn);
		startBtn.setFont(new Font("굴림", Font.BOLD, 20));
		stopBtn.setFont(new Font("굴림", Font.BOLD, 20));
		startBtn.setEnabled(false);
		
		getContentPane().setBackground(Color.WHITE);
		getContentPane().add(clockLabel, BorderLayout.CENTER);
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		new ClockThread().start();
		
		startBtn.addActionListener(new ButtonEventHandler());
		stopBtn.addActionListener(new ButtonEventHandler());
		
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(350, 100, 600, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new DigitalClockApp("DigitalClock");
	}
	
	//날짜와 시간을 출력하는 스레드 클래스
	public class ClockThread extends Thread {
		@Override
		public void run() {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
			while (true) {
				if(isRun) {				
					/*
					Date now=new Date();
					String clock=sdf.format(now);
					clockLabel.setText(clock);
					*/
					clockLabel.setText(sdf.format(new Date()));
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//버튼을 누르는 이벤트에 대한 이벤트 핸들러
	public class ButtonEventHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object eventButton=e.getSource();
			
			if(eventButton==startBtn) {
				isRun=true;
				startBtn.setEnabled(false);
				stopBtn.setEnabled(true);
			} else if(eventButton==stopBtn) {
				isRun=false;
				startBtn.setEnabled(true);
				stopBtn.setEnabled(false);
			}
		}
	}
}
