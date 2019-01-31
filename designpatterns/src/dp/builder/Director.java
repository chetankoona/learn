package dp.builder;

public class Director {

    public static void main(String args[]){
        Director director = new Director();
        Computer computer = director.createComputer();
        System.out.println(computer.toString());
    }

    private Computer createComputer() {
        Computer.ComputerBuilder builder = new Computer.ComputerBuilder("256GB","3GB");
        builder.setGraphicCardEnabled(true);
        builder.setBluetoothEnabled(false);
        return builder.build();

    }
}
