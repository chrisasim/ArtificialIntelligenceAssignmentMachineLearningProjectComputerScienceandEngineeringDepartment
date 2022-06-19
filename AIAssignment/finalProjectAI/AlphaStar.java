    import java.util.InputMismatchException;

    import java.util.Scanner;

    import java.util.Set;

    import java.lang.*;

    import java.util.Random;

    import java.util.concurrent.ThreadLocalRandom;

    public class AlphaStar

    {

	    /* Implementing Fisher–Yates shuffle
	    static void shuffleArray(int[] ar)
	    {
		    
		    Random rnd = ThreadLocalRandom.current();
		    for (int i = ar.length - 1; i > 0; i--)
		    {
		      int index = rnd.nextInt(i + 1); // kanoyme suffle ton array maurwn kai asprwn mpalwn(0,1,-1)
		      
			  
		      int a = ar[index];
		      ar[index] = ar[i];
		      ar[i] = a;
			  System.out.println(ar[i]);
		    }
			System.out.println("This was the vector we want to fix.");
	     } */
          

	     // function to calculate Euclidean distance, this is h(n), euritiki sinartisi
		public static int calculateDistance(int[] array1, int[] array2) //apostasi metaksi tou pws einai twra o pinakas(suffled) kai tou swstou(telikou)
	        {
	 	        double Sum = 0.0;
	            for(int i=0;i<array1.length;i++) {
         		  Sum = Sum + Math.pow((array1[i]-array2[i]),2);
	            }
	            int value = (int) Math.sqrt(Sum); //eukleidia apostasi
	            return value;
		}

        public static void main(String... arg)

        {

            int N;

            Scanner scan = new Scanner(System.in);

            try

            {

                System.out.println("Enter the number N");

                N = scan.nextInt();
		//int arr[] = {0,1,0,1,-1};
		int arr[] = new int[2*N+1];
		int size=arr.length;
		int correctarr[] = new int[2*N+1];
		for (int i=0; i<correctarr.length/2;i++)
		{
			arr[i]=1;
			correctarr[i] = 1;
		}
		for (int i=(arr.length/2); i<arr.length;i++)
			{
				arr[i] = 0;
				correctarr[i]=0;
			}
		correctarr[correctarr.length-2] = -1;
		arr[arr.length-2] = -1;
		for(int i=0;i<size;i++) {
			System.out.println(arr[i]);
		}
		
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
		
		//shuffleArray(arr); //kanoume mix ton arxiko pinaka
		System.out.println("This is the eukleidian distance 'Matrix we have- Matrix we should have':");
        System.out.println(calculateDistance(arr,correctarr)); //apostasi metaksi twn pinakwn(arxikos kai swstos) 
		int dist[] = new int[2*N + 1];
		int indexOfEmpty = 0;
		for (int i=0;i<arr.length; i++)
		{
			if (arr[i]==-1)
			{
				indexOfEmpty = i; //thesi tou empty stoixeiou
			}
		}
		for (int i=0; i<arr.length;i++)
		{
			if (i!=indexOfEmpty)
			{
				dist[i] = Math.abs(i-indexOfEmpty); //pinakas apostasewn olwn twn stoixeiwn apo tin empty thesi
			}
		}
		System.out.println("The matrix with how far every index is from the empty:");
		for (int i=0; i<dist.length;i++)
		{
			System.out.println(dist[i]);
		}
		int[] costFunction = new int[2*N+1]; //pinakas me kosti
		for (int i=0; i<costFunction.length; i++)
		{
			costFunction[i] = calculateDistance(arr, correctarr) + dist[i]; //pragmatiki apostasi tou stoixeiou apo empty thesi+eukleidia
		}
		int distanceIndexOfEmptyAndFirstSwap = 0;
        int distanceIndexOfEmptyAndSecondSwap = 0;
        //int l=0;
        //while(arr[l]!=1 && l<arr.length/2)
			for(int l=0; l<arr.length;l++){
                 if(arr[l]!=1 && l<arr.length/2) {
					 
			        System.out.println(l+"->"+indexOfEmpty);
                    distanceIndexOfEmptyAndFirstSwap = distanceIndexOfEmptyAndFirstSwap + Math.abs(l-indexOfEmpty);
                    int temp = arr[l];
                    arr[l] = arr[indexOfEmpty];
                    arr[indexOfEmpty] = temp;
                    for (int j=0; j<arr.length; j++)
                    {
                       dist[j] = Math.abs(j-indexOfEmpty);
				       costFunction[j] = calculateDistance(arr,correctarr)+dist[j]; //pragmatiki apostasi tou stoixeiou apo empty thesi+eukleidia
                         }
			         int min = 90000000;
			        for (int k=arr.length/2; k<arr.length; k++)
			        {
				    int minimum_cost = min;
				    if(arr[k]==1 && costFunction[k]<min)
				    {
	                   distanceIndexOfEmptyAndSecondSwap = distanceIndexOfEmptyAndSecondSwap + Math.abs(k+arr.length/2-indexOfEmpty);
					   int temp1 = arr[k];
                	   arr[k] = arr[indexOfEmpty];
                       arr[indexOfEmpty] = temp;
                       indexOfEmpty = k;
					   min = calculateDistance(arr, correctarr) + dist[k];
				    }
			        }
             		l+=1;
		}
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
