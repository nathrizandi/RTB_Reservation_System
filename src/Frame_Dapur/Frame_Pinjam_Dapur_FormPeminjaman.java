package Frame_Dapur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;
import Main.Main;
import Ruangan.*;
public class Frame_Pinjam_Dapur_FormPeminjaman extends JFrame implements ActionListener,WindowListener{
	
	private JDatePickerImpl datePicker;
	
	private Font font = new Font(Font.SANS_SERIF, Font.BOLD, 20);
	private Font font_btn = new Font(Font.DIALOG, Font.PLAIN, 14);

	private JPanel pnl_north = new JPanel();
	private JPanel pnl_center = new JPanel();
	private JPanel pnl_south = new JPanel();
	private JPanel pnl_title = new JPanel();
	
	private JLabel lbl_header = new JLabel("Peminjaman Dapur");
	
	private JButton btn_back = new JButton("Back");
	private JButton btn_submit = new JButton("Submit");
	
	private JTextField txt_tanggal = new JTextField();
	private JTextField txt_bulan = new JTextField();
	private JTextField txt_tahun = new JTextField();
	private JTextField txt_jm = new JTextField();
	private JTextField txt_js = new JTextField();
	private JTextField txt_mm = new JTextField();			
	private JTextField txt_ms = new JTextField();
	private JLabel error_label = new JLabel();
	private JOptionPane success_pop = new JOptionPane();
	private JOptionPane fail_pop = new JOptionPane();
	
	
	private ButtonGroup radio_group = new ButtonGroup();
	private JRadioButton tungku1 = new JRadioButton("1 Tungku");
	private JRadioButton tungku2 = new JRadioButton("2 Tungku");
	
	private Frame_Pinjam_Dapur_ListPeminjaman list_peminjaman;
	private Main main;
	
	public void init() {
		setLayout(new BorderLayout());
		
		SqlDateModel model = new SqlDateModel();
		
		JDatePanelImpl panel = new JDatePanelImpl(model, new Properties());
		panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		datePicker = new JDatePickerImpl(panel, new AbstractFormatter() {
			
			public String valueToString(Object value) throws ParseException {
				
				if(value!=null) {
					Calendar cal = (Calendar) value;
					SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
					String strDate = format.format(cal.getTime());
					
					return strDate;
				}return "";
			}
			
			public Object stringToValue(String text) throws ParseException {
				return "";
			}
		});
		
		lbl_header.setFont(font);
//		lbl_header2.setFont(font);
		
		btn_back.setFont(font_btn);
//		btn_back.setBackground(Color.LIGHT_GRAY);
		btn_back.setFocusPainted(false);
//		btn_back.setBorderPainted(false);
		btn_back.addActionListener(this);
		
		btn_submit.setFont(font_btn);
//		btn_submit.setBackground(Color.LIGHT_GRAY);
		btn_submit.setFocusPainted(false);
//		btn_submit.setBorderPainted(false);
		btn_submit.addActionListener(this);
		
		// North
		pnl_north.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
//		pnl_north.setLayout(new GridLayout(0, 10));
//		pnl_north.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 0));
		pnl_north.add(btn_back);
		pnl_north.setPreferredSize(new Dimension(800, 80));
		pnl_title.setPreferredSize(new Dimension(800, 50));
		pnl_title.add(lbl_header);
		pnl_north.add(pnl_title);
		add(pnl_north, "North");
		
		// Center
		pnl_center.setLayout(new FlowLayout());
//		pnl_center.add(new JLabel(" "));
//		pnl_center.add(lbl_header);
//		pnl_center.add(lbl_header2);
//		pnl_center.add(new JLabel(" "));
		
		GridLayout layout = new GridLayout(9, 4);
		layout.setHgap(2);
		pnl_center.setLayout(layout);
		pnl_center.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 100));
		
		pnl_center.add(new JLabel(" "));
		pnl_center.add(new JLabel(" "));
		pnl_center.add(new JLabel(" "));
		pnl_center.add(new JLabel(" "));
		pnl_center.add(new JLabel("Tanggal (DD/MM/YYYY): "));
		pnl_center.add(datePicker);
		pnl_center.add(new JLabel(""));
		pnl_center.add(new JLabel(""));
		pnl_center.add(new JLabel(" "));
		pnl_center.add(new JLabel(" "));
		pnl_center.add(new JLabel(" "));
		pnl_center.add(new JLabel(" "));
		pnl_center.add(new JLabel("Jam Mulai: "));
		pnl_center.add(txt_jm);
		pnl_center.add(new JLabel("                    :"));
		pnl_center.add(txt_mm);
		pnl_center.add(new JLabel(" "));
		pnl_center.add(new JLabel(" "));
		pnl_center.add(new JLabel(" "));
		pnl_center.add(new JLabel(" "));
		pnl_center.add(new JLabel("Jam Selesai: "));
		pnl_center.add(txt_js);
		pnl_center.add(new JLabel("                    :"));
		pnl_center.add(txt_ms);
		pnl_center.add(new JLabel(" "));
		pnl_center.add(new JLabel(" "));
		pnl_center.add(new JLabel(" "));
		pnl_center.add(new JLabel(" "));
		pnl_center.add(new JLabel("Jumlah Tungku: "));
		
		radio_group.add(tungku1);
		radio_group.add(tungku2);	
		pnl_center.add(tungku1);
		pnl_center.add(tungku2);
		
		pnl_center.add(new JLabel(" "));
		pnl_center.add(new JLabel(" "));
		pnl_center.add(new JLabel(" "));
		pnl_center.add(new JLabel(" "));
		
		add(pnl_center, "Center");
		
		// South
		pnl_south.setLayout(new BorderLayout());
		error_label.setHorizontalAlignment(JLabel.CENTER);
        error_label.setForeground(Color.RED);
        error_label.setFont(error_label.getFont().deriveFont(Font.PLAIN));
		pnl_south.add(error_label,"North");
		JPanel pnl_fill = new JPanel();
		pnl_fill.add(btn_submit);
		pnl_south.add(pnl_fill,"Center");
		pnl_south.setBorder(BorderFactory.createEmptyBorder(10, 0, 50, 0));
		add(pnl_south, "South");
		
