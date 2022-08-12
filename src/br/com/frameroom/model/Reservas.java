/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.frameroom.model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Rodrigo
 */
public class Reservas {
    
    private int cod_reserva;
    private Date data;
    private String hora_inicio;
    private String hora_fim;
    private String usuario_cpf;
    private Espacos espaco;
    private Usuarios usuario;
    private String mensagem;

    public int getCod_reserva() {
        return cod_reserva;
    }

    public void setCod_reserva(int cod_reserva) {
        this.cod_reserva = cod_reserva;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_fim() {
        return hora_fim;
    }

    public void setHora_fim(String hora_fim) {
        this.hora_fim = hora_fim;
    }

    public String getUsuario_cpf() {
        return usuario_cpf;
    }

    public void setUsuario_cpf(String usuario_cpf) {
        this.usuario_cpf = usuario_cpf;
    }

    public Espacos getEspaco() {
        return espaco;
    }

    public void setEspaco(Espacos espaco) {
        this.espaco = espaco;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    

    
   
    
}
