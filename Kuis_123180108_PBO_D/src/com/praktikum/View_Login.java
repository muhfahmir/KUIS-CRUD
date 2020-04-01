package com.praktikum;

import javax.swing.*;
import java.awt.*;

public class View_Login extends JFrame {

    Font fontt = new Font("SanSerif", Font.PLAIN, 20);
    JLabel lusername = new JLabel("Username :");
    JTextField tfusername = new JTextField();
    JLabel lpassword = new JLabel("Password :");
    JPasswordField tfpassword = new JPasswordField();
    JButton btnLogin = new JButton("LOGIN");
    JLabel label = new JLabel("LOGIN ADMIN");
    public View_Login(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("LOGIN");
        setVisible(true);
        setLayout(null);
        setSize(300, 250);
        setBackground(Color.white);

        add(label);
        label.setFont(fontt);
        label.setBounds(60, 20, 250, 20);

        add(lusername);
        lusername.setBounds(30, 80, 90, 20);
        add(tfusername);
        tfusername.setBounds(115, 80, 120, 20);

        add(lpassword);
        lpassword.setBounds(30, 105, 90, 20);
        add(tfpassword);
        tfpassword.setBounds(115, 105, 120, 20);

        add(btnLogin);
        btnLogin.setBounds(80, 135, 90, 20);

    }

    public String getUsername() {
        return tfusername.getText();
    }

    public String getPassword() {
        return tfpassword.getText();
    }


}

