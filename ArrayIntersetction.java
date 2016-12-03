/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayintersetction;

import java.util.Arrays;

/**
 *
 * @author Laurin
 */
public class ArrayIntersetction {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayIntersetction a = new ArrayIntersetction();
        int[] array1 = {1,4,4,5,8,19,23,42,73};
        int [] array2= {1,4,5,9,17,21,42,73};
        int[] test = a.letsBegin(array1, array2);
        System.out.println(Arrays.toString(test));
        
    }
    public int[] letsBegin(int[] a, int [] b){
    int[] omnom = new int[this.arrayIntersectionZahl(a,b,0, 0)];
    
    return this.arrayIntersection(a, b, omnom, 0, 0);
    }
    public int[] arrayIntersection(int[] a, int [] b, int[]omnom, int z, int y){
      
    if(this.intIntersection(a[y], b, 0)){omnom[z]=a[y];z++;}
    if(y<a.length-1){this.arrayIntersection(a, b, omnom, z, y+1);}
  return omnom;  
    }
    
    public int arrayIntersectionZahl(int[] a, int[] b, int y, int arrayl){
     if(this.intIntersection(a[y], b, 0)){arrayl++;
    }
     if(y<a.length-1){return this.arrayIntersectionZahl(a , b, y+1, arrayl);}
   
    
    return arrayl;
//    int aktuelly=0;
//   int aktuell;
//  for (int i=0;i<a.length;i++){
//        aktuell=a[i];
//        for(int j=0;j<b.length;j++){
//            if(b[j]==aktuell){           
//            aktuelly++;
//            }
//        }
//    } 
//  int[] y=new int[aktuelly];
//  aktuelly=0;
//    for (int i=0;i<a.length;i++){
//        aktuell=a[i];
//        for(int j=0;j<b.length;j++){
//            if(b[j]==aktuell){
//            y[aktuelly]=aktuell;
//            aktuelly++;
//            }
//        }
//    } 
//    return y;
    }

public  boolean intIntersection(int a, int[] b, int y){
    if(y==b.length){return false;}
    if(b[y]==a){return true;}
   return this.intIntersection(a, b, y+1);

}}