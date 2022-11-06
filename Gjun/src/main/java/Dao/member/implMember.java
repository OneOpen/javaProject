package Dao.member;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Dao.DbConnection;
import Model.member;

public class implMember implements memberDao{

	public static void main(String[] args) {
		//member m=new member("hhh","kkkk","1234","台北","666","111");
		//new implMember().add(m);
		//System.out.println(new implMember().queryAll());
		/*List<member> l=new implMember().queryAll();
		for(member m:l)
		{
			System.out.println(m.getId()+"\t"+m.getName());
		}*/
		
		//System.out.println(new implMember().queryMember("abc","1234"));

		//System.out.println(new implMember().queryUsername("abc"));
		
		//System.out.println(new implMember().queryMember(2));
		
		/*	member m=new implMember().queryMember(3);
		m.setName("teacher");
		m.setMobile("123456789");
		
		new implMember().update(m);*/
		
		new implMember().delete(4);
	}

	@Override
	public void add(member m) {
		EntityManager em=DbConnection.getDb();
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public List<member> queryAll() {
		EntityManager em=DbConnection.getDb();
		String JPQL="select m from member m";
		Query q=em.createQuery(JPQL);
		List<member> l=q.getResultList();
		
		return l;
	}

	@Override
	public member queryMember(String username, String password) {
		EntityManager em=DbConnection.getDb();
		String JPQL="select m from member m where m.username=?1 and m.password=?2";
		Query q=em.createQuery(JPQL);
		q.setParameter(1, username);
		q.setParameter(2, password);
		
		List<member> l=q.getResultList();
		member[] m=l.toArray(new member[l.size()]);
		if(l.size()!=0)
		{
			return m[0];
		}
		else
		{
			return null;
		}
		
	}

	@Override
	public boolean queryUsername(String username) {
		EntityManager em=DbConnection.getDb();
		String JPQL="select m from member m where m.username=?1";
		Query q=em.createQuery(JPQL);
		q.setParameter(1, username);
		List<member> l=q.getResultList();
		boolean x = false;
		if(l.size()!=0) x=true;
		return x;
	}

	@Override
	public member queryMember(int id) {
		EntityManager em=DbConnection.getDb();
		String JPQL="select m from member m where m.id=?1";
		Query q=em.createQuery(JPQL);
		q.setParameter(1, id);
		List<member> l=q.getResultList();
	
		member[] m=l.toArray(new member[l.size()]);
		if(l.size()!=0)
		{
			return m[0];
		}
		else
		{
			return null;
		}
	}

	@Override
	public void update(member m) {
		EntityManager em=DbConnection.getDb();
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void delete(int id) {
		EntityManager em=DbConnection.getDb();
		member m=em.find(member.class,id);
		em.getTransaction().begin();
		em.remove(m);
		em.getTransaction().commit();
		em.close();
		
		
	}

}