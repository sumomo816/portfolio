package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.util.DBConnector;


public class ItemListDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();


	public ArrayList<ItemInfoDTO> getItemList() throws SQLException{

		String sql ="SELECT item_name, item_price, item_stock FROM item_info_transaction";

		ArrayList<ItemInfoDTO> itemList = new ArrayList<ItemInfoDTO>();

		try{

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				ItemInfoDTO dto = new ItemInfoDTO();
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setItemStock(rs.getString("item_stock"));

				itemList.add(dto);

			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return itemList;

	}

}
