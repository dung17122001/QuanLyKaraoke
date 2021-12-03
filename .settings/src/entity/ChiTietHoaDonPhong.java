package entity;

import java.sql.Time;

public class ChiTietHoaDonPhong {
	private HoaDon hoaDon;
	private Phong phong;
	private Time gioVao;
	private Time gioRa;
	
	public ChiTietHoaDonPhong() {
		// TODO Auto-generated constructor stub
	}

	public ChiTietHoaDonPhong(HoaDon hoaDon, Phong phong, Time gioVao, Time gioRa) {
		super();
		this.hoaDon = hoaDon;
		this.phong = phong;
		this.gioVao = gioVao;
		this.gioRa = gioRa;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}

	public Time getGioVao() {
		return gioVao;
	}

	public void setGioVao(Time gioVao) {
		this.gioVao = gioVao;
	}

	public Time getGioRa() {
		return gioRa;
	}

	public void setGioRa(Time gioRa) {
		this.gioRa = gioRa;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDonPhong [hoaDon=" + hoaDon + ", phong=" + phong + ", gioVao=" + gioVao + ", gioRa=" + gioRa
				+ "]";
	}

	
	
}
