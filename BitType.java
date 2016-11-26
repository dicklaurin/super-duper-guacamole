/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Laurin
 */

public enum BitType {
   Twist, Dwelling, Masonry;

public static Material[] canHandle(BitType type){
    
    switch(type){
        case Twist:  Material[] a = {Material.Wood, Material.Plastic, Material.Metal}; return a; 
        case Dwelling: Material[] b = {Material.Wood, Material.Plastic}; return b;
        case Masonry:  Material[] c = {Material.Stone, Material.Concrete, Material.ReinforcedConcrete}; return c;    
        default: return null;    
    }
}
}