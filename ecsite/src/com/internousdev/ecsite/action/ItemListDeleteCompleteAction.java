package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListDeleteCompleteAction extends ActionSupport implements SessionAware{



	public Map<String, Object> session;

	private ItemListDeleteCompleteDAO dao = new ItemListDeleteCompleteDAO();



	public String execute() throws SQLException{



		int res = dao.itemInfoDelete();

		if(res > 0){

			session.put("message", "商品情報を正しく削除しました。");
		}else if(res == 0){
			session.put("message", "商品情報の削除に失敗しました。");
		}

		String result = SUCCESS;
		return result;
	}

	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
