public class Carte {

    private int color;
    private int value;

    public Carte(int color, int value) {
        this.color = color;
        this.value = value;
    }

    public int compareTo(Carte carte){
        if (this.value > carte.value) return 1;
        else if (this.value < carte.value) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Carte{ " +
                Jeu.tabValue[value] +
                " de " + Jeu.tabColor[color] +
                '}';
    }

    public int getColor() {
        return color;
    }

    public int getValue() {
        return value;
    }
}
