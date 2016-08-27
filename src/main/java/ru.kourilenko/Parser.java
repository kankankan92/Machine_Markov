package ru.kourilenko;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {
    public static ArrayList<Instruction> parse(String a) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(a));
        ArrayList<Instruction> list = new ArrayList<>();
        while (true){
            String str;
            try {
                str = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Ошибка чтения файла с инструкциями");
            }
            if (str == null) break;
            Instruction i = new Instruction(str);
            list.add(i);
        }
        return list;
    }
}
