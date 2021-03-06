package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.datastax.driver.core.Cluster;
import com.lib.CassandraHosts;
import com.models.UserModel;

/**
 * Servlet implementation class Profile
 */
@WebServlet({ "/Profile", "/Profile/*" })
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Cluster cluster;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }
    
 String username="";   
 
    public void init(ServletConfig config) throws ServletException {
// TODO Auto-generated method stub
cluster = CassandraHosts.getCluster();
}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
					
		String url = request.getRequestURL().toString();
		
		int i=44;
		char ch;
	
		username="";

		while (i!=url.length())
		{
			ch = url.charAt(i);
			username=username+ch;	
			i++;
		}
		
		System.out.println(username);

		
		
		UserModel tm= new UserModel();
		tm.setCluster(cluster);	
		
		String mail = tm.getEmail(username);
		System.out.println(mail);
		
		
		request.setAttribute("User", username);
		request.setAttribute("Email", mail);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/Profile.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserModel tm= new UserModel();
		tm.setCluster(cluster);	
		
		String mail = request.getParameter("email");
		String pw = request.getParameter("password");
		tm.ChangePass(username, pw);
		tm.ChangeMail(username, mail);
		
		
		RequestDispatcher rd;
		
		request.setAttribute("Username", username);
		
		rd = request.getRequestDispatcher("/ProfileSuc.jsp");
		rd.forward(request, response);
		
	}

}
