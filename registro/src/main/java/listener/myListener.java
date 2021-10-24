package listener;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import beans.*;

public class myListener implements MessageListener{
	
	
	
	public void onMessage(Message message) {
		
		TextMessage txtM = (TextMessage) message;
			String texto;
			try {
				texto = txtM.getText();
				String[] componentes = texto.split(";");
				String username=componentes[0];
				String firstname = componentes[1];
				String lastname = componentes[2];
				String fecha_inicio = componentes[3];    
			    String fecha_salida = componentes[4];
			    Registro r = new Registro (username,firstname,lastname,fecha_inicio,fecha_salida);
			    registroDAO.createRegistro(r);	
			} catch (JMSException e) {
				e.printStackTrace();
			}
					

	
	}
	
}