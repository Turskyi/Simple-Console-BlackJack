package gamePackage;

import java.util.ArrayList;
import java.util.List;

import static gamePackage.Rank.*;
import static gamePackage.Rank.KING;

abstract class User {
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
                card.setPoints ( );
            }
            sum += card.getPoints ();
        }
        while (sum > 21 && aceN > 0) {
            sum -= 10;
            aceN--;
        }
        return sum;
    }
    User() {
        userDeck = new ArrayList<> ();
    }

    List<Card> getUserDeck() {
        return userDeck;
    }

    int getUserPoints() {
        int i = 0;
        while (i < userDeck.size ( )) {
            i++;
        }
        return userPoints(userDeck);
    }
}
