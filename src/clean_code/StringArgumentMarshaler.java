package clean_code;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringArgumentMarshaler implements ArgumentMarshaler{
    private String stringValue ="";
    @Override
    public void set(Iterator<String> currentArgument) throws Exception {
        try {
            stringValue = currentArgument.next();
        } catch (NoSuchElementException e){
            throw new ArgsException(ErrorCode.MISSING_STRING);
        }
    }

    public static String getValue(ArgumentMarshaler am){
        if (am != null && am instanceof StringArgumentMarshaler){
            return ((StringArgumentMarshaler) am).stringValue;
        } else {
            return "";
        }
    }
}
