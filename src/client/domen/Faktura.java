/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.domen;

import java.util.Date;
import java.util.List;

/**
 *
 * @author luka
 */
public class Faktura {
    private Long id;
    private Date datum;
    private double ukupnaCena;
    private double pdv;
    private boolean storinirana;
    private Clan clan;
    private Sponzor sponzor;
    private List<Usluga> listaUsluga;
    
    public Faktura(Long id, Date datum, double ukupnaCena, double pdv, boolean storinirana, Clan clan, Sponzor sponzor, List<Usluga> listaUsluga) {
        this.id = id;
        this.datum = datum;
        this.ukupnaCena = ukupnaCena;
        this.pdv = pdv;
        this.storinirana = storinirana;
        this.clan = clan;
        this.sponzor = sponzor;
        this.listaUsluga = listaUsluga;
    }

    public Faktura(Long id, Date datum, double ukupnaCena, double pdv, boolean storinirana, Clan clan, Sponzor sponzor) {
        this.id = id;
        this.datum = datum;
        this.ukupnaCena = ukupnaCena;
        this.pdv = pdv;
        this.storinirana = storinirana;
        this.clan = clan;
        this.sponzor = sponzor;
    }

    public List<Usluga> getListaUsluga() {
        return listaUsluga;
    }

    public void setListaUsluga(List<Usluga> listaUsluga) {
        this.listaUsluga = listaUsluga;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public double getPdv() {
        return pdv;
    }

    public void setPdv(double pdv) {
        this.pdv = pdv;
    }

    public boolean isStorinirana() {
        return storinirana;
    }

    public void setStorinirana(boolean storinirana) {
        this.storinirana = storinirana;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Sponzor getSponzor() {
        return sponzor;
    }

    public void setSponzor(Sponzor sponzor) {
        this.sponzor = sponzor;
    }
    
}
