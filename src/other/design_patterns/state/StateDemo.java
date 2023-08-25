package other.design_patterns.state;

public class StateDemo {
    public static void main(String[] args) {
        Player player = new Player();
        player.walk();
        player.setState(new RunningState());
        player.walk();
    }
}
