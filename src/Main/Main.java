package Main;
import Ruangan.*;
import Akun.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import Akun.Admin;
import Akun.Peminjam;
import Frame_General.*;

public class Main {
	Scanner scan = new Scanner(System.in);
	private Peminjam curr_peminjam = new Peminjam();
	private ArrayList<Admin> list_admin = new ArrayList<>();
	private ArrayList<Peminjam> list_peminjam = new ArrayList<>();
	private ArrayList<Dapur> list_dapur = new ArrayList<>();
	private ArrayList<Komunal> list_komunal = new ArrayList<>();
	private ArrayList<Mesincuci> list_mesincuci = new ArrayList<>();
	private ArrayList<Serbaguna> list_serbaguna = new ArrayList<>();
	
	
	//Kumpulan frame
//	private Frame_Delete_List frame_del_list;
//	private Frame_Pinjam_List frame_pinjam_list;
	private Frame_Welcome frame_welcome;
	
    public boolean isDate(LocalDate date) {
        LocalDate today = LocalDate.now();
        long daysBetween = ChronoUnit.DAYS.between(today, date);
        System.out.println("The days difference is " + daysBetween);
        if(daysBetween<=7 && daysBetween>=0) {
        	return true;
        }
        return false;
    }
	
    public boolean isDuration(int jam_mulai, int menit_mulai, int jam_selesai, int menit_selesai) {
    	int total_mulai = jam_mulai*60 + menit_mulai;
    	int total_selesai = jam_selesai*60 + menit_selesai;
    	int selisih = total_selesai - total_mulai;
    	if(selisih>=60 && selisih<=120) return true;
    	return false;
    }
    
	public void sort_dapur(){
		list_dapur.sort(new Comparator<Dapur>() {

			@Override
			public int compare(Dapur o1, Dapur o2) {
				if(o1.getTahun().compareTo(o2.getTahun())!=0) return o1.getTahun().compareTo(o2.getTahun());
				else if(o1.getBulan().compareTo(o2.getBulan())!=0) return o1.getBulan().compareTo(o2.getBulan());
				else if(o1.getHari().compareTo(o2.getHari())!=0) return o1.getHari().compareTo(o2.getHari());
				else if(o1.getJam_mulai().compareTo(o2.getJam_mulai())!=0) return o1.getJam_mulai().compareTo(o2.getJam_mulai());
				else if(o1.getMenit_mulai().compareTo(o2.getMenit_mulai())!=0) return o1.getMenit_mulai().compareTo(o2.getMenit_selesai());
				else return 0;
			}
		});
	}
	public void sort_komunal() {
		list_komunal.sort(new Comparator<Komunal>() {

			@Override
			public int compare(Komunal o1, Komunal o2) {
				// TODO Auto-generated method stub
				if(o1.getTahun().compareTo(o2.getTahun())!=0) return o1.getTahun().compareTo(o2.getTahun());
				else if(o1.getBulan().compareTo(o2.getBulan())!=0) return o1.getBulan().compareTo(o2.getBulan());
				else if(o1.getHari().compareTo(o2.getHari())!=0) return o1.getHari().compareTo(o2.getHari());
				else if(o1.getJam_mulai().compareTo(o2.getJam_mulai())!=0) return o1.getJam_mulai().compareTo(o2.getJam_mulai());
				else if(o1.getMenit_mulai().compareTo(o2.getMenit_mulai())!=0) return o1.getMenit_mulai().compareTo(o2.getMenit_selesai());
				else return 0;
			}
		});
	}
	public void sort_mesincuci() {
		list_mesincuci.sort(new Comparator<Mesincuci>() {

			@Override
			public int compare(Mesincuci o1, Mesincuci o2) {
				if(o1.getTahun().compareTo(o2.getTahun())!=0) return o1.getTahun().compareTo(o2.getTahun());
				else if(o1.getBulan().compareTo(o2.getBulan())!=0) return o1.getBulan().compareTo(o2.getBulan());
				else if(o1.getHari().compareTo(o2.getHari())!=0) return o1.getHari().compareTo(o2.getHari());
				else if(o1.getJam_mulai().compareTo(o2.getJam_mulai())!=0) return o1.getJam_mulai().compareTo(o2.getJam_mulai());
				else if(o1.getMenit_mulai().compareTo(o2.getMenit_mulai())!=0) return o1.getMenit_mulai().compareTo(o2.getMenit_selesai());
				else return 0;
			}
		});
	}
	public void sort_serbaguna() {
		list_serbaguna.sort(new Comparator<Serbaguna>() {

			@Override
			public int compare(Serbaguna o1, Serbaguna o2) {
				if(o1.getTahun().compareTo(o2.getTahun())!=0) return o1.getTahun().compareTo(o2.getTahun());
				else if(o1.getBulan().compareTo(o2.getBulan())!=0) return o1.getBulan().compareTo(o2.getBulan());
				else if(o1.getHari().compareTo(o2.getHari())!=0) return o1.getHari().compareTo(o2.getHari());
				else if(o1.getJam_mulai().compareTo(o2.getJam_mulai())!=0) return o1.getJam_mulai().compareTo(o2.getJam_mulai());
				else if(o1.getMenit_mulai().compareTo(o2.getMenit_mulai())!=0) return o1.getMenit_mulai().compareTo(o2.getMenit_selesai());
				else return 0;
			}
		});
	}
	
