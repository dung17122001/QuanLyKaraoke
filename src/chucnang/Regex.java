package chucnang;

import java.io.Serializable;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class Regex implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean RegexDiaChi(JTextField txtDiaChi2) {
		String input = txtDiaChi2.getText();
		String regex = "^([ A-Za-z0-9,.a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]*(\\s?))+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (!matcher.find()) {
			JOptionPane.showMessageDialog(null, "Nhập sai địa chỉ (Ví dụ nhập:56a Cầu Xéo, Tân quí, Tân Phú");
			txtDiaChi2.requestFocus();
			txtDiaChi2.selectAll();
			return true;
		} else
			return false;
	}

	public boolean kiemTraTuoi(JDateChooser modelNgay) {
		long millis = System.currentTimeMillis();
		Date today = new Date(millis);
		Date ngaySinh = (Date) modelNgay.getDate();
		if (ngaySinh.compareTo(today) > 0) {
			JOptionPane.showMessageDialog(null, "Dữ liệu tuổi không hợp lệ phải trước ngày hiện tại");
			return true;
		} else
			return false;

	}

	public boolean RegexTen(JTextField txtTen2) {
		String input = txtTen2.getText();
		String regex = "^([ A-Za-za-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]*(\\s?))+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (!matcher.find()) {
			JOptionPane.showMessageDialog(null, "Nhập sai tên (Ví dụ nhập:Nguyễn Văn A)");
			txtTen2.requestFocus();
			txtTen2.selectAll();
			return true;
		} else
			return false;
	}

	public boolean RegexMaNV(JTextField txtMa2) {
		String input = txtMa2.getText();
		String regex = "^[N][V][0-9]{3}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (!matcher.find()) {
			JOptionPane.showMessageDialog(null, "Nhập sai mã (Ví dụ nhập:NV1234 )");
			txtMa2.requestFocus();
			txtMa2.selectAll();
			return true;
		} else
			return false;
	}
	public boolean RegexMaNCC(JTextField txtMa2) {
		String input = txtMa2.getText();
		String regex = "^[N][C][C][0-9]{3}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (!matcher.find()) {
			JOptionPane.showMessageDialog(null, "Nhập sai mã (Ví dụ nhập:NCC234 )");
			txtMa2.requestFocus();
			txtMa2.selectAll();
			return true;
		} else
			return false;
	}
	public boolean kiemTraRong(JTextField txt) {
		if (txt.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Dữ liệu không được để trống");
			txt.requestFocus();
			return true;
		}
		return false;
	}
	public boolean kiemTraRongTen(JTextField txt) {
		if (txt.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Tên không được để trống");
			txt.requestFocus();
			return true;
		}
		return false;
	}
	public boolean kiemTraNS(JDateChooser ngaysinh) {
		if (ngaysinh.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Ngày sinh không được để trống");
			ngaysinh.requestFocus();
			return true;
		}
		return false;
	}
	public boolean kiemTraGiaPhong(JTextField txtTuoi2) {
		try {
			int x = Integer.parseInt(txtTuoi2.getText());
			if (x < 0) {
				JOptionPane.showMessageDialog(null, "Nhập sai dữ liệu lương (Phải lớn hơn 0)");
				return true;
			}
			return false;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Nhập sai kiểu dữ liệu giá phòng (phải nhập số)");
			return true;
		}
	}

	public boolean RegexSDT(JTextField txtSDT) {
		String input = txtSDT.getText();
		String regex = "^[0-9]{9,12}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (!matcher.find()) {
			JOptionPane.showMessageDialog(null, "Nhập sai định dạng số điện thoại hoặc CMND (Ví dụ nhập:0987654321/312477543");
			txtSDT.requestFocus();
			txtSDT.selectAll();
			return true;
		} else
			return false;
	}
	
//	SỐ LƯỢNG
	public boolean regexSoLuong(JTextField txtSoluong) {
		String input = txtSoluong.getText();
		String regex = "^[0-9]+$";
		if(!input.matches(regex))
		{	JOptionPane.showMessageDialog(null, "Số lượng phải là số nguyên và lớn hơn 0 (ví dụ nhập: 1000)");
			txtSoluong.requestFocus();
			txtSoluong.selectAll();
			return true;
		}
		return false;
		
	}
}