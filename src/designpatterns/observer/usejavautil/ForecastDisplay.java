package designpatterns.observer.usejavautil;

import java.util.Observable;
import java.util.Observer;

/**
 * @author james reall008@163.com  10/17/2018
 */
public class ForecastDisplay implements Observer, DisplayElement {

    private Observable observable;

    private float temperature ;

    public ForecastDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);

    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.temperature = weatherData.getTemperature();
            display();

        }

    }

    @Override
    public void display() {
        System.out.println("ForecastDisplay: " + this.temperature);
    }
}
