package spittr.config;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import spittr.Spitter;
import spittr.Spittle;
import spittr.data.SpitterRepository;
import spittr.data.SpittleRepository;

@Configuration
@ComponentScan(basePackages = { "spittr" }, excludeFilters = {
		@Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
public class RootConfig {
	
	@Bean
	public SpittleRepository spittleRepository(){
		return new SpittleRepository(){

			public List<Spittle> findSpittles(long max, int count) {
				// TODO Auto-generated method stub
				List<Spittle> spittles = new ArrayList<Spittle>();
				for (int i = 0; i < count; i++) {
					spittles.add(new Spittle("Spittle " + i, new Date()));
				}
				return spittles;
			}

			public Spittle findOne(long spittleId) {
				Spittle s = new Spittle("adsada", new Date());
				return s;
			}
			
		};
	}
	
	
	@Bean
	public SpitterRepository spitterRepository(){
		return new SpitterRepository(){

			public void save(Spitter spitter) {
				// TODO Auto-generated method stub
				
			}

			public Spitter findByUsername(String username) {
				// TODO Auto-generated method stub
				return null;
			}

			
		};
	}	
	
	
}