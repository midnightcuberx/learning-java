import java.util.Scanner;
import java.util.Random;
class Main {
  public static void main(String[] args) {
    Scanner input= new Scanner(System.in);
    String playagain="y";
    String [] choices={"rock","paper","scissors"};
    int wins=0;
    int losses=0;
    int draws=0;
    do {
      String rps=randchoice(choices);
      System.out.println("Rock Paper or Scissors?");
      String playerchoice=input.nextLine().toLowerCase();
      if (playerchoice==rps){
        System.out.println("DRAW! You and your opponent both played "+rps+"!");
        draws+=1;
      } else{
        switch (playerchoice){
          case "rock":
            if (rps=="scissors"){
              System.out.println("YOU WIN! You played rock and your opponent played scissors!");
              wins+=1;
            } else if (rps=="paper"){
              System.out.println("YOU LOSE! You played rock and your opponent played paper!");
              losses+=1;
            }
            break;
          
          case "scissors":
            if (rps=="paper"){
              System.out.println("YOU WIN! You played scissors and your opponent played paper!");
              wins+=1;
            } else if (rps=="rock"){
              System.out.println("YOU LOSE! You played scissors and your opponent played rock!");
              losses+=1;
            }
            break;

          case "paper":
            if (rps=="rock"){
              System.out.println("YOU WIN! You played paper and your opponent played rock!");
              wins+=1;
            } else if (rps=="scissors"){
              System.out.println("YOU LOSE! You played paper and your opponent played scissors!");
              losses+=1;
            }
            break;

          default:
            System.out.println("Sorry, that is not rock paper or scissors!");
            break;
        }
      }
      System.out.println("Your stats now:");
      float winrate=wins/(wins+draws+losses);
      
      System.out.println("Your winrate: "+winrate);
      System.out.println("Wins: "+wins);
      System.out.println("Draws: "+draws);
      System.out.println("Losses: "+losses);

    }while (playagain.toLowerCase()=="y");
    System.out.println("Thank you for playing");
  }

	public static String randchoice(String[] list) {
		int num=randnum(0, list.length-1);
		return list[num];
	}
	
	public static int randnum(int num1, int num2) {
		Random rand=new Random();
		int diff=num2-num1;
		int num = rand.nextInt(diff+1)+num1;
		return num;
	}

}
