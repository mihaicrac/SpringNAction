package spittr.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import spittr.Spittle;
import spittr.data.SpittleRepository;

//@Component
public class Repository implements SpittleRepository {

	public List<Spittle> findSpittles(long max, int count) {
		// TODO Auto-generated method stub
		List<Spittle> spittles = new ArrayList<Spittle>();
		for (int i = 0; i < count; i++) {
			spittles.add(new Spittle("Spittle " + i, new Date()));
		}
		return spittles;
	}

	public Spittle findOne(long spittleId) {
		// TODO Auto-generated method stub
		Spittle s = new Spittle("adsada", new Date());
		return s;
	}

}