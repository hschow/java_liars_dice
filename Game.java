import java.util.Scanner;

public class Game {

    Player[] player;
    int round;
    boolean ongoing = false;
    int x =0;
    Player currentPlayer;
    Bid currentBid = new Bid(1, 1);
    Player previousPlayer;

    Game(Player[] player){
        this.player = player;
        currentPlayer = player[x];
    }

    public void startGame(int numberDice){
        ongoing = true;
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    public boolean isPlaying(){
        return ongoing;
    }
    public boolean makeBid(Bid bid){
        previousPlayer = currentPlayer;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the face value of your bid: ");
        int fv = scanner.nextInt();
        System.out.println("Now would you please enter the quantity if the bid");
        int q = scanner.nextInt();
        Bid otherBid = new Bid(fv,q);
        if (bid.isOtherBigger(otherBid)==true){
            currentBid = otherBid;
            x++;
            if (x>=player.length){
                x=0;
            }
            currentPlayer = player[x];
            return true;
        }
        else {
            return false;
        }
    }
    public boolean makeChallenge(){
        int t =0;
        for (int i=0; i<player.length; i++){
            for (int j=0; j<player[i].numberOfDice; j++){
                Die[] dice = (player[i].getDice());
                Die die = new Die();
                int[] listOfDice = die.dice2Ints(dice);
                if (listOfDice[j]==(currentBid.faceValue) || listOfDice[j]==1){
                    t++;
                }
            }
        }
        if (t>=currentBid.quantity){
            return true;
        }
        else {
            return false;
        }
    }
    public void increase(){
        x++;
        if (x>=player.length){
            x=0;
        }
    }

}
