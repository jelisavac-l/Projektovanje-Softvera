/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.domen;

/**
 *
 * @author luka
 */
public class FizickoLice extends Sponzor {
    private String jmbg;

    public FizickoLice(String jmbg, Long id, String naziv, String kontakt) {
        super(id, naziv, kontakt);
        this.jmbg = jmbg;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }
    
}
