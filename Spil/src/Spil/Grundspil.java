package Spil;
import java.util.Objects;
import java.util.Scanner;

public class Grundspil {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Terning terning1 = new Terning();
        Terning terning2 = new Terning();
        // ud fra de 2 terninge objekter bliver det lavet et array med terning 1 på plads 0 og terning 2 på plads 1
        Terning[] terningSaet = {terning1, terning2};
        int spillerEtPoint = 0;
        int spillerToPoint = 0;
        // en variable som skifter imellem 1 og 2 og bestemmer hvem som slå med terningen
        int hvisTur = 1;
        // en String variabel som bliver ændret ud fra hvad spillerne skriver, så spilerne selv kan bestemme om de vil slå
        //eller om de vil stoppe spillet
        String vent = "y";
        System.out.println("Vælg en af jer som er spiller 1, derefter på tur skiftes i med at slå med terningerne første til 40 point vinder");
        System.out.println();
        //en while sætning som forsætter indtil en af de 2 spiller når 40 point eller
        //hvis de skriver andet end y og derfor stopper spillet
        while (spillerEtPoint <= 40 && spillerToPoint <= 40 && vent.equals("y")) {
            if (hvisTur == 1) {
                System.out.println("Spiller 1, din tur til at slå");
                System.out.println("Du har " + spillerEtPoint + " point indtil videre og mangler " + (40 - spillerEtPoint) + " for at vinde");
                System.out.println("Skriv y og tryk enter for at slå, skrives andet stopper spillet");
                //venter på at spiller 1 skriver y og derfor slår med terningerne
                vent = scan.nextLine();
                // hvis der bliver skrevet y slåes med terningerne og summen af de 2 terninger plusses til spiller 1s point
                if (vent.equals("y")) {
                    //bruger slaaterning method fra terningobject
                    terningSaet[0].slaaTerning();
                    terningSaet[1].slaaTerning();
                    //plusser summen til spillerEtPoint
                    spillerEtPoint = spillerEtPoint + (terningSaet[0].terningvaerdiRetur() + terningSaet[1].terningvaerdiRetur());
                    System.out.println("Du slog: " + terningSaet[0].terningvaerdiRetur() + " og " + terningSaet[1].terningvaerdiRetur());
                    System.out.println("Summen af de to terninger er: " + (terningSaet[0].terningvaerdiRetur()+terningSaet[1].terningvaerdiRetur()));
                    System.out.println("Du har nu: " + spillerEtPoint + " point");
                    System.out.println();
                    //ændrer hvisTur til 2 og derfor giver spiller 2 sin tur
                    hvisTur = 2;
                }
            } else {
                //det samme som ovenfor bare for spiller 2
                System.out.println("Spiller 2, din tur til at slå");
                System.out.println("Du har " + spillerToPoint + " point indtil videre og mangler " + (40 - spillerToPoint) + " for at vinde");
                System.out.println("Skriv y og tryk enter for at slå, skrives andet stopper spillet");
                vent = scan.nextLine();
                if (vent.equals("y")) {
                    terningSaet[0].slaaTerning();
                    terningSaet[1].slaaTerning();
                    spillerToPoint = spillerToPoint + (terningSaet[0].terningvaerdiRetur() + terningSaet[1].terningvaerdiRetur());
                    System.out.println("Du slog: " + terningSaet[0].terningvaerdiRetur() + " og " + terningSaet[1].terningvaerdiRetur());
                    System.out.println("Summen af de to terninger er: " + (terningSaet[0].terningvaerdiRetur()+terningSaet[1].terningvaerdiRetur()));
                    System.out.println("Du har nu: " + spillerToPoint + " point");
                    System.out.println();
                    hvisTur = 1;
                }
            }
        }
        //tjekker hvem der har nået 40 point og siger tillykke til den pågældene spiller, hvis ingen nåede 40 point
        // men spillet stadig stoppede er det fordi spillet blev stoppet af en af spillerne
        if (vent.equals("y") && spillerEtPoint >= 40) {
            System.out.println("Tillykke spiller 1, du var den første der nåede 40 point, hvilket betyder at du vandt spillet");
        } else if (vent.equals("y")) {
            System.out.println("Tillykke spiller 2, du var den første der nåede 40 point, hvilket betyder at du vandt spillet");
        } else {
            System.out.println("Spillet blev stoppet inden nogen af jer nåede 40 point, så ingen vandt");
        }
    }
}