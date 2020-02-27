public class Bid {

    int faceValue;
    int quantity;

    Bid(int faceValue, int quantity){
        this.faceValue=faceValue;
        this.quantity=quantity;
    }
    public int getFaceValue(){
        return faceValue;
    }
    public int getQuantity(){
        return quantity;
    }
    boolean isOtherBigger(Bid otherBid){
        if (this.quantity > otherBid.quantity) {
            return false;
        }
        else{
            if (this.faceValue>=otherBid.faceValue){
                return false;
            }
            else{
                return true;
            }
        }
    }

}
