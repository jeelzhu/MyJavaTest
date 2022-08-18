package zombie;

import java.util.*;

public class ZombieApocalypse {
    private int dimensions;
    private Queue<Creature> activeZombies = new LinkedList<>();
    private List<Creature> frozenZombies = new LinkedList<>();
    private char[] moves;
    private List<Creature>[][] grid;

    private List<Creature> getFrozenZombies() {
        return frozenZombies;
    }

    private ZombieApocalypse(int dimensions, Creature zombie, List<Creature> victims, char[] moves){
        this.dimensions = dimensions;
        this.activeZombies.add(zombie);
        this.moves = moves;
        initializeGrid(victims);
    }

    private void initializeGrid(List<Creature> victims){
        this.grid = new List[dimensions][dimensions];
        for (Creature victim: victims) {
            if (grid[victim.x][victim.y] == null){
                List<Creature> list = new LinkedList<>();
                list.add(victim);
                grid[victim.x][victim.y] = list;
            }
            else{
                grid[victim.x][victim.y].add(victim);
            }
        }
    }

    private void start(){
        transformVictimInStartPosition();
        transformVictimInMoving();
    }

    private void transformVictimInStartPosition(){
        Creature zombie = activeZombies.peek();
        transformVictim(zombie);
    }

    private void transformVictimInMoving() {
        while(!activeZombies.isEmpty()){
            Creature zombie = activeZombies.poll();
            moveZombie(zombie);
            frozenZombies.add(zombie);
        }
    }

    private void moveZombie(Creature zombie){
        for (Character m: moves){
            zombie.move(m, dimensions);
            transformVictim(zombie);
        }
    }

    private void transformVictim(Creature zombie){
        List<Creature> victims = grid[zombie.x][zombie.y];
        if  (victims != null){
            activeZombies.addAll(victims);
            grid[zombie.x][zombie.y] = null;
        }
    }

