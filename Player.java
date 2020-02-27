import java.util.ArrayList;

public class Player {

    String name;
    int numberOfDice;
    Die[] dices = new Die[5];

    Player(String name){
        this.name=name;
        numberOfDice=5;
    }

    public void startGame(int numberOfDice){
        numberOfDice = 5;
    }
    public void roll(){
        for (int i=0; i<numberOfDice; i++){
            Die die = new Die();
            dices[i] = die;
        }
        if (numberOfDice<5){
            for (int j=numberOfDice;j<5;j++){
                dices[j] = null;
            }
        }
        Die die = new Die();
        int[] rolls = die.dice2Ints(dices);
    }
    public int loseDice(){
        numberOfDice = numberOfDice-1;
        System.out.println(this.getName()+" you have lost a dice");
        return (numberOfDice-1);
    }
    public String getName(){
        return name;
    }
    public int getDiceCount(){
        return numberOfDice;
    }
    public Die[] getDice(){
        return dices;
    }

}
