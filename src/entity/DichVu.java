package entity;

public class DichVu {
	
	private String maDichVu;
	private String tenDichVu;
	private String giaTien;
	private String maLoaiDV;
	
	public DichVu(String maDichVu, String tenDichVu, String giaTien, String maLoaiDV) {
		super();
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;
		this.giaTien = giaTien;
		this.maLoaiDV = maLoaiDV;
	}

	@Override
	public String toString() {
		return "DichVu [maDichVu=" + maDichVu + ", tenDichVu=" + tenDichVu + ", giaTien=" + giaTien + ", maLoaiDV="
				+ maLoaiDV + "]";
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

	public String getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(String giaTien) {
		this.giaTien = giaTien;
	}

	public String getMaLoaiDV() {
		return maLoaiDV;
	}

	public void setMaLoaiDV(String maLoaiDV) {
		this.maLoaiDV = maLoaiDV;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((giaTien == null) ? 0 : giaTien.hashCode());
		result = prime * result + ((maDichVu == null) ? 0 : maDichVu.hashCode());
		result = prime * result + ((maLoaiDV == null) ? 0 : maLoaiDV.hashCode());
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
		if (giaTien == null) {
			if (other.giaTien != null)
				return false;
		} else if (!giaTien.equals(other.giaTien))
			return false;
		if (maDichVu == null) {
			if (other.maDichVu != null)
				return false;
		} else if (!maDichVu.equals(other.maDichVu))
			return false;
		if (maLoaiDV == null) {
			if (other.maLoaiDV != null)
				return false;
		} else if (!maLoaiDV.equals(other.maLoaiDV))
			return false;
		if (tenDichVu == null) {
			if (other.tenDichVu != null)
				return false;
		} else if (!tenDichVu.equals(other.tenDichVu))
			return false;
		return true;
	}
	
	
}
