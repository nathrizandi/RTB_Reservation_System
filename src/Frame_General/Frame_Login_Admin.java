package Frame_General;


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
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import Main.Main;
public class Frame_Login_Admin extends JFrame implements ActionListener,WindowListener{
    private Font font_title = new Font(Font.SANS_SERIF, Font.BOLD, 25);
    
    //Main panel
    private JPanel pnl_main = new JPanel();
    
    // Header
    private JPanel panel_north = new JPanel();
    private JLabel lbl_login = new JLabel("Masuk sebagai Admin");
    private JPanel panel_space_north1 = new JPanel();
    private JPanel panel_space_north2 = new JPanel();
    
    // Component
    private JPanel panel_center = new JPanel();
    private JPanel panel_center_frame = new JPanel();
    private JPanel panel_center_frame1 = new JPanel();
    private JPanel panel_space_center1 = new JPanel();
    private JPanel panel_space_center2 = new JPanel();
    private JTextField txt_username = new JTextField();
    private JPasswordField txt_password = new JPasswordField();
    private JOptionPane fail_pop = new JOptionPane();
    private JPanel panel_spacing = new JPanel();

    // Footer
    private JPanel panel_south = new JPanel();
    private JPanel panel_south_frame = new JPanel();
    private JPanel panel_space_south1 = new JPanel();
    private JPanel panel_space_south2 = new JPanel();
    private JButton btn_back = new JButton("Back");
    private JButton btn_submit = new JButton("Submit");
    private JLabel error_label = new JLabel();

    //Main
    private Main main;
    
    //Kumpulan frame
    private Frame_Welcome welcome;
    private Frame_Delete_List delete_list;
    

    void init_components(){
    	setLayout(new BorderLayout());
        pnl_main.setLayout(new BorderLayout());
        pnl_main.setPreferredSize(new Dimension(500, 250));
        // Header
        panel_north.setLayout(new BorderLayout());
        lbl_login.setFont(font_title);
        panel_north.add(lbl_login, "North");
        lbl_login.setHorizontalAlignment(JLabel.CENTER);
        panel_north.add(panel_space_north1, "Center");
        panel_north.add(panel_space_north2, "South");
        pnl_main.add(panel_north, BorderLayout.NORTH);
        
        // Content
        panel_center_frame.setLayout(new BorderLayout());
        panel_center_frame.add(panel_space_center1, "Center");
        pnl_main.add(panel_center_frame, BorderLayout.WEST);

        panel_center_frame1.setLayout(new BorderLayout());
        panel_center_frame1.add(panel_space_center2, "Center");
        pnl_main.add(panel_center_frame1, BorderLayout.EAST);

        panel_center.setLayout(new GridLayout(4, 2));
        
        // Row 1
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        panel_center.add(new JLabel(""));
        panel_center.add(new JLabel(""));
        
        JLabel lbl_username = new JLabel("Username");
        lbl_username.setHorizontalAlignment(SwingConstants.CENTER);
        panel_center.add(lbl_username);
;
        panel_center.add(txt_username);
        

        // Row 2
        JLabel lbl_password = new JLabel("Password");
        lbl_password.setHorizontalAlignment(SwingConstants.CENTER);
        panel_center.add(lbl_password);
        panel_center.add(txt_password);
        panel_center.add(new JLabel(""));
        panel_center.add(new JLabel(""));
        pnl_main.add(panel_center);

        // Footer
        panel_south_frame.setLayout(new BorderLayout());
        panel_south_frame.add(panel_space_south1, "North");
        panel_south_frame.add(panel_space_south2, "Center");
        
        panel_spacing.setPreferredSize(new Dimension(100, 100));
        panel_spacing.setLayout(new BorderLayout());
        JPanel panel_button_landing = new JPanel();
        panel_button_landing.add(btn_back);
        panel_spacing.add(panel_button_landing,"West");
        
		error_label.setHorizontalAlignment(JLabel.CENTER);
        error_label.setForeground(Color.RED);
        error_label.setFont(error_label.getFont().deriveFont(Font.PLAIN));
        
        panel_south.setLayout(new BorderLayout());
        btn_back.addActionListener(this);
        btn_submit.addActionListener(this);
        
        JPanel container = new JPanel();
        container.add(btn_submit);
        panel_south.add(container,"Center");
        panel_south.add(error_label,"North");
        
        panel_south_frame.add(panel_south, "South");
        pnl_main.add(panel_south_frame, "South");
        
        JPanel pnl_dummy = new JPanel();
        pnl_dummy.add(pnl_main);
        
        add(panel_spacing , "North");
        add(pnl_dummy,"Center");
        
        addWindowListener(this);
        
        setTitle("Login as Student");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,500);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        
    }

    public Frame_Login_Admin(Main main){
    	this.main = main;
        init_components();
    }

//    public static void main(String[] args) {
//        new Frame_Login_Peminjam();
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj.equals(btn_back)) {
        	this.dispose();
        	welcome = new Frame_Welcome(main);
        }
        else if(obj.equals(btn_submit)) {
        	if(txt_password.getPassword().length==0 || txt_username.getText().isEmpty()) {
        		error_label.setText("Mohon mengisi semua bagian");
        		return;
        	}
        	error_label.setText("");      
        	String username = txt_username.getText();
        	String password = new String(txt_password.getPassword());
        	
        	if(main.login_admin(username, password)) {
        		this.dispose();
        		delete_list = new Frame_Delete_List(main);
        	}
        	else {
        		fail_pop.showMessageDialog(null, "Username atau password yang Anda masukkan tidak valid", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        	}
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
		System.out.println("Frame_Login_Admin");
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

//txt_username.setPreferredSize(new Dimension(100, 20));
//JPanel panel_resize_txt = new JPanel();
//panel_resize_txt.setLayout(new FlowLayout(FlowLayout.LEFT));
//panel_resize_txt.setBorder(blackBorder);
//panel_resize_txt.add(txt_username);