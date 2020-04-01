package com.praktikum;

import java.awt.*;
import javax.swing.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ViewFormEdit extends JFrame{
    JPanel panel2 = new JPanel();

    Font fontt = new Font("SanSerif", Font.PLAIN, 20);

    JLabel lID = new JLabel("ID :");
    JTextField tfID = new JTextField();
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

    JButton btnUpdate = new JButton("Edit");
    JButton btnBatal = new JButton("Batal");

    public ViewFormEdit() {
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

        panel2.add(lID);
        lID.setBounds(250, 75, 90, 20);
        panel2.add(tfID);
        tfID.setBounds(350, 75, 120, 20);
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

        panel2.add(btnUpdate);
        btnUpdate.setBounds(250, 255, 90, 20);

        panel2.add(btnBatal);
        btnBatal.setBounds(350, 255, 90, 20);

    }
    public String gettfID(){
        return tfID.getText();
    }

    public String gettfJudul(){
        return tfjudul.getText();
    }
    public String gettfTipe(){
        return tftipe.getText();
    }
    public String gettfEpisode(){
        return tfepisode.getText();
    }
    public String gettfGenre(){
        return tfgenre.getText();
    }
    public String gettfStatus(){
        return tfstatus.getText();
    }
    public String gettfRating(){
        return tfrating.getText();
    }


}
