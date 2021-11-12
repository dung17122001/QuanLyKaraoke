package entity;


import java.sql.Date;
import java.util.Objects;

public class DonDatPhong {

	private String maDonDatPhong;
	private Date thoiGianDat;
	private KhachHang khachHang;
	private NhanVien nhanVien;
	
	public DonDatPhong() {
		// TODO Auto-generated constructor stub
	}

	public DonDatPhong(String maDonDatPhong, Date thoiGianDat, KhachHang khachHang, NhanVien nhanVien) {
		super();
		this.maDonDatPhong = maDonDatPhong;
		this.thoiGianDat = thoiGianDat;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
	}

	public String getMaDonDatPhong() {
		return maDonDatPhong;
	}

	public void setMaDonDatPhong(String maDonDatPhong) {
		this.maDonDatPhong = maDonDatPhong;
	}

	public Date getThoiGianDat() {
		return thoiGianDat;
	}

	public void setThoiGianDat(Date thoiGianDat) {
		this.thoiGianDat = thoiGianDat;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maDonDatPhong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DonDatPhong other = (DonDatPhong) obj;
		return Objects.equals(maDonDatPhong, other.maDonDatPhong);
	}

	@Override
	public String toString() {
		return "DonDatPhong [maDonDatPhong=" + maDonDatPhong + ", thoiGianDat=" + thoiGianDat + ", khachHang="
				+ khachHang + ", nhanVien=" + nhanVien + "]";
	}

	
}