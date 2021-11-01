package entity;

public class LoaiPhong {
	
	private String maLoaiPhong;
	private String tenLoai;
	private String moTa;
	
	public LoaiPhong(String maLoaiPhong, String tenLoai, String moTa) {
		super();
		this.maLoaiPhong = maLoaiPhong;
		this.tenLoai = tenLoai;
		this.moTa = moTa;
	}

	@Override
	public String toString() {
		return "LoaiPhong [maLoaiPhong=" + maLoaiPhong + ", tenLoai=" + tenLoai + ", moTa=" + moTa + "]";
	}

	public String getMaLoaiPhong() {
		return maLoaiPhong;
	}

	public void setMaLoaiPhong(String maLoaiPhong) {
		this.maLoaiPhong = maLoaiPhong;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maLoaiPhong == null) ? 0 : maLoaiPhong.hashCode());
		result = prime * result + ((moTa == null) ? 0 : moTa.hashCode());
		result = prime * result + ((tenLoai == null) ? 0 : tenLoai.hashCode());
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
		LoaiPhong other = (LoaiPhong) obj;
		if (maLoaiPhong == null) {
			if (other.maLoaiPhong != null)
				return false;
		} else if (!maLoaiPhong.equals(other.maLoaiPhong))
			return false;
		if (moTa == null) {
			if (other.moTa != null)
				return false;
		} else if (!moTa.equals(other.moTa))
			return false;
		if (tenLoai == null) {
			if (other.tenLoai != null)
				return false;
		} else if (!tenLoai.equals(other.tenLoai))
			return false;
		return true;
	}
	
	
}
