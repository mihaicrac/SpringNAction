package spittr.web;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

import spittr.Spitter;
import spittr.data.SpitterRepository;

//@Component
public class SpitterRepo implements SpitterRepository{

	HashMap <String, Spitter> db = new HashMap<String, Spitter>(); 
	AtomicLong count = new AtomicLong(0);
	
	public Spitter save(Spitter spitter) {
		// TODO Auto-generated method stub
		long id = count.incrementAndGet();
		spitter.setId(id);
		db.put(spitter.getUsername(), spitter);
		return spitter;
	}

	public Spitter findByUsername(String username) {
		// TODO Auto-generated method stub
		return db.get(username);
	}

}
