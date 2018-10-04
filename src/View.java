import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class View extends JFrame {

    private JButton play;

    private JPanel pMain,pLol;
    public JLabel lLeftCard, lBack1,lBack2, lRightCard, nbCarteJ1,nbCarteJ2,taillePli,win;
    private JPanel pPlay;
    private JPanel pInfo,pTop;
    private JPanel pBouton;
    private String fileName = "C:\\Users\\Florent\\Desktop\\TP11\\src\\png\\";

    private JLabel joueur1gagne,joueur2gagne, tour;

    private Jeu jeu;

    ImageIcon back;

    public View(Jeu jeu) {
        this.jeu = jeu;
        creerWidget();
        ajouterWidget();
        pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setTitle("TP BATAILE : RICHARD Théo   //   FLIEDNER Florent");
        this.setVisible(true);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("./png/back_card.jpg")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    public View() {
        creerWidget();
        ajouterWidget();
        /*pack();*/
        setSize(650,375);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setTitle("TP BATAILE : RICHARD Théo   //   FLIEDNER Florent");
        this.setVisible(true);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("./png/back_card.jpg")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    public void creerWidget() {
        pMain = new JPanel();
        pMain.setLayout(new BoxLayout(pMain, BoxLayout.Y_AXIS));

        pPlay = new JPanel();
        pTop = new JPanel();
        pPlay.setLayout(new BoxLayout(pPlay, BoxLayout.X_AXIS));
        pTop.setLayout(new BoxLayout(pTop, BoxLayout.X_AXIS));

        pInfo = new JPanel();
        pInfo.setLayout(new BoxLayout(pInfo, BoxLayout.Y_AXIS));

        pBouton = new JPanel();
        pLol = new JPanel();

        back = new ImageIcon(fileName + "back_card.jpg");

        lLeftCard = new JLabel();
        lRightCard = new JLabel();
        nbCarteJ1 = new JLabel();
        nbCarteJ2 = new JLabel();
        taillePli= new JLabel();
        lBack1 = new JLabel();
        lBack2 = new JLabel();

        lBack1.setIcon(new ImageIcon(back.getImage().getScaledInstance(130, 200, Image.SCALE_SMOOTH)));
        lBack2.setIcon(new ImageIcon(back.getImage().getScaledInstance(130, 200, Image.SCALE_SMOOTH)));
        lLeftCard.setIcon(new ImageIcon(back.getImage().getScaledInstance(130, 200, Image.SCALE_SMOOTH)));
        lRightCard.setIcon(new ImageIcon(back.getImage().getScaledInstance(130, 200, Image.SCALE_SMOOTH)));
//        lRightCard.setIcon(new ImageIcon(jeu.getTabImage()[2][3].getImage().getScaledInstance(100, 200, Image.SCALE_SMOOTH)));

        play = new JButton("GO !");
        win = new JLabel(" ");
        tour = new JLabel(" ");
        joueur1gagne = new JLabel(" ");
        joueur2gagne = new JLabel(" ");
    }

    public void ajouterWidget() {
        pTop.add(nbCarteJ1);
        pTop.add(taillePli);
        pTop.add(nbCarteJ2);

        pPlay.add(lBack1);
        pPlay.add(lLeftCard);

        pInfo.add(tour);
        pInfo.add(joueur1gagne);
        pInfo.add(joueur2gagne);

        pLol.add(pInfo);
        pPlay.add(pLol);
        pPlay.add(lRightCard);
        pPlay.add(lBack2);
        pBouton.add(play);

        pMain.add(pTop);
        pMain.add(pInfo);
        pMain.add(pPlay);
        pMain.add(win);
        pMain.add(pBouton);
        setContentPane(pMain);
    }



    public void addActionListener(Control cb) {
        play.addActionListener(cb);
    }

    public JButton getPlay() {
        return play;
    }

    public void setPlay(JButton play) {
        this.play = play;
    }

    public ImageIcon getBack() {
        return back;
    }

    public void setBack(ImageIcon back) {
        this.back = back;
    }

    public JPanel getpMain() {
        return pMain;
    }

    public void setpMain(JPanel pMain) {
        this.pMain = pMain;
    }

    public JLabel getlLeftCard() {
        return lLeftCard;
    }

    public void setlLeftCard(JLabel lLeftCard) {
        this.lLeftCard = lLeftCard;
    }

    public JLabel getlBack1() {
        return lBack1;
    }

    public void setlBack1(JLabel lBack1) {
        this.lBack1 = lBack1;
    }

    public JLabel getlBack2() {
        return lBack2;
    }

    public void setlBack2(JLabel lBack2) {
        this.lBack2 = lBack2;
    }

    public JLabel getlRightCard() {
        return lRightCard;
    }

    public void setlRightCard(JLabel lRightCard) {
        this.lRightCard = lRightCard;
    }

    public JPanel getpPlay() {
        return pPlay;
    }

    public void setpPlay(JPanel pPlay) {
        this.pPlay = pPlay;
    }

    public JPanel getpInfo() {
        return pInfo;
    }

    public void setpInfo(JPanel pInfo) {
        this.pInfo = pInfo;
    }

    public JPanel getpBouton() {
        return pBouton;
    }

    public void setpBouton(JPanel pBouton) {
        this.pBouton = pBouton;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public JLabel getJoueur1gagne() {
        return joueur1gagne;
    }

    public void setJoueur1gagne(JLabel joueur1gagne) {
        this.joueur1gagne = joueur1gagne;
    }

    public JLabel getJoueur2gagne() {
        return joueur2gagne;
    }

    public void setJoueur2gagne(JLabel joueur2gagne) {
        this.joueur2gagne = joueur2gagne;
    }

    public JLabel getTour() {
        return tour;
    }

    public void setTour(JLabel tour) {
        this.tour = tour;
    }

    public Jeu getJeu() {
        return jeu;
    }

    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }

    public JPanel getpLol() {
        return pLol;
    }

    public void setpLol(JPanel pLol) {
        this.pLol = pLol;
    }

    public JLabel getNbCarteJ1() {
        return nbCarteJ1;
    }

    public void setNbCarteJ1(JLabel nbCarteJ1) {
        this.nbCarteJ1 = nbCarteJ1;
    }

    public JLabel getNbCarteJ2() {
        return nbCarteJ2;
    }

    public void setNbCarteJ2(JLabel nbCarteJ2) {
        this.nbCarteJ2 = nbCarteJ2;
    }

    public JLabel getTaillePli() {
        return taillePli;
    }

    public void setTaillePli(JLabel taillePli) {
        this.taillePli = taillePli;
    }

    public JPanel getpTop() {
        return pTop;
    }

    public void setpTop(JPanel pTop) {
        this.pTop = pTop;
    }

    public JLabel getWin() {
        return win;
    }

    public void setWin(JLabel win) {
        this.win = win;
    }
}
