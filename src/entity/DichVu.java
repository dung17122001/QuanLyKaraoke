package entity;

import java.util.Objects;

public class DichVu {
	
	private String maDichVu;
	private String tenDichVu;
	private String donVi;
	private double giaTien;
	private LoaiDichVu LoaiDichVu;
	
	public DichVu(String maDichVu, String tenDichVu, String donVi, double giaTien, entity.LoaiDichVu loaiDichVu) {
		super();
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;
		this.donVi = donVi;
		this.giaTien = giaTien;
		LoaiDichVu = loaiDichVu;
	}

	public DichVu() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DichVu [maDichVu=" + maDichVu + ", tenDichVu=" + tenDichVu + ", donVi=" + donVi + ", giaTien=" + giaTien
				+ ", LoaiDichVu=" + LoaiDichVu + "]";
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

	public String getDonVi() {
		return donVi;
	}

	public void setDonVi(String donVi) {
		this.donVi = donVi;
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((LoaiDichVu == null) ? 0 : LoaiDichVu.hashCode());
		result = prime * result + ((donVi == null) ? 0 : donVi.hashCode());
		long temp;
		temp = Double.doubleToLongBits(giaTien);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((maDichVu == null) ? 0 : maDichVu.hashCode());
		result = prime * result + ((tenDichVu == null) ? 0 : tenDichVu.hashCode());
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
		DichVu other = (DichVu) obj;
		if (LoaiDichVu == null) {
			if (other.LoaiDichVu != null)
				return false;
		} else if (!LoaiDichVu.equals(other.LoaiDichVu))
			return false;
		if (donVi == null) {
			if (other.donVi != null)
				return false;
		} else if (!donVi.equals(other.donVi))
			return false;
		if (Double.doubleToLongBits(giaTien) != Double.doubleToLongBits(other.giaTien))
			return false;
		if (maDichVu == null) {
			if (other.maDichVu != null)
				return false;
		} else if (!maDichVu.equals(other.maDichVu))
			return false;
		if (tenDichVu == null) {
			if (other.tenDichVu != null)
				return false;
		} else if (!tenDichVu.equals(other.tenDichVu))
			return false;
		return true;
	}
	
	
	
	
}
