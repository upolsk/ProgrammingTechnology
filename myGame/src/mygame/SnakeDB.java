/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mygame;

import java.sql.*;
import java.util.*;
import mygame.HighScore;


public class SnakeDB {
    private int maxNumOfScores;
    private PreparedStatement insertStatement;
    private PreparedStatement deleteStatement;
    private PreparedStatement defaultStatement;
    private Connection conn;  

    public SnakeDB() throws SQLException{
        this.maxNumOfScores =  10 ;
        String dataBaseURL = "jdbc:mysql://localhost/highscores?"
                    + "serverTimezone=UTC&user=root&password=x8VmhunQ";  
        String insertQuery = "INSERT INTO HIGHSCORES ( NAME, SCORE) VALUES (?, ?)";
        String deleteQuery = "DELETE FROM HIGHSCORES WHERE SCORE=?";
        String createQuery = "CREATE TABLE HIGHSCORES (Id int(20) primary key auto_increment, NAME varchar(200) not null, SCORE int(20))";
        this.conn = DriverManager.getConnection(dataBaseURL);
        this.defaultStatement = conn.prepareStatement(createQuery);
        this.insertStatement = conn.prepareStatement(insertQuery);
        this.deleteStatement = conn.prepareStatement(deleteQuery);
    }

    public ArrayList<HighScore> getHighScores() throws SQLException {
        ArrayList<HighScore> highScores = new ArrayList<>();
        String query = "SELECT * FROM HIGHSCORES";
        Statement statement = conn.createStatement();
        ResultSet results ;
        try{
            results = statement.executeQuery(query);
        }catch(SQLException e){
            defaultStatement.execute();
            results = statement.executeQuery(query);
        }
        while (results.next()) {
            highScores.add(new HighScore(results.getString("NAME"), results.getInt("SCORE")));
        }
        sortByScore(highScores);
        return highScores;
    }
    
    private void insertScore(String name, int score) throws SQLException {
       try{
            insertStatement.setString(1, name);
            insertStatement.setInt(2, score);
            insertStatement.executeUpdate();
        } catch(SQLException e){
            defaultStatement.executeUpdate();
            insertStatement.setString(1, name);
            insertStatement.setInt(2, score);
            insertStatement.executeUpdate();
        }
    }

    public void putHighScore(String pName, int score) throws SQLException {
        ArrayList<HighScore> currentHighScores = getHighScores();
        if (currentHighScores.size() < maxNumOfScores){
            insertScore(pName, score);
        }else{
            int smallestScore = currentHighScores.get(currentHighScores.size() - 1).getScore();
            if (smallestScore < score){
                deleteScores(smallestScore);
                insertScore(pName, score);
            }
        }
    }


    private void sortByScore(ArrayList<HighScore> highScores){
        highScores.sort(HighScore::compareByScore);
    }

    private void deleteScores(int score) throws SQLException {
        deleteStatement.setInt(1, score);
        deleteStatement.executeUpdate();
    }
        
    public String[] getColumnNamesArray(){
        String[] columnNames = {"ID", "Name", "Score"};
        return columnNames;
    }
    
    public String[][] getDataTable() throws SQLException{
        ArrayList<HighScore> currentHighscores = getHighScores();
        String[][] data = new String[10][3];
        int ID = 1, counter=0;

        for(HighScore hs : currentHighscores){
            data[counter][0] = Integer.toString(ID++);
            data[counter][1] = hs.getName();
            data[counter][2] = Integer.toString(hs.getScore());
            counter++;
        }
        while(counter < 10){
            data[counter][0] = Integer.toString(ID++);
            data[counter][1] = "";
            data[counter][2] = "";
            counter++;
        }
        return data;
    }
}
