package vn.edu.vinaenter.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import vn.edu.vinaenter.model.Role;
import vn.edu.vinaenter.model.User;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final String FIND_ALL = "SELECT u.*,r.name FROM `users` AS u INNER JOIN roles AS r ON u.roleid = r.id";
	private static final String FIND_ONE_BY_ID = "SELECT u.*,r.name FROM `users` AS u INNER JOIN roles AS r ON u.roleid = r.id WHERE u.id = ?";
	private static final String INSERT_ONE = "INSERT INTO users (username,fullname,password,roleid) VALUE (?,?,?,?)";
	private static final String COUNT_USERNAME ="SELECT COUNT(*) FROM users WHERE username = ? ";
	private static final String DELTE_ONE_BY_ID ="DELETE FROM users  WHERE id = ? ";
	private static final String UPDATE_ONE_BY_ID ="UPDATE users SET fullname = ? , password = ? , roleid = ? WHERE id = ? ";
	public RowMapper<User> getRowMapper(){
		return new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User(rs.getInt("id"), rs.getString("username"), 
						rs.getString("fullname"), rs.getString("password"),	new Role(rs.getInt("roleid"), rs.getString("name")));
				return user;
			}
		};
	}
	public List<User> getItems(){
		return jdbcTemplate.query(FIND_ALL, getRowMapper());
	}
	public User getItem(int id) {
		return jdbcTemplate.queryForObject(FIND_ONE_BY_ID,getRowMapper(),new Object[] {id});
	}

	public int add( User user) {
		
		return jdbcTemplate.update(INSERT_ONE,new Object[] {user.getUsername(),
				user.getFullname(),user.getPassword(),user.getRole().getId()});
	}
	
	public boolean hasUser(String username) {
		return jdbcTemplate.queryForObject(COUNT_USERNAME, boolean.class,new Object[] {username});
	}

	public int delete(int id) {
		
		return jdbcTemplate.update(DELTE_ONE_BY_ID,new Object[] {id});
	}
	public int edit( User user) {
		return jdbcTemplate.update(UPDATE_ONE_BY_ID,new Object[] {user.getFullname(),user.getPassword(),user.getRole().getId(),user.getId()});
	}
}
