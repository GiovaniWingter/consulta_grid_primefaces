/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.lab.dao;

import br.com.lab.bean.Hq;
import br.com.lab.util.DbUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Giovani
 */
public class HqDAO {

    public static final String CONSULTA_HQ = "SELECT " +
                                                " idhq " +
                                                " ,nome_hq " +
                                                " ,descr_hq " +
                                                " ,url_imagem " +
                                                " ,idpreco_hq " +
                                                " ,hq_idhq " +
                                                " ,dt_inicio " +
                                                " ,dt_fim " +
                                                " ,preco " +
                                                " FROM JavaJSF.dbo.hq h, JavaJSF.dbo.preco_hq p " +
                                                " where " +
                                                " p.hq_idhq = h.idhq and " +
                                                " ? >= p.dt_inicio  and  ? <= p.dt_fim";
    
    public static  final String CONSULTA_HQ_CAT = "SELECT " +
                                                " idhq " +
                                                " ,nome_hq " +
                                                " ,descr_hq " +
                                                " ,url_imagem " +
                                                " ,idpreco_hq " +
                                                " ,hq_idhq " +
                                                " ,dt_inicio " +
                                                " ,dt_fim " +
                                                " ,preco " +
                                                " FROM hq h, preco_hq p " +
                                                " where " +
                                                " p.hq_idhq = h.idhq and " +
                                                " ? >= p.dt_inicio  and  ? <= p.dt_fim and " +
                                                " h.descr_hq = ? ";
    
    public List<Hq> consultarHq() {		
        Connection conn = DbUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        List<Hq> listaHq = new ArrayList<Hq>();
        try {
                statement = conn.prepareStatement(CONSULTA_HQ);
                statement.setDate(1,  new Date(System.currentTimeMillis()));
                statement.setDate(2,  new Date(System.currentTimeMillis()));
                result = statement.executeQuery();
                while (result.next()) {
                        Hq objHq = new Hq();
                        objHq.setIdhq(result.getInt(1));
                        objHq.setHq(result.getString(2));
                        objHq.setCategoria(result.getString(3));
                        objHq.setPreco(result.getFloat(9));
                        objHq.setUrl(result.getString(4));
                        listaHq.add(objHq);
                }
        } catch (SQLException e) {
                e.getMessage();
        } finally {
                DbUtil.close(conn, statement, result);
        }
        return listaHq;		
    }
    
    public List<Hq> consultarHqCat(String categoria) {		
        Connection conn = DbUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        List<Hq> listaHq = new ArrayList<Hq>();
        try {
                statement = conn.prepareStatement(CONSULTA_HQ_CAT);
                statement.setDate(1,  new Date(System.currentTimeMillis()));
                statement.setDate(2,  new Date(System.currentTimeMillis()));
                statement.setString(3,  categoria);
                result = statement.executeQuery();
                while (result.next()) {
                        Hq objHq = new Hq();
                        objHq.setIdhq(result.getInt(1));
                        objHq.setHq(result.getString(2));
                        objHq.setCategoria(result.getString(3));
                        objHq.setPreco(result.getFloat(9));
                        objHq.setUrl(result.getString(4));
                        listaHq.add(objHq);
                }
        } catch (SQLException e) {
                e.getMessage();
        } finally {
                DbUtil.close(conn, statement, result);
        }
        return listaHq;		
    }
    
}
