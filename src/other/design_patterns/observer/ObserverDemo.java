package other.design_patterns.observer;

public class ObserverDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer observer1 = new Observer();
        Observer observer2 = new Observer();
        subject.addObserver(observer1);
        //subject.addObserver(observer2);
        subject.update();

    }
}
