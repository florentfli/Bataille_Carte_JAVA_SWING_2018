import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Jeu {

    private int tour = 0;

    final static protected String[] tabColor = {"Pique", "Coeur", "Carreau", "Trèfle"};
    final static protected String[] tabValue = {"Sept", "Huit", "Neuf", "Dix", "Valet", "Dame", "Roi", "As"};

    private ImageIcon[][] tabImage = new ImageIcon[4][13];

    private String fileName = "C:\\Users\\Florent\\Desktop\\TP11\\src\\png\\";

    private ArrayList<Carte> listCarte = new ArrayList<>();

    private ArrayList<Carte> cartesGagnee = new ArrayList<>();

    private Joueur joueur1 = new Joueur();
    private Joueur joueur2 = new Joueur();

    private String carteInGameJ1, carteInGameJ2;

    private Carte j1, j2;

    int sizePli = 0, nbCartej1, getNbCartej2;
    View view;
    private boolean joueur1Win = false, joueur2Win = false;
    private boolean bataille = false;
    private boolean joueur1WinPartie = false;
    private boolean joueur2WinPartie = false;

    public Jeu() {
        initPaquet();
    }

    public Jeu(View view) {
        this.view = view;
        initPaquet();
    }

    public void initPaquet() {
        for (int i = 0; i < tabColor.length; i++) {
            for (int j = 0; j < tabValue.length; j++) {
                listCarte.add(i + j, new Carte(i, j));
                String fileNameCard;
                if (j < 4) {
                    fileNameCard = fileName + (7 + j) + (i + 1) + ".png";
                    tabImage[i][j] = new ImageIcon(fileNameCard);
                }
                switch (j) {
                    case 4:
                        fileNameCard = fileName + "J" + (i + 1) + ".png";
                        tabImage[i][j] = new ImageIcon(fileNameCard);
                        break;
                    case 5:
                        tabImage[i][j] = new ImageIcon(fileName + "Q" + (i + 1) + ".png");
                        break;
                    case 6:
                        tabImage[i][j] = new ImageIcon(fileName + "K" + (i + 1) + ".png");
                        break;
                    case 7:
                        tabImage[i][j] = new ImageIcon(fileName + "A" + (i + 1) + ".png");
                        break;
                }
            }
        }
        Collections.shuffle(listCarte);
        for (int i = 0; i < listCarte.size(); i++) {
            if (i < 15) {
                joueur1.addCarte(listCarte.get(i));
                nbCartej1 = joueur1.getListCarteJoueur().size();
            } else {
                joueur2.addCarte(listCarte.get(i));
                nbCartej1 = joueur2.getListCarteJoueur().size();
            }
        }
    }

    public void jouePartie() {
        while (joueur1.getListCarteJoueur().size() > 0 && joueur2.getListCarteJoueur().size() > 0) {
            this.joueTour();
            view.getTour().setText("" + tour);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void joueTour() {
        System.out.println("\nTours #" + tour);
        if (!bataille) sizePli = 0;

        if (joueur1.getListCarteJoueur().size() > 0 && joueur2.getListCarteJoueur().size() > 0) {
            Carte carteJ1 = joueur1.tireCarte();
            j1 = carteJ1;
            sizePli++;
            carteInGameJ1 = ("" + carteJ1.getValue() + carteJ1.getColor() + ".png");
            System.out.println("Joueur 1 pioche :\t" + carteJ1);
            cartesGagnee.add(carteJ1);

            Carte carteJ2 = joueur2.tireCarte();
            j2 = carteJ2;
            sizePli++;
            carteInGameJ2 = ("" + carteJ2.getValue() + carteJ2.getColor() + ".png");
            System.out.println("Joueur 2 pioche :\t" + carteJ2);
            cartesGagnee.add(carteJ2);

            if (!bataille) {
                if (carteJ1.compareTo(carteJ2) == 1) {
                    joueur1.addCartes(cartesGagnee);
                    cartesGagnee.clear();

                    System.out.println("Joueur 1 l'emporte\n");
                    joueur1Win = true;
                    joueur2Win = false;
                    bataille = false;
                } else if (carteJ1.compareTo(carteJ2) == -1) {
                    joueur2.addCartes(cartesGagnee);
                    cartesGagnee.clear();

                    System.out.println("Joueur 2 l'emporte\n");
                    joueur1Win = false;
                    joueur2Win = true;
                    bataille = false;
                } else {
                    System.out.println("\n\tBataile !!\n");
                    joueur1Win = false;
                    joueur2Win = false;
                    bataille = true;
                }
            } else {
                if (joueur1.getListCarteJoueur().size() > 1 && joueur2.getListCarteJoueur().size() > 1) {
                    cartesGagnee.add(joueur1.tireCarte());
                    cartesGagnee.add(joueur2.tireCarte());
                    sizePli += 2;

                    this.view.getlLeftCard().setIcon(new ImageIcon(this.getTabImage()[this.getJ1().getColor()][this.getJ1().getValue()].getImage().getScaledInstance(130, 200, Image.SCALE_SMOOTH)));
                    this.view.getlRightCard().setIcon(new ImageIcon(this.getTabImage()[this.getJ2().getColor()][this.getJ2().getValue()].getImage().getScaledInstance(130, 200, Image.SCALE_SMOOTH)));
                    //joueTour();
                    bataille = false;
                } else if (joueur2.getListCarteJoueur().size() > 1) {
                    cartesGagnee.add(joueur2.tireCarte());
                    sizePli++;
                    this.view.getlLeftCard().setIcon(new ImageIcon(this.getTabImage()[this.getJ1().getColor()][this.getJ1().getValue()].getImage().getScaledInstance(130, 200, Image.SCALE_SMOOTH)));
                    this.view.getlRightCard().setIcon(new ImageIcon(this.getTabImage()[this.getJ2().getColor()][this.getJ2().getValue()].getImage().getScaledInstance(130, 200, Image.SCALE_SMOOTH)));
                    //joueTour();
                } else if (joueur1.getListCarteJoueur().size() > 1) {
                    cartesGagnee.add(joueur1.tireCarte());
                    sizePli++;
                    view.getlLeftCard().setIcon(new ImageIcon(this.getTabImage()[this.getJ1().getColor()][this.getJ1().getValue()].getImage().getScaledInstance(130, 200, Image.SCALE_SMOOTH)));
                    view.getlRightCard().setIcon(new ImageIcon(this.getTabImage()[this.getJ2().getColor()][this.getJ2().getValue()].getImage().getScaledInstance(130, 200, Image.SCALE_SMOOTH)));
                    //joueTour();

                }
            }
        } else System.out.println("un joueur n'a plus de carte");


        System.out.println("nb cartes J1 : " + joueur1.getListCarteJoueur().size() + "\nnb cartes J2 : " + joueur2.getListCarteJoueur().size());

        tour++;
        view.getNbCarteJ1().setText("Nombre de carte Joueur 1 : " + joueur1.getListCarteJoueur().size() + "    ");
        view.getNbCarteJ2().setText("Nombre de carte Joueur 2 : " + joueur2.getListCarteJoueur().size() + "    ");
        view.getTaillePli().setText("Taille du plis : " + sizePli + "    ");


        if (this.isJoueur1Win()) {
            view.getJoueur1gagne().setText("Joueur 1 gagne le pli");
            view.getJoueur2gagne().setText("");
        } else if (this.isJoueur2Win()) {
            view.getJoueur2gagne().setText("Joueur 2 gagne le pli");
            view.getJoueur1gagne().setText("");
        } else if (!this.isJoueur2Win() && !this.isJoueur1Win() || bataille) {
            view.getJoueur1gagne().setText("BATAILLE !");
        }
        if (joueur1.getListCarteJoueur().size() <= 0) {
            System.out.println("\n\tJoueur 2 gagne la partie");
            view.getPlay().setText("restart");
            joueur2WinPartie = true;
        }
        if (joueur2.getListCarteJoueur().size() <= 0) {
            System.out.println("\n\tJoueur 1 gagne la partie");
            view.getPlay().setText("restart");
            joueur1WinPartie = true;
        }

    }


    public int getTour() {
        return tour;
    }

    public void setTour(int tour) {
        this.tour = tour;
    }

    public static String[] getTabColor() {
        return tabColor;
    }

    public static String[] getTabValue() {
        return tabValue;
    }

    public ImageIcon[][] getTabImage() {
        return tabImage;
    }

    public void setTabImage(ImageIcon[][] tabImage) {
        this.tabImage = tabImage;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<Carte> getListCarte() {
        return listCarte;
    }

    public void setListCarte(ArrayList<Carte> listCarte) {
        this.listCarte = listCarte;
    }

    public ArrayList<Carte> getCartesGagnee() {
        return cartesGagnee;
    }

    public void setCartesGagnee(ArrayList<Carte> cartesGagnee) {
        this.cartesGagnee = cartesGagnee;
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public void setJoueur1(Joueur joueur1) {
        this.joueur1 = joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }

    public void setJoueur2(Joueur joueur2) {
        this.joueur2 = joueur2;
    }

    public String getCarteInGameJ1() {
        return carteInGameJ1;
    }

    public void setCarteInGameJ1(String carteInGameJ1) {
        this.carteInGameJ1 = carteInGameJ1;
    }

    public String getCarteInGameJ2() {
        return carteInGameJ2;
    }

    public void setCarteInGameJ2(String carteInGameJ2) {
        this.carteInGameJ2 = carteInGameJ2;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public Carte getJ1() {
        return j1;
    }

    public void setJ1(Carte j1) {
        this.j1 = j1;
    }

    public Carte getJ2() {
        return j2;
    }

    public void setJ2(Carte j2) {
        this.j2 = j2;
    }

    public boolean isJoueur1Win() {
        return joueur1Win;
    }

    public void setJoueur1Win(boolean joueur1Win) {
        this.joueur1Win = joueur1Win;
    }

    public boolean isJoueur2Win() {
        return joueur2Win;
    }

    public void setJoueur2Win(boolean joueur2Win) {
        this.joueur2Win = joueur2Win;
    }

    public int getSizePli() {
        return sizePli;
    }

    public void setSizePli(int sizePli) {
        this.sizePli = sizePli;
    }

    public int getNbCartej1() {
        return nbCartej1;
    }

    public void setNbCartej1(int nbCartej1) {
        this.nbCartej1 = nbCartej1;
    }

    public int getGetNbCartej2() {
        return getNbCartej2;
    }

    public void setGetNbCartej2(int getNbCartej2) {
        this.getNbCartej2 = getNbCartej2;
    }

    public boolean isBataille() {
        return bataille;
    }

    public void setBataille(boolean bataille) {
        this.bataille = bataille;
    }

    public boolean isJoueur1WinPartie() {
        return joueur1WinPartie;
    }

    public void setJoueur1WinPartie(boolean joueur1WinPartie) {
        this.joueur1WinPartie = joueur1WinPartie;
    }

    public boolean isJoueur2WinPartie() {
        return joueur2WinPartie;
    }

    public void setJoueur2WinPartie(boolean joueur2WinPartie) {
        this.joueur2WinPartie = joueur2WinPartie;
    }
}


