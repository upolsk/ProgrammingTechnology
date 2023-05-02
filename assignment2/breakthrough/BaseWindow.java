package breakthrough;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class BaseWindow extends JFrame {
    
    public BaseWindow() {
        setTitle("Breakthrough Board Game");
        setSize(1000, 700);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                showExitConfirmation();
            }

        });
        URL url = Window.class.getResource("icon.gif");
        setIconImage(Toolkit.getDefaultToolkit().getImage(url));
    }
    private void showExitConfirmation() {
        int n = JOptionPane.showConfirmDialog(this, "Do you really want to quit?",
                "Really?", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            doUponExit();
        }
    }
    protected void doUponExit() {
        this.dispose();
    }
}
