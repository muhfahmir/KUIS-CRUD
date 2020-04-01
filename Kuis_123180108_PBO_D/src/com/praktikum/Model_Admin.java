package com.praktikum;

import javax.swing.*;
import java.sql.*;

public class Model_Admin {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/kuis_pbo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static final String DB_USER = "root";
    static final String DB_PASS = "";

    Connection koneksi;
    Statement statement;
    int rs;

    public Model_Admin(){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi=(Connection) DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
        }catch(SQLException ex){
            System.err.println("Gagal koneksi");
        }catch (ClassNotFoundException ex){
            System.err.println(ex);
        }
    }

    public void insertFilm(String judul,String tipe,String episode,String genre,String status,String rating){
        try{
            String query = "INSERT INTO `film`(`judul`, `tipe`, `episode`, `genre`, `status`, `rating`) " +
                    "VALUES ('"+ judul+"','"+tipe+"','"+episode+"','"+genre+"','"+status+"','"+rating+"')";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil disimpan!");
        } catch (SQLException sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * FROM `film`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++;
            }
            return jmlData;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }

    public String[][] readFilm(){
        try{
            int jmlData=0;
            String data[][] = new String[getBanyakData()][7];
            String query = "SELECT * FROM `film`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("id");
                data[jmlData][1] = resultSet.getString("judul");
                data[jmlData][2] = resultSet.getString("tipe");
                data[jmlData][3] = resultSet.getString("episode");
                data[jmlData][4] = resultSet.getString("genre");
                data[jmlData][5] = resultSet.getString("status");
                data[jmlData][6] = resultSet.getString("rating");
                jmlData++;
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public void deleteFilm(String id){
        try{
            String query = "DELETE FROM `film` WHERE `id` = '"+id+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");

        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }

    }

    public void updateFilm(String id,String judul,String tipe,String episode,String genre,String status,String rating){
        try{
            statement = koneksi.createStatement();
            String query = "UPDATE `film` SET `judul`='"+judul+"',`tipe`='"+tipe+"',`episode`='"
                    +episode+"',`genre`='"+genre+"',`status`='"+status+"',`rating`='"
                    +rating+"' WHERE `id` = '"+id+"'";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Edit Data Sukses!");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public String[][] searchFilm(String judul){
        try{
            int jmlData=0;
            String data[][] = new String[getBanyakDataFilm(judul)][7];
            String query = "SELECT * FROM film where judul like '%"+judul+"%'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("id");
                data[jmlData][1] = resultSet.getString("judul");
                data[jmlData][2] = resultSet.getString("tipe");
                data[jmlData][3] = resultSet.getString("episode");
                data[jmlData][4] = resultSet.getString("genre");
                data[jmlData][5] = resultSet.getString("status");
                data[jmlData][6] = resultSet.getString("rating");
                jmlData++;
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public int getBanyakDataFilm(String judul){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * FROM film where judul like '%"+judul+"%'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++;
            }
            return jmlData;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }




}

