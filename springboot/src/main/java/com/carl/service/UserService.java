package com.carl.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.carl.dao.mysql.UserMapper;
import com.carl.framework.Code;
import com.carl.framework.ReturnData;
import com.carl.model.User;

/**
 * 用户服务
 * 
 * @author liqq
 *
 */
@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 手机,密码登录
	 * @param mobile
	 * @param password
	 * @return
	 */
	public ReturnData loginWithMobilePassword(String mobile, String password) {
		ReturnData returnData = new ReturnData(Code.OK);
		User record = new User();
		record.setMobile(mobile);
		User selectOne = userMapper.selectOne(record);
		if (selectOne == null) {
			returnData.setErrorCode(Code.ERROR.getCode());
			returnData.setErrorString("用户不存在");
			return returnData;
		} else {
			if (password.equals(selectOne.getPassword())) {
				// 成功,记录登录时间
				String tmpInfo = selectOne.getTmpInfo();
				JSONObject jsonObject = JSON.parseObject(tmpInfo);
				if(null == jsonObject){
					jsonObject = new JSONObject();
				}
				jsonObject.put("loginTime",LocalDateTime.now().toString());
				selectOne.setTmpInfo(jsonObject.toJSONString());
				updateByPrimaryKeySelective(selectOne);
			} else {
				// 失败
				returnData.setErrorCode(Code.ERROR.getCode());
				returnData.setErrorString("密码不正确");
			}
		}
		return returnData;
	}
	
	/**
	 * 手机,短信登录
	 * @param mobile
	 * @param smscode
	 * @return
	 */
	public ReturnData loginWithMobileSmscode(String mobile, String smscode) {
		//TODO
		return null;
	}
	
	/**
	 * 创建用户
	 * @param user
	 * @return
	 */
	public int createUser(User user){
		int record = userMapper.insert(user);
		return record;
	}
	
	/**
	 * 按主键更新
	 * @param user
	 * @return
	 */
	public int updateByPrimaryKeySelective(User user){
		return userMapper.updateByPrimaryKeySelective(user);
	}
	
	/**
	 * 获取全部用户
	 * @return
	 */
	public List<User> selectAll(){
		List<User> selectAll = userMapper.selectAll();
		return selectAll;
	}
	
	public List<User> selectPage(User user){
		List<User> select = userMapper.select(user);
		return select;
	}
}
