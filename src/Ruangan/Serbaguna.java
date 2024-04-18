package Ruangan;


public class Serbaguna extends Ruangan{
	private String luas;
	
	public Serbaguna() {
		// TODO Auto-generated constructor stub
	}

	public Serbaguna(String luas, Integer hari, Integer bulan, Integer tahun, Integer jam_mulai, Integer menit_mulai,
			Integer jam_selesai, Integer menit_selesai, String nama_peminjam, String kelas_peminjam,
			String gender_peminjam) {
		super(hari, bulan, tahun, jam_mulai, menit_mulai, jam_selesai, menit_selesai, nama_peminjam, kelas_peminjam,
				gender_peminjam);
		// TODO Auto-generated constructor stub
		this.luas = luas;
	}

	public String getLuas() {
		return luas;
	}

	public void setLuas(String luas) {
		this.luas = luas;
	}
	
	
	
	
}
