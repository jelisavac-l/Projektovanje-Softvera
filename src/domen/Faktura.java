/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.util.Date;
import java.util.List;

/**
 *
 * @author luka
 */
public class Faktura {
    private Long id;
    private Date datum;
    private Double ukupnaCena;
    private Double pdv;
    private Double popust;
    private Boolean stornirana;
    private Clan clan;
    private Sponzor sponzor;
    private List<StavkaFakture> stavke;
    
    public Faktura(Long id, Date datum, Double ukupnaCena, Double pdv, Boolean storinirana, Clan clan, Sponzor sponzor, Double popust, List<StavkaFakture> stavke) {
        this.id = id;
        this.datum = datum;
        this.ukupnaCena = ukupnaCena;
        this.pdv = pdv;
        this.stornirana = storinirana;
        this.clan = clan;
        this.sponzor = sponzor;
        this.stavke = stavke;
        this.popust = popust;
    }

    public Faktura(Long id, Date datum, Double ukupnaCena, Double pdv, Boolean storinirana, Clan clan, Sponzor sponzor, Double popust) {
        this.id = id;
        this.datum = datum;
        this.ukupnaCena = ukupnaCena;
        this.pdv = pdv;
        this.stornirana = storinirana;
        this.clan = clan;
        this.popust = popust;
        this.sponzor = sponzor;
    }
    
    public Double getPopust() {
        return popust;
    }

    public void setPopust(Double popust) {
        this.popust = popust;
    }

    public List<StavkaFakture> getListaStavkaFakture() {
        return stavke;
    }

    public void setListaStavkaFakture(List<StavkaFakture> stavke) {
        this.stavke = stavke;
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

    public Double getOsnovnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public Double getPdv() {
        return pdv;
    }

    public void setPdv(double pdv) {
        this.pdv = pdv;
    }

    public Boolean isStornirana() {
        return stornirana;
    }

    public void setStorinirana(boolean stornirana) {
        // zastititi se i ovde
        this.stornirana = stornirana;
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
