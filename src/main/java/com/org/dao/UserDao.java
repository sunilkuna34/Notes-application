package com.org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.org.dto.User;

public class UserDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("karthik");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void SaveAndUpdateUser(User user) {
		
				
		et.begin();
		//em.persist(u);
		em.merge(user);
		et.commit();
		
	}



	





public User fetchUserById(int id) {
	
	
	User std=em.find(User.class,id );
	
	return std;
	
	
}
public User fetchUserByEmailAndPassword(String email,String password) {
		Query querry = em.createQuery("select u from User u where u.email=?1 and u.password=?2");
	
	querry.setParameter(1, email);
	querry.setParameter(2, password);
	List<User> list = querry.getResultList();
	if(list!=null) {
		for(User u:list) {			

		return u;
		
		}
		}
		return null;



}

public List<User> fetchAllUsers(){
	List<User> list=new ArrayList<User>();
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("karthik");
	
	EntityManager em=emf.createEntityManager();
Query querry = em.createQuery("SELECT S FROM User S");
List<User> list1 = querry.getResultList();

for(User s : list1) {
//System.out.println("Name: "+s.getName());
//System.out.println("Age: "+s.getAge());
//System.out.println("Email: "+s.getEmail());
//System.out.println("Password: "+s.getPassword());
//System.out.println("Mobile: "+s.getMobile());
//System.out.println("---------------------------------");

list.add(s);



}

return list;
	
	
}

}





