package Dao.member;

import java.util.List;

import Model.member;

public interface memberDao {
	//Create
	void add(member m);
	
	
	//Read
	List<member> selectAll();
	member selectId(int id);
	member selectUser(String username);
	
	//update
	void update(member m);
	
	//delete
	void delete(int id);

}