package audit;

import domen.Clan;

/**
 *
 * @author luka
 */
public class Audit {
    // Ulogovani clan.
    private Clan clan = null;
    private static      Audit instance = null;
    
    private Audit() {}
    
    public static Audit getInstance()
    {
        if(instance == null)
            instance = new Audit();
        return instance;
    }
    
    public void setClan(Clan clan)
    {
        if(this.clan == null) 
            this.clan = clan;
        else
            throw new RuntimeException("Clan vec postoji!");
    }
    
    public Clan getClan()
    {
        if(this.clan != null)
            return this.clan;
        else
            throw new RuntimeException("Korisnik nije ulogovan!");
    }
    
    
    
}
