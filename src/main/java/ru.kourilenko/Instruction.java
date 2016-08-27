package ru.kourilenko;

public class Instruction {
    String from;
    String to;
    boolean isFinal = false;

    public Instruction(String str) {
        if (str.contains("->")&&!str.isEmpty()) {
            isFinal = str.contains(".");
            str = str.replace(".", "");
            from = str.split("->")[0];
            if (str.endsWith("->")) {
                to = "";
            } else {
                to = str.split("->")[1];
            }
        }else{
            throw new IllegalArgumentException("Некорректная строка!"+str);
        }
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "from=" + from  +
                ", to=" + to  +
                ", isFinal=" + isFinal +
                '}';
    }
}
