import java.util.Scanner;
class PlaceStone{
    public static void stoneLocation(int[][] board, int n){
        if(n%2==1){//n이 홀수면 흑돌, 짝수면 백돌
            System.out.println("흑돌 차례입니다. x, y좌표를 입력해주세요.");
                Scanner scanner = new Scanner(System.in);
                int x = scanner.nextInt();
                int y = scanner.nextInt();
            board[y][x]=1;
        }
        if(n%2==0){
            System.out.println("백돌 차례입니다. x, y좌표를 입력해주세요.");
                Scanner scanner = new Scanner(System.in);
                int x = scanner.nextInt();
                int y = scanner.nextInt();
            board[y][x]=2;
        }
    }
}
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String whiteStone = " ○ ";//(질문)다크테마라 검은색으로 보이는건가?
        String blackStone = " ● ";

        System.out.println("아무 키나 입력하면 게임이 시작됩니다.");
        scanner.nextLine();
        System.out.println("게임 시작!");
        int[][] board = new int[15][15];
        int n=0;
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
            PlaceStone.stoneLocation(board, n);
        }
    }
}