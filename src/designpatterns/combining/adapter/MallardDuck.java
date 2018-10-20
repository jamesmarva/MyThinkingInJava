package designpatterns.combining.adapter;

/**
 * 复合模式
 * @author james reall008@163.com  10/20/2018
 */
public class MallardDuck  implements Quackable {
    @Override
    public void quack() {
        System.out.println("Quack");

    }
}
