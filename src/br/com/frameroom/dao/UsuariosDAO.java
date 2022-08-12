/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.frameroom.dao;

import br.com.frameroom.jdbc.ConnectionFactory;
import br.com.frameroom.model.Usuarios;
import br.com.frameroom.view.Login;
import br.com.frameroom.view.Menu;
import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class UsuariosDAO{ 
    
    private Connection con;
       
    public UsuariosDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
        
    //Metodo cadastrarUsuario 
    public void cadastrarUsuario(Usuarios obj){
        try {
            
            
            // 1 - criar comando sql
            String sql = "INSERT INTO usuarios (cpf, nome, telefone, email, senha, cod_cargo)"
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            
            //2 - conectar o bd e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getCpf());
            stmt.setString(2, obj.getNome());
            stmt.setString(3, obj.getTelefone());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setInt(6, obj.getCod_cargo());
            
            
            //3 - Executar comando sql
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }
    
    public boolean verificaEmail(String email) {
        
        boolean existeEmail = false;
        
        try {
         String sql = "SELECT * FROM usuarios WHERE email = ?";

        PreparedStatement stmt = con.prepareStatement(sql);
        
        stmt.setString(1, email);
        
        ResultSet rs = stmt.executeQuery();
        
        if(rs.next()){
            existeEmail = true;
        }
        else{
            existeEmail = false;
        }
        

        
       
        } catch (Exception e) {
            
        }
        
        return existeEmail;
        

    }
    
        public boolean verificaCpf(String cpf) {
        
        boolean existeCpf = false;
        
        
        try {
         String sql = "SELECT * FROM usuarios WHERE cpf = ?";

        PreparedStatement stmt = con.prepareStatement(sql);
        
        stmt.setString(1, cpf);

        
        ResultSet rs = stmt.executeQuery();
        

        
        if(rs.next()){
            existeCpf = true;
        }
        else{
            existeCpf = false;
            
        }
        

        
       
        } catch (Exception e) {
            
        }
        
        
        return existeCpf;
        

    }
    
    
    
    public void efetuaLogin(String email, String senha){
        try {
            
            String sql = "select * from usuarios where email = ? and senha = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
        
            ResultSet rs = stmt.executeQuery();
            
            
            if(rs.next()){
                // Usuario logou
                
                // Caso o usuario seja admin
                if(rs.getInt("cod_cargo") == 9){

                    JOptionPane.showMessageDialog(null, "Bem-vindo ao Frameroom");
                    Menu tela = new Menu();
                    tela.usuarioLogadoNome = rs.getString("nome");
                    tela.usuarioLogadoCpf = rs.getString("cpf");
                    tela.usuarioCodCargo = rs.getInt("cod_cargo");
                    tela.setVisible(true);
                }
                
                //caso usuario nao seja admin
                else if(rs.getInt("cod_cargo") != 9){

                    JOptionPane.showMessageDialog(null, "Bem-vindo ao Frameroom");
                    Menu tela = new Menu();
                    tela.usuarioLogadoNome = rs.getString("nome");
                    tela.usuarioLogadoCpf = rs.getString("cpf");
                    tela.usuarioCodCargo = rs.getInt("cod_cargo");
                    
                    //Desabilitar menus
                    tela.btnSideCadastrarEspaco.setEnabled(false);
                    tela.btnSideCadastrarEspaco.setVisible(false);
                    
                    tela.btnSideCadastrarHorarios.setEnabled(false);
                    tela.btnSideCadastrarHorarios.setVisible(false);
                    
                    tela.btnSideSolicitacoes.setEnabled(false);
                    tela.btnSideSolicitacoes.setVisible(false);
                   
                    tela.selectTipo.setEnabled(false);
                    tela.selectAndar.setEnabled(false);
                    tela.txtNumero.setEditable(false);
                    tela.txtCapacidade.setEditable(false);
                    tela.txtDescricao.setEditable(false);
                    
                    tela.btnEditar.setVisible(false);
                    tela.btnEditar.setEnabled(false);
                    tela.btnEditar.setOpaque(false);
                    tela.btnEditar.setContentAreaFilled(false);
                    tela.btnEditar.setBorderPainted(false);
                    tela.btnEditar.setText("");
                    
                    tela.btnExcluir.setVisible(false);
                    tela.btnExcluir.setEnabled(false);
                    tela.btnExcluir.setOpaque(false);
                    tela.btnExcluir.setContentAreaFilled(false);
                    tela.btnExcluir.setBorderPainted(false);
                    tela.btnExcluir.setText("");
                    
                    tela.separador1.setVisible(false);
                    tela.separador2.setVisible(false);
                    tela.separador3.setVisible(false);
                    
               
                    tela.setVisible(true);
                }

                
                
            }
            
            else{
                // Dados incorretos
                JOptionPane.showMessageDialog(null, "Dados incorretos!");
                
                Login login = new Login();
                login.setVisible(true);
            }
                    
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }
}
