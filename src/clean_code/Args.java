package clean_code;

import com.sun.jdi.connect.Connector;

import java.util.*;

public class Args {
    private Map<Character, ArgumentMarshaler> marshalers;
    private Set<Character> argsFound;
    private ListIterator<String> currentArgument;

    public Args(String schema, String[] args) throws ArgsException{

        marshalers = new HashMap<>();
        argsFound = new HashSet<>();
        
    }
    
    private void parseSchema(String schema) throws ArgsException {
        for (String element: schema.split(",")){
            if (element.length()>0)
                parseSchemaElement(element.trim());
        }
    }

    private void parseSchemaElement(String element)throws ArgsException {
        char elementId = element.charAt(0);
        String elementTail = element.substring(1);
        validateSchemaElementId(elementId);
        if (elementTail.length()==0)
            marshalers.put(elementId, new BooleanArgumentMarshaler());
        else if (elementTail.equals("*"))
            marshalers.put(elementId, new StringArgumentMarshaler());
    }

    private void validateSchemaElementId(char elementId) {
    }
}
