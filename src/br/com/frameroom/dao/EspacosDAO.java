/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.frameroom.dao;

import br.com.frameroom.jdbc.ConnectionFactory;
import br.com.frameroom.model.Espacos;
import com.mysql.jdbc.JDBC4PreparedStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class EspacosDAO {
    
    private Connection con;
       
    public EspacosDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
        
    //Metodo cadastrarEspaco 
    public void cadastrarEspaco(Espacos obj){
        try {
            
            System.out.println(obj);
            
            // 1 - criar comando sql
            String sql = "INSERT INTO espacos (cod_espaco, tipo_espaco, numero, nome, capacidade, andar, descricao)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            
            //2 - conectar o bd e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getCod_espaco());
            stmt.setString(2, obj.getTipo_espaco());
            stmt.setInt(3, obj.getNumero());
            stmt.setString(4, obj.getNome());
            stmt.setInt(5, obj.getCapacidade());
            stmt.setInt(6, obj.getAndar());
            stmt.setString(7, obj.getDescricao());
  
            
            
            //3 - Executar comando sql
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Espaço cadastrado com sucesso!");
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }
    
    
    public void excluirEspaco(Espacos obj){
        try {
            
            // 1 - criar comando sql
            String sql = "delete from horarios where cod_espaco = ?";
            
            //2 - conectar o bd e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getCod_espaco());
            
            
            //3 - Executar comando sql
            stmt.execute();
            stmt.close();
            
            
            sql = "delete from reservas where cod_espaco = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getCod_espaco());
            stmt.execute();
            stmt.close();
            
            sql = "delete from espacos where cod_espaco = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getCod_espaco());
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Espaço excluido com sucesso!");
                    
                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }
    
    
    public void alterarEspaco(Espacos obj){
        try {
            // 1 - criar comando sql
            String sql = "UPDATE espacos SET cod_espaco = ?, tipo_espaco=?, numero=?, nome=?, capacidade=?, andar=?, descricao=? where cod_espaco = ?";
            
            //2 - conectar o bd e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNew_cod_espaco());
            stmt.setString(2, obj.getTipo_espaco());
            stmt.setInt(3, obj.getNumero());
            stmt.setString(4, obj.getNome());
            stmt.setInt(5, obj.getCapacidade());
            stmt.setInt(6, obj.getAndar());
            stmt.setString(7, obj.getDescricao());
            stmt.setString(8, obj.getCod_espaco());
  
            
            
            //3 - Executar comando sql
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Espaço alterado com sucesso!");
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }
    
    // Listar espaços
    public List<Espacos> listarEspacos(){
        try {
            
            //1 - Criar lista
            List<Espacos> lista = new ArrayList<>();
            
            //2 - Criar comando sql, organizar e executar
            String sql = "SELECT * FROM espacos";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Espacos obj = new Espacos();
                
                obj.setCod_espaco(rs.getString("cod_espaco"));
                obj.setTipo_espaco(rs.getString("tipo_espaco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setNome(rs.getString("nome"));
                obj.setCapacidade(rs.getInt("capacidade"));
                obj.setAndar(rs.getInt("andar"));
                obj.setDescricao(rs.getString("descricao"));
                
                lista.add(obj);
            }
            
            return lista;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
}
    
    //Metodo buscarEspacoPorTipo
    public List<Espacos> buscarEspacoPorTipo(String tipo_espaco){
     try {
            
            //1 - Criar lista
            List<Espacos> lista = new ArrayList<>();
            
            //2 - Criar comando sql, organizar e executar
            String sql = "SELECT * FROM espacos where tipo_espaco like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, tipo_espaco);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Espacos obj = new Espacos();
                
                obj.setCod_espaco(rs.getString("cod_espaco"));
                obj.setTipo_espaco(rs.getString("tipo_espaco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setNome(rs.getString("nome"));
                obj.setCapacidade(rs.getInt("capacidade"));
                obj.setAndar(rs.getInt("andar"));
                obj.setDescricao(rs.getString("descricao"));
                
                lista.add(obj);
            }
            
            return lista;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
}
    
    public List<Espacos> buscarEspacoPorAndar(int andar){
     try {
            
            //1 - Criar lista
            List<Espacos> lista = new ArrayList<>();
            
            //2 - Criar comando sql, organizar e executar
            String sql = "SELECT * FROM espacos where andar like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, andar);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Espacos obj = new Espacos();
                
                obj.setCod_espaco(rs.getString("cod_espaco"));
                obj.setTipo_espaco(rs.getString("tipo_espaco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setNome(rs.getString("nome"));
                obj.setCapacidade(rs.getInt("capacidade"));
                obj.setAndar(rs.getInt("andar"));
                obj.setDescricao(rs.getString("descricao"));
                
                lista.add(obj);
            }
            
            return lista;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
}
    
}
