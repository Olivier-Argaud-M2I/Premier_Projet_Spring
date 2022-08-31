package fr.m2i.premierspring.enums;

public enum OperationType {

    ADDITION,
    SOUSTRACTION,
    MULTIPLICATION,
    DIVISION,
    PUISSANCE;

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



}
