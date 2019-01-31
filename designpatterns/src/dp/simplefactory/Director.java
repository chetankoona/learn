package dp.simplefactory;

public class Director {

    public static void main(String args[]) {
        Computer compOne = ComputerFactory.getComputerInstance(ComputerType.PC, "2GB", "256GB", "2.1GHZ");
        Computer compTwo = ComputerFactory.getComputerInstance(ComputerType.SERVER, "8GB", "500GB", "3.1GHZ");
        System.out.println(compOne);
        System.out.println(compTwo);
    }

}
