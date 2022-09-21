public class RaflebaererSpil {
    static int[] slaaTerning() {
        int terning1 = (int) ((Math.random() * 6)+1);
        int terning2 = (int) ((Math.random() * 6)+1);
        return new int[]{terning1, terning2};
    }
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < 1000000; i++) {
            int[] resultat = slaaTerning();
            System.out.println(resultat[0] + ", " + resultat[1]);
            if (resultat[0] == 6 && resultat[1] == 6) {
                count++;
            }
        }
        System.out.println(count);
    }

}
