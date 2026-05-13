import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String whiteStone = " ○ ";
        String blackStone = " ● ";

        System.out.println("아무 키나 입력하면 게임이 시작됩니다.");
        scanner.nextLine();
        System.out.println("게임 시작!");

        int[][] board = new int[15][15];
        System.out.print("     ");

        for (int i=0;i<board.length;i++){
            if(i<10 && i!=0) {
                    System.out.print(" ");
                }
                System.out.print(i + " ");
                if (i==board.length-1){
                    System.out.println();
                }
        }
            
        for(int i = 0, k=0; i<board.length; i++, k++){
            if(k<10) {
                System.out.print(" ");
            }
            System.out.print(" "+ k + " ");
            for(int j=0; j<board[i].length; j++){
                System.out.print(" . ");
            }
            System.out.println();
        }
    }
}
