
    import java.util.InputMismatchException;

    import java.util.Scanner;

    import java.util.Set;

    import java.lang.*;

    import java.util.Random;


    public class UniformCostSearch
   {

        public static void main(String... arg)

        {

            Random rgen = new Random();

            int adjacency_matrix[][];

            int N;

            int source = 0;

            int destination = 0;

            int distance;

            Scanner scan = new Scanner(System.in);

            try

            {

                System.out.println("Enter the number N");

                N = scan.nextInt();
		//int arr[] = {0,1,0,1,-1};
		int arr[] = new int[2*N+1];
		for (int i=0; i<arr.length/2;i++)
		{
			arr[i] = 1;
		}
		arr[arr.length-1] = -1;
		for (int i=(arr.length/2); i<arr.length;i++)
			{
				arr[i] = 0;
			}
		arr[arr.length-1] = -1;
		
		for (int i=0; i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		System.out.println("This was the first inputs to array");
        Random rgener = new Random();  // Random number generator			
			// Now we mix the array
		    for (int i=0; i<arr.length; i++) { 
				int randomPosition = rgener.nextInt(arr.length);
				int temp = arr[i];
				arr[i] = arr[randomPosition];
				arr[randomPosition] = temp;
			}
			System.out.println("This is the mix of array:");
			for (int i=0; i<arr.length;i++)
			{
				System.out.println(arr[i]);
			}
			System.out.println("STOP");
		
		int dist[] = new int[2*N + 1];
		int indexOfEmpty = 0;
		int indexOfEmptyChar = 0;
		for (int i=0;i<arr.length; i++)
		{
			if (arr[i]==-1)
			{
				indexOfEmpty = i; //thesi kenou stoixeiou
			}
		}
		for (int i=0; i<arr.length;i++)
		{
			if (i!=indexOfEmpty)
			{
				dist[i] = Math.abs(i-indexOfEmpty); //apostaseis olwn twn stoixeiwn apo ti thesi empty
			}
		}
		System.out.println("This is the distance that every ball has from the empty position");
		for (int i=0; i<dist.length;i++)
		{
			System.out.println(dist[i]);
		}
		System.out.println("STOP");
		int distanceIndexOfEmptyAndFirstSwap = 0;
        int distanceIndexOfEmptyAndSecondSwap = 0;
        int l=0;
        while(arr[l]!=1 && l<arr.length/2)
                {
			System.out.println("We will do now an exchange:");		
			System.out.println(l+"->"+indexOfEmpty);
            distanceIndexOfEmptyAndFirstSwap = distanceIndexOfEmptyAndFirstSwap + Math.abs(l-indexOfEmpty);
            int temp = arr[l];
            arr[l] = arr[indexOfEmpty];
            arr[indexOfEmpty] = temp;
			int min = 60000000;
            indexOfEmpty = l;
			System.out.println("The array after exchange:");
			for(int i=0;i<arr.length;i++) {
			   System.out.println(arr[i]);
			 }
			System.out.println("stop");
            for (int j=0; j<arr.length; j++)
                {
                 dist[j] = Math.abs(j-indexOfEmpty); //apostasi olwn twn stoixeiwn apo to keno
                }
			for (int k=arr.length/2; k<arr.length; k++)
			    {
				if(arr[k]==1 && dist[k]<min)
				{
                    min = dist[k];
	                 distanceIndexOfEmptyAndSecondSwap = distanceIndexOfEmptyAndSecondSwap + Math.abs(k+arr.length/2-indexOfEmpty);
					 int temp1 = arr[k];
                	 arr[k] = arr[indexOfEmpty];
                     arr[indexOfEmpty] = temp;
                     indexOfEmpty = k;
				}
			}
             		l+=1;
		}
		for (int a=0; a<arr.length; a++)
		{
			if (arr[a]==-1)
			{
				indexOfEmptyChar = a;
			}
		}
		int temp2 = arr[arr.length-2];
		arr[arr.length-2] = arr[indexOfEmptyChar];
		arr[indexOfEmptyChar] = temp2;
		for (int z=0; z<arr.length; z++)
		{
			System.out.println(arr[z]);
		}
		int finaldistances = distanceIndexOfEmptyAndFirstSwap+distanceIndexOfEmptyAndSecondSwap;
                System.out.println("Final Cost:"+finaldistances);

            } catch (InputMismatchException inputMismatch)

            {

                System.out.println("Wrong Input Format");

            }

            scan.close();

        }

    }



