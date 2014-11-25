
/**
 * Write a description of class MailItem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailItem
{
    // atributo que indica Quien envia el mail 
    private String from;
    // atributo que indica quien es el Destinatario
    private String to;
    // atributo que recoge el mensaje que se envia
    private String message;

/**
 * constructor que crea el objeto en funcion de los parametros asignados
 */
public MailItem(String fromMail, String toMail, String sms)
{
    from = fromMail;
    to = toMail;
    message = sms;
}

/**
 * Metodo que devuelve quien envia el mail
 */
public String getFrom()
{
    return from;
}
/**
 * Método que devuelve quien es el destinatario del mail
 */
public String getTo()
{
    return to;
}
/**
 * Metodo que devuelve el contenido del mensaje
 */
public String getMessage()
{
    return message;
}
/**
 * Metodo que imprime por pantalla el mail
 */
public void printEmail()
{
    System.out.println("De: " + from);
    System.out.println("Para: " + to);
    System.out.println(message);
}
   
 


}
    
