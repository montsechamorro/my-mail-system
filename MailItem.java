
/**
 * Esta clase representa un mensaje de email
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
    // indica el asunto del email
    private String subject;

/**
 * constructor que crea el objeto en funcion de los parametros asignados
 */
public MailItem(String from, String to, String message,String subject)
{
    this.from = from;
    this.to = to;
    this.message = message;
    this.subject = subject;
}

/**
 * Metodo que devuelve quien envia el mail( la dirección de origen)
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
 * metodo que devuelve el asunto del email
 */
public String getSubject()
{
    return subject;
}
/**
 * Metodo que imprime por pantalla el mail.dirección de origen y destino y contenido
 */
public void printEmail()
{
    System.out.println("De: " + from);
    System.out.println("Para: " + to);
    System.out.println("Asunto: " + subject);
    System.out.println(message);
}
   
 


}
    
