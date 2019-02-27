package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;


public class BuyItemDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	private BuyItemDTO buyItemDTO = new BuyItemDTO();

	public ArrayList<BuyItemDTO> getBuyItemInfoList(){
		String sql= "SELECT * FROM item_info_transaction";
		ArrayList<BuyItemDTO> buyItemList = new ArrayList<BuyItemDTO>();

		try{
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){

				buyItemDTO.setId(rs.getInt("id"));
				buyItemDTO.setItemName(rs.getString("item_name"));
				buyItemDTO.setItemPrice(rs.getString("item_price"));

               buyItemList.add(buyItemDTO);

			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return buyItemList;
	}
//	public BuyItemDTO getBuyItemDTO(){
//		return buyItemDTO;
//	}
}