	public void print_dapur() {
		if(list_dapur.size()==0) {
			return;
		}
		
		sort_dapur();
		for(Dapur x : list_dapur) {
			x.print_ruangan();
			System.out.print(" Tungku : " + x.getJumlah_tungku());
			System.out.println();
		}
	}
	public void print_komunal() {
		if(list_komunal.size()==0) {
			return;
		}
		
		sort_komunal();
		for(Komunal x : list_komunal) {
			x.print_ruangan();
			System.out.println(" " + x.getLantai());
		}
	}
	public void print_mesincuci() {
		if(list_mesincuci.size()==0) {
			return;
		}
		
		sort_mesincuci();
		for(Mesincuci x : list_mesincuci) {
			x.print_ruangan();
			System.out.println(" " + x.getJumlah_mesin());
		}
	}
	public void print_serbaguna() {
		if(list_serbaguna.size()==0) {
			return;
		}
		
		sort_serbaguna();
		for(Serbaguna x : list_serbaguna) {
			x.print_ruangan();
			System.out.println(" " + x.getLuas());
		}
	}
	
	public boolean valid_tanggal_dapur(Dapur temp) {
//		System.out.println("Here");
		int flag=0;
		int flag_added=0;
		for(Dapur x: list_dapur) {
			if(x.getTahun().equals(temp.getTahun()) && x.getBulan().equals(temp.getBulan()) && x.getHari().equals(temp.getHari())) {
				flag=1;
				int x_total_menit_selesai = x.getJam_selesai()*60 + x.getMenit_selesai();
				int x_total_menit_mulai = x.getJam_mulai()*60 + x.getMenit_mulai();
				int temp_total_menit_mulai = temp.getJam_mulai()*60 + temp.getMenit_mulai();
				int temp_total_menit_selesai = temp.getJam_selesai()*60 + temp.getMenit_selesai();
				if(temp_total_menit_mulai >= x_total_menit_selesai) {
					if(list_dapur.indexOf(x) == list_dapur.size()-1) {
						 list_dapur.add(temp);
						 flag_added=1;
						 return true;
					}
					else {
						Dapur y = list_dapur.get(list_dapur.indexOf(x)+1);
						if(y.getTahun().equals(temp.getTahun()) && y.getBulan().equals(temp.getBulan()) && y.getHari().equals(temp.getHari())) {
							int y_total_menit_mulai = y.getJam_mulai()*60 + y.getMenit_mulai();
							if(temp_total_menit_selesai <= y_total_menit_mulai) {
								 list_dapur.add(temp);
								 flag_added=1;
								 return true;
							}
						}
					}
				}
				else if(temp_total_menit_selesai <= x_total_menit_mulai) {
					if(list_dapur.indexOf(x) == 0) {
						 list_dapur.add(temp);
						 flag_added=1;
						 return true;
					}
					else {
						Dapur y = list_dapur.get(list_dapur.indexOf(x)-1);
						if(y.getTahun() == temp.getTahun() && y.getBulan() == temp.getBulan() && y.getHari() == temp.getHari()) {
							int y_total_menit_selesai = y.getJam_selesai()*60 + y.getMenit_selesai();
							if(temp_total_menit_selesai <= y_total_menit_selesai) {
								 list_dapur.add(temp);
								 flag_added=1;
								 return true;
							}
						}
					}
				}
			}
		}
		if(flag==0) {
			list_dapur.add(temp);
			flag_added=1;
			return true;
		}
		if(flag_added==0) {
			//Tempat untuk memasukkan pesan bahwa waktu yang dimasukkan tidak valid
			return false;
		}
		return false;
	}
	public boolean valid_tanggal_komunal(Komunal temp) {
		int flag=0;
		int flag_added=0;
		for(Komunal x: list_komunal) {
			if(x.getTahun().equals(temp.getTahun()) && x.getBulan().equals(temp.getBulan()) && x.getHari().equals(temp.getHari())) {
				flag=1;
				int x_total_menit_selesai = x.getJam_selesai()*60 + x.getMenit_selesai();
				int x_total_menit_mulai = x.getJam_mulai()*60 + x.getMenit_mulai();
				int temp_total_menit_mulai = temp.getJam_mulai()*60 + temp.getMenit_mulai();
				int temp_total_menit_selesai = temp.getJam_selesai()*60 + temp.getMenit_selesai();
				if(temp_total_menit_mulai >= x_total_menit_selesai) {
					if(list_komunal.indexOf(x) == list_komunal.size()-1) {
						 list_komunal.add(temp);
						 flag_added=1;
						 return true;
					}
					else {
						Komunal y = list_komunal.get(list_komunal.indexOf(x)+1);
						if(y.getTahun().equals(temp.getTahun()) && y.getBulan().equals(temp.getBulan()) && y.getHari().equals(temp.getHari())) {
							int y_total_menit_mulai = y.getJam_mulai()*60 + y.getMenit_mulai();
							if(temp_total_menit_selesai <= y_total_menit_mulai) {
								 list_komunal.add(temp);
								 flag_added=1;
								 return true;
							}
						}
					}
				}
				else if(temp_total_menit_selesai <= x_total_menit_mulai) {
					if(list_komunal.indexOf(x) == 0) {
						 list_komunal.add(temp);
						 flag_added=1;
						 return true;
					}
					else {
						Komunal y = list_komunal.get(list_komunal.indexOf(x)-1);
						if(y.getTahun() == temp.getTahun() && y.getBulan() == temp.getBulan() && y.getHari() == temp.getHari()) {
							int y_total_menit_selesai = y.getJam_selesai()*60 + y.getMenit_selesai();
							if(temp_total_menit_selesai <= y_total_menit_selesai) {
								 list_komunal.add(temp);
								 flag_added=1;
								 return true;
							}
						}
					}
				}
			}
		}
		if(flag==0) {
			list_komunal.add(temp);
			flag_added=1;
			return true;
		}
		if(flag_added==0) {
			//Tempat untuk memasukkan pesan bahwa waktu yang dimasukkan tidak valid
			return false;
		}
		return false;
	}
	public boolean valid_tanggal_mesincuci(Mesincuci temp) {
		int flag=0;
		int flag_added=0;
		for(Mesincuci x: list_mesincuci) {
			if(x.getTahun().equals(temp.getTahun()) && x.getBulan().equals(temp.getBulan()) && x.getHari().equals(temp.getHari())) {
				flag=1;
				int x_total_menit_selesai = x.getJam_selesai()*60 + x.getMenit_selesai();
				int x_total_menit_mulai = x.getJam_mulai()*60 + x.getMenit_mulai();
				int temp_total_menit_mulai = temp.getJam_mulai()*60 + temp.getMenit_mulai();
				int temp_total_menit_selesai = temp.getJam_selesai()*60 + temp.getMenit_selesai();
				if(temp_total_menit_mulai >= x_total_menit_selesai) {
					if(list_mesincuci.indexOf(x) == list_mesincuci.size()-1) {
						 list_mesincuci.add(temp);
						 flag_added=1;
						 return true;
					}
					else {
						Mesincuci y = list_mesincuci.get(list_mesincuci.indexOf(x)+1);
						if(y.getTahun().equals(temp.getTahun()) && y.getBulan().equals(temp.getBulan()) && y.getHari().equals(temp.getHari())) {
							int y_total_menit_mulai = y.getJam_mulai()*60 + y.getMenit_mulai();
							if(temp_total_menit_selesai <= y_total_menit_mulai) {
								 list_mesincuci.add(temp);
								 flag_added=1;
								 return true;
							}
						}
					}
				}
				else if(temp_total_menit_selesai <= x_total_menit_mulai) {
					if(list_mesincuci.indexOf(x) == 0) {
						 list_mesincuci.add(temp);
						 flag_added=1;
						 return true;
					}
					else {
						Mesincuci y = list_mesincuci.get(list_mesincuci.indexOf(x)-1);
						if(y.getTahun() == temp.getTahun() && y.getBulan() == temp.getBulan() && y.getHari() == temp.getHari()) {
							int y_total_menit_selesai = y.getJam_selesai()*60 + y.getMenit_selesai();
							if(temp_total_menit_selesai <= y_total_menit_selesai) {
								 list_mesincuci.add(temp);
								 flag_added=1;
								 return true;
							}
						}
					}
				}
			}
		}
		if(flag==0) {
			list_mesincuci.add(temp);
			flag_added=1;
			return true;
		}
		if(flag_added==0) {
			//Tempat untuk memasukkan pesan bahwa waktu yang dimasukkan tidak valid
			return false;
		}
		return false;
	}
	public boolean valid_tanggal_serbaguna(Serbaguna temp) {
		int flag=0;
		int flag_added=0;
		for(Serbaguna x: list_serbaguna) {
			if(x.getTahun().equals(temp.getTahun()) && x.getBulan().equals(temp.getBulan()) && x.getHari().equals(temp.getHari())) {
				flag=1;
				int x_total_menit_selesai = x.getJam_selesai()*60 + x.getMenit_selesai();
				int x_total_menit_mulai = x.getJam_mulai()*60 + x.getMenit_mulai();
				int temp_total_menit_mulai = temp.getJam_mulai()*60 + temp.getMenit_mulai();
				int temp_total_menit_selesai = temp.getJam_selesai()*60 + temp.getMenit_selesai();
				if(temp_total_menit_mulai >= x_total_menit_selesai) {
					if(list_serbaguna.indexOf(x) == list_serbaguna.size()-1) {
						 list_serbaguna.add(temp);
						 flag_added=1;
						 return true;
					}
					else {
						Serbaguna y = list_serbaguna.get(list_serbaguna.indexOf(x)+1);
						if(y.getTahun().equals(temp.getTahun()) && y.getBulan().equals(temp.getBulan()) && y.getHari().equals(temp.getHari())) {
							int y_total_menit_mulai = y.getJam_mulai()*60 + y.getMenit_mulai();
							if(temp_total_menit_selesai <= y_total_menit_mulai) {
								 list_serbaguna.add(temp);
								 flag_added=1;
								 return true;
							}
						}
					}
				}
				else if(temp_total_menit_selesai <= x_total_menit_mulai) {
					if(list_serbaguna.indexOf(x) == 0) {
						 list_serbaguna.add(temp);
						 flag_added=1;
						 return true;
					}
					else {
						Serbaguna y = list_serbaguna.get(list_serbaguna.indexOf(x)-1);
						if(y.getTahun() == temp.getTahun() && y.getBulan() == temp.getBulan() && y.getHari() == temp.getHari()) {
							int y_total_menit_selesai = y.getJam_selesai()*60 + y.getMenit_selesai();
							if(temp_total_menit_selesai <= y_total_menit_selesai) {
								 list_serbaguna.add(temp);
								 flag_added=1;
								 return true;
							}
						}
					}
				}
			}
		}
		if(flag==0) {
			list_serbaguna.add(temp);
			flag_added=1;
			return true;
		}
		if(flag_added==0) {
			//Tempat untuk memasukkan pesan bahwa waktu yang dimasukkan tidak valid
			return false;
		}
		return false;
	}
	
