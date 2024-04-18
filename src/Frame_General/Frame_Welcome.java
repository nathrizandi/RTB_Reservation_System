package Frame_General;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import Main.Main;
public class Frame_Welcome extends JFrame implements ActionListener,WindowListener{
	
	private JPanel panel_radio = new JPanel();
	private JLabel lbltitle = new JLabel("Welcome to RTB Reservation System");
	private JButton rb_admin = new JButton("Admin");
	private JButton rb_mhs = new JButton("Peminjam");
	private JPanel panel_inradio = new JPanel();
//	private JPanel panel_submit = new JPanel();
//	private JButton bsubmit = new JButton("Submit");
	
	
	
	//Tampungan main
	private Main main;
	
	//Kelas berikutnya
	private Frame_Login_Admin login_admin;
	private Frame_Login_Peminjam login_peminjam;
	
	
	
	public void init_component() {
		setLayout(new GridLayout(5,1));
		
//		Label welcome
		lbltitle.setFont(new Font(getName(), Font.BOLD, 20));
		lbltitle.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		lbltitle.setVerticalAlignment((int) TOP_ALIGNMENT);
		//panel_radio
		panel_radio.setLayout(new GridLayout(2, 1));
		JLabel lbllogin =  new JLabel("Login sebagai:");
		lbllogin.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		lbllogin.setFont(new Font(getName(), Font.PLAIN, 15));
		panel_radio.add(lbllogin);
		panel_inradio.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//Make buttons
		panel_inradio.add(rb_admin);
		panel_inradio.add(rb_mhs);
		panel_radio.add(panel_inradio);
		
		rb_admin.addActionListener(this);
		rb_mhs.addActionListener(this);
		
		
		//Add btn submit to panel submit
//		panel_submit.add(bsubmit);
		
		add(new JPanel());
		add(lbltitle);
		add(panel_radio);
		add(new JPanel());
		addWindowListener(this);
//		add(panel_submit);
	}
	
	public Frame_Welcome(Main main) {
		// TODO Auto-generated constructor stub
		this.main = main;
    	init_component();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setTitle("RTB Reservation System");
        setLocationRelativeTo(null);
        setVisible(true);
	}
	
//    public static void main(String[] args) {
//        new Frame_Welcome();
//    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		  Object action = e.getSource();
		  
		  if(action.equals(rb_admin)){
			  this.dispose();
			  login_admin = new Frame_Login_Admin(main);
		  }
		  
		  else if(action.equals(rb_mhs)) {
			  this.dispose();
			  login_peminjam = new Frame_Login_Peminjam(main);
		  }
	}

@Override
public void windowOpened(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowClosing(WindowEvent e) {
	// TODO Auto-generated method stub
	System.out.println("Frame_Welcome");
	main.closeFile();
	
}

@Override
public void windowClosed(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowIconified(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowDeiconified(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowActivated(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowDeactivated(WindowEvent e) {
	// TODO Auto-generated method stub
	
}
}
