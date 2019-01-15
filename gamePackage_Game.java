package gamePackage;

import java.util.*;

import static gamePackage.Rank.*;
import static gamePackage.Suit.*;

public class Game {
    private Scanner scanner = new Scanner (System.in);

    private Comp comp;
    private Player player;
    private List<Card> deck = new ArrayList<> ( );

    public Game() {
        comp = new Comp ( );
    }

    private void createFullDeck() {
        Rank[] ranks = new Rank[]{ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING};
        Suit[] suits = new Suit[]{CLUBS, DIAMONDS, HEARTS, SPADES};
        for (Suit suit : suits) {
            for (int j = 0; j < (ranks.length); j++) {
                if (j > 9) {
                    deck.add (new Card (ranks[j], suit, 10));
                } else if (j < 1) {
                    deck.add (new Card (ranks[j], suit, j + 11));
                } else {
                    deck.add (new Card (ranks[j], suit, j + 1));
                }
            }
        }
    }

    private void getTheName() {
        System.out.println ("What is your name?");
        player = new Player (scanner.nextLine ( ));
        System.out.println ("Hello, " + player.getName ( ));
    }

    private void takeTwoCards() {
        player.getUserDeck ().add (deck.get (0));
        deck.remove (0);
        player.getUserDeck ( ).add (deck.get (1));
        deck.remove (1);
        showMyCards ( );
    }

    private void showMyCards() {
        System.out.println ("Your cards: " + player.getUserDeck ( ));
        System.out.println ("You have: " + player.getUserPoints ( ) + " total points ");
    }

    private void takeAnotherCard() {
        System.out.println ("Would you like to take another card? \n Press 'y' or 'n' ");
        if (scanner.nextLine ( ).equals ("y")) {
            player.getUserDeck ( ).add (deck.get (0));
            deck.remove (0);
            showMyCards ( );
            if (player.getUserPoints ( ) < 21) {
            takeAnotherCard ( );
               }
            if (player.getUserPoints () > 21){
                   youLose ();
               }
        }
                System.out.println ("Now is comp`s turn. " );
                compTurn();
    }

    private void compTurn() {
                if(comp.getUserPoints () > 11){
                comparePoints();
            } else  {
                System.out.println ("Comp takes a card" );
                    comp.getUserDeck ( ).add (deck.get (0));
                deck.remove (0);
                compTurn ();
            }
        }

    private void comparePoints() {
        showCompCards ();
        if (player.getUserPoints () > comp.getUserPoints ()){
            youWon ();
        } else if (comp.getUserPoints () > 21) {
            youWon ( );
        } else {
            youLose();
        }
    }

    private void youLose() {
        System.out.println ("You lose! See you later" );
        System.exit (0);
    }

    private void youWon(){
        System.out.println ("Congratulations! You won!" );
        System.exit (0);
    }

    private void showCompCards() {
        System.out.println ( "Comp`s cards: " + comp.getUserDeck ());
        System.out.println ("Comp has: " + comp.getUserPoints () + " total points ");
    }

    public void start() {
        createFullDeck();
        Collections.shuffle(deck);
        getTheName();
        takeTwoCards();
        takeAnotherCard();
    }
}
