package Frame_General;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Frame_Dapur.Frame_Pinjam_Dapur_ListPeminjaman;
import Frame_Komunal.Frame_Pinjam_Komunal_ListPeminjaman;
import Frame_MesinCuci.Frame_Pinjam_MesinCuci_ListPeminjaman;
import Frame_Sergun.Frame_Pinjam_SerGun_ListPeminjaman;
import Main.Main;

	public class Frame_Pinjam_List extends JFrame implements ActionListener,WindowListener{
	
	private Font font = new Font(Font.SANS_SERIF, Font.BOLD, 30);
	private Font font_btn = new Font(Font.DIALOG, Font.PLAIN, 16);

	private JPanel pnl_header = new JPanel();
	private JPanel pnl_center = new JPanel();
	private JLabel lbl_choose = new JLabel("Pilih ruangan yang ingin dipinjam");
	private JButton btn_dapur = new JButton("Dapur");
	private JButton btn_mc = new JButton("Mesin Cuci");
	private JButton btn_komunal = new JButton("Komunal");
	private JButton btn_sergun = new JButton("SerGun");
	private JButton btn_back = new JButton("Back");
	
	private Main main;
	private Frame_Welcome welcome;
	private Frame_Pinjam_Dapur_ListPeminjaman list_peminjaman_dapur;
	private Frame_Pinjam_Komunal_ListPeminjaman list_peminjaman_komunal;
	private Frame_Pinjam_MesinCuci_ListPeminjaman list_peminjaman_mesincuci;
	private Frame_Pinjam_SerGun_ListPeminjaman list_peminjaman_sergun;
	
	public void init() {
		setLayout(new BorderLayout());
		JPanel container_button = new JPanel();
		container_button.add(btn_back);
		btn_back.addActionListener(this);
		btn_back.setFocusPainted(false);
		container_button.setBackground(Color.WHITE);
		lbl_choose.setBorder(BorderFactory.createEmptyBorder(120, 0, 40, 70));
		// center
		lbl_choose.setFont(font);
		lbl_choose.setHorizontalAlignment(SwingConstants.CENTER);
		pnl_header.setLayout(new BorderLayout());
		pnl_header.add(lbl_choose,"Center");
		pnl_header.add(container_button,"West");
		add(pnl_header, "North");
		
		btn_dapur.setFont(font_btn);
//		btn_dapur.setBackground(Color.LIGHT_GRAY);
		btn_dapur.setFocusPainted(false);
//		btn_dapur.setBorderPainted(false);
		btn_dapur.addActionListener(this);
		
		btn_mc.setFont(font_btn);
//		btn_mc.setBackground(Color.LIGHT_GRAY);
		btn_mc.setFocusPainted(false);
//		btn_mc.setBorderPainted(false);
		btn_mc.addActionListener(this);
		
		btn_komunal.setFont(font_btn);
//		btn_komunal.setBackground(Color.LIGHT_GRAY);
		btn_komunal.setFocusPainted(false);
//		btn_komunal.setBorderPainted(false);
		btn_komunal.addActionListener(this);
		
		btn_sergun.setFont(font_btn);
//		btn_sergun.setBackground(Color.LIGHT_GRAY);
		btn_sergun.setFocusPainted(false);
//		btn_sergun.setBorderPainted(false);
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
		
		addWindowListener(this);
		
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 500);
		setLocationRelativeTo(null);
		setTitle("RTB Reservation System");
	}
	
	public Frame_Pinjam_List(Main main) {
		this.main = main;
		init();
	}

	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		if(obj.equals(btn_back)) {
			this.dispose();
			welcome = new Frame_Welcome(main);
			return;
		}
		
		if(obj.equals(btn_dapur)) {
			this.dispose();
			list_peminjaman_dapur = new Frame_Pinjam_Dapur_ListPeminjaman(main);
		}
		if(obj.equals(btn_komunal)) {
			this.dispose();
			list_peminjaman_komunal = new Frame_Pinjam_Komunal_ListPeminjaman(main);
		}
		if(obj.equals(btn_sergun)) {
			this.dispose();
			list_peminjaman_sergun = new Frame_Pinjam_SerGun_ListPeminjaman(main);
		}
		if(obj.equals(btn_mc)) {
			this.dispose();
			list_peminjaman_mesincuci = new Frame_Pinjam_MesinCuci_ListPeminjaman(main);
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
		System.out.println("Frame_Pinjam_List");
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
//		new Frame_Pinjam_List(null);
//	}
}
