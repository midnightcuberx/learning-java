import java.util.Random;
public class get3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a=get3();
		System.out.println(a);
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

	public static boolean includes(String[] list, String str) {
		for (String item:list) {
			if (item==str) {
				return true;
			}
		}
		return false;
		
	}

	public static String[] add(String[] list,String item) {
		int length=list.length;
		String [] newList= new String [length+1];
		for (int i=0;i<length;i++) {
			newList[i]=list[i];
		}
		newList[length]= item;
		return newList;
	}
	
	public static String[] remove(String[] list,String item) {
		String[] newList=new String [list.length-1];
		//check if its in list
		for (String listitem:list) {
			if (listitem!=item) {
				add(newList,listitem);
			}
		}
		return newList;
	}

	public static String join(String[] list,String joinwith) {
		String str="";
		for (String item:list) {
			str=str+joinwith+item;
		}
		return str;
	}

	public static String get3() {
		String [] moves= {"R","L","U","D","F","B"};
		String [] turns= {"2 "," ","' "};
		String [] rMoves= {"R","L"};
		String [] uMoves= {"U","D"};
		String [] fMoves= {"F","B"};
		String [] scramble= {};
		
		String move=null;
		String turn;
		
		boolean loop=true;
		
		int times=randnum(18,22);
		int num;
		
		for (int i = 0;i<times;i++) {
			loop=true;
			
			while (loop==true) {
				move=randchoice(moves);
				
				if (i>1) {
					if ((includes(rMoves,move) && includes(rMoves,scramble[scramble.length-2]) && includes(rMoves,scramble[scramble.length-4])) || (includes(uMoves,move) && includes(uMoves,scramble[scramble.length-2]) && includes(uMoves,scramble[scramble.length-4])) || (includes(fMoves,move) && includes(fMoves,scramble[scramble.length-2]) && includes(fMoves,scramble[scramble.length-4])) || move==scramble[scramble.length-2]) {
						loop=true;
					} else {
						loop=false;
					}
				} else if (i==1) {
					if (scramble[scramble.length-2]==move) {
						loop=true;
					} else {
						loop=false;
					}

				} else {
					loop=false;
				}
			}
			
			turn=randchoice(turns);
			scramble=add(scramble,move);
			scramble=add(scramble,turn);
			
			
		}
		
		return join(scramble,"");
	}


}
