package cn.edu.xupt.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.xupt.bean.Users;
import cn.edu.xupt.daoImpl.UserDAO;

@Service
public class Userservice {
	//@Autowired
	private UserDAO userDAO=new UserDAO();
	
	public Users findUserByName(String username) {
		// TODO Auto-generated method stub
		List<Users> list=userDAO.findUserByName(username);
		if(list!=null&&list.size()!=0) {
			return list.get(0);
		}else {
			return null;
		}
	}
	@Transactional
	public void save(Users users) {
		userDAO.save(users);
	}
	public List<Users> getAll(){
		return userDAO.getAllUsers();
	}
	public boolean deleteUser(Integer id) {
		userDAO.deleteUser(new Users(id, null, 0, null));
		return true;
	}
	public Users findUserByid(Integer id) {
		// TODO Auto-generated method stub
		return userDAO.getUserById(id);
	}
	public Users update(Users users) {
		// TODO Auto-generated method stub
		return userDAO.update(users);
	}
}
