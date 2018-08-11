package dao;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import model.ConnectToDatabase;
import model.ThongTinSanPham;

public class ThongTinSanPhamDAO {
Map<String, ThongTinSanPham> mapThongTinSanPham = loadData();

private Map<String, ThongTinSanPham> loadData() {
	Map<String, ThongTinSanPham> mapTemp = new HashMap<>();
	
	ResultSet resultSet;
	try {
		resultSet = new ConnectToDatabase().selectData("select * from thongtinsanpham");
		while (resultSet.next()) {
			String maSanPham= resultSet.getString(1);
			String moTa1= resultSet.getString(2);
			String moTa2= resultSet.getString(3);
			String moTa3= resultSet.getString(4);
			String moTa4= resultSet.getString(5);
			String moTa5= resultSet.getString(6);
			String hinhAnhChiTiet= resultSet.getString(6);
			ThongTinSanPham thongTinSanPham = new ThongTinSanPham(maSanPham, moTa1, moTa2, moTa3, moTa4, moTa5, hinhAnhChiTiet);
			mapTemp.put(thongTinSanPham.getMaSanPham(), thongTinSanPham);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return mapTemp;
}
public static void main(String[] args) {
	
	ThongTinSanPhamDAO thongTinSanPhamDAO = new ThongTinSanPhamDAO();
	System.out.println(thongTinSanPhamDAO.mapThongTinSanPham);
}
}
