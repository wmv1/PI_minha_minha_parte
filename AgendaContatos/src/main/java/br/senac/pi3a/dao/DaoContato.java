/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3a.dao;

import br.senac.pi3a.model.Contato;
import java.sql.Connection;
import br.senac.pi3a.utils.ConnectionUtils;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import br.senac.pi3a.exceptions.DuplicateException;

/**
 *
 * @author everton
 *
 */
public class DaoContato {

    static int id_contato;

    private final Connection connection;

    public DaoContato() {

        this.connection = new DBConnector().getConexaoDB();
    }

    //public void inserirContato(Contato contato)
    public void insereContato(Contato contato) throws DuplicateException {
        String sql = "INSERT INTO contato ("
                + "nome, "
                + "data_nasc, "
                + "telefone, "
                + "email, "
                + "sexo,"
                + "favorito)"
                + " VALUES (?, ?, ?, ?, ?, ?)";

        try {

            // prepared statement para inserção
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            //Seta valores para inserção
            stmt.setString(1, contato.getNome());
            //converte a data para inserir no banco
//            java.sql.Date dt = new java.sql.Date(contato.getDataNascimento().getTime());

            java.util.Date dataUtil = contato.getDataNascimento();
            java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());

          

          //  Timestamp dt = new Timestamp(data.getDate());
            stmt.setDate(2, dataSql);
            stmt.setString(3, contato.getTelefone());
            stmt.setString(4, contato.getEmail());
            stmt.setString(5, Character.toString(contato.getSexo()));
            stmt.setBoolean(6, contato.getFavorito()); 
            //Executa SQL Statement
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                throw new DuplicateException("CONTATO EXISTENTE!");
            }
            throw new RuntimeException(e);
        }

    }
}
