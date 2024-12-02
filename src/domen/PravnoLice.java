/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

/**
 *
 * @author luka
 */
public class PravnoLice extends Sponzor {
    private String regBr;
    private String PIB;

    public PravnoLice(String regBr, String PIB, Long id, String naziv, String kontakt) {
        super(id, naziv, kontakt);
        this.regBr = regBr;
        this.PIB = PIB;
    }

    public String getRegBr() {
        return regBr;
    }

    public void setRegBr(String regBr) {
        this.regBr = regBr;
    }

    public String getPIB() {
        return PIB;
    }

    public void setPIB(String PIB) {
        this.PIB = PIB;
    }
    
    @Override
    public String toString() {
        return super.getNaziv() + " [PL " + regBr + " | " + PIB + " ] ";
    }
    
    
}
