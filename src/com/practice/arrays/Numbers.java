package com.practice.arrays;

public class Numbers {
	
	static int distributeCandy(int[] score) {
//		https://www.hackerrank.com/challenges/candies
		
        int[] candy = new int[score.length];
        int count=1;
        candy[0]=1;
        for(int i=1;i<score.length;i++){
            if(score[i]>score[i-1])
                candy[i] = candy[i-1]+1;
            else if(score[i]<=score[i-1])
                candy[i]=1;
        }
        for(int i=score.length-1;i>0;i--){
            if(score[i]<score[i-1] && candy[i]>=candy[i-1])
                candy[i-1] = candy[i]+1;
        }
        int sum = 0;
        for(int i=0;i<candy.length;i++)
            sum+= candy[i];
        return sum;
    }
}
