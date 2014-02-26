package com.servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.datastax.driver.core.Cluster;
import com.lib.*;
import com.models.*;
import com.stores.*;

/**
* Servlet implementation class ChangePass
*/
@WebServlet({ "ChangePass", "/ChangePass/*" })
public class ChangePass extends HttpServlet {
private static final long serialVersionUID = 1L;
    private Cluster cluster;
    /**
* @see HttpServlet#HttpServlet()
*/
    public ChangePass() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
// TODO Auto-generated method stub
cluster = CassandraHosts.getCluster();
}
    
/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
	
	
	}
    
/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/

String  username="";

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
//String args[]=Convertors.SplitRequestPath(request);			
			RequestDispatcher rd;	
				
			TweetModel tm2= new TweetModel();
			tm2.setCluster(cluster);			
			String url = request.getRequestURL().toString();
			
		//	int i=42;
		//	char ch;
		
		//	if (username=="")
		//	{
		//	while (i!=url.length())
	//		{
	//			ch = url.charAt(i);
	//			username=username+ch;	
	//			i++;
	//		}
			
	//		System.out.println(username);
	//		}
			
			
			LinkedList<TweetStore> tweetList = tm2.getTweets(username);
			request.setAttribute("User", username);
			rd = request.getRequestDispatcher("ChangePass.jsp");

			rd.forward(request, response);
	

}

}

