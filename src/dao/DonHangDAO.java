package dao;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import model.ConnectToDatabase;
import model.DonHang;
import model.TaiKhoan;

public class DonHangDAO {
Map<String, DonHang> mapDonHang=loadData();

public DonHangDAO() {
	super();
}

private Map<String, DonHang> loadData() {
	Map<String, DonHang> mapTemp= new HashMap<>();

		try {
			ResultSet resultSet = new ConnectToDatabase().selectData("select * from donhang");
			while (resultSet.next()) {
				String maDonHang= resultSet.getString(1);
				String tenKhachHang= resultSet.getString(2);
				String danhSachMaSanPham= resultSet.getString(3);
				String danhSachTenSanPham= resultSet.getString(4);
				int tongSoLuong= resultSet.getInt(5);
				double tongTien= resultSet.getInt(6);
				String ngayMua= resultSet.getString(7);
				String diaChi= resultSet.getString(8);
				String soDienThoai= resultSet.getString(9);
				String email= resultSet.getString(10);
				String tinhTrangDonHang= resultSet.getString(11);
				
				DonHang donHang= new DonHang(maDonHang, tenKhachHang, danhSachMaSanPham, danhSachTenSanPham, tongSoLuong, tongTien, ngayMua, diaChi, soDienThoai, email, tinhTrangDonHang);
				mapTemp.put(donHang.getMaDonHang(), donHang);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return mapTemp;
}
public static void main(String[] args) {
	DonHangDAO donHangDAO= new DonHangDAO();
	System.out.println(donHangDAO.mapDonHang);
}
}
