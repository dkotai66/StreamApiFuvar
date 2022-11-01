package hu.petrik.streamapifuvar;

public class Fuvar {
    private int taxiAzonosito;
    private String indulasIdopont;
    private int utazasIdotartama;
    private double meglettTavolsag;
    private double vitelDij;
    private double borravalo;
    private String fizetesModja;


    public Fuvar(int taxiAzonosito, String indulasIdopont, int utazasIdotartama, double meglettTavolsag, double vitelDij, double borravalo, String fizetesModja) {
        this.taxiAzonosito = taxiAzonosito;
        this.indulasIdopont = indulasIdopont;
        this.utazasIdotartama = utazasIdotartama;
        this.meglettTavolsag = meglettTavolsag;
        this.vitelDij = vitelDij;
        this.borravalo = borravalo;
        this.fizetesModja = fizetesModja;
    }

    public double getBokezu(){
       return borravalo/vitelDij;
    }
    public double getBevetel(){
        return vitelDij+borravalo;
    }

    public int getTaxiAzonosito() {
        return taxiAzonosito;
    }

    public String getIndulasIdopont() {
        return indulasIdopont;
    }

    public int getUtazasIdotartama() {
        return utazasIdotartama;
    }

    public double getMeglettTavolsag() {
        return meglettTavolsag;
    }

    public double getVitelDij() {
        return vitelDij;
    }

    public double getBorravalo() {
        return borravalo;
    }

    public String getFizetesModja() {
        return fizetesModja;
    }

    @Override
    public String toString() {
        return "Fuvar{" +
                "taxiAzonosito=" + taxiAzonosito +
                ", indulasIdopont='" + indulasIdopont + '\'' +
                ", utazasIdotartama=" + utazasIdotartama +
                ", meglettTavolsag=" + meglettTavolsag +
                ", vitelDij=" + vitelDij +
                ", borravalo=" + borravalo +
                ", fizetesModja='" + fizetesModja + '\'' +
                '}';
    }
}

