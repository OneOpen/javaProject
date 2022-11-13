package Dao.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import Dao.DbConnection;
import Model.member;

public class implMember implements memberDao{

	public static void main(String[] args) {
		//System.out.println(new implMember().selectAll());
		//member m=new member("aaaaa","yy","000","台北","44","55");
		//new implMember().add(m);
		
		//System.out.println(new implMember().selectId(1));
		//member m=new implMember().selectId(1);
		//m.setName("teacher");
		
		//new implMember().update(m);
		
		//new implMember().delete(1);
		
		System.out.println(new implMember().selectUser("def"));

	}

	@Override
	public List<member> selectAll() {
		SqlSession session=DbConnection.getDb();
		List<member> l=session.selectList("memberMapper.selectAll");
		return l;
	}

	@Override
	public void add(member m) {
		SqlSession session=DbConnection.getDb();
		session.insert("memberMapper.add", m);
		session.commit();
		
	}

	@Override
	public member selectId(int id) {
		SqlSession session=DbConnection.getDb();
		List<member> l=session.selectList("memberMapper.selectId", id);
		member[] m=l.toArray(new member[l.size()]);
		return m[0];
	}

	@Override
	public void update(member m) {
		SqlSession session=DbConnection.getDb();
		session.update("memberMapper.update", m);
		session.commit();
		
	}

	@Override
	public void delete(int id) {
		SqlSession session=DbConnection.getDb();
		session.update("memberMapper.delete",id);
		session.commit();
		
	}

	@Override
	public member selectUser(String username) {
		member m=null;
		SqlSession session=DbConnection.getDb();
		List<member> l=session.selectList("memberMapper.selectUser",username);
		member[] M=l.toArray(new member[l.size()]);
		if(l.size()!=0) m=M[0];
		return m;
	}

}