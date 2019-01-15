package gamePackage;

public class Card {
    private Rank rank;
    private Suit suit;
    private int points;

    public  Card(Rank rank, Suit suit, int points) {
        this.rank = rank;
        this.suit = suit;
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public Rank getRank() {
        return rank;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "\n Card: " + rank +
                " " + suit +
                ", " + points +
                " points ";
    }
}
