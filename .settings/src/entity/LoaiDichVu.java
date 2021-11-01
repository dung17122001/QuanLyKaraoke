package entity;

public class LoaiDichVu {
	
	private String maLoai;
	private String tenLoaiDV;
	
	public LoaiDichVu(String maLoai, String tenLoaiDV) {
		super();
		this.maLoai = maLoai;
		this.tenLoaiDV = tenLoaiDV;
	}

	@Override
	public String toString() {
		return "LoaiDichVu [maLoai=" + maLoai + ", tenLoaiDV=" + tenLoaiDV + "]";
	}

	public String getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}

	public String getTenLoaiDV() {
		return tenLoaiDV;
	}

	public void setTenLoaiDV(String tenLoaiDV) {
		this.tenLoaiDV = tenLoaiDV;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maLoai == null) ? 0 : maLoai.hashCode());
		result = prime * result + ((tenLoaiDV == null) ? 0 : tenLoaiDV.hashCode());
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
		LoaiDichVu other = (LoaiDichVu) obj;
		if (maLoai == null) {
			if (other.maLoai != null)
				return false;
		} else if (!maLoai.equals(other.maLoai))
			return false;
		if (tenLoaiDV == null) {
			if (other.tenLoaiDV != null)
				return false;
		} else if (!tenLoaiDV.equals(other.tenLoaiDV))
			return false;
		return true;
	}
	
	
}
