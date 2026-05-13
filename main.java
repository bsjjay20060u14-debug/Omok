import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("아무 키나 입력하면 게임이 시작됩니다.");
        scanner.nextLine();
        System.out.println("게임 시작!");

        int[][] board = new int[15][15];

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                System.out.print(". ");
            }
            System.out.println();
        }
    }
}