    private String getResults(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("zombies score: ")
                .append(frozenZombies.size() - 1)
                .append("\nzombies positions: ");
        for (Creature zombie: frozenZombies){
            stringBuilder.append("(").append(zombie.x).append(",").append(zombie.y).append(") ");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
/*
        case1();

        case2();

        case3();
        case4();

        case5();*/

        case6();

    }
    private static void case1(){
        System.out.println("Test Case 1: one zombie, no victim");
        Creature zombie = new Creature(2,1);
        List<Creature> victims = new ArrayList<>();
        char[] moves = {'D', 'L', 'U', 'U', 'R', 'R'};
        ZombieApocalypse zombieApocalypse = new ZombieApocalypse(4, zombie, victims, moves);
        zombieApocalypse.start();
        List<Creature> frozenZombies = zombieApocalypse.getFrozenZombies();
        if (frozenZombies.size() !=1 || frozenZombies.get(0).x !=3 || frozenZombies.get(0).y !=0  ){
            //no victim is transformed to zombie , there are is only one zombies to the end
            System.out.println("Fail");
            return;
        }
        System.out.println(zombieApocalypse.getResults());
    }

    private static void case2(){
        System.out.println("Test Case 2: one zombie, three victims");
        Creature zombie = new Creature(2,1);
        Creature victim1 = new Creature(0,1);
        Creature victim2 = new Creature(1,2);
        Creature victim3 = new Creature(3,1);
        List<Creature> victims = new ArrayList<>();
        victims.add(victim1);
        victims.add(victim2);
        victims.add(victim3);
        char[] moves = {'D', 'L', 'U', 'U', 'R', 'R'};
        ZombieApocalypse zombieApocalypse = new ZombieApocalypse(4, zombie, victims, moves);
        zombieApocalypse.start();
        List<Creature> frozenZombies = zombieApocalypse.getFrozenZombies();
        if (frozenZombies.size() !=4){//All three victims are transformed to zombies, there are total four zombies to the end
            System.out.println("Fail");
            return;
        }
        System.out.println(zombieApocalypse.getResults());
    }

    private static void case3(){
        System.out.println("Test Case 3: one zombie, three victims, dimensions is 6");
        Creature zombie = new Creature(2,1);
        Creature victim1 = new Creature(0,1);
        Creature victim2 = new Creature(1,2);
        Creature victim3 = new Creature(3,1);
        List<Creature> victims = new ArrayList<>();
        victims.add(victim1);
        victims.add(victim2);
        victims.add(victim3);
        char[] moves = {'D', 'L', 'U', 'U', 'R', 'R'};
        ZombieApocalypse zombieApocalypse = new ZombieApocalypse(6, zombie, victims, moves);
        zombieApocalypse.start();
        List<Creature> frozenZombies = zombieApocalypse.getFrozenZombies();
        if (frozenZombies.size() !=3 ){//two out of three victims are transformed to zombies, there are total three zombies to the end
            System.out.println("Fail");
            return;
        }
        System.out.println(zombieApocalypse.getResults());
    }

    private static void case4(){
        System.out.println("Test Case 4: one zombie, 4 victims, dimensions is 6");
        Creature zombie = new Creature(3,4);
        Creature victim1 = new Creature(1,2);
        Creature victim2 = new Creature(2,3);
        Creature victim3 = new Creature(4,2);
        Creature victim4 = new Creature(5,4);
        List<Creature> victims = new ArrayList<>();
        victims.add(victim1);
        victims.add(victim2);
        victims.add(victim3);
        victims.add(victim4);
        char[] moves = {'R', 'R', 'R', 'R', 'U', 'U','R', 'R', 'R'};
        ZombieApocalypse zombieApocalypse = new ZombieApocalypse(6, zombie, victims, moves);
        zombieApocalypse.start();
        List<Creature> frozenZombies = zombieApocalypse.getFrozenZombies();
        if (frozenZombies.size() !=3 ){//two out of three victims are transformed to zombies, there are total three zombies to the end
            //System.out.println("Fail");
            //return;
        }
        System.out.println(zombieApocalypse.getResults());
    }

    private static void case5(){
        System.out.println("Test Case 5: one zombie, 4 victims, dimensions is 6, however one victim and zombie occupied same initial position");
        Creature zombie = new Creature(3,4);
        Creature victim1 = new Creature(1,2);
        Creature victim2 = new Creature(3,4);
        Creature victim3 = new Creature(4,2);
        Creature victim4 = new Creature(5,4);
        List<Creature> victims = new ArrayList<>();
        victims.add(victim1);
        victims.add(victim2);
        victims.add(victim3);
        victims.add(victim4);
        char[] moves = {'R', 'R', 'R', 'R', 'U', 'U','R', 'R', 'R'};
        ZombieApocalypse zombieApocalypse = new ZombieApocalypse(6, zombie, victims, moves);
        zombieApocalypse.start();
        List<Creature> frozenZombies = zombieApocalypse.getFrozenZombies();
        if (frozenZombies.size() !=4 ){//two out of three victims are transformed to zombies, there are total three zombies to the end
            //System.out.println("Fail");
            //return;
        }
        System.out.println(zombieApocalypse.getResults());
    }


    private static void case6(){
        System.out.println("Test Case 6: one zombie, 5 victims, dimensions is 6, " +
                "however mutiple victims occupied same position");
        Creature zombie = new Creature(3,3);
        Creature victim1 = new Creature(1,4);
        Creature victim2 = new Creature(1,4);
        Creature victim3 = new Creature(5,2);
        Creature victim4 = new Creature(5,2);
        Creature victim5 = new Creature(4,5);
        List<Creature> victims = new ArrayList<>();
        victims.add(victim1);
        victims.add(victim2);
        victims.add(victim3);
        victims.add(victim4);
        victims.add(victim5);
        char[] moves = {'D', 'L', 'L', 'L', 'L', 'U', 'U','R', 'R'};
        ZombieApocalypse zombieApocalypse = new ZombieApocalypse(6, zombie, victims, moves);
        zombieApocalypse.start();
        List<Creature> frozenZombies = zombieApocalypse.getFrozenZombies();
        if (frozenZombies.size() !=5 ){//two out of three victims are transformed to zombies, there are total three zombies to the end
            //System.out.println("Fail");
            //return;
        }
        System.out.println(zombieApocalypse.getResults());
    }

}

class Creature{
    int x, y;
    Creature(int x, int y){
        this.x = x;
        this.y = y;
    }
    void move(char move, int dimensions){
        if (move == 'U') up(dimensions);
        else if (move =='D') down(dimensions);
        else if (move =='L') left(dimensions);
        else if (move =='R') right(dimensions);
    }

    private void up(int dimensions){
        if(this.y - 1 < 0) this.y = dimensions-1;
        else this.y--;
    }

    private void down(int dimensions) {
        if(this.y + 1 == dimensions) this.y =0;
        else this.y++;
    }

    private void left(int dimensions) {
        if(this.x - 1 < 0) this.x = dimensions-1;
        else this.x--;
    }

    private void right(int dimensions) {
        if(this.x + 1 == dimensions) this.x = 0;
        else this.x++;
    }
}