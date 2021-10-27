package entity;

import java.util.Date;

public class HoaDon {
	
	private String maHoaDon;
	private Date ngayLap;
	private String trangThai;
	private String gioVao;
	private String gioRa;
	private String maPhong;
	private String maNhanVien;
	private String maKhachHang;
	
	public HoaDon(String maHoaDon, Date ngayLap, String trangThai, String gioVao, String gioRa, String maPhong,
			String maNhanVien, String maKhachHang) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLap = ngayLap;
		this.trangThai = trangThai;
		this.gioVao = gioVao;
		this.gioRa = gioRa;
		this.maPhong = maPhong;
		this.maNhanVien = maNhanVien;
		this.maKhachHang = maKhachHang;
	}

	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayLap=" + ngayLap + ", trangThai=" + trangThai + ", gioVao="
				+ gioVao + ", gioRa=" + gioRa + ", maPhong=" + maPhong + ", maNhanVien=" + maNhanVien + ", maKhachHang="
				+ maKhachHang + "]";
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

	public String getGioVao() {
		return gioVao;
	}

	public void setGioVao(String gioVao) {
		this.gioVao = gioVao;
	}

	public String getGioRa() {
		return gioRa;
	}

	public void setGioRa(String gioRa) {
		this.gioRa = gioRa;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gioRa == null) ? 0 : gioRa.hashCode());
		result = prime * result + ((gioVao == null) ? 0 : gioVao.hashCode());
		result = prime * result + ((maHoaDon == null) ? 0 : maHoaDon.hashCode());
		result = prime * result + ((maKhachHang == null) ? 0 : maKhachHang.hashCode());
		result = prime * result + ((maNhanVien == null) ? 0 : maNhanVien.hashCode());
		result = prime * result + ((maPhong == null) ? 0 : maPhong.hashCode());
		result = prime * result + ((ngayLap == null) ? 0 : ngayLap.hashCode());
		result = prime * result + ((trangThai == null) ? 0 : trangThai.hashCode());
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
		HoaDon other = (HoaDon) obj;
		if (gioRa == null) {
			if (other.gioRa != null)
				return false;
		} else if (!gioRa.equals(other.gioRa))
			return false;
		if (gioVao == null) {
			if (other.gioVao != null)
				return false;
		} else if (!gioVao.equals(other.gioVao))
			return false;
		if (maHoaDon == null) {
			if (other.maHoaDon != null)
				return false;
		} else if (!maHoaDon.equals(other.maHoaDon))
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
		if (ngayLap == null) {
			if (other.ngayLap != null)
				return false;
		} else if (!ngayLap.equals(other.ngayLap))
			return false;
		if (trangThai == null) {
			if (other.trangThai != null)
				return false;
		} else if (!trangThai.equals(other.trangThai))
			return false;
		return true;
	}
	
	
}
