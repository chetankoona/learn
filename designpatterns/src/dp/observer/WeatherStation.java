package dp.observer;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentCondition currentCondition = new CurrentCondition(weatherData);
        Statistics statistics = new Statistics(weatherData);

        weatherData.measurementsChanged(10,20,30);
        System.out.println("\n");
        weatherData.measurementsChanged(40,50,60);
        System.out.println("\n");
        weatherData.removeObserver(statistics);
        weatherData.measurementsChanged(70,80,90);
    }
}
