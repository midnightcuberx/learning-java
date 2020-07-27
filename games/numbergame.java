import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String playagain="y";
    int score=0;
    do{
      Scanner input= new Scanner(System.in);
      int lives=10;
      boolean gameover=false;
      int number=(int) (Math.random()*1000)+1;
      do {
        System.out.println("I am thinking of a number between 1 and 1000. You have "+lives+" guesse(s) left. What is my number?");
        int userguess=input.nextInt();
        lives-=1;
        if (userguess!=number) {
          
          if (userguess>number) {
            System.out.println("Your guess of "+userguess+" is too high");
          }
          else {
            System.out.println("Your guess of "+userguess+" is too low");
          }
        }
        else {
          System.out.println("You guessed correctly");
          gameover=true;
        }
        
      } while (gameover==false && lives>0);
      if (gameover) {
        score+=(lives+1);
        System.out.println("GG YOU WON! Your score is now "+score);
      }
      else if (gameover==false) {
        System.out.println("You lost because you ran out of guesses. My number was "+number);
      }
      System.out.println("Do you want to play again? Y or N?");
      playagain=input.nextLine()+input.nextLine();
    } while (playagain.toLowerCase()=="y");
    System.out.println("Thank you for playing! Your final score was "+score);
	}

}
