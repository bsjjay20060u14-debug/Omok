import java.util.Scanner;
import java.lang.ArrayIndexOutOfBoundsException;

class PlaceStone{
    public static void stoneLocation(int[][] board){
        Scanner scanner = new Scanner(System.in);
        if(main.n%2==1){//n이 홀수면 흑돌, 짝수면 백돌
            System.out.println("흑돌 차례입니다. x, y좌표를 입력해주세요.");
                int x = scanner.nextInt();
                int y = scanner.nextInt();

            if(board[y][x]==0){
                board[y][x]=1;
            }
                else {
                    System.out.println("이미 돌이 놓여있는 좌표입니다. 다시 입력해주세요.");
                    main.n--;
                }
        }
        if(main.n%2==0){
            System.out.println("백돌 차례입니다. x, y좌표를 입력해주세요.");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                
            if(board[y][x]==0){
                board[y][x]=2;
            }
                else {
                    System.out.println("이미 돌이 놓여있는 좌표입니다. 다시 입력해주세요.");
                    main.n--;
                }
        }
    }
}
public class main {
    static int n=0;//static으로 선언하여 다른 클래스에서도 n값을 사용할 수 있도록 함
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String whiteStone = " ○ ";
        String blackStone = " ● ";

        System.out.println("아무 키나 입력하면 게임이 시작됩니다.");
        scanner.nextLine();
        System.out.println("게임 시작!");
        int[][] board = new int[15][15];
        
    for(;;){ //보드 매턴마다 출력하기 위해 무한루프 추가함
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
                    if(board[i][j]==1){//점 외에 흑돌과 백돌 출력위해 추가
                        System.out.print(blackStone);
                    } 
                    else if(board[i][j]==2){
                        System.out.print(whiteStone);
                        } 
                    else {
                        System.out.print(" . ");
                    }
                }
                System.out.println();
            }
            n++;

            try{
                PlaceStone.stoneLocation(board);
            } 
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("잘못된 좌표입니다. 다시 입력해주세요.");
                n--;
            }
        }
    }
}