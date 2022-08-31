package fr.m2i.premierspring.enums;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.tomcat.util.buf.StringUtils;

import java.util.HashMap;
import java.util.Map;

public enum OperationType {




    ADDITION("ADDITION"),
    SOUSTRACTION("SOUSTRACTION"),
    MULTIPLICATION("MULTIPLICATION"),
    DIVISION("DIVISION"),
    PUISSANCE("PUISSANCE");

    public static OperationType fromString(String operation){
        switch (operation){
            case "+":return  ADDITION;
            case "-":return  SOUSTRACTION;
            case "*":return  MULTIPLICATION;
            case "/":return  DIVISION;
            case "²":return  PUISSANCE;
            default: throw new IllegalArgumentException("operateur illegal");
        }

    }

    OperationType(String value) {
        this.value = value;
    }

    private String value;
    @JsonValue
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    //    public enum DeviceScheduleFormat {
//
//        Weekday,
//        EvenOdd,
//        Interval;
//
//        private static Map<String, OperationType> namesMap = new HashMap<String, OperationType>(5);
//
//        static {
//            namesMap.put("ADDITION", ADDITION);
//            namesMap.put("SOUSTRACTION", SOUSTRACTION);
//            namesMap.put("MULTIPLICATION", MULTIPLICATION);
//            namesMap.put("DIVISION", DIVISION);
//            namesMap.put("PUISSANCE", PUISSANCE);
//        }
//
//        @JsonCreator
//        public static OperationType forValue(String value) {
//            return namesMap.get(StringUtils.lowerCase(value));
//        }
//
//        @JsonValue
//        public String toValue() {
//            for (Map.Entry<String, OperationType> entry : namesMap.entrySet()) {
//                if (entry.getValue() == this)
//                    return entry.getKey();
//            }
//
//            return null; // or fail
//        }
//    }



}
