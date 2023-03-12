import java.math.BigInteger;
import java.util.*;
public class algo5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int maxtree = 0;
        int arr[] = new int[2];
        int totalIncome =0;
        int count=0;
        int treedays[] = new int[] {10,6,15,5,15};
        int incometree[] = new int[] {12000,10000,27500,7500,8000};
        int maxincome[] = new int[5];
        int totalIarray[] = new int[T];
        for(int i=0;i<T;i++){
            for(int j=0;j<2;j++){
                arr[j] = sc.nextInt();
            }
            maxtree = (40*arr[0])/100;
            for(int k=0;k<5;k++){
                maxincome[k] = ((arr[1]/treedays[k])*incometree[k]);
                totalIncome = totalIncome + maxincome[k];
                arr[0]--;
            }
            maxtree--;
            Arrays.sort(maxincome); 
            // for(int o=0;o<maxincome.length;o++){
            //     System.out.print(maxincome[o]+" ");
            // }
            for(int l=1;arr[0]!=0;l++){
                if(arr[0]-maxtree >=0 && arr[0]>=maxtree){
                    // totalIncome=totalIncome+((arr[1]/treedays[k])*incometree[k]);
                    arr[0]-=maxtree;
                    totalIncome = totalIncome + (maxtree*maxincome[maxincome.length-l]);               
                }
                else{
                    totalIncome = totalIncome + (arr[0]*maxincome[maxincome.length-l]);
                    arr[0]=0;
                }
            }

            totalIarray[i] = totalIncome;
            totalIncome = 0;
        }
        for(int i= 0;  i < totalIarray.length ; i++){
            System.out.println("Case #"+(i+1)+": "+totalIarray[i]);
        }
    }
}
