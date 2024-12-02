/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.domen;

/**
 *
 * @author luka
 */
public class StavkaFakture {
    private Long id;
//    private Faktura faktura;
    private Usluga usluga;
    private Integer kolicina;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usluga getUsluga() {
        return usluga;
    }

    public void setUsluga(Usluga usluga) {
        this.usluga = usluga;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }

    public StavkaFakture(Long id, Usluga usluga, Integer kolicina) {
        this.id = id;
        this.usluga = usluga;
        this.kolicina = kolicina;
    }
    
    
}
