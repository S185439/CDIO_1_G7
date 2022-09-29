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

        //Funkion 1.3 HVAD VED DE OM LAKS

        boolean sidsteslagpar6spiller1 = false;
        boolean sidsteslagpar6spiller2 = false;

        // 1.4 laver booleans der sørger for at ændre spillernes status
        boolean spillerEtFinalist = false;
        boolean spillerToFinalist = false;
        boolean vinderErFundet = false;

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
        while (!vinderErFundet && vent.equals("y")) {
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
                    System.out.println("Du slog: " + terningSaet[0].terningvaerdiRetur() + " og " + terningSaet[1].terningvaerdiRetur());

                    if (spillerEtFinalist) {
                        if (terningSaet[0].terningvaerdiRetur() == 1 && terningSaet[1].terningvaerdiRetur() == 1) {
                            spillerEtPoint = 0;
                            System.out.println("Du slog 2 1'ere, så du mister du alle dine point");
                        } else if (terningSaet[0].terningvaerdiRetur() == terningSaet[1].terningvaerdiRetur()) {
                            vinderErFundet = true;
                        } else {
                            hvisTur = 2;
                        }
                    } else {
                        // funk 1.3
                        if (terningSaet[0].terningvaerdiRetur() == 6 && terningSaet[1].terningvaerdiRetur() == 6 && sidsteslagpar6spiller1) {
                            vinderErFundet = true;
                        }
                        //plusser summen til spillerEtPoint
                        spillerEtPoint = spillerEtPoint + (terningSaet[0].terningvaerdiRetur() + terningSaet[1].terningvaerdiRetur());
                        System.out.println("Summen af de to terninger er: " + (terningSaet[0].terningvaerdiRetur() + terningSaet[1].terningvaerdiRetur()));
                        System.out.println("Du har nu: " + spillerEtPoint + " point");
                        System.out.println();
                        //ændrer hvisTur til 2 og derfor giver spiller 2 sin tur

                        // Feature 1, Hvis spilleren slår 2 1'ere sættes spillerens point til 0.
                        if (terningSaet[0].terningvaerdiRetur() == 1 && terningSaet[1].terningvaerdiRetur() == 1) {
                            spillerEtPoint = 0;
                            System.out.println("Du slog 2 1'ere, så du mister du alle dine point");
                        }
                        //Feature 2, Spilleren får en ekstra tur, hvis de slår to ens
                        if (terningSaet[0].terningvaerdiRetur() == terningSaet[1].terningvaerdiRetur()) {
                            System.out.println("Du slog 2 ens, så du får en ekstra tur!");
                            System.out.println();
                            //bruger hvisTur til at give samme spiller en ekstra tur
                            hvisTur = 1;
                        } else {
                            //ændrer hvisTur til 2 og derfor giver spiller 2 sin tur
                            hvisTur = 2;
                        }
                        //counter til funk 1.3
                        if (terningSaet[0].terningvaerdiRetur() == 6 && terningSaet[1].terningvaerdiRetur() == 6) {
                            sidsteslagpar6spiller1 = true;
                        } else {
                            sidsteslagpar6spiller1 = false;
                        }
                        // 1.4 hvis en spiller har 40+ point så sættes de i finalist status.
                        if (spillerEtPoint >= 40) {
                            spillerEtFinalist = true;
                            System.out.println("Spiller 1 er nået 40 point, du skal slå 2 ens for at vinde");
                        }
                    }
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
                    System.out.println("Du slog: " + terningSaet[0].terningvaerdiRetur() + " og " + terningSaet[1].terningvaerdiRetur());
                    if (spillerToFinalist) {
                        if (terningSaet[0].terningvaerdiRetur() == 1 && terningSaet[1].terningvaerdiRetur() == 1) {
                            spillerEtPoint = 0;
                            System.out.println("Du slog 2 1'ere, mister du alle dine point");
                            System.out.println();
                        } else if (terningSaet[0].terningvaerdiRetur() == terningSaet[1].terningvaerdiRetur()) {
                            vinderErFundet = true;
                        } else {
                            hvisTur = 1;
                        }
                    } else {
                        if (terningSaet[0].terningvaerdiRetur() == 6 && terningSaet[1].terningvaerdiRetur() == 6 && sidsteslagpar6spiller2) {
                            vinderErFundet = true;
                        }
                        spillerToPoint = spillerToPoint + (terningSaet[0].terningvaerdiRetur() + terningSaet[1].terningvaerdiRetur());;
                        System.out.println("Summen af de to terninger er: " + (terningSaet[0].terningvaerdiRetur() + terningSaet[1].terningvaerdiRetur()));
                        System.out.println("Du har nu: " + spillerToPoint + " point");
                        System.out.println();

                        if (terningSaet[0].terningvaerdiRetur() == 1 && terningSaet[1].terningvaerdiRetur() == 1) {
                            spillerEtPoint = 0;
                            System.out.println("Du slog 2 1'ere, så du mister du alle dine point");
                        }
                        if (terningSaet[0].terningvaerdiRetur() == terningSaet[1].terningvaerdiRetur()) {
                            System.out.println("Du slog 2 ens, så du får en ekstra tur!");
                            System.out.println();
                        } else {
                            hvisTur = 1;
                        }

                        if (terningSaet[0].terningvaerdiRetur() == 6 && terningSaet[1].terningvaerdiRetur() == 6) {
                            sidsteslagpar6spiller2 = true;
                        } else {
                            sidsteslagpar6spiller2 = false;
                        }
                        if (spillerToPoint >= 40) {
                            spillerToFinalist = true;
                            System.out.println("Spiller 2 er nået 40 point, du skal slå 2 ens for at vinde");
                            System.out.println();
                        }
                    }
                }
            }

        }
        //tjekker hvem der har nået 40 point og siger tillykke til den pågældene spiller, hvis ingen nåede 40 point
        // men spillet stadig stoppede er det fordi spillet blev stoppet af en af spillerne
        if (vent.equals("y") && hvisTur == 1) {
            System.out.println("Tillykke spiller 1, du var den første der nåede 40 point, hvilket betyder at du vandt spillet");
        } else if (vent.equals("y")) {
            System.out.println("Tillykke spiller 2, du var den første der nåede 40 point, hvilket betyder at du vandt spillet");
        } else {
            System.out.println("Spillet blev stoppet inden nogen af jer nåede 40 point, så ingen vandt");
        }
    }
}





