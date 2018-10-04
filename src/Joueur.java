import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Joueur {

    private ArrayList<Carte> listCarteJoueur = new ArrayList<>();

    public Joueur(){}

    public Carte tireCarte(){
        Carte carte = this.listCarteJoueur.get(this.listCarteJoueur.size()-1);
        this.listCarteJoueur.remove(this.listCarteJoueur.size()-1);
        return carte;
    }

    public void addCartes(ArrayList<Carte> cartesGagnees){
        //pour ajouter sous le paquet :
        Collections.reverse(this.listCarteJoueur);
        for (int i = 0; i < cartesGagnees.size(); i++){
            this.listCarteJoueur.add(cartesGagnees.get(i));
        }
        Collections.reverse(this.listCarteJoueur);
    }

    public void addCarte(Carte carte){
        this.listCarteJoueur.add(carte);
    }


    public List<Carte> getListCarteJoueur() {
        return listCarteJoueur;
    }

    public void setListCarteJoueur(ArrayList<Carte> listCarteJoueur) {
        this.listCarteJoueur = listCarteJoueur;
    }
}
