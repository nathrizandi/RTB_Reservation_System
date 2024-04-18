package Frame_MesinCuci;
import Main.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Frame_General.Frame_Delete_List;
import Main.Main;
import Ruangan.Mesincuci;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.EventListener;

public class Frame_Delete_MesinCuci extends JFrame implements ActionListener,WindowListener{

    private JTable table;
    private String[] column = {"Tanggal","Mulai","Selesai","Nama","Kelas","Gender","Jml mesin"};
    private DefaultTableModel model = new DefaultTableModel(column,0);
    private JButton bback = new JButton("Back");
    private JPanel panel_back = new JPanel();
    private JLabel lblnote = new JLabel("Note : Pilih baris dan tekan enter untuk menghapus");
    private JLabel lbltitle = new JLabel("HAPUS MESIN CUCI");
    private JPanel panel_title = new JPanel();
    private Main main;
    
    //Frame_Delete_List yang dihubungkan kesini
    
//    public void populate_data() {
//    	
//    	
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
//    	};
//    	
//    	for(Object[] x : row) {
//    		model.addRow(x);
//    	}
//    	
//    }
   
//    			{"02/12/2023","12:30","13:30","Dexter","PPTI 14","Laki-laki","1"}
    public void populate_data() {
    	System.out.println(main.getList_mesincuci().size());
    	for(Mesincuci x : main.getList_mesincuci()) {
    		System.out.println(x.getGender_peminjam());
    		String tanggal = String.format("%d/%d/%d", x.getHari(),x.getBulan(),x.getTahun());
    		String jam_mulai = String.format("%d:%d", x.getJam_mulai(),x.getMenit_mulai());
    		String jam_selesai = String.format("%d:%d", x.getJam_selesai(),x.getMenit_selesai());
    		String nama = x.getNama_peminjam();
    		String kelas = x.getKelas_peminjam();
    		String gender = x.getGender_peminjam();
    		String jumlah_tungku = Integer.toString(x.getJumlah_mesin());
    		Object[] y = {tanggal, jam_mulai, jam_selesai, nama, kelas, gender, jumlah_tungku};
    		model.addRow(y);
    	}
    }
    
    public void init_component() {
    	setLayout(new BorderLayout());
    	
    	//buat panel untuk back button dan label untuk pengingat
    	panel_back.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
    	bback.addActionListener(this);
    	panel_back.add(bback);
    	panel_back.setPreferredSize(new Dimension(800, 80));
    	
    	//setting lblnote
        lblnote.setForeground(Color.RED);
        lblnote.setFont(lblnote.getFont().deriveFont(Font.PLAIN));
    	
    	//panel title
    	panel_title.setPreferredSize(new Dimension(800,20));
    	panel_title.add(lbltitle);
    	panel_back.add(bback);
    	panel_back.add(panel_title);
    	panel_back.add(lblnote);
    	
    	
    	add(panel_back,"North");
    	//Bagian table
        table = new JTable(model){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }	
        };
        InputMap inputMap = table.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ActionMap actionMap = table.getActionMap();
        inputMap.put(KeyStroke.getKeyStroke("ENTER"), "deleteRow");
        actionMap.put("deleteRow", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    ((DefaultTableModel) table.getModel()).removeRow(selectedRow);
//                    System.out.println("The removed selected row is : " + selectedRow);
//                    System.out.println("The size of list_dapur before is : "  + main.getList_dapur().size());
                    main.getList_mesincuci().remove(selectedRow);
//                    System.out.println("The size of list_dapur now is : "  + main.getList_dapur().size());
                }
            }
        });
        
        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(200);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        
        
        JScrollPane jsptable = new JScrollPane(table);
        add(jsptable);
        
    }
    
    public Frame_Delete_MesinCuci(Main main) {
    	this.main = main;
    	init_component();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setTitle("RTB Reservation System");
        setLocationRelativeTo(null);
        populate_data();
//        System.out.println("Mantap");
        setVisible(true);
        setResizable(false);
        addWindowListener(this);
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(this.bback)) {
			this.dispose();
			Frame_Delete_List fdl = new Frame_Delete_List(main);
		}
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public String[] getColumn() {
		return column;
	}

	public void setColumn(String[] column) {
		this.column = column;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public JButton getBback() {
		return bback;
	}

	public void setBback(JButton bback) {
		this.bback = bback;
	}

	public JPanel getPanel_back() {
		return panel_back;
	}

	public void setPanel_back(JPanel panel_back) {
		this.panel_back = panel_back;
	}

	public JLabel getLblnote() {
		return lblnote;
	}

	public void setLblnote(JLabel lblnote) {
		this.lblnote = lblnote;
	}

	public JLabel getLbltitle() {
		return lbltitle;
	}

	public void setLbltitle(JLabel lbltitle) {
		this.lbltitle = lbltitle;
	}

	public JPanel getPanel_title() {
		return panel_title;
	}

	public void setPanel_title(JPanel panel_title) {
		this.panel_title = panel_title;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Frame_Delete_Dapur");
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
