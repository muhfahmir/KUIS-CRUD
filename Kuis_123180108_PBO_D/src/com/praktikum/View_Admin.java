package com.praktikum;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class View_Admin extends JFrame {

    JPanel panel2 = new JPanel();

    Font fontt = new Font("SanSerif", Font.PLAIN, 20);

    JLabel ljudul = new JLabel("Judul :");
    JTextField tfjudul = new JTextField();
    JLabel ltipe = new JLabel("Tipe :");
    JTextField tftipe = new JTextField();
    JLabel lepisode = new JLabel("Episode :");
    JTextField tfepisode = new JTextField();
    JLabel lstatus = new JLabel("Status :");
    JTextField tfstatus = new JTextField();
    JLabel lgenre = new JLabel("Genre :");
    JTextField tfgenre = new JTextField();
    JLabel lrating = new JLabel("Rating :");
    JTextField tfrating = new JTextField();

    JTextField tfsearch = new JTextField();

    JButton btnCreate = new JButton("Create");
    JButton btnUpdate = new JButton("Update");
    JButton btnDelete = new JButton("Delete");
    JButton btnExit = new JButton("Exit");
    JButton btnSearch = new JButton("Search");
    JButton btnRefresh   = new JButton("Refresh");

    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"ID","JUDUL","TIPE","EPISODE","GENRE","STATUS","RATING"};

    public View_Admin() {

        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);

        setTitle("DATA FILM ASULOLE");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(1000, 800);

        JLabel label = new JLabel("-DATA FILM ASULOLE-");
        panel2.add(label);
        label.setBounds(250, 20, 300, 20);
        label.setFont(fontt);

        add (panel2);

        panel2.setBounds(10, 10, 1000, 800);
        panel2.setLayout(null);
        panel2.setBackground(Color.white);

        panel2.add(ljudul);
        ljudul.setBounds(250, 100, 90, 20);
        panel2.add(tfjudul);
        tfjudul.setBounds(350, 100, 120, 20);
        panel2.add(ltipe);
        ltipe.setBounds(250, 125, 90, 20);
        panel2.add(tftipe);
        tftipe.setBounds(350, 125, 120, 20);
        panel2.add(lepisode);
        lepisode.setBounds(250, 150, 90, 20);
        panel2.add(tfepisode);
        tfepisode.setBounds(350, 150, 120, 20);

        panel2.add(lstatus);
        lstatus.setBounds(250, 175, 90, 20);
        panel2.add(tfstatus);
        tfstatus.setBounds(350, 175, 120, 20);

        panel2.add(lgenre);
        lgenre.setBounds(250, 200, 90, 20);
        panel2.add(tfgenre);
        tfgenre.setBounds(350, 200, 120, 20);

        panel2.add(lrating);
        lrating.setBounds(250, 225, 90, 20);
        panel2.add(tfrating);
        tfrating.setBounds(350, 225, 120, 20);

        panel2.add(btnRefresh);
        btnRefresh.setBounds(120, 255, 90, 20);

        panel2.add(btnCreate);
        btnCreate.setBounds(240, 255, 90, 20);

        panel2.add(btnUpdate);
        btnUpdate.setBounds(360, 255, 90, 20);

        panel2.add(btnDelete);
        btnDelete.setBounds(480, 255, 90, 20);

        panel2.add(btnExit);
        btnExit.setBounds(600, 255, 90, 20);

        panel2.add(tfsearch);
        tfsearch.setBounds(50, 290, 530, 20);
        panel2.add(btnSearch);
        btnSearch.setBounds(600, 290, 90, 20);

        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);

        panel2.add(scrollPane);
        scrollPane.setBounds(20, 320, 800, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    }

//    ID","JUDUL","TIPE","EPISODE","GENRE","STATUS","RATING"

    public String getJudul(){
        return tfjudul.getText();
    }
    public String getTipe(){
        return tftipe.getText();
    }
    public String getEpisode(){
        return tfepisode.getText();
    }
    public String getGenre(){
        return tfgenre.getText();
    }
    public String getStatus(){
        return tfstatus.getText();
    }
    public String getRating(){
        return tfrating.getText();
    }
    public String getSearch(){
        return tfsearch.getText();
    }


}