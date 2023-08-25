package other.design_patterns.state;

public class RunningState implements State{
    @Override
    public void walk(Player player) {
        System.out.println("running state is walking");
    }

    @Override
    public void run(Player player) {

    }

    @Override
    public void stop(Player player) {

    }
}
