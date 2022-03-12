/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author abdo-25-5-18
 */
import java.util.Scanner;
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("please insert the number of rows");
        int n1=input.nextInt();
        int nn1=n1;
        System.out.println("please insert the number of columns");
        int n2 = input.nextInt();
        int nn2=n2;
        if(n1<n2){n1=n2;}else if(n2<n1){n2=n1;}
        double arr[][] = new double[n1][n2];
        for(int i =0;i<nn1;i++){
        for(int j =0;j<nn2;j++){
            System.out.println("please insert of row "+ (i+1)+" column "+(j+1));
        double x = input.nextDouble();
        arr[i][j]=x;
        
        }
        
        }
        //  ده ال dummy   
        if(n1<n2){
        for(int i=nn1+1;i<(n2-nn1);i++){
        for(int j=0;j<n2;j++){
        arr[i][j]=0;
        }
        }
        
        }else if(n2<n1){
        for(int i =0;i<n1;i++){
        for(int j =nn2+1;j<(n1-n2);j++){
        arr[i][j]=0;
        }
        
        }
        }
        
        
        for(int i=0;i<arr.length;i++){
        System.out.print("\n");
        
        
       for(int j =0;j<arr[0].length;j++){
      System.out.print(arr[i][j]+" ");

                    
        }
        
        }
        
        //this is in case of maximization
        double arr2[][]=new double[n1][n2];
        double max=0;
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
        if(arr[i][j] > max){
        max=arr[i][j];
        }}}
        
        
        System.out.println(" \n Please insert 1 for maxixmization hungrian and 0 for minimization hungrian");
        double choosemax=input.nextDouble();
        
        // choose the case ,max or min
        if(choosemax ==1)
        for(int i =0;i<n1;i++){
        for(int j=0;j<n2;j++){
        arr2[i][j]=max-arr[i][j];
        if(j==n2){
        break;
        }
        }
        }

        
        
        
        
        
        //the smallest value in row
        double small[]=new double[n1];
        // if it was maximization
        if(choosemax ==1){
        for(int i=0;i<arr2.length;i++){
        small[i]=arr2[i][0];
        for(int j=0;j<arr2[0].length;j++){
        if(small[i]>arr2[i][j]){
        small[i]=arr2[i][j];
        }
        if(j==n2){
        break;
        }
        }
        }
        }else{ //if it was minimization
        for(int i=0;i<arr.length;i++){
        small[i]=arr[i][0];// as a start of small value , then we can search
        for(int j=0;j<arr[0].length;j++){
        if(small[i]>arr[i][j]){
        small[i]=arr[i][j];
        }
        if(j==n2){
        break;
        }
        }
        }
        }
        
        
        //the smallest values in rows
        System.out.println("\n the smallest values of rows");
        
        for(int i = 0;i<small.length;i++){
        System.out.print(small[i]+" ");
        }
        //here we subtract the smallest value from matrix values
        if(choosemax ==1){
        for(int i =0;i<n1;i++){
        for(int j=0;j<n2;j++){
        arr2[i][j]=arr2[i][j]-small[i];
        if(j==n2){
        break;
        }
        }
        }
        }else{ 
        for(int i =0;i<n1;i++){
        for(int j=0;j<n2;j++){
        arr2[i][j]=arr[i][j]-small[i]; //here if it was minimization case
        if(j==n2){
        break;
        }
        }
        } 
        }
        
        //print the edited matrix
        System.out.println("\n the 1st edited new matrix");
        for(int i=0;i<arr2.length;i++){
            System.out.println();
        for(int j=0;j<arr[0].length;j++){
        System.out.print(arr2[i][j]+" ");
        
        }
        
        }
        double small2[]=new double[n2]; //the smallest values of array columns
        for(int i =0;i<n2;i++){
        small2[i]=arr2[0][i];
        for(int j=0;j<n1;j++){
        if(small2[i]>arr2[j][i]){
        small2[i]=arr2[j][i];
        }
        if(j==n1){
        break;
        }
        
        }
        
        }
        System.out.println("\n the smallest values of columns");
        for(int i=0;i<small2.length;i++){
        System.out.println(small2[i]);
        }
        //the second edited matrix after subtracting 
        System.out.println("the new 2nd edited matrix");
        for(int i=0;i<n2;i++){
        for(int j=0;j<n1;j++){
        arr2[j][i]=arr2[j][i]-small2[i]; //subtract the smallest value of column from column
        if(j==n1){
        break;
        }
        
        }
        
        }
        for(int i=0;i<n1;i++){
        System.out.println();
        for(int j=0;j<n2;j++){
        System.out.print(arr2[i][j]+"  ");
        
        }
        }
        
        
        double optimal[] = new double[n1]; //the optimal values of matrix
        double test1[]=new double[n1]; //for skip the rows  that we choosed it zeros
        double test2[]=new double[n2]; //for skip the columns  that we choosed it zeros
        //let's fill this arrays as a start ,because we will use this values again for check if we get all optimal values or not
        for(int i =0;i<test1.length;i++){
        test1[i]=-1;
        test2[i]=-1;
        optimal[i]=-1;
        }
        
        //here  we walk on every value in matrix and get just one zero from row and colum
        // i searched from up left angle of matrix
        for(int i=0;i<n1;i++){
        for(int j=0;j<n2;j++){
            double tester=-1;

            for(int k=0;k<n1;k++){
            if(test1[k]==i || test2[k]==j){
            tester++;
            }
            
            
            
            }
        if(arr2[i][j]==0 && tester == -1){
        optimal[i]=arr[i][j];
        test1[i]=i;
        test2[i]=j;
        }
        
        }
        
        }
        
        
        
        //here i check if still -1 value in array optimal , if still -1 let's check from another angle
        double breaker=-1;
         for(int i=0;i<optimal.length;i++){
        if(optimal[i]==-1){
        breaker++;
        }
        }
         
         if(breaker != -1){
         for(int i =0;i<test1.length;i++){
         test1[i]=-1;
         test2[i]=-1;
         optimal[i]=-1;
         }
         breaker=-1;
         }
         
         
         
         
         
                
        //here i check from down right angle
        for(int i=n1-1;i>=0;i--){
        for(int j=n2-1;j>=0;j--){
            double tester=-1;

            for(int k=0;k<n1;k++){
            if(test1[k]==i || test2[k]==j){
            tester++;
            
            }
            
            
            
            }
        if(arr2[i][j]==0 && tester == -1){
        optimal[i]=arr[i][j];
        test1[i]=i;
        test2[i]=j;
        
        }
        
        }
        
        }
        
        
        
         for(int i=0;i<optimal.length;i++){
        if(optimal[i]==-1){
        breaker++;
        }
        }
         
         if(breaker != -1){
         for(int i =0;i<test1.length;i++){
         test1[i]=-1;
         test2[i]=-1;
         optimal[i]=-1;
         }
         breaker=-1;
         }

        
        //here i check from up left angle by column wise
        for(int i=0;i<n1;i++){
        for(int j=0;j<n2;j++){
            double tester=-1;

            for(int k=0;k<n1;k++){
            if(test1[k]==i || test2[k]==j){
            tester++;
            }
            
            
            
            }
        if(arr2[j][i]==0 && tester == -1){
        optimal[i]=arr[j][i];
        test1[i]=i;
        test2[i]=j;
        }
        
        }
        
        }
        
        
         for(int i=0;i<optimal.length;i++){
        if(optimal[i]==-1){
        breaker++;
        }
        }
         
         if(breaker != -1){
         for(int i =0;i<test1.length;i++){
         test1[i]=-1;
         test2[i]=-1;
         optimal[i]=-1;
         }
         breaker=-1;
         }

         
         
        for(int i=0;i<n1;i++){
        for(int j=n2-1;j>=0;j--){
            double tester=-1;

            for(int k=0;k<n1;k++){
            if(test1[k]==i || test2[k]==j){
            tester++;
            
            }
            
            
            
            }
        if(arr2[i][j]==0 && tester == -1){
        optimal[i]=arr[i][j];
        test1[i]=i;
        test2[i]=j;
        
        }
        
        }
        
        }
         
        
        
         for(int i=0;i<optimal.length;i++){
        if(optimal[i]==-1){
        breaker++;
        }
        }
         
         if(breaker != -1){
         for(int i =0;i<test1.length;i++){
         test1[i]=-1;
         test2[i]=-1;
         optimal[i]=-1;
         }
         breaker=-1;
         }

         
         // i searched from up right angle of matrix 
        for(int i=n1-1;i>=0;i--){
        for(int j=0;j<n2;j++){
            double tester=-1;

            for(int k=0;k<n1;k++){
            if(test1[k]==i || test2[k]==j){
            tester++;
            
            }
            
            
            
            }
        if(arr2[i][j]==0 && tester == -1){
        optimal[i]=arr[i][j];
        test1[i]=i;
        test2[i]=j;
        
        }
        
        }
        
        }

        
         for(int i=0;i<optimal.length;i++){
        if(optimal[i]==-1){
        breaker++;
        }
        }
         
         if(breaker != -1){
         for(int i =0;i<test1.length;i++){
         test1[i]=-1;
         test2[i]=-1;
         optimal[i]=-1;
         }
         breaker=-1;
         }

         
         // i searched from down right angle of matrix by column wise
        for(int i=n1-1;i>=0;i--){
        for(int j=n2-1;j>=0;j--){
            double tester=-1;

            for(int k=0;k<n1;k++){
            if(test1[k]==i || test2[k]==j){
            tester++;
            
            }
            
            
            
            }
        if(arr2[j][i]==0 && tester == -1){
        optimal[i]=arr[j][i];
        test1[i]=i;
        test2[i]=j;
        
        }
        
        }
        
        }

        
        
        

        //and here we go , finally the optimal numbers
        double optimalsolution=0;
        System.out.println("\n the optimal numbers are");
        
         for(int i=0;i<n1;i++){
        optimalsolution=optimalsolution+optimal[i];
        System.out.print(optimal[i]+"  ");
        }
         //here we add all optimal values to make the optimal cost
        System.out.println("\n the optimal cost = "+optimalsolution );
        //code made by abdelraheman mahmoud goma
    

        
        
        
        
}
}


