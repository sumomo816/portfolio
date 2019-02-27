package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.UserListDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserListDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();


	public ArrayList<UserListDTO> getUserInfo() throws SQLException{

		ArrayList<UserListDTO> userListDTO = new ArrayList<UserListDTO>();

		String sql = "SELECT login_id, login_pass, user_name, admin_flg from login_user_transaction";

	try{
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while(rs.next()){
			UserListDTO dto = new UserListDTO();
			dto.setLoginUserId(rs.getString("login_id"));
			dto.setLoginPassword(rs.getString("login_pass"));
			dto.setUserName(rs.getString("user_name"));
			dto.setAdminFlg(rs.getString("admin_flg"));

			userListDTO.add(dto);
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		con.close();
	}
     return userListDTO;
	}

	public boolean isExistUserId(String loginUserId) throws SQLException{

		boolean result = false;
		String sql = "SELECT count(*) as count FROM login_user_transaction WHERE login_id = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				if(rs.getInt("count") > 0){
					result = true;
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
	}

}
