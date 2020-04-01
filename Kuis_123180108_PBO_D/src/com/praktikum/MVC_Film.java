package com.praktikum;

public class MVC_Film {
    Model_Admin model_admin=new Model_Admin();
    View_Admin view_admin = new View_Admin();
    Controller_Film controller_film = new Controller_Film(view_admin,model_admin);
}
