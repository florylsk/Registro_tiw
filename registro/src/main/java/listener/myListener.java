package listener;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import beans.*;

public class myListener implements MessageListener{
	
	
	
	public static void Receiver() throws JMSException, ParseException {
		try {
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
              
            //5) create listener object  
            MessageListener listener=new myListener();  
              
            //6) register the listener object with receiver  
            receiver.setMessageListener(listener);  
            
			Message msg = null;
			msg = receiver.receive(4000);
			if (msg != null) {

			if (msg instanceof TextMessage) {

			TextMessage txtM = (TextMessage) msg;
					}
				} 

			con.close();	
		} 

		catch (NamingException e) {
			e.printStackTrace();
		}
	
	}
	
	
	public void onMessage(Message message) {
		
		TextMessage txtM = (TextMessage) message;
		try {
			String texto = txtM.getText();
			String[] componentes = texto.split(";");
			String username=componentes[0];
			String firstname = componentes[1];
			String lastname = componentes[2];
			
			String _fecha_inicio = componentes[3];
			SimpleDateFormat dateFormat_inicio = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		    Date parsedDate_inicio = dateFormat_inicio.parse(_fecha_inicio);
		    Timestamp fecha_inicio = new java.sql.Timestamp(parsedDate_inicio.getTime());
		    
		    String _fecha_salida = componentes[4];
			SimpleDateFormat dateFormat_salida = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		    Date parsedDate_salida = dateFormat_salida.parse(_fecha_salida);
		    Timestamp fecha_salida = new java.sql.Timestamp(parsedDate_salida.getTime());
		    Registro r = new Registro (username,firstname,lastname,fecha_inicio,fecha_salida);
		    registroDAO.createRegistro(r);			
			
			
		} catch (JMSException | ParseException e) {
			e.printStackTrace();
		}
		
		

		
	}



	

	
}