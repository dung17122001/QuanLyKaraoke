package entity;

import java.util.Date;

public class HoaDon {
	
	private String maHoaDon;
	private Date ngayLap;
	private String trangThai;
	private String gioVao;
	private String gioRa;
	private Phong Phong;
	private NhanVien NhanVien;
	private KhachHang KhachHang;
	
	public HoaDon(String maHoaDon, Date ngayLap, String trangThai, String gioVao, String gioRa, entity.Phong phong,
			entity.NhanVien nhanVien, entity.KhachHang khachHang) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLap = ngayLap;
		this.trangThai = trangThai;
		this.gioVao = gioVao;
		this.gioRa = gioRa;
		Phong = phong;
		NhanVien = nhanVien;
		KhachHang = khachHang;
	}

	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayLap=" + ngayLap + ", trangThai=" + trangThai + ", gioVao="
				+ gioVao + ", gioRa=" + gioRa + ", Phong=" + Phong + ", NhanVien=" + NhanVien + ", KhachHang="
				+ KhachHang + "]";
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

	public Phong getPhong() {
		return Phong;
	}

	public void setPhong(Phong phong) {
		Phong = phong;
	}

	public NhanVien getNhanVien() {
		return NhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		NhanVien = nhanVien;
	}

	public KhachHang getKhachHang() {
		return KhachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		KhachHang = khachHang;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((KhachHang == null) ? 0 : KhachHang.hashCode());
		result = prime * result + ((NhanVien == null) ? 0 : NhanVien.hashCode());
		result = prime * result + ((Phong == null) ? 0 : Phong.hashCode());
		result = prime * result + ((gioRa == null) ? 0 : gioRa.hashCode());
		result = prime * result + ((gioVao == null) ? 0 : gioVao.hashCode());
		result = prime * result + ((maHoaDon == null) ? 0 : maHoaDon.hashCode());
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
		if (KhachHang == null) {
			if (other.KhachHang != null)
				return false;
		} else if (!KhachHang.equals(other.KhachHang))
			return false;
		if (NhanVien == null) {
			if (other.NhanVien != null)
				return false;
		} else if (!NhanVien.equals(other.NhanVien))
			return false;
		if (Phong == null) {
			if (other.Phong != null)
				return false;
		} else if (!Phong.equals(other.Phong))
			return false;
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
