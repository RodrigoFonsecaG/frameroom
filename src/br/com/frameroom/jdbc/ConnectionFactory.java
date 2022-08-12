/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.frameroom.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Rodrigo
 */
public class ConnectionFactory {
    public Connection getConnection(){
        try {
            
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1/frameroom", "usuario", "123");
                    
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
