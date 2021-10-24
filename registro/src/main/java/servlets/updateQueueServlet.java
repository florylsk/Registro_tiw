package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.jms.JMSException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import beans.*;
import listener.myListener;



@WebServlet(urlPatterns = {"/updateQueue" })
public class updateQueueServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public updateQueueServlet() {
		super();
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		    throws ServletException, IOException{
			req.getRequestDispatcher("registro.jsp").forward(req, res);

	}
}