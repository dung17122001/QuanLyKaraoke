package entity;

import java.util.Date;

public class DonDatPhong {

	private String maDonDatPhong;
	private Date thoiGianDat;
	private String maPhong;
	private String maKhachHang;
	private String maNhanVien;
	
	public DonDatPhong(String maDonDatPhong, Date thoiGianDat, String maPhong, String maKhachHang, String maNhanVien) {
		super();
		this.maDonDatPhong = maDonDatPhong;
		this.thoiGianDat = thoiGianDat;
		this.maPhong = maPhong;
		this.maKhachHang = maKhachHang;
		this.maNhanVien = maNhanVien;
	}

	@Override
	public String toString() {
		return "DonDatPhong [maDonDatPhong=" + maDonDatPhong + ", thoiGianDat=" + thoiGianDat + ", maPhong=" + maPhong
				+ ", maKhachHang=" + maKhachHang + ", maNhanVien=" + maNhanVien + "]";
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

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maDonDatPhong == null) ? 0 : maDonDatPhong.hashCode());
		result = prime * result + ((maKhachHang == null) ? 0 : maKhachHang.hashCode());
		result = prime * result + ((maNhanVien == null) ? 0 : maNhanVien.hashCode());
		result = prime * result + ((maPhong == null) ? 0 : maPhong.hashCode());
		result = prime * result + ((thoiGianDat == null) ? 0 : thoiGianDat.hashCode());
		return result;
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
		if (maDonDatPhong == null) {
			if (other.maDonDatPhong != null)
				return false;
		} else if (!maDonDatPhong.equals(other.maDonDatPhong))
			return false;
		if (maKhachHang == null) {
			if (other.maKhachHang != null)
				return false;
		} else if (!maKhachHang.equals(other.maKhachHang))
			return false;
		if (maNhanVien == null) {
			if (other.maNhanVien != null)
				return false;
		} else if (!maNhanVien.equals(other.maNhanVien))
			return false;
		if (maPhong == null) {
			if (other.maPhong != null)
				return false;
		} else if (!maPhong.equals(other.maPhong))
			return false;
		if (thoiGianDat == null) {
			if (other.thoiGianDat != null)
				return false;
		} else if (!thoiGianDat.equals(other.thoiGianDat))
			return false;
		return true;
	}
	
	
}
