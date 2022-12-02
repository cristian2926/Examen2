/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.app.modelo;

import lombok.Data;

@Data
public class ResultadoTO {
   public int Id_Resultado, punto;
   public String nombre_partida, nombre_jugador1, nombre_jugador2, ganador, estado;
}
