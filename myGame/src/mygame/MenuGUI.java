/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mygame;

import java.awt.*;
import javax.swing.*;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MenuGUI extends JPanel {
    public MenuGUI(LayoutManager layout) {super(layout);}
    @Override
    protected void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        ImageIcon menu = new ImageIcon("src/resources/snake.png");
        Image backgroundImg = menu.getImage();
        gr.drawImage(backgroundImg,0,0,null);
    }
}
