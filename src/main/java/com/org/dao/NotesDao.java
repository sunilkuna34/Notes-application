package com.org.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.org.dto.Notes;
import com.org.dto.User;

public class NotesDao {
	public Notes FetchNotesById(int id){
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("karthik");
		EntityManager em=emf.createEntityManager();
		Notes ntd=em.find(Notes.class,id );
		
		
		
		return ntd;
		
		
	}
	public List<Notes> fetchAllNotes(){
		List<Notes> list=new ArrayList<Notes>();
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("karthik");
		
		EntityManager em=emf.createEntityManager();
	Query querry = em.createQuery("SELECT S FROM Notes S");
	List<Notes> list1 = querry.getResultList();

	for(Notes s : list1) {
		
		list.add(s);



	}

	return list;
		
		
	}
	

}
