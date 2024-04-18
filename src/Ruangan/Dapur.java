package Ruangan;


public class Dapur extends Ruangan{
	private Integer jumlah_tungku;
	
	public Dapur() {
		// TODO Auto-generated constructor stub
	}
	
	public Dapur(Integer hari, Integer bulan, Integer tahun, Integer jam_mulai, Integer menit_mulai,
			Integer jam_selesai, Integer menit_selesai, String nama_peminjam, String kelas_peminjam,
			String gender_peminjam, Integer jumlah_tungku) {
		super(hari, bulan, tahun, jam_mulai, menit_mulai, jam_selesai, menit_selesai, nama_peminjam, kelas_peminjam,
				gender_peminjam);
		this.jumlah_tungku = jumlah_tungku;
	}

	public Integer getJumlah_tungku() {
		return jumlah_tungku;
	}

	public void setJumlah_tungku(Integer jumlah_tungku) {
		this.jumlah_tungku = jumlah_tungku;
	}
	
	
}
