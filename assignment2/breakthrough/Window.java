package breakthrough;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Window extends BaseWindow {

    private final int size;
    private final Model model;
    private final JLabel label;
    private final JLabel red_label;
    private final JLabel blue_label;
    private final MainWindow mainWindow;
    private final JButton[][] buttons;
    
   
    public Window(int size, MainWindow mainWindow) {
        buttons = new JButton[size][size];
        this.size = size;
        this.mainWindow = mainWindow;
        model = new Model(size);

        JPanel top = new JPanel();
        
        label = new JLabel();
        red_label = new JLabel();
        blue_label = new JLabel();
        updateLabelText();
        
        JButton newGameButton = new JButton();
        newGameButton.setText("New game");
        newGameButton.addActionListener(e -> newGame());
        
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
        
        top.add(label);
        top.add(red_label);
        top.add(blue_label);
        top.add(newGameButton);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(size, size));
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (model.getPlayer(i, j) == Player.X) {
                    buttons[i][j] = new JButton("X");
                } else if (model.getPlayer(i, j) == Player.Y) {
                    buttons[i][j] = new JButton("Y");
                }else {
                    buttons[i][j] = new JButton();
                }
                
                mainPanel.add(buttons[i][j]);
            }
        }
        
        addButton(buttons);
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(top, BorderLayout.NORTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);
    }
   
    private void addButton(JButton[][] button) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int I = i;
                int J = j;
                button[i][j].addActionListener(e -> {
                    if (model.getPlayer(I, J) == Player.X || model.getPlayer(I, J) == Player.Y) {
                        model.step(I, J);
                        System.out.println("Step");
                    }else {
                        model.move(I, J);
                        System.out.println("Move");
                    }
                    for (int k = 0; k < size; k++) {
                        for (int l = 0; l < size; l++) {
                            buttons[k][l].setBackground(null);
                            if (model.getPlayer(k, l) == Player.X) {
                                buttons[k][l].setText("X");
                            }else if (model.getPlayer(k, l) == Player.Y) {
                                buttons[k][l].setText("Y");
                            }else if (model.getPlayer(k, l) == Player.S) {
                                buttons[k][l].setBackground(Color.GRAY);
                            }else if (model.getPlayer(k, l) == Player.SX) {
                                buttons[k][l].setText("X");
                                buttons[k][l].setBackground(Color.GRAY);
                            }else if (model.getPlayer(k, l) == Player.SY) {
                                buttons[k][l].setText("Y");
                                buttons[k][l].setBackground(Color.GRAY);
                            }else {
                                buttons[k][l].setText("");
                            }
                        }
                    }
                    updateLabelText();

                    Player winner = model.findWinner();
                    if (winner != Player.NOBODY) {
                        showGameOverMessage(winner);
                    }
                });
            }
        }
    }
    
    

    private void showGameOverMessage(Player winner) {
        JOptionPane.showMessageDialog(this,
                "Game is over. Winner: " + winner.name());
        newGame();
    }
    
    private void newGame() {
        Window newWindow = new Window(size, mainWindow);
        newWindow.setVisible(true);
        
        this.dispose();
        mainWindow.getWindowList().remove(this);
    }
    
    private void updateLabelText() {
        label.setText("Current player: "
                + model.getActualPlayer().name());
    }

    @Override
    protected void doUponExit() {
        super.doUponExit();
        mainWindow.getWindowList().remove(this);
    }
    
}
