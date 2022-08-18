package leetCode;

public class SingleRowKeyboard {
    public int calculateTime(String keyboard, String word) {
        int count = 0;
        int pointer=0;
        for(char c: word.toCharArray()) {
            int indexOf =keyboard.indexOf(c);
            count += Math.abs(pointer - indexOf );
            pointer = indexOf;

        }
        return count;
    }

    public static void main(String[] args) {
        String keyboard = "pqrstuvwxyzabcdefghijklmno";

        System.out.println(keyboard.indexOf('d'));

    }
}
