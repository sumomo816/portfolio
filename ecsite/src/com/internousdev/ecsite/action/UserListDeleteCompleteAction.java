package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListDeleteCompleteAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	private UserListDeleteCompleteDAO userListDeleteCompleteDAO = new UserListDeleteCompleteDAO();

	public String execute() throws SQLException{

		String result = SUCCESS;

		int res = userListDeleteCompleteDAO.userInfoDelete();

		if(res > 0){

			session.put("message", "ユーザー情報を正しく削除しました。");
		}else if(res == 0){
			session.put("message", "ユーザー情報の削除に失敗しました。");
		}
		return result;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}


}
