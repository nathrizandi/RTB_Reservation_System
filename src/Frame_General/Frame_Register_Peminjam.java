package Frame_General;
import Akun.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Main.Main;

public class Frame_Register_Peminjam extends JFrame implements ActionListener,WindowListener{
	private Font font_title = new Font(Font.SANS_SERIF, Font.BOLD, 25);
	
	//header
	private JPanel panel_north = new JPanel();
	private JLabel lbl_register = new JLabel("Registrasi Peminjam"); 
	
	//content
	private JPanel panel_center = new JPanel();
	private JTextField txt_username = new JTextField(); 
	private JTextField txt_name = new JTextField();
	private JPasswordField txt_password = new JPasswordField(); 
	private JPasswordField txt_confirmPassword = new JPasswordField();
	private JComboBox<String> combo_class = new JComboBox<>();
	private JRadioButton radio_male = new JRadioButton("Male");
	private JRadioButton radio_female = new JRadioButton("Female");
	private JOptionPane success_pop = new JOptionPane();
	//footer
	private JPanel panel_south = new JPanel();
	private JButton btn_submit = new JButton("Submit");
	private JButton btn_back = new JButton("Back");
	private JLabel error_label = new JLabel();
	
	//Main
	private Main main;
	
	//Frame lain
	private Frame_Login_Peminjam login_peminjam;
	
	void init_components() {
		setLayout(new BorderLayout());
		
		//header
		panel_north.setLayout(new BorderLayout()); 
		lbl_register.setFont(font_title);
//		panel_north.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lbl_register.setHorizontalAlignment(JLabel.CENTER); lbl_register.setVerticalAlignment(JLabel.CENTER);
		lbl_register.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 80));
		JPanel pnldummy = new JPanel();
		pnldummy.add(btn_back);
		panel_north.add(pnldummy,"West");
		panel_north.add(lbl_register,"Center"); 
		
		
		add(panel_north, "North");
		
		//content
		JPanel panel_resize_left = new JPanel();
		JPanel panel_resize_right = new JPanel();
		panel_resize_left.setPreferredSize(new Dimension(100,200));
		panel_resize_right.setPreferredSize(new Dimension(100,200));
		add(panel_resize_left,"West");
		add(panel_resize_right,"East");
		
		panel_center.setLayout(new GridLayout(8, 2));
//		panel_center.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel_center.add(new JPanel());
		panel_center.add(new JPanel());
			//row 1
			JLabel a = new JLabel("Username");
			a.setHorizontalAlignment(JLabel.LEFT); a.setVerticalAlignment(JLabel.CENTER);
			JLabel b = new JLabel("Nama lengkap");
			b.setHorizontalAlignment(JLabel.LEFT); b.setVerticalAlignment(JLabel.CENTER);
			JLabel c = new JLabel("Password");
			c.setHorizontalAlignment(JLabel.LEFT); c.setVerticalAlignment(JLabel.CENTER);
			JLabel d = new JLabel("Konfirmasi password");
			d.setHorizontalAlignment(JLabel.LEFT); d.setVerticalAlignment(JLabel.CENTER);
			JLabel e = new JLabel("Kelas");
			e.setHorizontalAlignment(JLabel.LEFT); e.setVerticalAlignment(JLabel.CENTER);
			JLabel f = new JLabel("Gender");
			f.setHorizontalAlignment(JLabel.LEFT); f.setVerticalAlignment(JLabel.CENTER);
			
			panel_center.add(a);
			panel_center.add(txt_username);
			//row 2
			panel_center.add(b);
			panel_center.add(txt_name);
			//row 3
			panel_center.add(c);
			panel_center.add(txt_password);
			//row 4
			panel_center.add(d);
			panel_center.add(txt_confirmPassword);
			//row 5
			panel_center.add(e);
			combo_class.addItem("PPTI 11");
			combo_class.addItem("PPTI 12");
			combo_class.addItem("PPTI 13");
			combo_class.addItem("PPTI 14");
			combo_class.addItem("PPTI 15");
			combo_class.addItem("PPTI 16");
			combo_class.addItem("PPBP 1");
			combo_class.addItem("PPBP 2");
			combo_class.addItem("PPBP 3");
			combo_class.addItem("PPBP 4");
			panel_center.add(combo_class);
			add(panel_center, "Center");
			//row 6
			panel_center.add(f);
			JPanel pnl_gender = new JPanel(); 
			pnl_gender.setLayout(new GridLayout(2,1));
			ButtonGroup bg_gender = new ButtonGroup(); 
			bg_gender.add(radio_male);
			bg_gender.add(radio_female);
			pnl_gender.add(radio_male);
			pnl_gender.add(radio_female);
			panel_center.add(pnl_gender);
			
		
		//footer
//		btn_back.addActionListener(this);
//		panel_south.add(btn_back);		
		add(panel_south, "South");	
		panel_south.setLayout(new BorderLayout());
		
		error_label.setHorizontalAlignment(JLabel.CENTER);
        error_label.setForeground(Color.RED);
        error_label.setFont(error_label.getFont().deriveFont(Font.PLAIN));
        
		panel_south.add(error_label,"North");
		JPanel container = new JPanel();
		container.add(btn_submit);
		panel_south.add(container,"Center");
		
		btn_back.addActionListener(this);
		btn_submit.addActionListener(this);
		
		
		setTitle("Registration Form");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,500);
		setLocationRelativeTo(null);
		setVisible(true); 
		setResizable(false);
		
		addWindowListener(this);
		
		
	}
	
	public Frame_Register_Peminjam(Main main) {
		// TODO Auto-generated constructor stub
		this.main = main;
		init_components();
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		new Frame_Register_Peminjam();
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj.equals(btn_back)) {
			this.dispose();
			login_peminjam = new Frame_Login_Peminjam(main);
		}
		else if(obj.equals(btn_submit)) {
			if(
				txt_username.getText().isEmpty()
				|| txt_password.getPassword().length==0
				|| txt_confirmPassword.getPassword().length==0
				|| txt_name.getText().isEmpty()
				|| txt_username.getText().isEmpty()
				|| !radio_male.isSelected() && !radio_female.isSelected()
					) {
				error_label.setText("Mohon mengisi semua bagian");
				return;
			}
			
			String password = new String(txt_password.getPassword());
			String password_konfirmasi = new String(txt_confirmPassword.getPassword());
			if(!main.register_konfirmasi_pass(password, password_konfirmasi)){
				error_label.setText("Isi password dan konfirmasi password Anda berbeda ");
				return;
			}
			
			String username = txt_username.getText();
			String name = txt_name.getText();
			String kelas = combo_class.getSelectedItem().toString();
			String gender;
			if(radio_male.isSelected()) {
				gender = "Laki-laki";
			}
			else {
				gender = "Perempuan";
			}
			
			Peminjam  n = new Peminjam(name, gender, kelas, username, password);
			main.getList_peminjam().add(n);
			success_pop.showMessageDialog(null, "Akun Anda telah berhasil dibuat", "Informasi", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
			login_peminjam =  new Frame_Login_Peminjam(main);
			
		}
		
		return;
	}

@Override
public void windowOpened(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowClosing(WindowEvent e) {
	// TODO Auto-generated method stub
	System.out.println("Frame_Register_Peminjam");
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
