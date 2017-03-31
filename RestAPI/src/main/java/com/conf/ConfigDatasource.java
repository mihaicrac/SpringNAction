package com.conf;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigDatasource {
	@Bean
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setUrl("jdbc:postgresql://localhost/Spring");
		ds.setUsername("postgres");
		ds.setPassword("ovidiu1992");
		return ds;
	}
}