	public boolean register_konfirmasi_pass(String pass1, String pass2) {
		if(pass1.equals(pass2)) {
			return true;
		}
		return false;
	}
	public boolean login_admin(String username, String password) {
		for(Admin x : list_admin) {
			if(x.login(username, password)) {
				return true;
			}
		}
		return false;
	}
	public boolean login_peminjam(String username, String password) {
		for(Peminjam x : list_peminjam) {
			if(x.login(username, password)) {
				curr_peminjam = x;
				return true;
			}
		}
		return false;
	}
	
	
	public boolean delete_admin_dapur(Integer number) {
		if(list_dapur.size()==0 || number<1 || number>list_dapur.size()) return false;
		list_dapur.remove(number-1);
		return true;
	}
	public boolean delete_admin_komunal(Integer number) {
		if(list_komunal.size()==0 || number<1 || number>list_komunal.size()) return false;
		list_komunal.remove(number-1);
		return true;
	}
	public boolean delete_admin_mesincuci(Integer number) {
		if(list_mesincuci.size()==0 || number<1 || number>list_mesincuci.size()) return false;
		list_mesincuci.remove(number-1);
		return true;
	}
	public boolean delete_admin_serbaguna(Integer number) {
		if(list_serbaguna.size()==0 || number<1 || number>list_serbaguna.size()) return false;
		list_serbaguna.remove(number-1);
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

	public Peminjam getCurr_peminjam() {
		return curr_peminjam;
	}

	public void setCurr_peminjam(Peminjam curr_peminjam) {
		this.curr_peminjam = curr_peminjam;
	}

	public ArrayList<Admin> getList_admin() {
		return list_admin;
	}

	public void setList_admin(ArrayList<Admin> list_admin) {
		this.list_admin = list_admin;
	}

	public ArrayList<Peminjam> getList_peminjam() {
		return list_peminjam;
	}

	public void setList_peminjam(ArrayList<Peminjam> list_peminjam) {
		this.list_peminjam = list_peminjam;
	}

	public ArrayList<Dapur> getList_dapur() {
		return list_dapur;
	}

	public void setList_dapur(ArrayList<Dapur> list_dapur) {
		this.list_dapur = list_dapur;
	}

	public ArrayList<Komunal> getList_komunal() {
		return list_komunal;
	}

	public void setList_komunal(ArrayList<Komunal> list_komunal) {
		this.list_komunal = list_komunal;
	}

	public ArrayList<Mesincuci> getList_mesincuci() {
		return list_mesincuci;
	}

	public void setList_mesincuci(ArrayList<Mesincuci> list_mesincuci) {
		this.list_mesincuci = list_mesincuci;
	}

	public ArrayList<Serbaguna> getList_serbaguna() {
		return list_serbaguna;
	}

	public void setList_serbaguna(ArrayList<Serbaguna> list_serbaguna) {
		this.list_serbaguna = list_serbaguna;
	}


	public void readFile() {
		File f  = new File("src/Main/laporan_peminjaman.txt");
		int count=0;
		int opening_count=0;
		int section=0;
		try {
			Scanner scan = new Scanner(f);
			while(scan.hasNextLine()) {
				String ts = scan.nextLine();
				if(opening_count<3) {
					opening_count++;
					continue;
				}
				else if(ts.length()==0) {
					continue;
				}
				else if(count<2) {
					if(ts.charAt(0)=='-') count++;
					continue;
				}
				else if(ts.charAt(0)=='-') {
					section++;
					count=0;
					continue;
				}
				
				if(section==0) {
					String[] ss = ts.split("\\s*\\|\\s*");
//					System.out.println(ss[0] + "dan" + ss[1]);
					String username = ss[0];
					String password = ss[1];
					list_admin.add(new Admin(username, password));
				}
				
				if(section==1) {
					String[] ss = ts.split("\\s*\\|\\s*");
//					System.out.println(ss[0]+"|"+ss[1]+"|"+ss[2]+"|"+ss[3]+"|"+ss[4]);
					String username = ss[0];
					String password = ss[1];
					String name = ss[2];
					String kelas = ss[3];
					String gender = ss[4];
					list_peminjam.add(new Peminjam(name, gender, kelas, username, password));
				}
				
				if(section==2) {
					String[] ss = ts.split("\\s*\\|\\s*");
					String[] tanggal = ss[0].split("/");
					int hari = Integer.parseInt(tanggal[0]);
					int bulan = Integer.parseInt(tanggal[1]);
					int tahun = Integer.parseInt(tanggal[2]);
					String[] mulai = ss[1].split(":");
					int jam_mulai = Integer.parseInt(mulai[0]);
					int menit_mulai = Integer.parseInt(mulai[1]);
					String[] selesai = ss[2].split(":");
					int jam_selesai = Integer.parseInt(selesai[0]);
					int menit_selesai = Integer.parseInt(selesai[1]);
					String name = ss[3];
					String kelas = ss[4];
					String gender = ss[5];
						int jml_tungku = Integer.parseInt(ss[6]);
						list_dapur.add(new Dapur(hari, bulan, tahun, jam_mulai, menit_mulai, jam_selesai, menit_selesai, name, kelas, gender, jml_tungku));
				}
				if(section==3) {
					String[] ss = ts.split("\\s*\\|\\s*");
					String[] tanggal = ss[0].split("/");
					int hari = Integer.parseInt(tanggal[0]);
					int bulan = Integer.parseInt(tanggal[1]);
					int tahun = Integer.parseInt(tanggal[2]);
					String[] mulai = ss[1].split(":");
					int jam_mulai = Integer.parseInt(mulai[0]);
					int menit_mulai = Integer.parseInt(mulai[1]);
					String[] selesai = ss[2].split(":");
					int jam_selesai = Integer.parseInt(selesai[0]);
					int menit_selesai = Integer.parseInt(selesai[1]);
					String name = ss[3];
					String kelas = ss[4];
					String gender = ss[5];
					int lantai = Integer.parseInt(ss[6]);
					list_komunal.add(new Komunal(hari, bulan, tahun, jam_mulai, menit_mulai, jam_selesai, menit_selesai, name, kelas, gender, lantai));
				}
				if(section==4) {
					String[] ss = ts.split("\\s*\\|\\s*");
					String[] tanggal = ss[0].split("/");
					int hari = Integer.parseInt(tanggal[0]);
					int bulan = Integer.parseInt(tanggal[1]);
					int tahun = Integer.parseInt(tanggal[2]);
					String[] mulai = ss[1].split(":");
					int jam_mulai = Integer.parseInt(mulai[0]);
					int menit_mulai = Integer.parseInt(mulai[1]);
					String[] selesai = ss[2].split(":");
					int jam_selesai = Integer.parseInt(selesai[0]);
					int menit_selesai = Integer.parseInt(selesai[1]);
					String name = ss[3];
					String kelas = ss[4];
					String gender = ss[5];
					int jml_mesin = Integer.parseInt(ss[6]);
					list_mesincuci.add(new Mesincuci(jml_mesin, hari, bulan, tahun, jam_mulai, menit_mulai, jam_selesai, menit_selesai, name, kelas, gender));
				}
				if(section==5) {
					String[] ss = ts.split("\\s*\\|\\s*");
					String[] tanggal = ss[0].split("/");
					int hari = Integer.parseInt(tanggal[0]);
					int bulan = Integer.parseInt(tanggal[1]);
					int tahun = Integer.parseInt(tanggal[2]);
					String[] mulai = ss[1].split(":");
					int jam_mulai = Integer.parseInt(mulai[0]);
					int menit_mulai = Integer.parseInt(mulai[1]);
					String[] selesai = ss[2].split(":");
					int jam_selesai = Integer.parseInt(selesai[0]);
					int menit_selesai = Integer.parseInt(selesai[1]);
					String name = ss[3];
					String kelas = ss[4];
					String gender = ss[5];
					String luas = ss[6];
 					list_serbaguna.add(new Serbaguna(luas, hari, bulan, tahun, jam_mulai, menit_mulai, jam_selesai, menit_selesai, name, kelas, gender));
				}
				
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void closeFile() {
	      try {
	          FileWriter file = new FileWriter("src/Main/laporan_peminjaman.txt");
	          
	          //header
	          file.write("-------------------------------\r\n"
	          		+ "LAPORAN PEMINJAMAN RUANGAN RTB\r\n"
	          		+ "-------------------------------\r\n"
	          		+ "");
	          
	          //list akun admin
	          file.write("\r\n"
	          		+ "LIST AKUN ADMIN\r\n"
	          		+ "-----------------------------------------\r\n"
	          		+ "Username            |Password\r\n"
	          		+ "-----------------------------------------\r\n");
	          
	          for(Admin x : list_admin) {
	        	  String akun_admin = String.format("%-20s|%s\n", x.getUsername(), x.getPassword());
	        	  file.write(akun_admin);
	          }
	          
	          file.write("-----------------------------------------\r\n");
	          
	          //list akun peminjam
	          file.write("\r\n"
	          		+ "LIST AKUN PEMINJAM\r\n"
	          		+ "----------------------------------------------------------------------------------------------\r\n"
	          		+ "Username            |Password            |Nama lengkap                  |Kelas     |Gender\r\n"
	          		+ "----------------------------------------------------------------------------------------------\r\n");
	          
	          for(Peminjam x : list_peminjam) {
	        	  String akun_peminjam = String.format("%-20s|%-20s|%-30s|%-10s|%s\r\n", x.getUsername(),x.getPassword(),x.getNama(),x.getKelas(),x.getGender());
	        	  file.write(akun_peminjam);
	          }
	          
	          file.write("----------------------------------------------------------------------------------------------\r\n");
	          
	          
	          //list peminjaman dapur
	          file.write("\r\n"
	          		+ "LIST PEMINJAMAN DAPUR\r\n"
	          		+ "------------------------------------------------------------------------------------------------\r\n"
	          		+ "Tanggal   |Jam mulai|Jam selesai|Nama                          |Kelas     |Gender    |Jml tungku\r\n"
	          		+ "------------------------------------------------------------------------------------------------\r\n");
	          
	          for(Dapur x : list_dapur) {
	        	  String tanggal = String.format("%d/%d/%d", x.getHari(),x.getBulan(),x.getTahun());
	        	  String mulai = String.format("%02d:%02d", x.getJam_mulai(),x.getMenit_mulai());
	        	  String selesai = String.format("%d:%d", x.getJam_selesai(),x.getMenit_selesai());
	        	  String peminjaman = String.format("%-10s|%-10s|%-10s|%-30s|%-10s|%-10s|%d\r\n", tanggal,mulai,selesai,x.getNama_peminjam(),x.getKelas_peminjam(),x.getGender_peminjam(),x.getJumlah_tungku());
	        	  file.write(peminjaman);
	          }
	          
	          file.write("------------------------------------------------------------------------------------------------\r\n");
	          
	          //list peminjaman komunal
	          file.write("\r\n"
		          		+ "LIST PEMINJAMAN KOMUNAL\r\n"
		          		+ "------------------------------------------------------------------------------------------------\r\n"
		          		+ "Tanggal   |Jam mulai|Jam selesai|Nama                          |Kelas     |Gender    |Lantai\r\n"
		          		+ "------------------------------------------------------------------------------------------------\r\n");
		          
		          for(Komunal x : list_komunal) {
		        	  String tanggal = String.format("%d/%d/%d", x.getHari(),x.getBulan(),x.getTahun());
		        	  String mulai = String.format("%02d:%02d", x.getJam_mulai(),x.getMenit_mulai());
		        	  String selesai = String.format("%d:%d", x.getJam_selesai(),x.getMenit_selesai());
		        	  String peminjaman = String.format("%-10s|%-10s|%-10s|%-30s|%-10s|%-10s|%d\r\n", tanggal,mulai,selesai,x.getNama_peminjam(),x.getKelas_peminjam(),x.getGender_peminjam(),x.getLantai());
		        	  file.write(peminjaman);
		          }
		          
		          file.write("------------------------------------------------------------------------------------------------\r\n");
	          
	          //list peminjaman mesin cuci
		          file.write("\r\n"
			          		+ "LIST PEMINJAMAN MESIN CUCI\r\n"
			          		+ "------------------------------------------------------------------------------------------------\r\n"
			          		+ "Tanggal   |Jam mulai|Jam selesai|Nama                          |Kelas     |Gender    |Jml mesin\r\n"
			          		+ "------------------------------------------------------------------------------------------------\r\n");
			          
			          for(Mesincuci x : list_mesincuci) {
			        	  String tanggal = String.format("%d/%d/%d", x.getHari(),x.getBulan(),x.getTahun());
			        	  String mulai = String.format("%02d:%02d", x.getJam_mulai(),x.getMenit_mulai());
			        	  String selesai = String.format("%d:%d", x.getJam_selesai(),x.getMenit_selesai());
			        	  String peminjaman = String.format("%-10s|%-10s|%-10s|%-30s|%-10s|%-10s|%d\r\n", tanggal,mulai,selesai,x.getNama_peminjam(),x.getKelas_peminjam(),x.getGender_peminjam(),x.getJumlah_mesin());
			        	  file.write(peminjaman);
			          }
			          
			          file.write("------------------------------------------------------------------------------------------------\r\n");
			          
	          //list peminjaman serbaguna
			          file.write("\r\n"
				          		+ "LIST PEMINJAMAN SERBAGUNA\r\n"
				          		+ "------------------------------------------------------------------------------------------------\r\n"
				          		+ "Tanggal   |Jam mulai|Jam selesai|Nama                          |Kelas     |Gender    |Luas\r\n"
				          		+ "------------------------------------------------------------------------------------------------\r\n");
				          
				          for(Serbaguna x : list_serbaguna) {
				        	  String tanggal = String.format("%d/%d/%d", x.getHari(),x.getBulan(),x.getTahun());
				        	  String mulai = String.format("%02d:%02d", x.getJam_mulai(),x.getMenit_mulai());
				        	  String selesai = String.format("%d:%d", x.getJam_selesai(),x.getMenit_selesai());
				        	  String peminjaman = String.format("%-10s|%-10s|%-10s|%-30s|%-10s|%-10s|%s\r\n", tanggal,mulai,selesai,x.getNama_peminjam(),x.getKelas_peminjam(),x.getGender_peminjam(),x.getLuas());
				        	  file.write(peminjaman);
				          }
				          
				          file.write("------------------------------------------------------------------------------------------------\r\n");
	          System.out.println("File tertulis");
	          file.close();
	       } catch (IOException e) {
	       }
	}
	
	public Main() {
		readFile();
		frame_welcome = new Frame_Welcome(this);
//		list_admin.add(new Admin("Udin", "Udon"));
		
		
	}
	

}