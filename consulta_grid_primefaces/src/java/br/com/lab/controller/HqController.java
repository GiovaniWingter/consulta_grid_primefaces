/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.lab.controller;

import br.com.lab.bean.Hq;
import br.com.lab.dao.HqDAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Giovani
 */
@ManagedBean(name = "hqController")
@SessionScoped
public class HqController implements Serializable{
    private Hq hq;
    private HqDAO hqDAO;
    private List<Hq> hqs;

    public Hq getHq() {
        return hq;
    }

    public void setHq(Hq hq) {
        this.hq = hq;
    }

    public HqDAO getHqDAO() {
        return hqDAO;
    }

    public void setHqDAO(HqDAO hqDAO) {
        this.hqDAO = hqDAO;
    }

    public List<Hq> getHqs() {
        return this.hqs;
    }

    public void setHqs(List<Hq> hqs) {
        this.hqs = hqs;
    }
    
    public void init(){
        hqDAO = new HqDAO();
        List<Hq> hqList = hqDAO.consultarHq();
        this.hqs = hqList;
        System.out.println("Passou DAO do gets");

    }
    
    public void consultaCat(String categoria){
        hqDAO = new HqDAO();
        List<Hq> hqList;
        if(categoria.equals("")){            
            hqList = hqDAO.consultarHq();
        }else{
            hqList = hqDAO.consultarHqCat(categoria);
        }
        this.hqs = hqList;
        System.out.println("Passou DAO");
        System.out.println(this.hqs.size());
    }
}
