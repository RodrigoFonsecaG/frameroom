/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.frameroom.model;

/**
 *
 * @author Rodrigo
 */
public class Espacos {
    
    
    // Atributos
    private String cod_espaco;
    private String new_cod_espaco;
    private String tipo_espaco;
    private int numero;
    private String nome;
    private int capacidade;
    private int andar;
    private String descricao;
    
    //Getters e setters
    public String getCod_espaco() {
        return cod_espaco;
    }

    public void setCod_espaco(String cod_espaco) {
        this.cod_espaco = cod_espaco;
    }

    public String getTipo_espaco() {
        return tipo_espaco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    

    public void setTipo_espaco(String tipo_espaco) {
        this.tipo_espaco = tipo_espaco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public String getNew_cod_espaco() {
        return new_cod_espaco;
    }

    public void setNew_cod_espaco(String new_cod_espaco) {
        this.new_cod_espaco = new_cod_espaco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
    @Override
    public String toString(){
        return this.getNome();
    }
    
    
}
