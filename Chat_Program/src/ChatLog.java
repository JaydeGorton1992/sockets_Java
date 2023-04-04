
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 *
 * @author Owner
 */
public class ChatLog {

    ArrayList<chatLogElement> Log;
    int HEIGHT, WIDTH;

    public ChatLog() {
        Log = new ArrayList();
        HEIGHT = 1000;
        WIDTH = 1000;
    }

    public void setSize(int height, int width) {
        HEIGHT = height;
        WIDTH = width;
    }

    public void add(String type, String text) {
        Log.add(new chatLogElement(type, text));
    }

    public void DrawEach(Graphics g) {
        int x, y, c;
        c = 0;
        x = 0;
        if (Log.size() > 16) {
            c -= Log.size() - 16;
        }
        for (chatLogElement element : Log) {
            x = 0;

            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setFont(g.getFont());
            
            FontRenderContext frc = g2.getFontRenderContext();

            if(element.Type == "Message"){
                 g.setColor(new Color(155, 155, 155));
            }else{
            g.setColor(new Color(213, 213, 255));//light blue
            }
            Rectangle2D boundingBoxText = g.getFont().getStringBounds(element.Text, frc);

            x = 0;
            g.fillRoundRect(x, 0 + (25 * c), 0 + ((int) boundingBoxText.getWidth()), 25, 10, 10);
            g.setColor(Color.black);
            g.drawString(element.Text, x, 15 + (25 * c));
            g.getFont().getSize();
            c++;
        }
    }

    private class chatLogElement {

        String Type;
        String Text;

        public chatLogElement(String type, String text) {
            Type = type;
            Text = text;
        }
    }
}
