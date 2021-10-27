public class Subtract implements Runnable{
    Warehouse storage;
    int number;
    int flag;
    
    public Subtract(Warehouse quantity, int minusOP, int bugFlagOP) {
        this.storage = quantity;
        this.number = minusOP;
        this.flag = bugFlagOP;
    }

    @Override
    public void run() {
        if(flag == 0){
            synchronized (this){
                storage.minusSize();
            }
        } else if (flag == 1){
            storage.minusSizeNoSync();
        }
    }
}
