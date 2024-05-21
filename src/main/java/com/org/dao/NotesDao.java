package com.org.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.org.dto.Notes;
import com.org.dto.User;

public class NotesDao {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("karthik");
		
		EntityManager em=emf.createEntityManager();
	EntityTransaction	et=em.getTransaction();
		
	public Notes FetchNotesById(int id){
		
		Notes ntd=em.find(Notes.class,id );
		
		
		
		return ntd;
		
		
	}
	public List<Notes> fetchAllNotes(){
		List<Notes> list=new ArrayList<Notes>();
			Query querry = em.createQuery("SELECT S FROM Notes S");
	List<Notes> list1 = querry.getResultList();

	for(Notes s : list1) {
		
		list.add(s);



	}

	return list;
		
		
	}
	
	public void UpdateNote(Notes note) {
		
		
		et.begin();
		em.merge(note);
		et.commit();
		System.out.println("Updated inserted");
		

	}
	
	public void deleteNotesById(int id) {
		
		
			Notes std=em.find(Notes.class, id);
//			User user = std.getUser();
//			List<Notes> list = user.getNotesList();
//			
//			for(Notes n: list) {
//				if(n.getId()==id) {
//					list.remove(n);
//					break;
//				}
//			}
	et.begin();
	//em.merge(user);
	em.remove(std);
	et.commit();
	System.out.println("Deleted succesfully");
		
		
		

	}
	

}
