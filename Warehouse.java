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
        //Thread.sleep(100);
        storageSize += 1;
        System.out.println("Added. Inventory size = " + storageSize);
    }

    public void minusSizeNoSync(){
        //Thread.sleep(100);
        storageSize -= 1;
        System.out.println("Removed. Inventory size = " + storageSize);
    }
}
