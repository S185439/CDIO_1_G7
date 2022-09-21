public class RaflebaererSpil {
    static int[] slaaTerning() {
        int terning1 = (int) ((Math.random() * 6)+1);
        int terning2 = (int) ((Math.random() * 6)+1);
        return new int[]{terning1, terning2};
    }
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < 100000; i++) {
            int resultat1 = slaaTerning()[0];
            int resultat2 = slaaTerning()[1];
            System.out.println(resultat1 + ", " + resultat2);
            if (resultat2 == 6 && resultat1 == 6) {
                count++;
            }
        }
        System.out.println(count);
    }

}
