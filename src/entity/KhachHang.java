package entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

import connect.ConnectDB;
import dao.DAO_KhachHang;

public class KhachHang {
	
	private String maKhachHang;
	private String tenKhachHang;
	private String diaChi;
	private String soDienThoai;
	private String soCMND;
	
	public KhachHang(String maKhachHang, String tenKhachHang, String diaChi, String soDienThoai, String soCMND) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.soCMND = soCMND;
	}

	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", diaChi=" + diaChi
				+ ", soDienThoai=" + soDienThoai + ", soCMND=" + soCMND + "]";
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getSoCMND() {
		return soCMND;
	}

	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diaChi == null) ? 0 : diaChi.hashCode());
		result = prime * result + ((maKhachHang == null) ? 0 : maKhachHang.hashCode());
		result = prime * result + ((soCMND == null) ? 0 : soCMND.hashCode());
		result = prime * result + ((soDienThoai == null) ? 0 : soDienThoai.hashCode());
		result = prime * result + ((tenKhachHang == null) ? 0 : tenKhachHang.hashCode());
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
		KhachHang other = (KhachHang) obj;
		if (diaChi == null) {
			if (other.diaChi != null)
				return false;
		} else if (!diaChi.equals(other.diaChi))
			return false;
		if (maKhachHang == null) {
			if (other.maKhachHang != null)
				return false;
		} else if (!maKhachHang.equals(other.maKhachHang))
			return false;
		if (soCMND == null) {
			if (other.soCMND != null)
				return false;
		} else if (!soCMND.equals(other.soCMND))
			return false;
		if (soDienThoai == null) {
			if (other.soDienThoai != null)
				return false;
		} else if (!soDienThoai.equals(other.soDienThoai))
			return false;
		if (tenKhachHang == null) {
			if (other.tenKhachHang != null)
				return false;
		} else if (!tenKhachHang.equals(other.tenKhachHang))
			return false;
		return true;
	}
	
	
}
