public class Die {
    static int numberOfDice = 0;

    int lastRoll;
    int totalValue;
    int totalRolls;
    int dieNumber;

    Die() {

    }

    /**
     * Roll the dice
     * @return this roll
     */

    int roll(){
        int value = (int)(Math.random()*6)+1;
        totalValue += value;
        lastRoll = value;
        totalRolls++;
        return value;
    }

    double getAverage() {
        int average= totalValue/totalRolls;
        return  average;
    }
    public int getNumberOfDie(){
        return  numberOfDice;
    }

    public int getFaceValue(){
        return  lastRoll;
    }
    public int getTotalRolls(){
        return  totalRolls;
    }

    double size(){
        if (totalValue==0){
            return 0;
        }else {
            return lastRoll;
        }
    }
    //int compareTo(Sizable sizable){
      //  Double size = size();
        //return size.compareTo(sizable.size());
   // }
    public static int[] dice2Ints(Die[] dice){
        int j=0;
        for (int i =0; i<dice.length; i++){
            if (dice[i] != null){
                j++;
            }
        }
        int[] array = new int[j];
        for (int i =0; i<j; i++){
            if (dice[i] != null){
                array[i] = dice[i].roll();
            }
        }
        return array;
    }
    public static int count(Die[] dice, int faceValue) {
        int totalCount = 0;
        for (int i = 0; i < dice.length; i++){
            if (dice[i].equals(faceValue)){
                totalCount++;
            }
            else if (dice[i].equals(1)){
                totalCount++;
            }
        }
        return totalCount;
    }
    public static int getMaxValue(){
        int maxValue = 6;
        return maxValue;
    }
    public static int getWildValue(){
        int wildValue = 1;
        return wildValue;
    }
    public static boolean isValidFaceValue(int faceValue){
        if (faceValue <= getMaxValue() && faceValue >= 1){
            return true;
        }
        else {
            return false;
        }
    }

}
