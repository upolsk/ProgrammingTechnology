/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mygame;
import java.io.IOException;

public class MainWindow
{
    public static void main(String[] args)
    {
        try{
            new SnakeGameGUI();
        }catch(Exception e ){
            System.out.println(e);
        }
        
    }
}