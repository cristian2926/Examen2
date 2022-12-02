/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.app.dao;


import java.util.List;
import pe.edu.upeu.app.modelo.ResultadoTO;

public interface ResultadoDaoI {
   public List ListarResultados();
   public int crearResultado(ResultadoTO re);
   public int update(ResultadoTO cl);
}
