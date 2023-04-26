package vn.edu.vinaenter.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository

public class LandsDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
//	public List<Lands> findall(){
//		String sql = "SELECT * FROM lands ORDER BY lid DESC LIMIT 3 ";
//		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Lands>(Lands.class));
//	}
//	
//	public List<Lands> findallcount(){
//		String sql = "SELECT * FROM lands ORDER BY count_views DESC LIMIT 3 ";
//		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Lands>(Lands.class));
//	}
//	public Lands findByid (int idland) {
//		String sql = "SELECT * FROM lands WHERE lid = ?";
//		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Lands>(Lands.class),idland);
//	}
//	
//	public List<Lands> findByidCat(int cid){
//		String sql = "SELECT * FROM lands WHERE cid = ? ";
//		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Lands>(Lands.class),cid);
//	}
//	public Lands findByid () {
//		String sql = "SELECT lid FROM lands ";
//		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Lands>(Lands.class));
//	}
//	
}
