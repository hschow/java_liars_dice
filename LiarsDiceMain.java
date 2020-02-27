import net.Poster;

import java.util.Scanner;

public class LiarsDiceMain {

    public static void main(String[] args) {
        Player[] players;
        Die die = new Die();
        if (args.length >= 2) {
            players = new Player[args.length];
            for (int i = 0; i < args.length; i++) {
                Player player = new Player(args[i]);
                player.startGame(5);
                player.roll();
                Poster.postDice(player.name,die.dice2Ints(player.getDice()));
                players[i] = player;
            }
        } else {
            players = new Player[2];
            Player player1 = new Player("Jon");
            Player player2 = new Player("Rob");
            player1.startGame(5);
            player1.roll();
            Poster.postDice(player1.name,die.dice2Ints(player1.getDice()));
            player2.startGame(5);
            player2.roll();
            Poster.postDice(player2.name,die.dice2Ints(player2.getDice()));
            players[0] = player1;
            players[1] = player2;
        }
        Game game = new Game(players);
        game.startGame(5);
        Bid startGameBid = new Bid(1, 1);
        System.out.println(game.currentPlayer.getName() + " it is your turn,");
        boolean legal = game.makeBid(startGameBid);
        while (legal == false) {
            System.out.println("that was an illegal bid try again.");
            legal = game.makeBid(startGameBid);
        }
        boolean ongoing = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println(game.currentPlayer.getName() + " it is your turn, do you wish to challenge the bid (0), or make a new bid (1): ");
        while (ongoing == true) {
            int action = scanner.nextInt();
            if (action==0){
                boolean outcome = game.makeChallenge();
                if (outcome==true){
                    game.currentPlayer.loseDice();
                }
                else{
                    game.previousPlayer.loseDice();
                    game.currentPlayer=game.previousPlayer;
                    game.increase();
                }
                if (game.currentPlayer.getDiceCount()<1){
                    System.out.println(game.currentPlayer.getName()+" you have lost, better luck next time!");
                    ongoing=false;
                }
                else{
                    for (int i=0; i<players.length;i++){
                        players[i].roll();
                        Poster.postDice(players[i].name,die.dice2Ints(players[i].getDice()));
                    }
                    System.out.println(game.currentPlayer.getName() + " it is your turn make a new bid,");
                    legal = game.makeBid(startGameBid);
                    while (legal == false) {
                        System.out.println("that was an illegal bid try again.");
                        legal = game.makeBid(startGameBid);
                    }
                }
            }
            else {
                legal = game.makeBid(startGameBid);
                while (legal == false) {
                    System.out.println("that was an illegal bid try again.");
                    legal = game.makeBid(startGameBid);
                }
            }
            if (ongoing==true) {
                System.out.println(game.currentPlayer.getName() + " it is your turn, do you wish to challenge the bid (0), or make a new bid (1): ");
            }

        }
    }

}
