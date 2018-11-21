package gfg.algo.search.binary;

import java.util.Scanner;

public class PainterPartionProblemOrig { 
    public static int numberPainters(int[] arr,int n,int mid)
    {
        int tot=0;int np = 1;
        for(int i=0;i<n;i++){
            tot = tot+arr[i];
            if(tot>mid){
                tot = arr[i];
                np++;
            } 
        }
        return np;
    }
    public static int partition(int[] arr,int n,int k)
    {
        int lo = 0;int hi = 0;
        for(int i=0;i<n;i++){
            lo = Math.max(lo,arr[i]);
            hi = hi+arr[i];
        }
        while(lo<hi){
            int mid = (lo+hi)/2;
            if(numberPainters(arr,n,mid)<=k) hi = mid;
            else lo=lo+1;
        }
        return lo;
    }
    public static void main(String args[]) { 
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int k = sc.nextInt(); 
            int n = sc.nextInt(); 
            int[] arr = new int[n];
            for(int i=0;i<n;i++) arr[i] = sc.nextInt();
            System.out.println(partition(arr, n, k)); 
        }
        sc.close();
    } 
}
