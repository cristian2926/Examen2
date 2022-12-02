/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.app.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import pe.edu.upeu.app.modelo.ModeloJuego;

public class JuegoGui {

    private MainJuego ventana;
    private ModeloJuego modelo;
    private JButton[][] MatrizButton;

    public JuegoGui(MainJuego ventan, ModeloJuego modelo) {
        this.ventana = ventan;
        this.modelo = modelo;
        MatrizButton = this.ventana.getMatrizButton();

        crearPlayer();
        
        JButton Iniciar = ventana.getIniciar();
        Iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarListeners();

            }
        });
        JButton Anular = ventana.getAnular();
        Anular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.anularJP(ventana,MatrizButton);

            }
        });
    }

    public void agregarListeners() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                agregarEventoMouse(i, j);

            }
        }
        /*JButton Anular=ventana.getAnular();
        Anular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
               // modelo.resetJP(MatrizButton);
              
                      
        }
     });*/
 /*JButton Iniciar=ventana.getInicio();
        Iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                modelo.resetJP(MatrizButton);
                      
        }
     });*/
    }

    private void agregarEventoMouse(int i, int j) {
        JButton ABtn = MatrizButton[i][j];
        ABtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                modelo.marcarBtn(i, j, MatrizButton, ABtn, ventana);
            }
        });

    }

    private void crearPlayer() {
        JLabel j1 = ventana.getVitoriasJ1();
        JLabel j2 = ventana.getVitoriasJ2();
        modelo.setPlayer(j1, j2);
    }
     private void crearTurno() {
        JLabel j1 = ventana.getTurnar();
        
        modelo.setturno(j1);
    }

}
