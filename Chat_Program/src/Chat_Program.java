/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Owner
 */
public class Chat_Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      ServerGUI ser = new ServerGUI(1337);
      //  ser.start();
      Client client = new Client("localhost",1337, "bob", new ClientGUI("localhost",1337));
      client.start();
        
    }
}
