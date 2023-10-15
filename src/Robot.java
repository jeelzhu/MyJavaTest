import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.StringJoiner;

/*
Test Input:

{
 "productsInTray": "ONSNOOPPERE",
 "targetDisplayHeight": 3,
 "targetDisplayConfiguration": [
 ["S"],
 ["N","O","O","P"],
 ["E", "R"]
 ]
}
Expected Output:

T3000 is stacking tray ONSNOOPPERE
placeInDisplay: { product: "O", shelf: 1, position: 1 }
placeInDisplay: { product: "N", shelf: 1, position: 0 }
placeInDisplay: { product: "S", shelf: 0, position: 0 }
returnToStorage: { product: "N" }
placeInDisplay: { product: "O", shelf: 1, position: 2 }
*/


public class Robot {
  private String name;
  private Stack<Product> tray;
  private DisplayShelf displayShelf;
  private StorageShelf storageShelf;

  public Robot(String name, Stack<Product> tray, DisplayShelf displayShelf, StorageShelf storageShelf){
    this.name = name;
    this.tray = tray;
    this.displayShelf = displayShelf;
    this.storageShelf = storageShelf;
  }

  public void run(){
    while(!tray.isEmpty()){
        Product product = tray.pop();
        try {
            this.displayShelf.placeProduct(product);
        } catch (PositionNotFoundException e){
            this.storageShelf.placeProduct(product);
        } catch (Exception e){
            System.out.println("Fail to run robot:"+e.getMessage());
        }
    }
  }

  public void displayTray(){
    StringBuilder builder= new StringBuilder();
    builder.append(name+" is stacking tray ");
    tray.stream().forEach(product->builder.append(product.getName()));
    System.out.println(builder.toString());
  }

  public static void main(String[] args) {
        final String[] tray = new String[] {"O", "N", "S", "N", "O", "O", "P", "P", "E", "R", "E"};
        //ONSNOOPPERE
        Stack<Product> trayStack = new Stack<>();
        for (int i = tray.length-1; i>=0; i--){
            trayStack.add(new Product(tray[i]));
        }
        /*
         *  "targetDisplayConfiguration": [
            ["S"],
            ["N","O","O","P"],
            ["E", "R"]
            ]
         */
        List<List<String>> targetDisplayConfiguration = List.of(
            List.of("S"),
            List.of("N", "O", "O", "P"),
            List.of("E", "R")
        );


         Map<String, Queue<Position>> productToDisplayMap = new HashMap<>();
         Queue<Position> sPosition = new LinkedList<>();
         sPosition.add(new Position(0,0));
         Queue<Position> oPosition = new LinkedList<>();
         oPosition.add(new Position(1,1));
         oPosition.add(new Position(1,2));
         Queue<Position> nPosition = new LinkedList<>();
         nPosition.add(new Position(1,0));
         Queue<Position> pPosition = new LinkedList<>();
         pPosition.add(new Position(1,3));
         Queue<Position> ePosition = new LinkedList<>();
         ePosition.add(new Position(2,0));
         Queue<Position> rPosition = new LinkedList<>();
         rPosition.add(new Position(2,1));
        productToDisplayMap.put("S", sPosition);
        productToDisplayMap.put("O", oPosition);
        productToDisplayMap.put("N", nPosition);
        productToDisplayMap.put("P", pPosition);
        productToDisplayMap.put("E", ePosition);
        productToDisplayMap.put("R", rPosition);
        DisplayShelf displayShelf = new DisplayShelf(3, 4, productToDisplayMap);
        StorageShelf storageShelf = new StorageShelf();
        Robot robot = new Robot("T3000", trayStack, displayShelf, storageShelf);
        robot.displayTray();
        robot.run();
        displayShelf.print();
        storageShelf.print();
    }
}

class Product {
    private String name;
    public Product(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}

class DisplayShelf {
    Map<String, Queue<Position>> productToDisplayMap;
    private List<List<Product>> shelves = new ArrayList<>();

    public DisplayShelf(int height, int width, Map<String, Queue<Position>> productToDisplayMap ){
        for(int i=0; i< height; i++){
            shelves.add(new ArrayList<Product>(Collections.nCopies(width, null)));
        }
        this.productToDisplayMap = productToDisplayMap;
    }

    private void put(Product product, Position position){
        shelves.get(position.shelf).set(position.position, product);
    }

    private Position getPosition(Product product){
        String name = product.getName();
        Queue<Position> positions = this.productToDisplayMap.get(name);
        if (positions == null){
            throw new PositionNotFoundException();
        }
        Position position = positions.poll();
        if (position == null){
            throw new PositionNotFoundException();
        }
        return position;
    }

    public void placeProduct(Product product){
        Position position = getPosition(product);
        this.put(product, position);
        //placeInDisplay: { product: "N", shelf: 1, position: 0 }
        System.out.println("placeInDisplay: { product: "+product.getName()+", shelf: "+position.shelf
        +", position: "+position.position+" ");
    }

    public void print(){
        /*
         * shelf 0: [S]
            shelf 1: [N,O,O,P]
            shelf 2: [E,R]
         */
        System.out.println("Display:");
        for (int i=0; i<this.shelves.size();i++){
            System.out.println("shelf "+i+":"+RobotUtil.convertProductsToStr(this.shelves.get(i)));
        }
    }

}

class StorageShelf {
    List<Product> shelf;

    public StorageShelf(){
        this.shelf = new ArrayList<>();
    }

    public void placeProduct(Product product) {
        this.shelf.add(product);
        //returnToStorage: { product: "N" }
        System.out.println("returnToStorage: { product: "+product.getName()+" }");
    }

    public void print(){
        System.out.println("Storage:");
        System.out.println(RobotUtil.convertProductsToStr(this.shelf));
    }
}

class Position {
    int shelf;
    int position;
    public Position(int shelf, int position){
        this.shelf = shelf;
        this.position = position;
    }
}

class PositionNotFoundException extends RuntimeException{
    public PositionNotFoundException(){
        super();
    }
}

class RobotUtil {
    //Convert products from the List to String like "[N,O,P,E]"
    public static String convertProductsToStr(List<Product> products){
        try {
            StringBuilder builder = new StringBuilder();
            StringJoiner joiner = new StringJoiner(",");
            products.stream().filter(product -> product != null).forEach(product -> joiner.add(product.getName()));
            builder.append("[").append(joiner.toString()).append("]");
            return builder.toString();
        }catch(Exception e){
            return "[]";
        }
    }
}
