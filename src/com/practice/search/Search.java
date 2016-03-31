package com.practice.search;

import java.util.Scanner;

public class Search {
	/*public static void main(String[] args) {
		//int[] a = {846930887,1681692778,1714636916,1957747794,424238336,719885387,1649760493,596516650,1189641422,1025202363,1350490028,783368691,1102520060,2044897764,1967513927,1365180541,1540383427,304089173,1303455737,35005212,521595369,294702568,1726956430,336465783,861021531,278722863,233665124,2145174068,468703136,1101513930,1801979803,1315634023,635723059,1369133070,1125898168,1059961394,2089018457,628175012,1656478043,1131176230,1653377374,859484422,1914544920,608413785,756898538,1734575199,1973594325,149798316,2038664371,1129566414};
		int[] a = {3,2,9,9,5,1};
		maxModSum(a, 7);
	}*/
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //String grid[] = new String[n];
        String[][] grid = new String[n][n];
        for(int i=0; i < n; i++){
            String x = in.next();
            int j=0;
            for(char c: x.toCharArray()){
                grid[i][j] = c+"";
                j++;
            }
        }
        int x = 1;
        int y = n-2;
        
        for(int i=x;i<y;i++){
            for(int j=x;j<y;j++){
                System.out.println(grid[1][1]);
                if(isCavity(grid, i, j)){
                System.out.print("X");
            } else{
                System.out.print(grid[i][j]);
                }}
            System.out.println();
        }
        
    }
	public static void SherlockAndArray(int[] a) { //Sorted array?
		
		int x = 0;
		int y = a.length - 1;
		int ls = a[x]; //left pointer value
		int rs = a[y]; //right pointer value
		while (y != x && (y - x) != 2) { //the gap between the two pointers should atleast be 2
			if (ls > rs) { 
				y--;
				rs += a[y]; //add one more element
			} else {
				x++;
				ls += a[x];
			}
		}
		if (ls == rs) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
	
	public static void maxModSum(int[] a, int mod){
		int modSum = 0;
		int n = a.length;
        int x = 0;
        int y = x;
        int sum = 0;
        sum = sum + a[y];
        
        while(y!=n-1){
            if(sum%mod > modSum){
                modSum = sum%mod;
                y++;
                sum = sum + a[y];
                
            } else{
                sum = sum-a[x];
                x++;
            }
            if(x==y){
                y++;
            }
        }
        System.out.println(modSum);
	}
	
	public static boolean isCavity(String[][] grid, int i, int j){
        System.out.println("x: "+i+"y: "+j+" "+grid[1][1]);
        int ele = Integer.parseInt(grid[i][j]);
        for(int x=i-1;x<i+2;x++){
            for(int y = j-1 ; y<j+2;y++){
            System.out.println("x: "+x+"y: "+y);
            if(x!=y && Integer.parseInt(grid[x][y])>ele)
                return false;
        }
        }
        return true;
    }
}
