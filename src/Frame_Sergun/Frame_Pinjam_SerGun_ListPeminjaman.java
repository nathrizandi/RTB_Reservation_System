package Frame_Sergun;
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
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Frame_General.Frame_Pinjam_List;
import Main.Main;
import Ruangan.Serbaguna;

public class Frame_Pinjam_SerGun_ListPeminjaman extends JFrame implements ActionListener,WindowListener{
	
	private Font font = new Font(Font.SANS_SERIF, Font.BOLD, 20);
	private Font font_btn = new Font(Font.DIALOG, Font.PLAIN, 14);

	private JPanel pnl_north = new JPanel();
	private JPanel pnl_center = new JPanel();
	private JPanel pnl_south = new JPanel();
	
	private JButton btn_back = new JButton("Back");
	private JButton btn_form = new JButton("Form Peminjaman");
	
	private JLabel lbl_title = new JLabel("List Peminjaman SerGun");
	
	private Frame_Pinjam_SerGun_FormPeminjaman form_peminjaman;
	private Frame_Pinjam_List pinjam_list;
	private Main main;
	
    private JTable table;
    private String[] column = {"Tanggal","Mulai","Selesai","Nama","Kelas","Gender","Area"};
    private DefaultTableModel model = new DefaultTableModel(column,0);
    
//    private Frame_Pinjam_Dapur_FormPeminjaman form_peminjaman = new Frame_Pinjam_Dapur_FormPeminjaman(main);
	
public void populate_data() {
    	
//    	Object[][] row = {
//    			{"02/12/2023","12:30","13:30","Dexter","PPTI 14","Laki-laki","1"},
//    			{"02/12/2023","12:30","13:30","Dexter","PPTI 14","Laki-laki","1"},
//    			{"02/12/2023","12:30","13:30","Dexter","PPTI 14","Laki-laki","1"},
//    			{"02/12/2023","12:30","13:30","Dexter","PPTI 14","Laki-laki","1"},
//    			{"02/12/2023","12:30","13:30","Dexter","PPTI 14","Laki-laki","1"},
//    			{"02/12/2023","12:30","13:30","Dexter","PPTI 14","Laki-laki","1"},
//    			{"02/12/2023","12:30","13:30","Dexter","PPTI 14","Laki-laki","1"},
//    			{"02/12/2023","12:30","13:30","Dexter","PPTI 14","Laki-laki","1"},
//    			{"02/12/2023","12:30","13:30","Dexter","PPTI 14","Laki-laki","1"},
//    			{"02/12/2023","12:30","13:30","Dexter","PPTI 14","Laki-laki","1"},
//    			{"02/12/2023","12:30","13:30","Dexter","PPTI 14","Laki-laki","1"},
//    			{"02/12/2023","12:30","13:30","Dexter","PPTI 14","Laki-laki","1"},
//    			{"02/12/2023","12:30","13:30","Dexter","PPTI 14","Laki-laki","1"},
//    			{"02/12/2023","12:30","13:30","Dexter","PPTI 14","Laki-laki","1"},
//    			{"02/12/2023","12:30","13:30","Dexter","PPTI 14","Laki-laki","1"},
//    			{"02/12/2023","12:30","13:30","Dexter","PPTI 14","Laki-laki","1"},
//    			{"02/12/2023","12:30","13:30","Dexter","PPTI 14","Laki-laki","1"},
//    			{"02/12/2023","12:30","13:30","Dexter","PPTI 14","Laki-laki","1"},
//    			{"02/12/2023","12:30","13:30","Dexter","PPTI 14","Laki-laki","1"},
//    			{"02/12/2023","12:30","13:30","Dexter","PPTI 14","Laki-laki","1"},
//    			{"02/12/2023","12:30","13:30","Dexter","PPTI 14","Laki-laki","1"},
//    			{"02/12/2023","12:30","13:30","Dexter","PPTI 14","Laki-laki","1"},
//    			{"02/12/2023","12:30","13:30","Dexter","PPTI 14","Laki-laki","1"},
//    			{"02/12/2023","12:30","13:30","Dexter","PPTI 14","Laki-laki","1"},
//    			{"02/12/2023","12:30","13:30","Dexter","PPTI 14","Laki-laki","1"},
//    			{"02/12/2023","12:30","13:30","Dexter","PPTI 14","Laki-laki","1"},
//    			{"02/12/2023","12:30","13:30","Dexter","PPTI 14","Laki-laki","1"},
//    			{"02/12/2023","12:30","13:30","Dexter","PPTI 14","Laki-laki","1"},
//    			{"02/12/2023","12:30","13:30","Dexter","PPTI 14","Laki-laki","1"},
//    			{"02/12/2023","12:30","13:30","Dexter","PPTI 14","Laki-laki","2"}
//    	};
//    	
//    	for(Object[] x : row) {
//    		model.addRow(x);
//    	}
	
		main.sort_serbaguna();
		System.out.println(main.getList_serbaguna().size());
		for(Serbaguna x : main.getList_serbaguna()) {
			System.out.println(x.getGender_peminjam());
			String tanggal = String.format("%d/%d/%d", x.getHari(),x.getBulan(),x.getTahun());
			String jam_mulai = String.format("%d:%d", x.getJam_mulai(),x.getMenit_mulai());
			String jam_selesai = String.format("%d:%d", x.getJam_selesai(),x.getMenit_selesai());
			String nama = x.getNama_peminjam();
			String kelas = x.getKelas_peminjam();
			String gender = x.getGender_peminjam();
			String jumlah_tungku = (x.getLuas());
			Object[] y = {tanggal, jam_mulai, jam_selesai, nama, kelas, gender, jumlah_tungku};
			model.addRow(y);
		}
    }
	
	public void init() {
		setLayout(new BorderLayout());
		
		lbl_title.setFont(font);
		
		btn_back.setFont(font_btn);
//		btn_back.setBackground(Color.LIGHT_GRAY);
		btn_back.setFocusPainted(false);
//		btn_back.setBorderPainted(false);
		btn_back.addActionListener(this);
		
		btn_form.setFont(font_btn);
//		btn_form.setBackground(Color.LIGHT_GRAY);
		btn_form.setFocusPainted(false);
//		btn_form.setBorderPainted(false);
		btn_form.addActionListener(this);
		
		// North
		pnl_north.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
//		pnl_north.setLayout(new GridLayout(0, 10));
//		pnl_north.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 0));
		pnl_north.add(btn_back);
		pnl_north.setPreferredSize(new Dimension(800, 90));
		pnl_center.setPreferredSize(new Dimension(800, 30));
		pnl_center.add(lbl_title);
		pnl_north.add(pnl_center);
		add(pnl_north, "North");
				
		table = new JTable(model){
            public boolean isCellEditable(int row, int column) {
                return false;
            }	
        };
        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(200);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        
        populate_data();
        
        JScrollPane jsptable = new JScrollPane(table);
        add(jsptable);
		
		// South
		pnl_south.add(btn_form);
		pnl_south.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		add(pnl_south, "South");
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("RTB Reservation System");
		addWindowListener(this);
	}
	
	public Frame_Pinjam_SerGun_ListPeminjaman(Main main) {
		this.main = main;
		init();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		if(obj.equals(btn_form)) {	
			this.dispose();
			form_peminjaman = new Frame_Pinjam_SerGun_FormPeminjaman(main);
			
		}else if(obj.equals(btn_back)) {
			this.dispose();
			pinjam_list = new Frame_Pinjam_List(main);
			
		}
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Frame_Pinjam_Dapur_ListPeminjaman");
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
