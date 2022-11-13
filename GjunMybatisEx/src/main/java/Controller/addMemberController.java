package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.member.implMember;
import Model.member;


public class addMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public addMemberController() {
        super();
    }
    
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*1.檢查帳號-->usename-->重複
		 *2.true-->addMemberError
		 *3.false-->request所有-->new member-->add(m) 
		 *4.addMembersuccess
		 */
    	request.setCharacterEncoding("BIG5");//傳輸出去的資料必須再次編碼才能顯示中文
    	String username = request.getParameter("username");
    	if(new implMember().selectUser(username)!=null) {
    		response.sendRedirect("member/addMemberError.jsp");
    	}else {
    		String name=request.getParameter("name");
    		String password=request.getParameter("password");
    		String address=request.getParameter("address");
    		String phone=request.getParameter("phone");
    		String mobile=request.getParameter("mobile");
    		
    		member m=new member(name,password,username,address,phone,mobile);
    		new implMember().add(m);
    		response.sendRedirect("member/addMemberSuccess.jsp");
    	}
	}

}
