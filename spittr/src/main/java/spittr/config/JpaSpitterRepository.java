package spittr.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spittr.Spitter;
import spittr.data.SpitterRepository;


@Repository
@Transactional
public class JpaSpitterRepository implements SpitterRepository {
	
	@PersistenceUnit
	private EntityManagerFactory em;
	
	public Spitter save(Spitter spitter) {
		// TODO Auto-generated method stub
		em.createEntityManager().persist(spitter);
		return em.createEntityManager().find(Spitter.class, spitter.getUsername());
	}

	public Spitter findByUsername(String username) {
		// TODO Auto-generated method stub
		return em.createEntityManager().find(Spitter.class, username);
	}
}