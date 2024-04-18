package Frame_General;

import Main.Main;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

import Frame_Dapur.Frame_Delete_Dapur;
import Frame_Komunal.Frame_Delete_Komunal;
import Frame_MesinCuci.Frame_Delete_MesinCuci;
import Frame_Sergun.Frame_Delete_SerGun;
import Main.Main;

public class Frame_Delete_List extends JFrame implements ActionListener,WindowListener{

	private Font font = new Font(Font.SANS_SERIF, Font.BOLD, 30);
	private Font font_btn = new Font(Font.DIALOG, Font.PLAIN, 16);

	private JPanel pnl_header = new JPanel();
	private JPanel pnl_center = new JPanel();
	private JLabel lbl_choose = new JLabel("Pilih ruangan yang ingin dihapus");
	private JButton btn_dapur = new JButton("Dapur");
	private JButton btn_mc = new JButton("Mesin Cuci");
	private JButton btn_komunal = new JButton("Komunal");
	private JButton btn_sergun = new JButton("SerGun");
	private JButton btn_back = new JButton("Back");
	
	private Main main;
	private Frame_Delete_Dapur frame_del_dapur;
	private Frame_Delete_Komunal frame_del_komunal;
	private Frame_Delete_SerGun frame_del_sergun;
	private Frame_Delete_MesinCuci frame_del_mesincuci;
	private Frame_Welcome welcome;
	
	public void init_component() {
		setLayout(new BorderLayout());
		
		JPanel container_button = new JPanel();
		container_button.add(btn_back);
		btn_back.addActionListener(this);
		container_button.setBackground(Color.WHITE);
		// center
		lbl_choose.setBorder(BorderFactory.createEmptyBorder(120, 0, 40, 70));
		lbl_choose.setFont(font);
		lbl_choose.setHorizontalAlignment(SwingConstants.CENTER);
		pnl_header.setLayout(new BorderLayout());
		pnl_header.add(lbl_choose,"Center");
		pnl_header.add(container_button,"West");
		pnl_header.add(lbl_choose);
		add(pnl_header, "North");
		
		btn_dapur.setFont(font_btn);
//		btn_dapur.setBackground(Color.LIGHT_GRAY);
		btn_dapur.setFocusPainted(false);
//		btn_dapur.setBorderPainted(false);
		
		btn_mc.setFont(font_btn);
//		btn_mc.setBackground(Color.LIGHT_GRAY);
		btn_mc.setFocusPainted(false);
//		btn_mc.setBorderPainted(false);
		
		btn_komunal.setFont(font_btn);
//		btn_komunal.setBackground(Color.LIGHT_GRAY);
		btn_komunal.setFocusPainted(false);
//		btn_komunal.setBorderPainted(false);
		
		btn_sergun.setFont(font_btn);
//		btn_sergun.setBackground(Color.LIGHT_GRAY);
		btn_sergun.setFocusPainted(false);
//		btn_sergun.setBorderPainted(false);
		
		btn_dapur.addActionListener(this);
		btn_komunal.addActionListener(this);
		btn_mc.addActionListener(this);
		btn_sergun.addActionListener(this);
		
		pnl_center.add(btn_dapur);
		pnl_center.add(new JLabel("                    "));
		pnl_center.add(btn_mc);
		pnl_center.add(new JLabel("                    "));
		pnl_center.add(btn_komunal);
		pnl_center.add(new JLabel("                    "));
		pnl_center.add(btn_sergun);
		add(pnl_center, "Center");
		
		pnl_header.setBackground(Color.WHITE);
		pnl_center.setBackground(Color.WHITE);
		setTitle("RTB Reservation System");
		addWindowListener(this);
	}
	
	public Frame_Delete_List(Main main) {
		// TODO Auto-generated constructor stub
		setSize(800, 500);
		init_component();
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("RTB Reservation System");
		setVisible(true);
		setResizable(false);
		this.main = main;
//		frame_del_dapur = new Frame_Delete_Dapur(this, this.main);
//		System.out.println(main);
//		System.out.println("This.main " + this.main);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btn_back)) {
			this.dispose();
			welcome = new Frame_Welcome(main);
			return;
		}
		
		
		if(e.getSource().equals(btn_dapur)) {
			frame_del_dapur = new Frame_Delete_Dapur(main);
			this.dispose();
		}
		if(e.getSource().equals(btn_komunal)) {
			frame_del_komunal = new Frame_Delete_Komunal(main);
			this.dispose();
		}
		if(e.getSource().equals(btn_mc)) {
			frame_del_mesincuci = new Frame_Delete_MesinCuci(main);
			this.dispose();
		}
		if(e.getSource().equals(btn_sergun)) {
			frame_del_sergun = new Frame_Delete_SerGun(main);
			this.dispose();
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
		System.out.println("Frame_Delete_List");
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
	
//	public static void main(String args[]) {
//		new Frame_Delete_List(null);
//	}

}
