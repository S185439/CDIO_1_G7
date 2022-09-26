package Test;
import Spil.Terning;
public class TestTerning {
    public static void main(String[] args) {
        Terning terning1 = new Terning();
        Terning terning2 = new Terning();
        int countEns = 0;
        int countTo = 0;
        int countTre = 0;
        int countFire = 0;
        int countFem = 0;
        int countSeks = 0;
        int countSyv = 0;
        int countOtte = 0;
        int countNi = 0;
        int countTi = 0;
        int countElleve = 0;
        int countTolv = 0;
        for (int i = 0; i < 1000; i++) {
            int resultat1 = terning1.slaaTerning();
            int resultat2 = terning2.slaaTerning();
            System.out.println(resultat1 + ", " + resultat2);
            if (resultat1 == resultat2) {
                countEns++;
            }
            switch (resultat1 + resultat2) {
                case 2 -> countTo++;
                case 3 -> countTre++;
                case 4 -> countFire++;
                case 5 -> countFem++;
                case 6 -> countSeks++;
                case 7 -> countSyv++;
                case 8 -> countOtte++;
                case 9 -> countNi++;
                case 10 -> countTi++;
                case 11 -> countElleve++;
                case 12 -> countTolv++;
            }
        }
        System.out.println("Ens: " + countEns);
        System.out.println("2: " + countTo + ", 3: " + countTre + ", 4: " + countFire + ", 5: " + countFem + ", 6: " + countSeks + ", 7: " + countSyv + ", 8: " + countOtte + ", 9: " + countNi + ", 10: " + countTi + ", 11: " + countElleve + ", 12: " + countTolv);
    }

}
