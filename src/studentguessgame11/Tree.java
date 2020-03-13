/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentguessgame11;

import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;

/**
 *
 * @author Raja Ali Hassan
 */
public class Tree {
    
    Vertex root;
    int n;
    int treelevel = 0;
   //Right is No 
  //Left is Yes
    
    public boolean addStudent(String student){
        
        //METHOD TO ADD THE STUDENT IN THE LEAF NODE AS PER THE SEQUENCE OF HIS/HER QUESTIONS
        
        Vertex temp = this.root;
        Vertex std = null;
        String [] parsed = student.split("&");
        //THE LEAF VERTEX KEY IS KEPT CONSTANT FOR ALL LEAF VERTEXES 
        std = new Vertex (parsed[0],-1,true);
        int i = 1;
        String name = null;
        String [] splited = null;
         
            
            
        while(temp !=  null){
        
            if( parsed[i].equals("YES")){
        
        
                if(temp.left == null){
                
                     temp.left = std;
                     return true;
                }
                //this is the extra code     
                if(temp.left.isStudent){
                
                 // temp.right is a student 
                // we have to replace it with a question 
               //saving the data in a variable to preserve it
               
                   name = temp.left.data ;
                   splited = name.split("(?!^)");
                   temp.left.isStudent = false;
                   temp.left.data = "DOES THE STUDENT'S NAME STARTS WITH  "+splited[0];
                   
                Vertex n = new Vertex(name,-1,true);       
                    temp.left.left = n;
             
                     temp.left.right = std; 
                     return true;
                
                } //this is the extra code
                
                
             temp = temp.left;
            }
            
            
            
            if(parsed[i].equals("NO")){
            
                
               //incase the right is null so the student is added 
               if(temp.right == null){
                   
                    temp.right = std;
                      return true;        
                }
              
                //this is the extra code     
                if(temp.right.isStudent){
                
                 // temp.right is a student 
                // we have to replace it with a question 
               //saving the data in a variable to preserve it
               
                   name = temp.right.data ;
                   splited = name.split("(?!^)");
                   temp.right.isStudent = false;
                   temp.right.data = "DOES THE STUDENT'S NAME STARTS WITH  "+splited[0];
                   
                Vertex n = new Vertex(name,-1,true);       
                    temp.right.left = n;
                    temp.right.right = std; 
                     return true;
                
                } //this is the extra code
                
                temp = temp.right;
            }
            i++;
        }
        
            return false;
    
    }
    public boolean add(Vertex new_v){
    
        this.root = this.recAdd(new_v, this.root);
        return true;
    }
    private Vertex recAdd(Vertex new_v, Vertex root){
    
        if(root == null){
            
            this.n++;
            return new_v;
        
        }
        
        if(new_v.key > root.key){
        
            
            root.right = recAdd(new_v,root.right);
        }
        
        if(new_v.key < root.key){
        
       
            root.left = recAdd(new_v,root.left);
        }
        
          return root;
    }
}
