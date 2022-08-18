package leetCode.easy;

public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (isRight(rec1, rec2) || isLeft(rec1, rec2) || isTop(rec1, rec2) || isBottom(rec1, rec2))
            return false;
        return true;

    }

    //rec2 is on the right side of rec1
    private boolean isRight(int[] rec1, int[] rec2){
        return rec1[2] <= rec2[0];
    }

    //rec2 is on the left side of rec1
    private boolean isLeft(int[] rec1, int[] rec2){
        return rec1[0] >= rec2[2];
    }

    //rec2 is above rec1
    private boolean isTop(int[] rec1, int[] rec2){
        return rec1[3] <= rec2[1];
    }

    //rec2 is below rec1
    private boolean isBottom(int[] rec1, int[] rec2){
        return rec1[1] >= rec2[3];
    }
}
