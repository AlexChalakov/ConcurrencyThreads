public class Warehouse {
    public int storageSize = 0; //declaring size of warehouse
    
    public synchronized void addSize(){ //important if its synchronized - if not, big numbers don't work
        storageSize += 1;
        System.out.println("Added. Inventory size = " + storageSize);
    }

    public synchronized void minusSize(){
        storageSize -= 1;
        System.out.println("Removed. Inventory size = " + storageSize);
    }

    /*public double getSize(){
        return storageSize;
    }*/
}
