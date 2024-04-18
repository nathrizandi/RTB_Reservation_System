package Akun;

public class Peminjam extends Akun{
	private String nama;
	private String gender;
	private String kelas;
	
	public Peminjam() {
		// TODO Auto-generated constructor stub
	}

	public Peminjam(String nama, String gender, String kelas) {
		super();
		this.nama = nama;
		this.gender = gender;
		this.kelas = kelas;
	}

	public Peminjam(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}
	
	public Peminjam(String nama, String gender, String kelas, String username, String password) {
		super(username, password);
		this.nama = nama;
		this.gender = gender;
		this.kelas = kelas;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getKelas() {
		return kelas;
	}

	public void setKelas(String kelas) {
		this.kelas = kelas;
	}
	
	
	
	
	
}
