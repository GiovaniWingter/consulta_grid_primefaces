/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.lab.bean;

import java.io.Serializable;

/**
 *
 * @author Giovani
 */
public class Hq implements Serializable{

    private int idhq;
    private String hq;
    private String categoria;
    private float preco;
    private String url;

    public int getIdhq() {
        return idhq;
    }

    public void setIdhq(int idhq) {
        this.idhq = idhq;
    }

    public String getHq() {
        return hq;
    }

    public void setHq(String hq) {
        this.hq = hq;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}