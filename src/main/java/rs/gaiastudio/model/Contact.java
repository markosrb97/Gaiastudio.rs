/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.gaiastudio.model;

/**
 *
 * @author filip
 */
public class Contact {
    
    private String name;
    private String subject;
    private String email;
    private String message;
    
    public Contact(){
        
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getSubject(){
        return subject;
    }
    
    public void setSubject(String subject){
        this.subject = subject;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getMessage(){
        return message;
    }
    
    public void setMessage(String message){
        this.message = message;
    }
    
    @Override
    public String toString(){
        if(subject == null){
            return  "ime: " + name + "\n" + "email: " + email + "\n" + "poruka: " + message;
        }else{
            return  "ime: " + name + "\n" + "email: " + email + "\n" + "tema: " + subject + "\n" + "poruka: " + message;
        }
    }
    
}
