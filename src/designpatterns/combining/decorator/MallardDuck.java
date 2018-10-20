package designpatterns.combining.decorator;

/**
 * 装饰器的鸭子
 * @author james reall008@163.com  10/20/2018
 */
public class MallardDuck implements Quackable {
    @Override
    public void quack() {
        System.out.println("Quack");
    }

    public String toString() {
        return "Mallard Duck";
    }
}
