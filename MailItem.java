
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

/**
 * constructor que crea el objeto en funcion de los parametros asignados
 */
public MailItem(String from, String to, String message)
{
    this.from = from;
    this.to = to;
    this.message = message;
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
 * Metodo que imprime por pantalla el mail.dirección de origen y destino y contenido
 */
public void printEmail()
{
    System.out.println("De: " + from);
    System.out.println("Para: " + to);
    System.out.println(message);
}
   
 


}
    
