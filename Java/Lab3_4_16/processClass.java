public class processClass extends genClass {

    public processClass(int myCash) {
        super(myCash);
    }

    private void setYourCash(int myColor, int myBet) {

        this.drawNum[0] = ran.nextInt(colors.length);
        this.drawNum[1] = ran.nextInt(colors.length);
        this.drawNum[2] = ran.nextInt(colors.length);

        System.out.println("Result: " + colors[drawNum[0]]);
        System.out.println("Result: " + colors[drawNum[1]]);
        System.out.println("Result: " + colors[drawNum[2]]);

        if ((drawNum[0] == myColor) && (drawNum[1] == myColor) && (drawNum[2] == myColor)) {
            this.yourCash = (this.yourCash + myBet) * 3;
            this.didYouwin = true;
        }
        if ((drawNum[0] == myColor) || (drawNum[1] == myColor) || (drawNum[2] == myColor)) {
            this.yourCash = (this.yourCash + myBet);
            this.didYouwin = true;
        } else {
            this.yourCash -= myBet;
        }
    }

    private void setYourCashIn(int myCashIn){
        
    }
    public int getYourCash(int myColor, int myBet) {
        setYourCash(myColor, myBet);
        return this.yourCash;
    }
}
