package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
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
			try{  
	            //1) Create and start connection  
	            InitialContext ctx=new InitialContext();  
	            QueueConnectionFactory f=(QueueConnectionFactory)ctx.lookup("myQueueConnectionFactory");  
	            QueueConnection con=f.createQueueConnection();  
	            con.start();  
	            //2) create Queue session  
	            QueueSession ses=con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);  
	            //3) get the Queue object  
	            Queue t=(Queue)ctx.lookup("myQueue");  
	            //4)create QueueReceiver  
	            QueueReceiver receiver=ses.createReceiver(t);  
	              
	            while (true) {     
	                Message msg = receiver.receive(2000); 
	                if (msg instanceof TextMessage) {
	                    TextMessage tm = (TextMessage) msg;
	                    String texto = tm.getText();
	    				String[] componentes = texto.split(";");
	    				String username=componentes[0];
	    				String firstname = componentes[1];
	    				String lastname = componentes[2];
	    				String fecha_inicio = componentes[3];    
	    			    String fecha_salida = componentes[4];
	    			    Registro r = new Registro (username,firstname,lastname,fecha_inicio,fecha_salida);
	    			    registroDAO.createRegistro(r);     
	                }
	                else{
	                    System.out.println("Queue Empty"); 
	                    con.stop();
	                    break;
	                }
	            }
            
            
			}catch(Exception e){System.out.println(e);}  
			req.getRequestDispatcher("registro.jsp").forward(req, res);

	}
}