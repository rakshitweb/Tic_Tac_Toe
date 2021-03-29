package tictactoe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        String userInput = "         ";
        char toggel = 'X';
        draw(userInput);
        boolean iscorrect=false;
        int i;
        boolean isImpossible = false;
        boolean XWin = false;
        boolean OWin = false;
        boolean difference;
        boolean isOver = false;
        boolean isdraw = false;
        int xs,os;
        do {
            do {
                System.out.println("Enter the coordinates: ");
                int a = myObj.nextInt();
                int b = myObj.nextInt();
                int pos = (a == 1) ? (a + b - 2) : (a == 2) ? (a + b) : (a + b + 2);
                if (a > 3 || a < 1 || b > 3 || b < 1)
                    System.out.println("Coordinates should be from 1 to 3!");
                else if (userInput.charAt(pos) == 'X' || userInput.charAt(pos) == 'O')
                    System.out.println("This cell is occupied! Choose another cell!");
                else {
                    userInput = userInput.substring(0, pos) + toggel + userInput.substring(pos + 1);
                    toggel = (toggel=='X')?'O':'X';
                    draw(userInput);
                    iscorrect = true;
                }
            } while (!iscorrect);
            xs=os=0;
            for (i = 0; i < 9; i++) {
                if (userInput.charAt(i) == 'X')
                    xs++;
                else if (userInput.charAt(i) == 'O')
                    os++;
            }
            if (xs + os == 9)
                isOver = true;
            if (Math.abs(xs - os) > 1) {
                isImpossible = true;
                difference = false;
            } else
                difference = true;

            if (difference && !isImpossible) {
                for (i = 0; i < 8; i++) {
                    int line = 0;
                    switch (i) {
                        case 0:
                            line = userInput.charAt(0) + userInput.charAt(1) + userInput.charAt(2);
                            break;
                        case 1:
                            line = userInput.charAt(3) + userInput.charAt(4) + userInput.charAt(5);
                            break;
                        case 2:
                            line = userInput.charAt(6) + userInput.charAt(7) + userInput.charAt(8);
                            break;
                        case 3:
                            line = userInput.charAt(0) + userInput.charAt(3) + userInput.charAt(6);
                            break;
                        case 4:
                            line = userInput.charAt(1) + userInput.charAt(4) + userInput.charAt(7);
                            break;
                        case 5:
                            line = userInput.charAt(2) + userInput.charAt(5) + userInput.charAt(8);
                            break;
                        case 6:
                            line = userInput.charAt(0) + userInput.charAt(4) + userInput.charAt(8);
                            break;
                        case 7:
                            line = userInput.charAt(2) + userInput.charAt(4) + userInput.charAt(6);
                            break;
                    }
                    if (line == 264) {
                        XWin = true;
                        isOver=true;
                    }
                    else if (line == 237) {
                        OWin = true;
                        isOver=true;
                    }
                }
                if (XWin && OWin)
                    isImpossible = true;
                if (isOver && !XWin && !OWin)
                    isdraw = true;
                if (!isImpossible) {
                    if (XWin)
                        System.out.println("X wins");
                    else if (OWin)
                        System.out.println("O wins");
//                    else if (!isOver)
//                        System.out.println("Game not finished");
                    if (isOver && isdraw) {
                        System.out.println("Draw");
                        isOver=true;
                    }
                } else {
                    System.out.println("Impossible");
                    isOver=true;
                }
            } else
                System.out.println("Impossible");
        }while(!isOver);
    }
    public static void draw(String userInput){
        System.out.println("---------");
        int i,j,k;
        k=0;
        for(i=0;i<3;i++){
            System.out.print("| ");
            for(j=0;j<3;j++){
                if(userInput.charAt(k)=='X'||userInput.charAt(k)=='O')
                    System.out.print(userInput.charAt(k));
                else
                    System.out.print(" ");
                k++;
                System.out.print(" ");
            }
            System.out.print("|\n");
        }
        System.out.println("---------");
    }
}
