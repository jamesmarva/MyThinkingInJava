package designpatterns.observer.usejavautil;

import twentyOne.fifth.WaxOMatic;

import java.util.Observable;
import java.util.Observer;

/**
 * @author james reall008@163.com  10/20/2018
 */
public class MyDisplay implements Observer, DisplayElement {

    private WeatherData weatherData;

    private float humidity;

    MyDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("MyDisplay: " + humidity);
    }


}
