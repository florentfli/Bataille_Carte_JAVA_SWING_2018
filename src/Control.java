import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control implements ActionListener {
    View view = new View();
    Jeu jeu = new Jeu(view);

    /*Jeu jeu = new Jeu();
    View view = new View(jeu);*/


    public Control() {
        view.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getPlay()) {
            //jeu.jouePartie();
            if (jeu.getJoueur1().getListCarteJoueur().size() > 0 && jeu.getJoueur2().getListCarteJoueur().size() > 0) {
                this.jeu.joueTour();
                this.view.getlLeftCard().setIcon(new ImageIcon(jeu.getTabImage()[jeu.getJ1().getColor()][jeu.getJ1().getValue()].getImage().getScaledInstance(130, 200, Image.SCALE_SMOOTH)));
                this.view.getlRightCard().setIcon(new ImageIcon(jeu.getTabImage()[jeu.getJ2().getColor()][jeu.getJ2().getValue()].getImage().getScaledInstance(130, 200, Image.SCALE_SMOOTH)));
                this.view.getTour().setText("Tour #" + jeu.getTour());
            }

            if (jeu.isJoueur1WinPartie()) view.getWin().setText("Joueur 1 gagne la partie en " + jeu.getTour() + " tours..");
            if (jeu.isJoueur2WinPartie())view.getWin().setText("Joueur 2 gagne la partie en " + jeu.getTour() + " tours..");

            /*if (jeu.getJoueur1().getListCarteJoueur().size() <= 0 || jeu.getJoueur2().getListCarteJoueur().size() <= 0){
                view.dispose();
                jeu.initPaquet();
                this.view = new View(jeu);
                view.setCont
            }*/
        }
    }
}
