package other.design_patterns.state;

public class Player {
    State state;

    public Player(){
        state = new ReadyState();
    }

    public void setState(State state){
        this.state = state;
    }

    public void walk(){
        state.walk(this);
    }

}
