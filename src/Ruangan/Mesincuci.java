package Ruangan;


public class Mesincuci extends Ruangan{
	private Integer jumlah_mesin;
	
	public Mesincuci() {
		// TODO Auto-generated constructor stub
	}
	
	public Mesincuci(Integer jumlah_mesin, Integer hari, Integer bulan, Integer tahun, Integer jam_mulai, Integer menit_mulai,
			Integer jam_selesai, Integer menit_selesai, String nama_peminjam, String kelas_peminjam,
			String gender_peminjam) {
		super(hari, bulan, tahun, jam_mulai, menit_mulai, jam_selesai, menit_selesai, nama_peminjam, kelas_peminjam,
				gender_peminjam);
		this.jumlah_mesin = jumlah_mesin;
		// TODO Auto-generated constructor stub
	}

	public Integer getJumlah_mesin() {
		return jumlah_mesin;
	}

	public void setJumlah_mesin(Integer jumlah_mesin) {
		this.jumlah_mesin = jumlah_mesin;
	}
	
	
	
}
