/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.frameroom.dao;

import br.com.frameroom.jdbc.ConnectionFactory;
import br.com.frameroom.model.Espacos;
import br.com.frameroom.model.Horarios;
import br.com.frameroom.model.Reservas;
import br.com.frameroom.model.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class HorariosDAO {
    private Connection con;
       
    public HorariosDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    //Metodo cadastrarProdutos 
    public void cadastrarHorarios(Horarios obj){
        try {
            
            
            // 1 - criar comando sql
            String sql = "INSERT INTO horarios (cod_espaco, dia, intervalo_1, intervalo_2, intervalo_3, intervalo_4, intervalo_5, intervalo_6, intervalo_7, intervalo_8, intervalo_9, intervalo_10, intervalo_11, intervalo_12,  intervalo_13,  intervalo_14,  intervalo_15,  intervalo_16)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE cod_espaco = VALUES(cod_espaco), dia = VALUES(dia), intervalo_1 = VALUES(intervalo_1), intervalo_2 = VALUES(intervalo_2), intervalo_3 = VALUES(intervalo_3), intervalo_4 = VALUES(intervalo_4), intervalo_5 = VALUES(intervalo_5), intervalo_6 = VALUES(intervalo_6), intervalo_7 = VALUES(intervalo_7) , intervalo_8 = VALUES(intervalo_8) , intervalo_9 = VALUES(intervalo_9) , intervalo_10 = VALUES(intervalo_10) , intervalo_11 = VALUES(intervalo_11) , intervalo_12 = VALUES(intervalo_12), intervalo_13 = VALUES(intervalo_13), intervalo_14 = VALUES(intervalo_14), intervalo_15 = VALUES(intervalo_15), intervalo_16 = VALUES(intervalo_16)";
            
            //2 - conectar o bd e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getCod_espaco());
            stmt.setString(2, obj.getDia());
            stmt.setString(3, obj.getIntervalo_1());
            stmt.setString(4, obj.getIntervalo_2());
            stmt.setString(5, obj.getIntervalo_3());
            stmt.setString(6, obj.getIntervalo_4());
            stmt.setString(7, obj.getIntervalo_5());
            stmt.setString(8, obj.getIntervalo_6());
            stmt.setString(9, obj.getIntervalo_7());
            stmt.setString(10, obj.getIntervalo_8());
            stmt.setString(11, obj.getIntervalo_9());
            stmt.setString(12, obj.getIntervalo_10());
            stmt.setString(13, obj.getIntervalo_11());
            stmt.setString(14, obj.getIntervalo_12());
            stmt.setString(15, obj.getIntervalo_13());
            stmt.setString(16, obj.getIntervalo_14());
            stmt.setString(17, obj.getIntervalo_15());
            stmt.setString(18, obj.getIntervalo_16());
 
          
            
            
            //3 - Executar comando sql
            stmt.execute();
            stmt.close();
            
            
            
            
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }
    
    
    // Listar reservas
    public List<Horarios> listarHorarios(String cod_espaco, String dia){
        try {
            
            //1 - Criar lista
            List<Horarios> lista = new ArrayList<>();
            
            //2 - Criar comando sql, organizar e executar
            String sql = "SELECT * FROM horarios WHERE cod_espaco = ? AND dia= ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cod_espaco);
            stmt.setString(2, dia);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Horarios obj = new Horarios();                

                
                obj.setCod_espaco(rs.getString("cod_espaco"));
                obj.setDia(rs.getString("dia"));
                obj.setIntervalo_1(rs.getString("intervalo_1"));
                obj.setIntervalo_2(rs.getString("intervalo_2"));
                obj.setIntervalo_3(rs.getString("intervalo_3"));
                obj.setIntervalo_4(rs.getString("intervalo_4"));
                obj.setIntervalo_5(rs.getString("intervalo_5"));
                obj.setIntervalo_6(rs.getString("intervalo_6"));
                obj.setIntervalo_7(rs.getString("intervalo_7"));
                obj.setIntervalo_8(rs.getString("intervalo_8"));
                obj.setIntervalo_9(rs.getString("intervalo_9"));
                obj.setIntervalo_10(rs.getString("intervalo_10"));
                obj.setIntervalo_11(rs.getString("intervalo_11"));
                obj.setIntervalo_12(rs.getString("intervalo_12"));
                obj.setIntervalo_13(rs.getString("intervalo_13"));
                obj.setIntervalo_14(rs.getString("intervalo_14"));
                obj.setIntervalo_15(rs.getString("intervalo_15"));
                obj.setIntervalo_16(rs.getString("intervalo_16"));
                

                
        
                lista.add(obj);
            }
            
            return lista;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }
}
