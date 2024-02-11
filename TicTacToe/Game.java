package TicTacToe;
import java.util.Scanner;
public class Game  implements IGame {

    public String player1="";
    public  String player2="";
    int count;
    

    private String gameBoard[][];
    String x;
    String o;
    int X;
    int O;


    public void startGame(){
        int k=1;
        count=0;
         gameBoard= new String[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                gameBoard[i][j]="   "+k+++"   ";
            }
        }

        System.out.println();

        System.out.println("Welcome to Tic Tac Toe Game");
       

        System.out.println("Lets Start the Game");
        
       
        displayBoard();
        choosePlayer();
        
    }
    public void choosePlayer(){
        Scanner sc = new Scanner(System.in) ;
        System.out.println("Enter Player 1 Name for x");
        player1 = sc.nextLine();
        if(player1.equals("")){
            player1="Player 1";
        }
        
        System.out.println("Enter Player 2 Name for O");
        player2 = sc.nextLine();
        if(player2.equals("")){
            player2="Player 2";
        }
      

        playGame();

    }
    String result;
   
    public void playGame(){

        count++;
        do{
       // System.out.println(count);
        if(count%2==0){
            player2Turn();

        }
        else{
            player1Turn();
        }
        displayBoard();
        String result=checkResults();
        if(result.equals("1")){
            System.out.println();
            System.out.println("-------------------------");
            System.out.println();
            System.out.println(player1+" won the game !! 😀");
            System.out.println();
            System.out.println("--------------------------");
            System.out.println();
            playAgain();
            
        }
        else if(result.equals("2")){
            System.out.println();
            System.out.println("-------------------------");
            System.out.println();
            System.out.println(player2+" won the game !! 😀");
            System.out.println();
            System.out.println("--------------------------");
            System.out.println();
            playAgain();
            
        }

        

        
        if(count>=9){
            System.out.println();
            System.out.println("----------");
            System.out.println();
            System.out.println("Game Draw 👎");
            System.out.println();
            System.out.println("----------");
            System.out.println();
            playAgain();
        }
        playGame();
        
    } while(result.equals(" "));
                   


    }
    

    public void player1Turn(){
        System.out.println("Its "+player1+" turn to draw X");
        System.out.println("Enter the box number to draw X");
        Scanner sc = new Scanner(System.in);

        x=sc.nextLine();
        if(x.equals("1")||x.equals("2")||x.equals("3")||x.equals("4")||x.equals("5")||x.equals("6")||x.equals("7")||x.equals("8")||x.equals("9")){
            X=Integer.parseInt(x);
        }   
        else{
            System.out.println("Invalid Input");
            player1Turn();
            return;
        }     
       
       if(X>=1 && X<=9){

        
       
         boolean found=false;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(gameBoard[i][j].equals("   "+X+"   ")){
                    found=true;
                    gameBoard[i][j]="   X   ";

                    break;
                }
                
            }
        }
        if(!found){
            System.out.println("Box number is already Filled");
           
        player1Turn();
        }
    }
    else{
        System.out.println("Invalid Input");
        player1Turn();
    }
        

    }
    public void player2Turn(){
        System.out.println("Its "+player2+" turn to draw O");
        System.out.println("Enter the box number to draw O");
        Scanner sc = new Scanner(System.in);
        o=sc.nextLine();
        if(o.equals("1")||o.equals("2")||o.equals("3")||o.equals("4")||o.equals("5")||o.equals("6")||o.equals("7")||o.equals("8")||o.equals("9")){
        O=Integer.parseInt(o);
        }
        else{
            System.out.println("Invalid Input");
            player2Turn();
            return;
        }
       if(O>=1 && O<=9){

         
        boolean found=false;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(gameBoard[i][j].equals("   "+O+"   ")){
                    found=true;
                    gameBoard[i][j]="   O   ";

                    break;
                }
                
            }
        }
        if(!found){
            System.out.println("Box number is already Filled");
        player2Turn();
        }
       
    }
    else{
        System.out.println("Invalid Input");
        player2Turn();
    }
        

    }
    public void displayBoard(){

        System.out.println();
       

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){

                if(j!=2){
                 System.out.print(gameBoard[i][j]+"|");
                }
                else{
                    System.out.print(gameBoard[i][j]);
                }

            }
            System.out.println();
            if(i!=2){
            System.out.println("----------------------");
            }
        }
        System.out.println();
       
        
        
        

    }
    public String checkResults(){

       String result= checkHorizontal();
       System.out.println(result);
       if(result.equals(" "))
       result= checkVertical();
       if(result.equals(" "))
       result= checkDiagonalLeft();
       if(result.equals(" "))
       result= checkDiagonalRight();
       
      return result;
        

       
}

