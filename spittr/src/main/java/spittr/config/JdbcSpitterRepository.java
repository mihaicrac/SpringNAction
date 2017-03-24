package spittr.config;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spittr.Spitter;
import spittr.data.SpitterRepository;

//@Repository
public class JdbcSpitterRepository implements SpitterRepository {
	private JdbcOperations jdbcOperations;

	@Autowired
	public JdbcSpitterRepository(JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}

	public Spitter save(Spitter spitter) {
		// TODO Auto-generated method stub
		
		jdbcOperations.update("insert into users (id, username, password, firstname, lastname) values (uuid_in(md5(random()::text || now()::text)::cstring), ?, ?, ?, ?)",
				spitter.getUsername(), spitter.getPassword(), spitter.getFirstName(), spitter.getLastName());
		return findByUsername(spitter.getUsername());
	}

	public Spitter findByUsername(String username) {
		// TODO Auto-generated method stub
		return jdbcOperations.queryForObject(
				"select * from users where username = ? ", new SpitterRowMapper(),
				username
				);
		
	}
	
	
	private static final class SpitterRowMapper implements RowMapper<Spitter> {
		public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Spitter(rs.getString("id"), rs.getString("username"), rs.getString("password"), rs.getString("firstName"), 
					rs.getString("lastName"));
		}

	}	
	
}