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
        int [] array2= {1,4,5,9,17,21,42,73,73};
        int[] test = a.letsBegin(array1, array2);
        int[] test2 = a.orderedIntersection(array1,array2);
        System.out.println();
        System.out.println("Input arrays:"+"\n"+Arrays.toString(array1)+"\n"+Arrays.toString(array2));
        System.out.println("Expected output (up to duplicate elements):"+"\n"+Arrays.toString(test));
        System.out.println("Actual output from recursive algorithm:"+"\n"+Arrays.toString(test));
        System.out.println("Actual output from recursive algorithm (optimized for sorted input):"+"\n"+Arrays.toString(test2));
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
    }
public  boolean intIntersection(int a, int[] b, int y){
    if(y==b.length){return false;}
    if(b[y]==a){return true;}
   return this.intIntersection(a, b, y+1);
////////////////////////////////////////////////////////////////////////////////////////////////////////////
}public int[] orderedIntersection(int[]a, int[] b){
    int[] a2 = this.arrayCheck(a);
    int[] b2 = this.arrayCheck(b);
    int [] c= this.letsBegin(a2,b2);
return c;    
}
    public int[] arrayCheck(int[] a){
    int[] ohBoy = new int[this.orderedArrLength(a,0,1)];
    ohBoy= this.orderedArrShrink(a,0,ohBoy,0);
    return ohBoy;}
    
    public int[] orderedArrShrink(int [] a, int b, int [] c, int czaehler){
          c[czaehler]=a[b];
        if(a[b]==a[b+1]){czaehler=czaehler-1;}
        
      
        b++;
        czaehler++;
        if(b==a.length-1){  c[czaehler]=a[b];}
        if(b<a.length-1){return this.orderedArrShrink(a, b, c, czaehler);}
        return c;
    };
    public int orderedArrLength(int [] a, int b, int c){
        if(a[b]==a[b+1]){c=c-1;}
       
        if(b<a.length-2){return this.orderedArrLength(a, b+1, c+1);}
        return c+1;
    };
}