import java.util.Scanner;
import java.lang.ArrayIndexOutOfBoundsException;

class CountStone {
    public static boolean Winner(int[][] board, int y, int x, int stone) {

        int count;
        //넘버패드 기준으로 설명
        count = 1;//마지막 돌 포함해서 1로 초기화(마지막 돌=넘버패드의 5번 위치일때)
        for (int i=1; i<=4; i++) {//6번 방향 검사
            int dx=x+i;
            if (dx>14 || board[y][dx]!=stone) break;
            count++;
        }
        for (int i=1; i<=4; i++) {//4번 방향 검사
            int dx=x-i;
            if (dx<0 || board[y][dx]!=stone) break;
            count++;
        }
        if (count>=5) return true;

        //상하 검사
        count = 1;
        for (int i=1; i<=4; i++) {//2번 방향 검사
            int dy=y+i;
            if (dy>14 || board[dy][x]!=stone) break;
            count++;
        }
        for (int i=1; i<=4; i++) {//8번 방향 검사
            int dy=y-i;
            if (dy<0 || board[dy][x]!=stone) break;
            count++;
        }
        if (count>=5) return true;

        //우하향 대각선 검사
        count = 1;
        for (int i=1; i<=4; i++) {//3번 방향 검사
            int dy=y+i;
            int dx=x+i;
            if (dy>14 || dx>14 || board[dy][dx]!=stone) break;
            count++;
        }
        for (int i=1; i<=4; i++) {//7번 방향 검사
            int dy=y-i;
            int dx=x-i;
            if (dy<0 || dx<0 || board[dy][dx]!=stone) break;
            count++;
        }
        if (count>=5) return true;

        //좌하향 대각선 검사
        count = 1;
        for (int i=1; i<=4; i++) {//1번 방향 검사
            int dy=y+i;
            int dx=x-i;
            if (dy>14 || dx<0 || board[dy][dx]!=stone) break;
            count++;
        }
        for (int i=1; i<=4; i++) {//9번 방향 검사
            int dy=y-i;
            int dx=x+i;
            if (dy<0 || dx>14 || board[dy][dx]!=stone) break;
            count++;
        }
        if (count>=5) return true;

        return false;//네 가지 선 모두 5개가 안 되면 승리 아님
    }
}

class PrintBoard {
    public static void printBoard(int[][] board) {
        String whiteStone = " ○ ";
        String blackStone = " ● ";
        
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
    }
}

class PlaceStone{
    public static void stoneLocation(int[][] board, Scanner scanner) {
        
        if(main.e==1){//에러 발생 시에 다시 보드 출력 후에 문장을 출력하기 위해 수정
            System.out.println("잘못된 좌표입니다. 다시 입력해주세요.");
            main.e=0;
        }
        else if(main.e==2){
            System.out.println("이미 돌이 있는 좌표입니다. 다시 입력해주세요.");
            main.e=0;
        }

        if(main.n%2==1){//n이 홀수면 흑돌, 짝수면 백돌
            System.out.println("흑돌 차례입니다. x, y좌표를 입력해주세요.");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if(board[y][x]==0){
                board[y][x]=1;
                
                main.lastX = x;//마지막 돌의 위치를 저장
                main.lastY = y;
                
            }
            else {
                main.e=2;
                main.n--;
            }
        }
        
        else if(main.n%2==0){//이유는 모르겠으나 오류 발생해서 else if로 수정함
            System.out.println("백돌 차례입니다. x, y좌표를 입력해주세요.");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            
            if(board[y][x]==0){
                board[y][x]=2;

                main.lastX = x;//마지막 돌의 위치를 저장
                main.lastY = y;
            }
            else {
                main.e=2;
                main.n--;
            }
        }
    }
}

public class main {
    static int n=0;//static으로 선언하여 다른 클래스에서도 n값을 사용할 수 있도록 함
    static int e=0;//에러 발생 시에 다시 보드 출력 후에 문장을 출력하기 위해 사용하는 변수
    
    static int lastX = -1;//마지막 돌의 위치를 저장할 변수
    static int lastY = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("아무 키나 입력하면 게임이 시작됩니다.");
        scanner.nextLine();
        System.out.println("게임 시작!");
        int[][] board = new int[15][15];
        
        for(;;){ //보드 매턴마다 출력하기 위해 무한루프 추가함
            PrintBoard.printBoard(board);// 보드 출력을 PrintBoard 클래스로 객체화함

            if (main.n>=9) {
                if(CountStone.Winner(board, main.lastY, main.lastX, board[main.lastY][main.lastX])) {
                if (main.n%2==0) {
                        System.out.println("백돌 승리");
                    } else {
                        System.out.println("흑돌 승리");
                    }
                    break;
                }
                else if(main.n==225) {
                    System.out.println("무승부입니다.");
                    break;
                }
            }

            main.n++;

            try{
                PlaceStone.stoneLocation(board, scanner);//메인의 스캐너를 클래스에서 사용하도록 수정
            } 
            catch(ArrayIndexOutOfBoundsException e){
                main.e=1;
                main.n--;
            }
        }
    }
}