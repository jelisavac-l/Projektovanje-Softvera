/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.domain;

/**
 *
 * @author luka
 */
public class Sponzor {
    private Long id;
    private String naziv;
    private String kontakt;

    public Sponzor(Long id, String naziv, String kontakt) {
        this.id = id;
        this.naziv = naziv;
        this.kontakt = kontakt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }
    
}
