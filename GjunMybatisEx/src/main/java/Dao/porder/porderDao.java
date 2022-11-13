package Dao.porder;

import java.util.List;

import Model.porder;

/* porderDao方法
 * 1.add(p)
 * 2.selectAll():List
 * 3.update()
 * 4.selectId(id)
 * 5.delete(id)
 * */


public interface porderDao {
		//Create
		void add(porder p);
		
		//Reads
		List<porder> selectAll();
 		porder selectId(int id);
		//update
		void update(porder p);
		//delete
		void delete(int id);
}
