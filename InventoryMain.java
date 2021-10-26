public class InventoryMain { //main class
    public static void main(String args[]) {
        String add = args [0]; //reading the first argument from the command line, which is +
        String minus = args [1]; //reading the second argument from the command line, which is -
        String bugFlag = args [2]; //reading the third argument from the command line, which is the bug flag

        int addOP = Integer.parseInt(add); //parsing it from string to int
        int minusOP = Integer.parseInt(minus);
        int bugFlagOP = Integer.parseInt(bugFlag);

        Warehouse quantity = new Warehouse(); //creating new instance of the warehouse 

        Thread t1 = new Thread(new Add(quantity, addOP, bugFlagOP));
        Thread t2 = new Thread(new Subtract(quantity, minusOP, bugFlagOP));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Final Inventory size = " + quantity.storageSize);
    }
}