package clean_code;

import java.util.Iterator;

public class BooleanArgumentMarshaler implements ArgumentMarshaler{
    private boolean booleanValue = false;
    @Override
    public void set(Iterator<String> currentArgument) throws Exception {
        booleanValue = true;
    }

    public static boolean getvalue(ArgumentMarshaler am){
        if (am != null && am instanceof BooleanArgumentMarshaler){
            return ((BooleanArgumentMarshaler) am).booleanValue;
        } else {
            return false;
        }
    }
}
