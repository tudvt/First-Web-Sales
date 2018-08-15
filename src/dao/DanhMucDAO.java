package dao;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import model.ConnectToDatabase;
import model.DanhMuc;

public class DanhMucDAO {
//Map<String, DanhMuc> mapDanhMuc=loadData();

public DanhMucDAO() {
	super();
}

public Map<String, DanhMuc> loadData() {
	 Map<String, DanhMuc> mapDanhMuc=new HashMap<>();
	 ResultSet resultSet;
	try {
		resultSet = new ConnectToDatabase().selectData("select * from danhmuc");

	while (resultSet.next()) {
		String maDanhMuc=resultSet.getString(1);
		String tenDanhMuc=resultSet.getString(2);
		
		DanhMuc danhMuc = new DanhMuc(maDanhMuc, tenDanhMuc);
		mapDanhMuc.put(danhMuc.getMaDanhMuc(), danhMuc);
		
	}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return mapDanhMuc;
}
public static void main(String[] args) {
	DanhMucDAO danhMucDAO = new DanhMucDAO();
	System.out.println(danhMucDAO.loadData());
}

}
