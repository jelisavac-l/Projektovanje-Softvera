/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.util.List;

/**
 *
 * @author luka
 */
public class Tim {
    private Long id;
    private String naziv;
    private List<Clan> listaClanova;

    public Tim(Long id, String naziv, List<Clan> listaClanova) {
        this.id = id;
        this.naziv = naziv;
        this.listaClanova = listaClanova;
    }

    public Tim(Long id, String naziv) {
        this.id = id;
        this.naziv = naziv;
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

    public List<Clan> getListaClanova() {
        return listaClanova;
    }

    public void setListaClanova(List<Clan> listaClanova) {
        this.listaClanova = listaClanova;
    }
    
    @Override
    public String toString()
    {
        return "[" + String.format("%03d", id) + "] " + naziv;
    }
    
}
