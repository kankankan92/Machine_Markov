package ru.kourilenko;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{

        MashineMarkov mashine = new MashineMarkov();
        switch (args.length) {
            case 0:
                mashine.getFileNameWithConsole();
                mashine.runMultiple();
                break;
            case 1:
                switch (args[0]) {
                    case "-dialog":
                        DialogWork.dialogWork(mashine);
                        break;
                    case "-help":
                        System.out.println(Consts.help);
                        break;
                    default:
                        mashine.setFileName(args[0]);
                        mashine.runMultiple();
                }

                break;
            case 2:
                mashine.setFileName(args[0]);
                mashine.runOnce(args[1]);
                break;
            default:
                System.out.println(Consts.help);
        }


    }
}


