package com.praktikum;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller_Film {

    Model_Admin modelAdmin;
    View_Admin viewAdmin;
    ViewFormEdit viewFormEdit;
    String dataterpilih = null;
    int baris,kolom;

    public Controller_Film(View_Admin view_admin, Model_Admin model_admin) {
        this.modelAdmin = model_admin;
        this.viewAdmin = view_admin;

        if (modelAdmin.getBanyakData() != 0) {
            String dataFilm[][] = modelAdmin.readFilm();
            viewAdmin.tabel.setModel(new JTable(dataFilm, viewAdmin.namaKolom).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        viewAdmin.btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (viewAdmin.getJudul().equals("")
                        || viewAdmin.getTipe().equals("")
                        || viewAdmin.getEpisode().equals("")
                        || viewAdmin.getGenre().equals("")
                        || viewAdmin.getStatus().equals("")
                        || viewAdmin.getRating().equals("")) {
                    JOptionPane.showMessageDialog(null, "field kosong");
                } else {
                    String judul = viewAdmin.getJudul();
                    String tipe = viewAdmin.getTipe();
                    String episode = viewAdmin.getEpisode();
                    String genre= viewAdmin.getGenre();
                    String status = viewAdmin.getStatus();
                    String rating = viewAdmin.getRating();
                    modelAdmin.insertFilm(judul, tipe, episode,genre,status,rating);

                }
            }

        });
        viewAdmin.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                baris = viewAdmin.tabel.getSelectedRow();
                kolom = viewAdmin.tabel.getSelectedColumn();

                dataterpilih = viewAdmin.tabel.getValueAt(baris, 0).toString();
                System.out.println(dataterpilih);
                if (dataterpilih != null) {
                    viewAdmin.btnDelete.setEnabled(true);
                    viewAdmin.btnUpdate.setEnabled(true);
                    viewAdmin.btnCreate.setEnabled(false);
                }
            }

        });

        view_admin.btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTable();
                viewAdmin.btnDelete.setEnabled(false);
                viewAdmin.btnUpdate.setEnabled(false);
                viewAdmin.btnCreate.setEnabled(true);
                view_admin.tfsearch.setText("");
                view_admin.tfrating.setText("");
                view_admin.tfstatus.setText("");
                view_admin.tfgenre.setText("");
                view_admin.tfepisode.setText("");
                view_admin.tftipe.setText("");
                view_admin.tfjudul.setText("");
            }
        });

        viewAdmin.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    if (dataterpilih != null) {
                        modelAdmin.deleteFilm(dataterpilih);
                        viewAdmin.btnDelete.setEnabled(true);
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("Gagal Hapus!");
                }
            }
        });
        viewAdmin.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                    if(dataterpilih != null){
                        String dataEditID = viewAdmin.tabel.getValueAt(baris,0).toString();
                        String dataEditJudul = viewAdmin.tabel.getValueAt(baris,1).toString();
                        String dataEditTipe = viewAdmin.tabel.getValueAt(baris,2).toString();
                        String dataEditEpisode = viewAdmin.tabel.getValueAt(baris,3).toString();
                        String dataEditGenre = viewAdmin.tabel.getValueAt(baris,4).toString();
                        String dataEditStatus = viewAdmin.tabel.getValueAt(baris,5).toString();
                        String dataEditRating = viewAdmin.tabel.getValueAt(baris,6).toString();
                        
                        viewFormEdit = new ViewFormEdit();

                        viewAdmin.dispose();
                        viewFormEdit.tfID.setText(dataEditID);
                        viewFormEdit.tfjudul.setText(dataEditJudul);
                        viewFormEdit.tftipe.setText(dataEditTipe);
                        viewFormEdit.tfepisode.setText(dataEditEpisode);
                        viewFormEdit.tfgenre.setText(dataEditGenre);
                        viewFormEdit.tfstatus.setText(dataEditStatus);
                        viewFormEdit.tfrating.setText(dataEditRating);
                        viewFormEdit.tfID.setEditable(false);

                        viewFormEdit.btnBatal.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                viewFormEdit.dispose();
                                MVC_Film mvc_film = new MVC_Film();
                            }
                        });

                        viewFormEdit.btnUpdate.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                if(dataterpilih != null){
                                    modelAdmin.updateFilm(
                                            viewFormEdit.gettfID(),
                                            viewFormEdit.gettfJudul(),
                                            viewFormEdit.gettfTipe(),
                                            viewFormEdit.gettfEpisode(),
                                            viewFormEdit.gettfGenre(),
                                            viewFormEdit.gettfStatus(),
                                            viewFormEdit.gettfRating()

                                    );
                                    viewFormEdit.dispose();
                                    MVC_Film mvc_film = new MVC_Film();
                                }
                            }
                        });
                    }
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                    System.out.println("Edit Gagal!");
                }
            }
        });

        view_admin.btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (viewAdmin.getSearch().equals("")) {
                    JOptionPane.showMessageDialog(null, "field kosong");
                } else {
                    String judul = viewAdmin.getSearch();
                    String dataFilm[][] = modelAdmin.searchFilm(judul);
                    viewAdmin.tabel.setModel(new JTable(dataFilm, viewAdmin.namaKolom).getModel());

                }
            }
        });

        view_admin.btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view_admin.dispose();
                VC_Login vc_login = new VC_Login();
            }
        });

    }

    private void updateTable() {
        String dataFilm[][] = modelAdmin.readFilm();
        viewAdmin.tabel.setModel(new JTable(dataFilm, viewAdmin.namaKolom).getModel());
    }
}
