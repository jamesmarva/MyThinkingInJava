package designpatterns.combining.adapter;

/**
 * @author james reall008@163.com  10/20/2018
 */
public class GooseAdapter implements Quackable {

    Goose goose;

    public GooseAdapter(Goose goose) {
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk();
    }

    public String toString() {
        return "Goose pretending to be a Duck";
    }
}
