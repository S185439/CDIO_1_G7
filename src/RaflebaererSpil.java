public class RaflebaererSpil {
    public static void main(String[] args) {
        Terning terning1 = new Terning();
        Terning terning2 = new Terning();
        int count = 0;
        for (int i = 0; i < 1000; i++) {
            int resultat1 = terning1.slaaTerning();
            int resultat2 = terning2.slaaTerning();
            System.out.println(resultat1 + ", " + resultat2);
            if (resultat1 == 6 && resultat2 == 6) {
                count++;
            }
        }
        System.out.println(count);
    }

}
