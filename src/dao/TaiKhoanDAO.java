package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import model.ConnectToDatabase;
import model.NhaCungCap;
import model.TaiKhoan;

public class TaiKhoanDAO implements ObjectDAO {
	public static Map<String, TaiKhoan> mapTaiKhoan = loadData();

	public TaiKhoanDAO() {
		super();
	}

	private static Map<String, TaiKhoan> loadData() {
		Map<String, TaiKhoan> mapTemp = new HashMap<>();
		try {
			ResultSet resultSet = new ConnectToDatabase().selectData("select * from taikhoan");
			while (resultSet.next()) {
				String tenTaiKhoan = resultSet.getString(1);
				String matKhau = resultSet.getString(2);
				String tenKhachHang = resultSet.getString(3);
				String gioiTinh = resultSet.getString(4);
				String soDienThoai = resultSet.getString(5);
				String email = resultSet.getString(6);
				String ngaySinh = resultSet.getString(7);
				String diaChi = resultSet.getString(8);
				String soLuotMua = resultSet.getString(9);
				String role = resultSet.getString(10);

				TaiKhoan taiKhoan = new TaiKhoan(tenTaiKhoan, matKhau, tenKhachHang, gioiTinh, soDienThoai, email,
						ngaySinh, diaChi, soLuotMua, role);

				mapTemp.put(taiKhoan.getTenTaiKhoan(), taiKhoan);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mapTemp;
	}

	public boolean checkLogin(String userName, String passWord) {
		TaiKhoan taiKhoan = mapTaiKhoan.get(userName);
		if (taiKhoan != null) {
			if (taiKhoan.getMatKhau().equals(passWord)) {
				return true;
			} else {
				return false;
			}
		}

		return false;

	}

	@Override
	public boolean add(Object obj) {
		TaiKhoan taiKhoan = (TaiKhoan) obj;
		mapTaiKhoan.put(taiKhoan.getTenTaiKhoan(), taiKhoan);
		String sql = "insert into taikhoan values (?,?,?,?,?,?,?,?,?,?)";
		Connection connection = ConnectToDatabase.getConnect();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, taiKhoan.getTenTaiKhoan());
			preparedStatement.setString(2, taiKhoan.getMatKhau());
			preparedStatement.setString(3, taiKhoan.getTenKhachHang());
			preparedStatement.setString(4, taiKhoan.getGioiTinh());
			preparedStatement.setString(5, taiKhoan.getSoDienThoai());
			preparedStatement.setString(6, taiKhoan.getEmail());
			preparedStatement.setString(7, taiKhoan.getNgaySinh());
			preparedStatement.setString(8, taiKhoan.getDiaChi());
			preparedStatement.setString(9, taiKhoan.getSoLuotMua());
			preparedStatement.setString(10, taiKhoan.getRole());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
@Override
public boolean del(String id) {
	mapTaiKhoan.remove(id);
	try {
		new ConnectToDatabase().excuteSql("delete from taikhoan where tenTaiKhoan='" + id + "'");
		return true;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}
@Override
public boolean edit(String id, Object obj) {
	TaiKhoan taiKhoan= (TaiKhoan) obj;
	mapTaiKhoan.replace(id, taiKhoan);
	String sql="update taikhoan set matkhau=?,tenkhachhang=?,gioitinh=?,sodienthoai=?,email=?,ngaysinh=?,diachi=?,spluotmua=?,role=? where tentaikhoan='"+id+"'";
	Connection connection = ConnectToDatabase.getConnect();
	try {
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setString(1, taiKhoan.getMatKhau());
		preparedStatement.setString(2, taiKhoan.getTenKhachHang());
		preparedStatement.setString(3, taiKhoan.getGioiTinh());
		preparedStatement.setString(4, taiKhoan.getSoDienThoai());
		preparedStatement.setString(5, taiKhoan.getEmail());
		preparedStatement.setString(6, taiKhoan.getNgaySinh());
		preparedStatement.setString(7, taiKhoan.getDiaChi());
		preparedStatement.setString(8, taiKhoan.getSoLuotMua());
		preparedStatement.setString(9, taiKhoan.getRole());
		preparedStatement.setString(10, id);

		preparedStatement.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}
public boolean changePass(String userName, String newPass) {
	
TaiKhoan taiKhoan = mapTaiKhoan.get(userName);
if(taiKhoan!=null) {
	taiKhoan.setMatKhau(newPass);
	mapTaiKhoan.replace(taiKhoan.getTenTaiKhoan(), taiKhoan);
	edit(taiKhoan.getTenTaiKhoan()	, taiKhoan);
	return true;
	
}else {
	return false;
}

}
	public static void main(String[] args) {
		TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
		System.out.println(taiKhoanDAO.mapTaiKhoan);
		System.out.println(taiKhoanDAO.mapTaiKhoan.size());
		//System.out.println(taiKhoanDAO.checkLogin("hiendi", "hiendi11"));
//
//		taiKhoanDAO.add(new TaiKhoan("tuongtu", "123456", "tuongtu", "nam", "01665715196", "tuongtu@gmail.com", "15/11/1998", "ktx b", "2", "customer"));
//	System.out.println(taiKhoanDAO.mapTaiKhoan);
//	System.out.println(taiKhoanDAO.mapTaiKhoan.size());
//	
	taiKhoanDAO.del("hieu");
	System.out.println(taiKhoanDAO.mapTaiKhoan);
	System.out.println(taiKhoanDAO.mapTaiKhoan.size());
	
//	
	}
}
