package vn.edu.vinaenter.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import vn.edu.vinaenter.constant.Defines;
import vn.edu.vinaenter.model.Category;
import vn.edu.vinaenter.model.Land;

@Repository
public class LandDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final String  FIND_ALL ="SELECT l.*,c.cname FROM lands AS l INNER JOIN categories AS c ON l.cid = c.cid";
	private static final String  FIND_ONE_BY_ID ="SELECT l.*,c.cname FROM lands AS l INNER JOIN categories AS c ON l.cid = c.cid WHERE  lid = ? ";
	private static final String  INSERT_ONE ="INSERT INTO lands (lname,description,cid,picture,area,address,detail) VALUES (?,?,?,?,?,?,?);";
	private static final String DELETE_BY_ID = "DELETE FROM  lands WHERE lid = ?";
	private static final String  EDIT_ONE_BY_ID = "UPDATE lands SET lname=?,description= ?,cid=?,picture=?,area=?,address=?,detail=? WHERE lid = ?";
	private static final String COUNT_ITEM_BYCAT_ID = "SELECT COUNT(*)FROM lands WHERE cid =?";
	private static final String COUNT_ALL = "SELECT COUNT(*) FROM lands AS l INNER JOIN categories AS c ON l.cid = c.cid";
	private static final String FIND_PAGINATION = "SELECT l.*,c.cname FROM lands AS l INNER JOIN categories AS c ON l.cid = c.cid ORDER BY date_create DESC LIMIT ?,? ";
	private static final String Find_By_CAT_ID = "SELECT l.*,c.cname FROM lands AS l INNER JOIN categories AS c ON l.cid = c.cid WHERE l.cid = ? ";
	private static final String  FIND_BY_RELATED ="SELECT l.*,c.cname FROM lands AS l INNER JOIN categories AS c ON l.cid = c.cid WHERE l.cid = ? AND l.lid != ? ORDER BY date_create DESC LIMIT ?";
	//private static final String FINd_PAGINATION_ADMIN = "SELECT l.*,c.cname FROM lands AS l INNER JOIN categories AS c ON l.cid = c.cid ORDER BY date_create DESC LIMIT ?,? ";
	private RowMapper<Land> getRowMapper(){
		return new RowMapper<Land>() {
			@Override
			public Land mapRow(ResultSet rs, int rowNum) throws SQLException {
				Land land = new Land(rs.getInt("lid"), rs.getString("lname"),rs.getString("description"), 
						rs.getTimestamp("date_create"), rs.getString("picture"), rs.getInt("area"), rs.getString("address"), rs.getInt("count_views"),rs.getString("detail"),
						new Category(rs.getInt("cid"),rs.getString("cname")));
				return land;
			}
		};
	}
		public List<Land> getitems(){
			return jdbcTemplate.query(FIND_ALL, getRowMapper());					
		}
		public Land getItem(int id) {
			return jdbcTemplate.queryForObject(FIND_ONE_BY_ID,getRowMapper(),new Object[]{id});					
		}

		public int add( Land land) {
		
			return jdbcTemplate.update(INSERT_ONE, 
					new Object[] {land.getLname(),land.getDescription(),land.getCategory().getCid(),land.getPicture()
							,land.getArea(),land.getAddress(),land.getDetail()});
		}

		public int del(int id) {
			
			return jdbcTemplate.update(DELETE_BY_ID,new Object[] {id});
		}
		public int edit( Land land) {
			
			return jdbcTemplate.update(EDIT_ONE_BY_ID, new Object[] {land.getLname(),land.getDescription(),
					land.getCategory().getCid(),land.getPicture(),land.getArea(),land.getAddress(),land.getDetail(),land.getLid()});
		}
		
		public int countItemByCategoryID(int id) {
			return jdbcTemplate.queryForObject(COUNT_ITEM_BYCAT_ID, Integer.class,new Object[] {id});
		}
		 public int countItems() {
			 return jdbcTemplate.queryForObject(COUNT_ALL, Integer.class);
		 }
		public List<Land> getItemsPagination(int offset) {
			return jdbcTemplate.query(FIND_PAGINATION,getRowMapper(),new Object[]{offset,Defines.ROW_COUNT}); 
		}
		public List<Land> getItemsByCategoryId(int id) {
			
			return jdbcTemplate.query(Find_By_CAT_ID, getRowMapper(),new Object[] {id});
		}
		public List<Land> getRelatedTiem(Land land,int max ) {
			
			return jdbcTemplate.query(FIND_BY_RELATED,getRowMapper(),new Object[] {land.getCategory().getCid(),land.getLid(),max} );
		}
	
}