//		pnl_north.setBackground(Color.WHITE);
//		pnl_center.setBackground(Color.WHITE);
//		pnl_south.setBackground(Color.WHITE);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("RTB Reservation System");
		addWindowListener(this);
	}

	public Frame_Pinjam_Dapur_FormPeminjaman(Main main) {
		this.main =  main;
		init();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj.equals(btn_back)) {
			this.dispose();
			list_peminjaman = new Frame_Pinjam_Dapur_ListPeminjaman(main);
			
		}
		else if(obj.equals(btn_submit)) {
			Date date = (Date) datePicker.getModel().getValue();
			if(
				date==null
				|| txt_jm.getText().isEmpty()
				|| txt_mm.getText().isEmpty()
				|| txt_js.getText().isEmpty()
				|| txt_ms.getText().isEmpty()
				|| !tungku1.isSelected() && !tungku2.isSelected()
					) {
				error_label.setText("Mohon mengisi semua bagian");
				return;
			}
			int jam_mulai = Integer.parseInt(txt_jm.getText());
			int menit_mulai = Integer.parseInt(txt_mm.getText());
			int jam_selesai = Integer.parseInt(txt_js.getText());
			int menit_selesai = Integer.parseInt(txt_ms.getText());
			int jumlah_tungku = 0;
			if(tungku1.isSelected()) {
				jumlah_tungku = 1;
			}
			else if(tungku2.isSelected()) {
				jumlah_tungku = 2;
			}
			Calendar temp_calendar = Calendar.getInstance();
			temp_calendar.setTime(date);
			int hari = temp_calendar.get(Calendar.DAY_OF_MONTH);
			int bulan = temp_calendar.get(Calendar.MONTH)+1;
			int tahun = temp_calendar.get(Calendar.YEAR);
			
			Dapur temp = new Dapur(hari, bulan, tahun, jam_mulai, menit_mulai, jam_selesai, menit_selesai,main.getCurr_peminjam().getNama() , main.getCurr_peminjam().getKelas(), main.getCurr_peminjam().getGender(),jumlah_tungku);
			System.out.println("Hari bulan tahun : " + temp.getHari() + "/" + temp.getBulan() + "/" + temp.getTahun());
			LocalDate localDate = LocalDate.of(tahun, bulan, hari);
			if(main.isDate(localDate) && main.isDuration(jam_mulai, menit_mulai, jam_selesai, menit_selesai) && main.valid_tanggal_dapur(temp)) {
					success_pop.showMessageDialog(null, "Jadwal berhasil ditambahkan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
					Frame_Pinjam_Dapur_ListPeminjaman n = new Frame_Pinjam_Dapur_ListPeminjaman(main);
					this.dispose();
					System.out.println("Hasil testing : ");
					System.out.println("Size dari list_dapur : " + main.getList_dapur().size());
					System.out.println("-------------------------------------------------------------------");
					System.out.println("Isi dapur : ");
					main.print_dapur();
					System.out.println("-------------------------------------------------------------------");
			}
			else {
				if(!main.isDate(localDate)) {
					fail_pop.showMessageDialog(null, "Tanggal minimal hari ini atau kurang dari seminggu", "Informasi", JOptionPane.INFORMATION_MESSAGE);					
				}
				
				else if(!main.isDuration(jam_mulai,menit_mulai,jam_selesai,menit_selesai)) {
					fail_pop.showMessageDialog(null, "Minimal peminjaman adalah 1 jam dan maksimal 2 jam", "Informasi", JOptionPane.INFORMATION_MESSAGE);					
				}
				else if(!main.valid_tanggal_dapur(temp)) {
					fail_pop.showMessageDialog(null, "Jam yang anda pilih bertabrakan dengan jam yang sudah ada", "Informasi", JOptionPane.INFORMATION_MESSAGE);										
				}
				
			}
			return;
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Frame_Pinjam_Dapur_FormPeminjaman");
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

 