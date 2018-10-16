package designpatterns.observer.notusejavautil;

/**
 * @author james reall008@163.com  10/16/2018
 */
public interface Subject {

    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
