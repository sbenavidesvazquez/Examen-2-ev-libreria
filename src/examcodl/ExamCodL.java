package examcodl;

import javax.swing.JOptionPane;
import twitter4j.TwitterException;

/**
 * Mi propio twitter para cod
 *
 * @author Serg Bena
 * @version 1.0
 */
public class ExamCodL {

    /**
     * Los métodos para que la aplicacion funcione.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws TwitterException {

        Metodos obx = new Metodos();
        int op;

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog("Elija que quiere hacer\n1-->Linea de tiempo\n2-->Buscar Twit\n3-->Twitear\n5-->salir"));
            switch (op) {
                case 1:
                    obx.lineaTiempo();
                    break;
                case 2:
                    obx.busqueda();
                    break;
                case 3:
                    obx.twiteo();
                    break;
                case 5:
                    System.exit(0);
            }
        } while (op == 5);
        
    }

}
