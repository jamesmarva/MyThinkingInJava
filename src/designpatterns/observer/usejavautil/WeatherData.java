package designpatterns.observer.usejavautil;

import java.util.Observable;

/**
 * @author james reall008@163.com  10/17/2018
 */
public class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() { }

    public void measurementsChanged() {

//        System.out.println("temperature " + this.temperature);
//        System.out.println("humidity " + this.humidity);
//        System.out.println("pressure " + this.pressure);
        setChanged();
        notifyObservers();

    }

    public void setNumbers(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }



    public float getTemperature() {
        return this.temperature;
    }

    public float getHumidity() {
        return this.humidity;
    }

    public float getPressure() {
        return this.pressure;
    }


}
