package entity;


import java.util.Objects;

import connect.ConnectDB;
import dao.DAO_DichVu;


public class DichVu {
	
	private String maDichVu;
	private String tenDichVu;
	private double giaTien;
	private LoaiDichVu LoaiDichVu;
	
	public DichVu(String maDichVu, String tenDichVu, double giaTien, LoaiDichVu loaiDichVu) {
		super();
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;
		this.giaTien = giaTien;
		LoaiDichVu = loaiDichVu;
	}
	
	public DichVu() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "DichVu [maDichVu=" + maDichVu + ", tenDichVu=" + tenDichVu + ", giaTien=" + giaTien + ", LoaiDichVu="
				+ LoaiDichVu + "]";
	}

	public String getMaDichVu() {
		return maDichVu;
	}

	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}

	public String getTenDichVu() {
		return tenDichVu;
	}

	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}

	public double getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(double giaTien) {
		this.giaTien = giaTien;
	}

	public LoaiDichVu getLoaiDichVu() {
		return LoaiDichVu;
	}

	public void setLoaiDichVu(LoaiDichVu loaiDichVu) {
		LoaiDichVu = loaiDichVu;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maDichVu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DichVu other = (DichVu) obj;
		return Objects.equals(maDichVu, other.maDichVu);
	}

	
	
	
}
