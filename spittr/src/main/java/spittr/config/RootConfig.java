package spittr.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import spittr.Spittle;
import spittr.data.SpittleRepository;

@Configuration
@ComponentScan(basePackages = { "spittr" }, excludeFilters = {
		@Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
public class RootConfig {

	@Bean
	public SpittleRepository spittleRepository() {
		return new SpittleRepository() {

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
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUrl("jdbc:postgresql://localhost/Spring");
		ds.setUsername("postgres");
		ds.setPassword("ovidiu1992");
		return ds;
	}

	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	
	@Bean
	public MultipartResolver multipartResolver() throws IOException {
		return new StandardServletMultipartResolver();
	}


}