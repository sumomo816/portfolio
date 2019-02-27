package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	private List<BuyItemDTO> buyItemList = new ArrayList<BuyItemDTO>();

	public String execute(){
		String result = "login";


		if(session.containsKey("adminFlg")){
			result = "input";
		}else if(session.containsKey("id")){
			BuyItemDTO buyItemDTO = new BuyItemDTO();
			BuyItemDAO buyItemDAO = new BuyItemDAO();
			buyItemList = buyItemDAO.getBuyItemInfoList();
			session.put("buyItemList", buyItemList);
			session.put("id", buyItemDTO.getId());

			result = SUCCESS;
		}
		return result;

	}

	public Map<String, Object> getSession(){
		return this.session;
	}
	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}


}
