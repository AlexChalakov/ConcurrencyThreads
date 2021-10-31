public class Subtract implements Runnable{
    Warehouse storage;
    int number;
    int flag;
    
    /**
     * A constructor for the add operation from the command line arguments
     * @param quantity storage number given by the warehouse class
     * @param minusOP number given from the command line argument for minus operation
     * @param bugFlagOP number given from the command line argument for bug flag
     */
    public Subtract(Warehouse quantity, int minusOP, int bugFlagOP) {
        this.storage = quantity;
        this.number = minusOP;
        this.flag = bugFlagOP;
    }

    @Override
    public void run() {
        if(flag == 0){
            synchronized (this){    //synchronizing only when flag is 0
                storage.minusSize();
            }
        } else if (flag == 1){
            storage.minusSizeNoSync();
        }
    }
}
