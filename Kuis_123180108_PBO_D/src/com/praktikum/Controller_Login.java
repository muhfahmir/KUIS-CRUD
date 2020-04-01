package com.praktikum;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller_Login {
    View_Login view_login;

    public Controller_Login(View_Login view_login){
        this.view_login = view_login;
        view_login.btnLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (view_login.getUsername().equals("123180108")
                        && view_login.getPassword().equals("fahmi")){
                    JOptionPane.showMessageDialog(null, "Berhasil Login");
                    view_login.dispose();
                    MVC_Film mvc_film = new MVC_Film();
                }else{
                    JOptionPane.showMessageDialog(null, "Gagal Login");
                }

            }
        });

    }
}
