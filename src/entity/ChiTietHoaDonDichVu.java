package entity;

public class ChiTietHoaDonDichVu {
	private HoaDon hoaDon;
	private DichVu dichVu;
	private int soLuong;
	
	public ChiTietHoaDonDichVu() {
		// TODO Auto-generated constructor stub
	}

	public ChiTietHoaDonDichVu(HoaDon hoaDon, DichVu dichVu, int soLuong) {
		super();
		this.hoaDon = hoaDon;
		this.dichVu = dichVu;
		this.soLuong = soLuong;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public DichVu getDichVu() {
		return dichVu;
	}

	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDonDichVu [hoaDon=" + hoaDon + ", dichVu=" + dichVu + ", soLuong=" + soLuong + "]";
	}
	
}
