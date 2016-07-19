package com.softpath.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.softpath.entity.Users;


@Repository
@Transactional
public class UserDaoImplement implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean checkUser(Users user) {
		
		//Users user1 = (Users) sessionFactory.getCurrentSession().get(Users.class, user.getIdUser());
		String user1 = (String)sessionFactory.getCurrentSession().createQuery("select nameUser from Users where usernameUser = :username "
		+"and passwordUser = :password").setParameter("username", user.getUsernameUser()).setParameter("password", user.getPasswordUser()).uniqueResult();
		
		if(user1 != null)
			return true;
		
		
		return false;
	}

}
