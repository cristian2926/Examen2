/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.app.dao;


import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.upeu.app.coon.ConnS;
import pe.edu.upeu.app.modelo.ResultadoTO;

/**
 *
 * @author INTEL
 */
public class ResultadoDao implements ResultadoDaoI{
    ConnS instance = ConnS.getInstance();
    Connection conexion = instance.getConnection();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List ListarResultados() {
       List<ResultadoTO> lista =new ArrayList();
       String sql = "select * from resultados";
        try {
            ps=conexion.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                ResultadoTO to = new ResultadoTO();
                to.setId_Resultado(rs.getInt("id_resultado"));
                to.setNombre_partida(rs.getString("nombre_partida"));
                to.setNombre_jugador1(rs.getString("nombre_jugador1"));
                to.setNombre_jugador2(rs.getString("nombre_jugador2"));
                to.setGanador(rs.getString("ganador"));
                to.setPunto(rs.getInt("punto"));
                to.setEstado(rs.getString("estado"));
                 lista.add(to);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public int crearResultado(ResultadoTO re) {
        int exec = 0;
        int i=0;
        String sql="insert into resultados(nombre_partida, nombre_jugador1, nombre_jugador2,ganador, punto, estado)  values(?,?,?,?,?,?)";
        
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(++i, re.getNombre_partida());
            ps.setString(++i, re.getNombre_jugador1());
            ps.setString(++i, re.getNombre_jugador2());
            ps.setString(++i, re.getGanador());
            ps.setInt(++i, re.getPunto());
            ps.setString(++i, re.getEstado());
            exec = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return exec;
    }

    @Override
    public int update(ResultadoTO cl) {
        int exec = 0;
        int i = 0;
        
        String sql = " update resultados set ganador=?, punto=?, estado=? where nombre_partida=?";
        
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, cl.getGanador());
            ps.setInt(2, cl.getPunto());
            ps.setString(3, cl.getEstado());
            ps.setString(4, cl.getNombre_partida());
            
             exec = ps.executeUpdate();
        } catch (Exception e) {
        }
        return exec;
    }

   

    
}
