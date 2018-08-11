package dao;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import model.ConnectToDatabase;
import model.TaiKhoan;

public class TaiKhoanDAO {
Map<String, TaiKhoan> mapTaiKhoan = loadData();

public TaiKhoanDAO() {
	super();
}

private Map<String, TaiKhoan> loadData() {
	Map<String, TaiKhoan> mapTemp= new HashMap<>();
	try {
		ResultSet resultSet = new ConnectToDatabase().selectData("select * from taikhoan");
	while (resultSet.next()) {
		String tenTaiKhoan= resultSet.getString(1);
		String matKhau= resultSet.getString(2);
		String tenKhachHang= resultSet.getString(3);
		String gioiTinh= resultSet.getString(4);
		String soDienThoai= resultSet.getString(5);
		String email= resultSet.getString(6);
		String ngaySinh= resultSet.getString(7);
		String diaChi= resultSet.getString(8);
		String soLuotMua= resultSet.getString(9);
		String role=resultSet.getString(10);
		
		TaiKhoan taiKhoan = new TaiKhoan(tenTaiKhoan, matKhau, tenKhachHang, gioiTinh, soDienThoai, email, ngaySinh, diaChi, soLuotMua, role);
	
	mapTemp.put(taiKhoan.getTenTaiKhoan(), taiKhoan);
	}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return mapTemp;
}
boolean checkLogin(String userName,String passWord) {
	TaiKhoan taiKhoan = mapTaiKhoan.get(userName);
	if(taiKhoan != null) {
		if(taiKhoan.getMatKhau().equals(passWord)) {
			return true;
		}else {
			return false;}
		}
	
	return false;
	 
}
public static void main(String[] args) {
	TaiKhoanDAO khachHangDAO = new TaiKhoanDAO();
	System.out.println(khachHangDAO.mapTaiKhoan);
	System.out.println(khachHangDAO.checkLogin("hiendi", "hiendi11"));

}
}
