import java.util.*;

public class game
{
	public static void main(String[] args)
	{
		boolean getTar = false;//是否猜到答案
		boolean repeat;//4位數是否有重複
		boolean tarDone = false;//答案型態是否正確

		double n;
		int ni;
		int a = 0;//幾個A
		int b = 0;//幾個B
		String out;
		String tar = "";//Target in String
		List<Integer> ab = new ArrayList<>();

		List<Integer> numbers = new ArrayList<>();
    	for(int i = 0; i < 10; i++)
    	{
   			numbers.add(i);
    	}
    
    	Collections.shuffle(numbers);
    
    	for(int i = 0; i < 4; i++)
    	{
      		tar += numbers.get(i).toString();
   		}
    	// System.out.println(tar);
		// 開始猜數字
		while(!getTar)
		{
			repeat = false;

			Scanner x = new Scanner(System.in);
			System.out.println("Enter a 'four number' string:");

			String ans = x.next();

			for(int i = 0; i < 4; i++)
			{
				for(int j = 0; j < 4; j++)
				{
					if(!(i == j) && ans.charAt(i) == ans.charAt(j))
					{
						repeat = true;
					}	
				}
			}


			if(ans.length()!=4)//判斷字串長度
			{
				System.out.println("This isn't a 'four number' string");
			}
			else if(repeat)//判斷是否重複數字
			{
				System.out.println("Repeat number in string");
					
      			}
			else if(Objects.equals(tar, ans))//判斷答案是否正確
			{
				System.out.println("You are correct!!");
				break;
      			}
      			else
      			{
      				a = 0;
      				b = 0;
      				for(int i = 0; i < 4; i++)
      				{
      					for(int j = 0; j < 4; j++)
      					{
      						if(Objects.equals(ans.charAt(i), tar.charAt(j)))
      						{
      							if(i == j)
      							{	      			
      								a += 1;
      							}
      							else
      							{
      								b += 1;
      							}
      						}
      					}
      				}
      			
      				ab.add(a);
      				ab.add(b);

      				out = ab.get(0).toString()+"A"+ab.get(1).toString()+"B";
      				System.out.println(out);
	
      				ab.remove(0);
      				ab.remove(0);
      			}
		}
	}
}


