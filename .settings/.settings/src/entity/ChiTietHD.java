package entity;

public class ChiTietHD {

		private String maHoaDon;
		private String maDichVu;
		private String soLuong;
		
		public ChiTietHD(String maHoaDon, String maDichVu, String soLuong) {
			super();
			this.maHoaDon = maHoaDon;
			this.maDichVu = maDichVu;
			this.soLuong = soLuong;
		}

		@Override
		public String toString() {
			return "ChiTietHD [maHoaDon=" + maHoaDon + ", maDichVu=" + maDichVu + ", soLuong=" + soLuong + "]";
		}

		public String getMaHoaDon() {
			return maHoaDon;
		}

		public void setMaHoaDon(String maHoaDon) {
			this.maHoaDon = maHoaDon;
		}

		public String getMaDichVu() {
			return maDichVu;
		}

		public void setMaDichVu(String maDichVu) {
			this.maDichVu = maDichVu;
		}

		public String getSoLuong() {
			return soLuong;
		}

		public void setSoLuong(String soLuong) {
			this.soLuong = soLuong;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((maDichVu == null) ? 0 : maDichVu.hashCode());
			result = prime * result + ((maHoaDon == null) ? 0 : maHoaDon.hashCode());
			result = prime * result + ((soLuong == null) ? 0 : soLuong.hashCode());
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
			ChiTietHD other = (ChiTietHD) obj;
			if (maDichVu == null) {
				if (other.maDichVu != null)
					return false;
			} else if (!maDichVu.equals(other.maDichVu))
				return false;
			if (maHoaDon == null) {
				if (other.maHoaDon != null)
					return false;
			} else if (!maHoaDon.equals(other.maHoaDon))
				return false;
			if (soLuong == null) {
				if (other.soLuong != null)
					return false;
			} else if (!soLuong.equals(other.soLuong))
				return false;
			return true;
		}
		
		
}
