public class Terning {
    private final int antalSider = 6;
    private int terningvaerdi;

    //////////////////////////////////////////////////////////////////////////////////
    //Constructor til terning
    public Terning() {
        terningvaerdi = 1;
    }
    //////////////////////////////////////////////////////////////////////////////////
    //method til at slå terning som ændre terningens værdi til et tilfældigt tal mellem 1 og 6
    public int slaaTerning() {
        terningvaerdi = (int) ((Math.random() * antalSider)+1);
        return terningvaerdi;
    }
    //////////////////////////////////////////////////////////////////////////////////
    //returnere terningens værdi uden at slå
    public int terningvaerdiRetur() {
        return terningvaerdi;
    }
}
