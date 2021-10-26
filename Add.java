public class Add implements Runnable{
    Warehouse storage;
    int number;
    int flag;

    public Add(Warehouse quantity, int addOP, int bugFlagOP) {
        this.storage = quantity;
        this.number = addOP;
        this.flag = bugFlagOP;
    }

    @Override
    public synchronized void run() {
        //if(flag == 0){
            //synchronized (this){
                for(int i = 0; i < number; i++){
                    storage.addSize();
                //}
            //}
        }
    }
}
