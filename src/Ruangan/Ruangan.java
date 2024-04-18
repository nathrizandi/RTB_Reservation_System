package Ruangan;


public class Ruangan {
	protected Integer hari;
	protected Integer bulan;
	protected Integer tahun;
	protected Integer jam_mulai;
	protected Integer menit_mulai;
	protected Integer jam_selesai;
	protected Integer menit_selesai;
	protected String nama_peminjam;
	protected String kelas_peminjam;
	protected String gender_peminjam;
	
	public void print_ruangan(){
		//tempat print list ruangan
		System.out.print("Hari : " + hari +" Bulan : "+  bulan + " Tahun : " + tahun + " Jam Mulai : " + jam_mulai + ":" + menit_mulai + " Jam selesai : " + jam_selesai + ":" + menit_selesai);
	}
	
	public Ruangan() {
		// TODO Auto-generated constructor stub
	}

	public Ruangan(Integer hari, Integer bulan, Integer tahun, Integer jam_mulai, Integer menit_mulai,
			Integer jam_selesai, Integer menit_selesai, String nama_peminjam, String kelas_peminjam,
			String gender_peminjam) {
		super();
		this.hari = hari;
		this.bulan = bulan;
		this.tahun = tahun;
		this.jam_mulai = jam_mulai;
		this.menit_mulai = menit_mulai;
		this.jam_selesai = jam_selesai;
		this.menit_selesai = menit_selesai;
		this.nama_peminjam = nama_peminjam;
		this.kelas_peminjam = kelas_peminjam;
		this.gender_peminjam = gender_peminjam;
	}

	public Integer getHari() {
		return hari;
	}

	public void setHari(Integer hari) {
		this.hari = hari;
	}

	public Integer getBulan() {
		return bulan;
	}

	public void setBulan(Integer bulan) {
		this.bulan = bulan;
	}

	public Integer getTahun() {
		return tahun;
	}

	public void setTahun(Integer tahun) {
		this.tahun = tahun;
	}

	public Integer getJam_mulai() {
		return jam_mulai;
	}

	public void setJam_mulai(Integer jam_mulai) {
		this.jam_mulai = jam_mulai;
	}

	public Integer getMenit_mulai() {
		return menit_mulai;
	}

	public void setMenit_mulai(Integer menit_mulai) {
		this.menit_mulai = menit_mulai;
	}

	public Integer getJam_selesai() {
		return jam_selesai;
	}

	public void setJam_selesai(Integer jam_selesai) {
		this.jam_selesai = jam_selesai;
	}

	public Integer getMenit_selesai() {
		return menit_selesai;
	}

	public void setMenit_selesai(Integer menit_selesai) {
		this.menit_selesai = menit_selesai;
	}

	public String getNama_peminjam() {
		return nama_peminjam;
	}

	public void setNama_peminjam(String nama_peminjam) {
		this.nama_peminjam = nama_peminjam;
	}

	public String getKelas_peminjam() {
		return kelas_peminjam;
	}

	public void setKelas_peminjam(String kelas_peminjam) {
		this.kelas_peminjam = kelas_peminjam;
	}

	public String getGender_peminjam() {
		return gender_peminjam;
	}

	public void setGender_peminjam(String gender_peminjam) {
		this.gender_peminjam = gender_peminjam;
	}
	
	
}

