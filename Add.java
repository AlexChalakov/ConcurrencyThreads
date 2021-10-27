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
    public void run() {
        if(flag == 0){
            synchronized (this){
                storage.addSize();
            }
        } else if (flag == 1){
            storage.addSizeNoSync();
        }
    }
}
