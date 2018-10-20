package designpatterns.observer.usejavautil;

/**
 * @author james reall008@163.com  10/20/2018
 */
public class WeatherStation  {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        MyDisplay myDisplay = new MyDisplay(weatherData);
        weatherData.setNumbers(1.01f, 1.02f, 1.03f);
    }
}
