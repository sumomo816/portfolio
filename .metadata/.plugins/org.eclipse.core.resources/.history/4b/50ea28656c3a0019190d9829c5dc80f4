package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class AdminCreateCompleteDAO {

	private DateUtil dateUtil = new DateUtil();

	public void adminCreate(String loginUserId, String loginPassword, String userName, String adminFlg) throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();


		String sql = "INSERT INTO login_user_transaction(login_id, login_pass, user_name, admin_flg, insert_date) VALUES (?,?,?,?,?)";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ps.setString(2, loginPassword);
			ps.setString(3, userName);
			ps.setString(4, adminFlg);
			ps.setString(5, dateUtil.getDate());

			ps.execute();



		}catch(SQLException e){
			e.printStackTrace();
		}try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

	}
}
