package com.practice;

public class Persian {

    public void whatsUp() {
        System.out.println("che khabar?");
    }
}
 
 interface AlienLanguage {
 
    default void whatsUp(){
        System.out.println("yada yadda, more yadda yaddda");
    }
}
 
 class Bilingual extends Persian implements AlienLanguage {
 
    public void converse() {
       whatsUp();
    }

     public static void main(String[] args) {
         new Bilingual().converse();
     }
 
}
