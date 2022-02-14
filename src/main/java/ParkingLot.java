public class ParkingLot {

    private int size;
    private int hourFee = 3;
    private int maxHours = 5;
    private int dailyFee = 15;


    public ParkingLot(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public int getFee(int hours) {
        if(hours >= maxHours) {
            return dailyFee;
        }else if(hours > 0){
            return hours * hourFee;
        }
        return 0;
    }
}
