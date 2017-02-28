/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3a.model;

import java.util.Date;

/**
 *
 * @author Willian Vieira
 *
 */

public class Contato {
    private String nome;
    private Date dataNascimento;
    private String telefone;
    private String email;
    private char sexo;
    private boolean favorito;
    
    // geters e seters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
    
    public boolean getFavorito(){
        return favorito;
    }
        
    public void setFavorito(boolean favorito){
        this.favorito = favorito;
    }
}
