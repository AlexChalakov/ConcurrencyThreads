import java.util.ArrayList;

public class InventoryMain { //main class
    public static void main(String args[]) throws InterruptedException {
        String add = args [0]; //reading the first argument from the command line, which is +
        String minus = args [1]; //reading the second argument from the command line, which is -
        String bugFlag = args [2]; //reading the third argument from the command line, which is the bug flag

        //parsing it from string to int
        int addOP = Integer.parseInt(add); 
        int minusOP = Integer.parseInt(minus);
        int bugFlagOP = Integer.parseInt(bugFlag);

        Warehouse quantity = new Warehouse(); //creating new instance of the warehouse 
        ArrayList<Thread> threadList = new ArrayList<Thread>(); //an array list so that they can be joined after they finish

        for(int i = 0; i< addOP; i++){
            threadList.add(new Thread(new Add(quantity, addOP, bugFlagOP)));
        }

        for(int i = 0; i< minusOP; i++){
            threadList.add(new Thread(new Subtract(quantity, minusOP, bugFlagOP)));
        }

        for (Thread t : threadList){
            //Thread.sleep(1000);
            t.start();
        }

        for (Thread t : threadList){
            t.join();
        }

        //final print with the appropriate result
        System.out.println("Final Inventory size = " + quantity.storageSize);

        //testing methods if we have all neccessary threads
        //System.out.println("id of thread " + t1.getName());
        //System.out.println("id of thread " + t2.getName());
    }
}