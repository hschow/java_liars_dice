public class Roller {

    public  static void main(String[] args){
        Die[] dice = {new Die(), new Die()};
        for (int i=0; i<100; i++){
            for (Die die : dice){
                die.roll();
                System.out.println(die + " the average is "+ die.getAverage());
            }
        }
    }



}
