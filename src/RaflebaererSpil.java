public class RaflebaererSpil {
    static int[] slaaTerning() {
        int terning1 = (int) (Math.random() * 7);
        int terning2 = (int) (Math.random() * 7);
        return new int[]{terning1, terning2};
    }
    public static void main(String[] args) {
    }

}
