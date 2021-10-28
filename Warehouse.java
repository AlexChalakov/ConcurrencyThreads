public class Warehouse {
    public int storageSize = 0; //declaring size of warehouse
    
    //two synchronized methods for add and subtract
    public synchronized void addSize(){ //important if its synchronized - if not, big numbers don't work
        storageSize += 1;
        System.out.println("Added. Inventory size = " + storageSize);
    }

    public synchronized void minusSize(){
        storageSize -= 1;
        System.out.println("Removed. Inventory size = " + storageSize);
    }

    //two unsynchronized methods for add and subtract
    public void addSizeNoSync(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        storageSize += 1;
        System.out.println("Added. Inventory size = " + storageSize);
    }

    public void minusSizeNoSync(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        storageSize -= 1;
        System.out.println("Removed. Inventory size = " + storageSize);
    }
}
