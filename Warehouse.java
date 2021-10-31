public class Warehouse {
    public int storageSize = 0; //declaring size of warehouse
    public int tempStorageSize; //declaring a temporary storage size so i move it around and create a race condition
    
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
        tempStorageSize = storageSize + 1;
        //means in order for a race condition to be created
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        storageSize = tempStorageSize;

        /*try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("Added. Inventory size = " + storageSize);
    }

    public void minusSizeNoSync(){
        tempStorageSize = storageSize - 1;
        //means in order for a race condition to be created
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        storageSize = tempStorageSize;

        /*try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("Removed. Inventory size = " + storageSize);
    }
}
