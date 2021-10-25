public class Subtract implements Runnable{
    Warehouse storage;
    int number;
    //int flag;
    
    public Subtract(Warehouse quantity, int minusOP /*int bugFlagOP*/) {
        this.storage = quantity;
        this.number = minusOP;
        //this.number = bugFlagOP;
    }

    @Override
    public synchronized void run() {
        //if(flag == 0){
            //synchronized (this){
                for(int i = 0; i < number; i++){
                    storage.minusSize();
                //}
            //}
        }
    }
}
