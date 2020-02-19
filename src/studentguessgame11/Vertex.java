/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentguessgame11;

/**
 *
 * @author Dawar Mustaqeem
 */
public class Vertex {
    
    Vertex right; //YES PART OF THE NODE
    Vertex left; //NO PART OF THE NODE
    String data;
    int key;
    boolean isStudent;
    
    Vertex(String data , int key){
    
        this.data = data;
        this.key = key;
        this.isStudent = false;
    
    }
    Vertex(String data, int key, boolean isStudent){
    
        this.data = data;
        this.key = key;
        this.isStudent = true;
    }
    
    public boolean hasLeft(){
    
        if(this.left == null){
        
            return false;
        }
        
        else{
        
            return true;
        }
    }
    
    public boolean hasRight(){
    
        if(this.right == null){
        
            return false;
        }
        
        else{
        
            return true;
        }
    }
    public boolean isLeaf(){
    
        if(this.right == null && this.left == null){
        
            return true;
        }
        else{
        
            return false;
        }
    }
    
    
    
}
