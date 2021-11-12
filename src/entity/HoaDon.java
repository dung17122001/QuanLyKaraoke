package entity;


import java.sql.Date;
import java.util.Objects;

public class HoaDon {
	
	private String maHoaDon;
	private Date ngayLap;
	private String trangThai;
	private KhachHang KhachHang;
	private NhanVien NhanVien;
	
	public HoaDon() {
		// TODO Auto-generated constructor stub
	}

	public HoaDon(String maHoaDon, Date ngayLap, String trangThai, entity.KhachHang khachHang,
			entity.NhanVien nhanVien) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLap = ngayLap;
		this.trangThai = trangThai;
		KhachHang = khachHang;
		NhanVien = nhanVien;
	}
	
	public HoaDon(String maHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public KhachHang getKhachHang() {
		return KhachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		KhachHang = khachHang;
	}

	public NhanVien getNhanVien() {
		return NhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		NhanVien = nhanVien;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maHoaDon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(maHoaDon, other.maHoaDon);
	}

	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayLap=" + ngayLap + ", trangThai=" + trangThai + ", KhachHang="
				+ KhachHang + ", NhanVien=" + NhanVien + "]";
	}
	
	
	
}
