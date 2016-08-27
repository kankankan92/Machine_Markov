package ru.kourilenko;

import java.util.Scanner;

public class DialogWork {
    public static void dialogWork(MashineMarkov mashineMarkov) {
        while (true){
            System.out.println("1-подключить файл с программой, 2-преобразовать одну строку, 3-преобразовать много строк, 4-выход");
            Scanner scan = new Scanner(System.in);
            switch (scan.nextLine()){
                case "1":
                    mashineMarkov.getFileNameWithConsole();
                    break;
                case "2":
                    System.out.println("Введите строку для обработки:");
                    mashineMarkov.runOnce(scan.nextLine());
                    break;
                case "3":
                    mashineMarkov.runMultiple();
                    break;
                case "4":
                    return;
                default:
            }
        }
    }
}
