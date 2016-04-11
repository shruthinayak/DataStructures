package com.practice;

import com.practice.arrays.GeeksForGeeks;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by shruthi on 11/4/16.
 */
public class Reflections {
    public static void main(String[] args) throws ClassNotFoundException {
        Method[] declaredMethods = GeeksForGeeks.class.getDeclaredMethods();
        System.out.println("###GeeksForGeeks");
        for (Method m : declaredMethods) {
            System.out.println("#####"+m.getName());
            Parameter[] parameters = m.getParameters();
            System.out.print("\t");
            for (Parameter p : parameters) {
                String type;
                if(p.getType().toString().contains("class")){
                    type = Class.forName(p.getType().toString().split(" ")[1]).getTypeName();
                } else{
                    type = p.getType().getName();
                }
                System.out.print(type + " " + p.getName() + ", ");
            }
            System.out.println();
            System.out.println();
        }
    }
}
