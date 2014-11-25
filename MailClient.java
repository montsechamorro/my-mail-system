
/**
 * Write a description of class MailClient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailClient
{
    // servidor asociado al cliente de mail
    private MailServer server;
    // dirección de correo del usuario, del cliente emisor
    private String user;

    /**
     * Constructor que crea objeto MailClient por medio de parametro
     */
    public MailClient(MailServer newServer, String newUser)
    {
        server = newServer;
        user = newUser;
    }

    /**
     * Metodo que recupera del servidor el siguiente email que tiene el usuario y devuelve dicho objeto
     */
    public MailItem getNextMailItem()
    {
        return server.getNextMailItem(user);
    }

    /**
     * metodo que recupera el siguiente email e imprime dicho mensaje.
     * si no hay email muestra mensaje por pantalla informando
     */
    public void printNextMailItem()
    {
        MailItem email = server.getNextMailItem(user);
        if(email == null){
            System.out.println("No hay mas mensajes");
        }
        else
        {
            email.printEmail();
        }
    }

    /**
     * metodo que crea un email, basandose en los parametros y lo envia al servidor del cliente
     */
    public void sendMailItem(String toMail, String sms)
    {
        MailItem email = new MailItem(user, toMail, sms);
        server.post(email);
    }

}

