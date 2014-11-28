
/**
 * Representa un cliente de correo electrónico
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
    public MailClient(MailServer server, String user)
    {
        this.server = server;
        this.user = user;
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
        MailItem email = server.getNextMailItem(user); // creamos la variable local para guardar lo que nos devuelve
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
    public void sendMailItem(String to, String message, String subject)
    {
        MailItem email = new MailItem(user, to, message, subject); // creamos el objeto MailItem(3 parametros). user lo cogemos de la clase mailClient
        server.post(email);
    }
    /**
     * metodo que imprime por pantalla los mensajes que tiene el usuario que esta utilizando el cliente
     */
    public void howManyMailItems()
    {
        int numberOfMails = server.howManyMailItems(user);
        System.out.println("Tiene " + numberOfMails + " emails en el servidor.");
    }
    /**
     * metodo que contesta automaticamente al emisor indicando q estamos de vacaciones y contiene el email recibido
     */
    public void getNextMailItemAndAutorespon()
    {
        MailItem email=server.getNextMailItem(user);
        String newFrom = email.getFrom();
        String newSubject = "RE: " + email.getSubject();
        String newMessage = (email.getMessage() + "Estoy de vacaciones");
        sendMailItem (newFrom, newSubject, newMessage);
      
    }
    }
        


