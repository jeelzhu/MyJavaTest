package codility;

public class MinPerimeterRectangle {
    public int solution(int N) {

        double min =0;
        for (int i=1; i<= (int)Math.sqrt(N); i++){
            int perimeter = 2*(i+ (N/i));
            if(i==1)
                min = perimeter;
            else if(perimeter < min)
                min = perimeter;

        }

        return (int) min;
    }

    public static void main(String[] args) {
        MinPerimeterRectangle rectangle = new MinPerimeterRectangle();
        System.out.println(rectangle.solution(30));
    }
}
