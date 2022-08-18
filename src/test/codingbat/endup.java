package codingbat;

public class endup {
    public String endUp(String str) {
        if (str != null){
            if (str.length() <=3)
                return str.toUpperCase();
            else{

                int length = str.length();
                String head = str.substring(0, length-3);
                String tail = str.substring(length-3, length);
                return head + tail.toUpperCase();

            }
        }
        return null;

    }

    public static void main(String[] args) {
        System.out.println(new endup().endUp("hi there"));
    }


}
