package examcodl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import twitter4j.DirectMessage;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Examen de cod, Metodos para hacer un twitter propio.
 *
 * @author Serg Bena
 * @version 1.1
 */
public class Metodos {

    /**
     * Este metodo indica la cuenta y el direccionamiento del que lo manda,o
     * busca
     */
    public void direccion() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("")
                .setOAuthConsumerSecret("")
                .setOAuthAccessToken("")
                .setOAuthAccessTokenSecret("");
    }

    /**
     * Indica la linea de tiempo
     */
    public void lineaTiempo() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("")
                .setOAuthConsumerSecret("")
                .setOAuthAccessToken("")
                .setOAuthAccessTokenSecret("");
        Twitter twitter = new TwitterFactory(cb.build()).getInstance();

        //getting timeline
        List<Status> statuses = null;
        try {
            statuses = twitter.getHomeTimeline();
        } catch (TwitterException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Showing home timeline.");
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":"
                    + status.getText());

        }

    }

    /**
     * Sirve para buscar un twit en todo Twitter.
     */
    public void busqueda() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("")
                .setOAuthConsumerSecret("")
                .setOAuthAccessToken("")
                .setOAuthAccessTokenSecret("");
        Twitter twitter = new TwitterFactory(cb.build()).getInstance();
        String twit = JOptionPane.showInputDialog("¿Que twit quiere buscar?");
        Query query = new Query(twit);//Coloca lo que buscas
        QueryResult result = null;
        try {
            result = twitter.search(query);
        } catch (TwitterException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Status status : result.getTweets()) {
            System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
        }
    }

    /**
     * Sirve para postear el twit.
     */
    public void twiteo() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("")
                .setOAuthConsumerSecret("")
                .setOAuthAccessToken("x")
                .setOAuthAccessTokenSecret("x");
        Twitter twitter = new TwitterFactory(cb.build()).getInstance();
        String twit = JOptionPane.showInputDialog("Que quere twittear");
        Status status = null;
        try {
            status = twitter.updateStatus(twit); //Escribes lo que quieres
        } catch (TwitterException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Successfully updated the status to [" + status.getText() + "].");
    }
    
    
}
