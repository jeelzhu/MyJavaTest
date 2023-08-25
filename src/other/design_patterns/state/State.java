package other.design_patterns.state;

public interface State {
    public abstract void walk(Player player);
    public abstract void run(Player player);
    public abstract  void stop(Player player);
}
