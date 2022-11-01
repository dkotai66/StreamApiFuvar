package hu.petrik.streamapifuvar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static List<Fuvar> fuvarok;

    public static void main(String[] args) {
        String fajlNev = "fuvar.csv";
        try {
            beolvas(fajlNev);
            for (Fuvar f: fuvarok) {
                System.out.println(f);
            }
            System.out.printf("\nAz állományban: %d fuvar került feljegyzésre!", fuvarok.stream().count());
            System.out.printf("\n6185 sofőr bevétele %d - %s borravaloból", fuvarok.stream().filter(fuvar -> fuvar.getTaxiAzonosito()==6185).count(), fuvarok.stream().filter(fuvar -> fuvar.getTaxiAzonosito()==6185).mapToDouble(Fuvar::getBevetel).sum());
            System.out.printf("\nÖsszesen %s mérföldet tettek meg a taxisok", fuvarok.stream().mapToDouble(Fuvar::getMeglettTavolsag).sum());
            System.out.printf("\nIdőben leghosszabb fuvar adatai: %s", fuvarok.stream().max(Comparator.comparingInt(Fuvar::getUtazasIdotartama)));
            System.out.printf("\nLegbőkezűbb borravalójú fuvar adatai: %s", fuvarok.stream().max(Comparator.comparingDouble(Fuvar::getBokezu)));
            System.out.printf("\nA 4261-es taxis összesen %s kilómétert tett meg", fuvarok.stream().mapToDouble(Fuvar::getMeglettTavolsag).sum()*1.6);
            System.out.printf("\nNem tudom");
            System.out.printf("\n1452-es fuvar szerepel: %s", fuvarok.stream().anyMatch(fuvar -> fuvar.getTaxiAzonosito() == 1452));
            System.out.printf("\nA 3 legrövidebb utazás adatai: ");
            fuvarok.stream().filter(fuvar -> fuvar.getUtazasIdotartama()>0).min(Comparator.comparingInt(Fuvar::getUtazasIdotartama)).stream().limit(3).forEach(System.out::println);
            String idopont = "2016-12-24";
            System.out.printf("\n%s-én %d fuvar volt", idopont,  fuvarok.stream().filter(fuvar -> fuvar.getIndulasIdopont().contains(idopont)).count());
            String idopont2 = "2016-12-31";
            System.out.printf("\n%s-én Borravalók aránya fuvarok után: ", idopont2);
            List<Double> borravalo = fuvarok.stream().filter(fuvar -> fuvar.getIndulasIdopont().contains(idopont2)).map(Fuvar::getBokezu).collect(Collectors.toList());
            borravalo.forEach(System.out::println);
        }catch (IOException e){
            System.out.println("hiba történt a fájl beolvasása során");
        }
    }

    private static void beolvas(String fajlNev) throws IOException{
        fuvarok = new ArrayList<>();

        FileReader fr = new FileReader(fajlNev);
        BufferedReader br = new BufferedReader(fr);
        String fejlec = br.readLine();
        String sor = br.readLine();
        while (sor != null && !sor.isEmpty()){
            String[] adatok = sor.replace(",", ".").split(";");
            Fuvar f = new Fuvar(Integer.parseInt(adatok[0]),
                    adatok[1],
                    Integer.parseInt(adatok[2]),
                    Double.parseDouble(adatok[3]),
                    Double.parseDouble(adatok[4]),
                    Double.parseDouble(adatok[5]),
                    adatok[6]);

            fuvarok.add(f);
            sor = br.readLine();
        }


        br.close();
        fr.close();
    }
}


