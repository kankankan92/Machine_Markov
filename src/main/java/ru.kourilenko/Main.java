package ru.kourilenko;

public class Main {
    public static void main(String[] args){

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
                        mashine.setFileNameWithString(args[0]);
                        mashine.runMultiple();
                }

                break;
            case 2:
                mashine.setFileNameWithString(args[0]);
                mashine.runOnce(args[1]);
                break;
            default:
                System.out.println(Consts.help);
        }


    }
}


