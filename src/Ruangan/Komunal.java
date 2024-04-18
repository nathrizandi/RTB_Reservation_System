package Ruangan;


public class Komunal extends Ruangan{
	private Integer lantai;
	
	public Komunal() {
		// TODO Auto-generated constructor stub
	}

	public Integer getLantai() {
		return lantai;
	}

	public void setLantai(Integer lantai) {
		this.lantai = lantai;
	}

	public Komunal(Integer hari, Integer bulan, Integer tahun, Integer jam_mulai, Integer menit_mulai,
			Integer jam_selesai, Integer menit_selesai, String nama_peminjam, String kelas_peminjam,
			String gender_peminjam, Integer lantai) {
		super(hari, bulan, tahun, jam_mulai, menit_mulai, jam_selesai, menit_selesai, nama_peminjam, kelas_peminjam,
				gender_peminjam);
		this.lantai = lantai;
		// TODO Auto-generated constructor stub
	}
	
	
}
