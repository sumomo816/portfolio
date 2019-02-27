package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	private ItemListDAO dao = new ItemListDAO();
	private ArrayList<ItemInfoDTO> itemList = new ArrayList<ItemInfoDTO>();

	public String execute() throws SQLException{

		String result = SUCCESS;

		itemList = dao.getItemList();

		return result;
	}
	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
	public ArrayList<ItemInfoDTO> getItemList(){
		return itemList;
	}
	public void setItemList(ArrayList<ItemInfoDTO> itemList){
		this.itemList = itemList;
	}
}
