import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindow extends Frame {
    public MyWindow(String title) {
        super(title);
        setSize(500,140);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        super.paint(g);
        Font sansSerifLarge = new Font("SansSerif", Font.BOLD, 18);
        Font sanSerifSmall = new Font("SansSerif",Font.BOLD, 12);
        g.setFont(sansSerifLarge);
        g.drawString("The complete Java Developer Course",60,60);
        g.setFont(sanSerifSmall);
        g.drawString("by Daniel",60,100);
    }
}
