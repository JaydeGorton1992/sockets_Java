
import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import javax.swing.JPanel;

/**
 *
 * @author Owner
 */
public class DrawGUI extends JPanel {

    ChatLog chatLog;

    public DrawGUI() {
        chatLog = new ChatLog();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        chatLog.setSize(super.getSize().height, super.getSize().width);
        chatLog.DrawEach(g);
    }

    public void sendText(String text) {
        chatLog.add("Sent", text);
    }

    public void receiveText(String text) {
        chatLog.add("Recived", text);
    }

    public void receiveMessage(String Message) {
        chatLog.add("Message", "System: " + Message);
    }
}
