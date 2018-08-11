

//Statement
public void excuteSql(String sql) throws Exception {
		Connection connect = getConnect();
		Statement stmt = connect.createStatement();
		stmt.executeUpdate(sql);
	}
	public boolean del(String id) {
		mapNhaCungCap.remove(id);
		try {
			new ConnectToDatabase().excuteSql("delete from nhacungcap where maNhaCungCap='" + id + "'");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
//	PreparedStatement
	public boolean remove(String id) {
		mapNhaCungCap.remove(id);

		String sql = "delete from nhacungcap where maNhaCungCap = ? ";
		Connection connection = ConnectToDatabase.getConnect();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, new NhaCungCap().getMaNhaCungCap());
			preparedStatement.executeUpdate();//update dữ liệu lên database
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}
}
