package vn.edu.vinaenter.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vn.edu.vinaenter.model.Contact;

@Repository
public class ContactDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final String INSERT_ONE = "INSERT INTO vnecontact( fullname, email, subject, content) VALUES (?,?,?,?)";
	private static final String FIND_ALL = "SELECT * FROM vnecontact";
	private static final String DEL_ONE_BY_ID = "DELETE FROM vnecontact WHERE cid = ?";
	
	public int add(Contact contact) {
		
		return jdbcTemplate.update(INSERT_ONE,new Object[] {contact.getFullname(),contact.getEmail(),contact.getSubject(),contact.getContent()});		
	}
	public List<Contact> Find_ALL(){
		return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<>(Contact.class));
	}
	public int del(int id) {
		return jdbcTemplate.update(DEL_ONE_BY_ID,new Object[] {id});
	}
}
