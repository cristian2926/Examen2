/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package pe.edu.upeu.app;

import pe.edu.upeu.app.gui.JuegoGui;
import pe.edu.upeu.app.gui.MainJuego;
import pe.edu.upeu.app.modelo.ModeloJuego;

public class PruebaTresRaya {

    public static void main(String[] args) {
        ModeloJuego modelo = new ModeloJuego();
        MainJuego ventana = new MainJuego();
        
        JuegoGui juego = new JuegoGui(ventana, modelo);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        //new MainJuego().setVisible(true);

    }
}
