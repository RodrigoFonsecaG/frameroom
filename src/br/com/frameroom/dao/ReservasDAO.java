/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.frameroom.dao;

import br.com.frameroom.jdbc.ConnectionFactory;
import br.com.frameroom.model.Espacos;
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
public class ReservasDAO {
     private Connection con;
       
    public ReservasDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    //Metodo cadastrarProdutos 
    public void cadastrarReservas(Reservas obj){
        try {
            
            
            // 1 - criar comando sql
            String sql = "INSERT INTO reservas (data, hora_inicio, hora_fim, cpf_usuario, cod_espaco, mensagem)"
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            
            //2 - conectar o bd e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setDate(1, obj.getData());
            stmt.setString(2, obj.getHora_inicio());
            stmt.setString(3, obj.getHora_fim());
            stmt.setString(4, obj.getUsuario_cpf());
            stmt.setString(5, obj.getEspaco().getCod_espaco());
            stmt.setString(6, obj.getMensagem());
            
            
            //3 - Executar comando sql
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Sua solitação de reserva foi feita com sucesso! \n Aguarde retorno. ");
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }
    
    // Listar reservas
    public List<Reservas> listarReservas(){
        try {
            
            //1 - Criar lista
            List<Reservas> lista = new ArrayList<>();
            
            //2 - Criar comando sql, organizar e executar
            String sql = "SELECT r.* , u.nome AS usuario_nome, u.cod_cargo, u.email, u.telefone, c.cargo AS usuario_cargo, e.nome AS espaco_nome " +
            "FROM reservas AS r " +
            "LEFT JOIN usuarios AS u " +
            "ON r.cpf_usuario = u.cpf " +
            "LEFT JOIN cargos AS c " +
            "ON c.cod_cargo = u.cod_cargo " +
            "LEFT JOIN espacos AS e " +
            "ON r.cod_espaco = e.cod_espaco";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Reservas obj = new Reservas();                
                Espacos e = new Espacos();
                Usuarios u = new Usuarios();

                
                obj.setData(rs.getDate("r.data"));
                obj.setHora_inicio(rs.getString("r.hora_inicio"));
                obj.setHora_fim(rs.getString("r.hora_fim"));
                obj.setMensagem(rs.getString("r.mensagem"));
                obj.setCod_reserva(rs.getInt("r.cod_reserva"));
                
                u.setNome(rs.getString("usuario_nome"));
                u.setCod_cargo(rs.getInt("u.cod_cargo"));
                u.setEmail(rs.getString("u.email"));
                u.setTelefone(rs.getString("u.telefone"));
                u.setCargo(rs.getString("usuario_cargo"));
                
                e.setNome(rs.getString("espaco_nome"));
                
                obj.setUsuario(u);
                obj.setEspaco(e);
                
        
                lista.add(obj);
            }
            
            return lista;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }
    
    public List<Reservas> listarReservarPrioridade(){
     try {
            
           //1 - Criar lista
            List<Reservas> lista = new ArrayList<>();
            
            //2 - Criar comando sql, organizar e executar
            String sql = "SELECT r.* , u.nome AS usuario_nome, u.cod_cargo, u.email, u.telefone, c.cargo AS usuario_cargo, e.nome AS espaco_nome " +
            "FROM reservas AS r " +
            "LEFT JOIN usuarios AS u " +
            "ON r.cpf_usuario = u.cpf " +
            "LEFT JOIN cargos AS c " +
            "ON c.cod_cargo = u.cod_cargo " +
            "LEFT JOIN espacos AS e " +
            "ON r.cod_espaco = e.cod_espaco " + 
            "ORDER BY c.cod_cargo";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Reservas obj = new Reservas();                
                Espacos e = new Espacos();
                Usuarios u = new Usuarios();

                
                obj.setData(rs.getDate("r.data"));
                obj.setHora_inicio(rs.getString("r.hora_inicio"));
                obj.setHora_fim(rs.getString("r.hora_fim"));
                obj.setMensagem(rs.getString("r.mensagem"));
                obj.setCod_reserva(rs.getInt("r.cod_reserva"));
                
                u.setNome(rs.getString("usuario_nome"));
                u.setCod_cargo(rs.getInt("u.cod_cargo"));
                u.setEmail(rs.getString("u.email"));
                u.setTelefone(rs.getString("u.telefone"));
                u.setCargo(rs.getString("usuario_cargo"));
                
                e.setNome(rs.getString("espaco_nome"));
                
                obj.setUsuario(u);
                obj.setEspaco(e);
                
        
                lista.add(obj);
            }
            
            return lista;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
}
    
     
    public void excluirReserva(Reservas obj){
        try {
            
            // 1 - criar comando sql
            String sql = "delete from reservas where cod_reserva = ?";
            
            //2 - conectar o bd e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getCod_reserva());
            
            //3 - Executar comando sql
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Solicitação de reserva excluida com sucesso!");
                    
                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }

}
