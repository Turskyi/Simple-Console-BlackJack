package gamePackage;

import java.util.ArrayList;
import java.util.List;

import static gamePackage.Rank.*;
import static gamePackage.Rank.KING;

public abstract class User {
    private List<Card> userDeck;
    private int userPoints(List<Card> cards){
        int aceN = 0;
        int sum = 0;
        for (Card card : cards) {
            Rank rank = card.getRank();
            if (rank.equals (ACE)) {
                aceN++;
            }
            if (rank.equals (JACK)|| rank.equals (QUEEN)||rank.equals (KING)) {
                card.setPoints (10);
            }
            sum += card.getPoints ();
        }
        while (sum > 21 && aceN > 0) {
            sum -= 10;
            aceN--;
        }
        return sum;
    }
    public User() {
        userDeck = new ArrayList<> ();
    }

    public List<Card> getUserDeck() {
        return userDeck;
    }

    public int getUserPoints() {
        for (int i = 0; i < userDeck.size ( ); i++) {
        }
        return userPoints(userDeck);
    }
}
