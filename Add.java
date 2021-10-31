public class Add implements Runnable{
    Warehouse storage;
    int number;
    int flag;

    /**
     * A constructor for the add operation from the command line arguments
     * @param quantity storage number given by the warehouse class
     * @param addOP number given from the command line argument for plus operation
     * @param bugFlagOP number given from the command line argument for bug flag
     */
    public Add(Warehouse quantity, int addOP, int bugFlagOP) {
        this.storage = quantity;
        this.number = addOP;
        this.flag = bugFlagOP;
    }

    @Override
    public void run() {
        if(flag == 0){
            synchronized (this){    //synchronizing only when flag is 0
                storage.addSize();
            }
        } else if (flag == 1){
            storage.addSizeNoSync();
        }
    }
}
