package spittr.config;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spittr.Spitter;
import spittr.data.SpitterRepository;


//@Repository
//@Transactional
public class HibernateSpitterRepository implements SpitterRepository{

	private SessionFactory sessionFactory;

	@Autowired
	public HibernateSpitterRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public Spitter save(Spitter spitter) {
		Serializable id = currentSession().save(spitter);
		System.out.println("xxxxxxxxxxxxxxxxxxx:"+id);
		return findByUsername(spitter.getUsername()); 
				
		//		Spitter(spitter.getUsername(), spitter.getPassword(), spitter.getFirstName(),
		//		spitter.getLastName());
	}

	public Spitter findOne(long id) {
		return (Spitter) currentSession().get(Spitter.class, id);
	}

	@Transactional
	public Spitter findByUsername(String username) {
		return (Spitter) currentSession().createCriteria(Spitter.class).add(Restrictions.eq("username", username))
				.list().get(0);
	}

}