package other.mosh;

public class TestArray {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Array numbers = new Array(3);
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);
        numbers.removeAt(1);
        numbers.print();

        //System.out.println(numbers.indexOf(10));
    }

}


class Array{
    private int[] arr;
    private int count;
    public Array(int size){
        arr = new int[size];
    }

    public void insert(int value) {
        if (count == arr.length){//increase the capacity of array
            int[] newArr = new int[count *2];
            for(int i=0; i< count; i++){
                newArr[i] = arr[i];
            }
            arr = newArr;
        }

        arr[count++] = value;
    }

    public void removeAt(int index) {
        if (index <0 || index >= count)
            throw new IllegalArgumentException();
        for(int i=index; i< count; i++) {
            arr[i]= arr[i+1];
        }
        count--;
    }

    public int indexOf(int value) {
        for (int i=0; i< count; i++){
            if (arr[i]==value)
                return i;
        }
        return -1;
    }

    public void print(){
        for (int i=0; i< count; i++){
            System.out.println(arr[i]);
        }
    }
}