public String checkHorizontal(){
    boolean xFlag=true;
    boolean oFlag=true;


   
    for(int i=0;i<3;i++){
        xFlag=true;
        oFlag=true;
        for(int j=0;j<3;j++){
            if(!gameBoard[i][j].equals("   X   ")){
                xFlag=false;
                
            }
            if(!gameBoard[i][j].equals("   O   ")){
                oFlag=false;
                
            }
            
        }
        if(xFlag){
           // System.out.println("Horizontal Check");
          //  System.out.println(player1+" is the winner");
            return "1";
        }
        if(oFlag){
            
           // System.out.println("Horizontal Check");
           // System.out.println(player2+" is the winner");
            return "2";
        }

       
        
    
}
return " ";

}
public String checkVertical(){
    boolean xFlag=true;
    boolean oFlag=true;


   
    for(int i=0;i<3;i++){
        xFlag=true;
        oFlag=true;
        for(int j=0;j<3;j++){
            if(!gameBoard[j][i].equals("   X   ")){
                xFlag=false;
                
            }
            if(!gameBoard[j][i].equals("   O   ")){
                oFlag=false;
                
            }
            
        }
        if(xFlag){

          //  System.out.println("verticalCheck");
           // System.out.println(player1+" is the winner");
            return "1";
        }
        if(oFlag){

            //System.out.println("Horizontal Check");
           // System.out.println(player2+" is the winner");
            return "2";
        }
        
    
}
return " ";
}

public String checkDiagonalRight(){
    boolean xFlag=false;
    boolean oFlag=false;

    if(gameBoard[0][0].equals("   X   ") && gameBoard[1][1].equals("   X   ") && gameBoard[2][2].equals("   X   ")){
        xFlag=true;
    
    }
    if(gameBoard[0][0].equals("   O   ") && gameBoard[1][1].equals("   O   ") && gameBoard[2][2].equals("   O   ")){
        oFlag=true;
    }
   
    
       // System.out.println(xFlag+""+oFlag);

       
        if(xFlag){
          //  System.out.println(player1+" is the winner");
            return "1";
        }
        if(oFlag){
          //  System.out.println(player2+" is the winner");
            return "2";
        }
        
    

return " ";
}

public String checkDiagonalLeft(){
    boolean xFlag=false;
    boolean oFlag=false;

    if(gameBoard[0][2].equals("   X   ") && gameBoard[1][1].equals("   X   ") && gameBoard[2][0].equals("   X   ")){
        xFlag=true;
    }
    if(gameBoard[0][2].equals("   O   ") && gameBoard[1][1].equals("   O   ") && gameBoard[2][0].equals("   O   ")){
        oFlag=true;
    }
    
        if(xFlag){
           // System.out.println(player1+" is the winner");
            return "1";
        }
        if(oFlag){
           // System.out.println(player2+" is the winner");
            return "2";
        }
        
    

return " ";
}

void playAgain(){
    System.out.println("Want to play again .Press p to play again");
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            if(s.equals("p")){
                startGame();
            }
            else{
                System.out.println("Thank you for playing");
                System.exit(0);
            }

}

    

    
}
