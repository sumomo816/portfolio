package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	public Map<String, Object> session;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	private List<BuyItemDTO> buyItemList = new ArrayList<BuyItemDTO>();
	private String adminFlg;

	public String execute(){

		String result = ERROR;

		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);
		session.put("loginUser", loginDTO);

		adminFlg = loginDTO.getAdminFlg();

		if(loginUserId.equals(loginDTO.getLoginId())
			&& loginPassword.equals(loginDTO.getLoginPassword())
			&& !(adminFlg == null)){

					result = "login";
					session.put("adminFlg", adminFlg);



		}else if(((LoginDTO) session.get("loginUser")).getLoginFlg()){
			result = SUCCESS;
			BuyItemDTO buyItemDTO = new BuyItemDTO();
			BuyItemDAO buyItemDAO = new BuyItemDAO();
			buyItemList = buyItemDAO.getBuyItemInfoList();
			session.put("buyItemList", buyItemList);

			session.put("login_user_id", loginDTO.getLoginId());
			session.put("id", buyItemDTO.getId());


			return result;
		}
		return result;
	}

	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}

	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

	public List<BuyItemDTO> getBuyItemList() {
		return buyItemList;
	}

	public void setBuyItemList(List<BuyItemDTO> buyItemList) {
		this.buyItemList = buyItemList;
	}

}
