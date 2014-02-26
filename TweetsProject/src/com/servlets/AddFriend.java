package com.servlets;

import java.io.IOException;

import com.datastax.driver.core.Cluster;
import com.lib.CassandraHosts;
import com.models.UserModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.TweetModel;

/**
 * Servlet implementation class AddFriend
 */
@WebServlet({ "/AddFriend", "/AddFriend/*" })
public class AddFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Cluster cluster;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFriend() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {
// TODO Auto-generated method stub
cluster = CassandraHosts.getCluster();
}
    
    String username="";
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = request.getRequestURL().toString();
		
		username="";
		int i=46;
		char ch;
	
		while (i!=url.length())
		{
			ch = url.charAt(i);
			username=username+ch;	
			i++;
		}
		
		
    	RequestDispatcher rd;
    	request.setAttribute("Username", username);
    	rd = request.getRequestDispatcher("/AddFriend.jsp");
    	rd.forward(request, response);
    	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		username="";
		
		String username2=request.getParameter("username");
		
		String url = request.getRequestURL().toString();
		
		UserModel tm= new UserModel();
		tm.setCluster(cluster);
		
		int i=46;
		char ch;
	
		while (i!=url.length())
		{
			ch = url.charAt(i);
			username=username+ch;	
			i++;
		}
		
		
		tm.MakeFriends(username, username2);
		request.setAttribute("Username", username);
    	RequestDispatcher rd;
    	rd = request.getRequestDispatcher("/FriendAdded.jsp");
    	rd.forward(request, response);
		
	}

}
