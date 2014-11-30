
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
    // guarda los email, bandeja de entradra
    private MailItem lastEmail;
    // emails enviados
    private int sendMailCount;
    // email recibidos
    private int receiveMailCount;
    // contador de email de spam recibidos
    private int receiveSpamCount;
    //dirección de quien nos ha enviado el correo mas largo
    private String longestFrom;

    /**
     * Constructor que crea objeto MailClient por medio de parametro
     */
    public MailClient(MailServer server, String user)
    {
        this.server = server;
        this.user = user;
        lastEmail = null;
        sendMailCount = 0;
        receiveMailCount = 0;
        receiveSpamCount = 0;
        longestFrom = "";
       
    }

    /**
     * Metodo que recupera del servidor el siguiente email que tiene el usuario y devuelve dicho email
     */
    public MailItem getNextMailItem()
    {
        lastEmail = server.getNextMailItem(user);
        return lastEmail;
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
        
        System.out.println("Tiene " + server.howManyMailItems(user) +
                            " emails en el servidor.");
    }
    /**
     * metodo que contesta automaticamente al emisor indicando q estamos de vacaciones y contiene el email recibido
     */
    public void getNextMailItemAndAutorespon()
    {
        MailItem email=server.getNextMailItem(user);  /// no podriamos poner en el if otra vez el metodo de recuperar email pq sino nos devolveria supuestamente el
                                                      /// segundo email, no el primero por segunda vez.
        if(email != null)
        {
            String newTo = email.getFrom();// es to y no from como puse yo, pq el que lo envio se convierte en quien lo recibe
            String newSubject = "RE: " + email.getSubject();
            String newMessage = "Estoy de vacaciones.\n" + email.getMessage(); // va delante la respuesta----//   \n es un salto de linea
            MailItem autorespond = new MailItem(user, newTo, newSubject, newMessage); 
            server.post(autorespond);
        }
       
    }
    /**
     * metodo que imprime por pantalla tantas veces como queramos el ultimo email recibido. si no hay mensajes informa de ello
     */
    public void printLastMailItem()
    {
                  
        if(lastEmail != null)
        {
             lastEmail.printEmail();
        }
        else
        {
           System.out.println("No tiene mensajes nuevos");  
                    
        }
    }
    /**
     * muestra estadisticas, emails enviados, recibidos, spam y dirección de correo que nos ha enviado el mensaje mas largo
     */
    public void printStatistics()
    {
        System.out.println("Ha recibido " + receiveMailCount + " emails");
        System.out.println("De ellos el " + ((receiveSpamCount/receiveMailCount)*100) + " % eran spam");
        System.out.println("Ha enviado " + sendMailCount + " emails");
        System.out.println("La dirección de la persona que nos envio el email mas largo es " + longestFrom);
    }
        

}
