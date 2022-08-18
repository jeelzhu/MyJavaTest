package other.mosh;

public class Stack {
    private int[] arr;

    public Stack(){

    }

    public void push(int value){
        if (arr == null){
            arr = new int[1];
            arr[0] = value;
        }
        else{
            int size = arr.length;
            int[] newArr = new int[size+1];
            System.arraycopy(arr, 0, newArr, 0, size);
            newArr[size] = value;
            arr = newArr;
        }
    }

    public int pop(){
        if (arr == null){
            throw new IllegalArgumentException();
        }
        else if (arr.length ==1){
            int pop = arr[0];
            arr = null;
            return pop;
        }
        int size = arr.length;
        int[] newArr = new int[size-1];
        System.arraycopy(arr, 0, newArr, 0,size-1);
        int pop = arr[size];
        arr = newArr;
        return pop;

    }
}
