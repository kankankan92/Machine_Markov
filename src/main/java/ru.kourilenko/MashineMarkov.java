package ru.kourilenko;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MashineMarkov {
    private ArrayList<Instruction> instructions = new ArrayList<>();

    public void setFileName(String fileName) throws IOException {
        instructions = Parser.parse(fileName.trim());
    }

    public void setFileNameWithString(String fileName) throws IOException {
        setFileName(fileName);
    }


    public void getFileNameWithConsole() {
        System.out.println("Введите имя файла с инструкциями:");
        Scanner scan = new Scanner(System.in);
        while (instructions.isEmpty()) {
            try {
                setFileName(scan.nextLine());
            } catch (IOException e) {
                System.out.println("Файла с таким именем не существует. Введите корректное имя файла:");
            }
        }
    }

    public String runOnce(String str) {
        String origin = str;
        while (true) {
            boolean flag = false;
            for (int i = 0; i < instructions.size(); i++) {
                if (str.contains(instructions.get(i).from)) {
                    str = str.replaceFirst(instructions.get(i).from, instructions.get(i).to);
                    flag = instructions.get(i).isFinal;
                    break;
                }
                if (i == instructions.size() - 1) flag = true;
            }
            if (flag) break;
        }
        System.out.println(origin + "->" + str);
        return str;
    }

    public void runMultiple() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Введите строку для обработки. Для выхода из программы введите слово 'exit'");
            String str = scan.nextLine();
            if (str.equals("exit")) {
                break;
            } else {
                runOnce(str);
            }
        }

    }

    public boolean hasInstructions() {
        return instructions != null;
    }

}
