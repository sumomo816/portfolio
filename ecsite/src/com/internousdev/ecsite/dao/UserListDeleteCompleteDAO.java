package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class UserListDeleteCompleteDAO {


	public int userInfoDelete() throws SQLException{

		String sql = "DELETE FROM login_user_transaction";

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		int result =0;
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			result = ps.executeUpdate();


		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
	}


}
