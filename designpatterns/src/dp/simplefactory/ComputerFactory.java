package dp.simplefactory;

public class ComputerFactory {
    public static Computer getComputerInstance(ComputerType type, String RAM, String HDD, String CPU){
        if(ComputerType.PC.equals(type)){
            return new PC(RAM,HDD,CPU);
        }else if(ComputerType.SERVER.equals(type)){
            return new Server(RAM,HDD,CPU);
        }
        return null;
    }
}
