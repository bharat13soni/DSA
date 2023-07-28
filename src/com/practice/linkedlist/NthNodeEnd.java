package com.practice.linkedlist;

import java.util.Stack;
class LLNode    
{    
int value;    
LLNode nxt;    
// Class Node constructor  
// that take n as it argument  
LLNode(int no)    
{    
this.value = no;    
this.nxt = null;    
}    
}   
public class NthNodeEnd   
{  
public int findNthFromEnd(LLNode h, int n)  
{  
Stack<Integer> stk = new Stack<Integer>();  
LLNode ptr = h;  
while(ptr != null)  
{  
    stk.push(ptr.value);  
    ptr = ptr.nxt;  
}  
int val = 0;  
while(n != 0)  
{  
val = stk.peek();  
stk.pop();  
n = n - 1;  
}  
return val;  
}  
// main method  
public static void main(String[] argvs)  
{  
// creating an object of the class NthNodeEnd  
NthNodeEnd obj = new NthNodeEnd();  
// input 1  
int n = 2;  
// the first or the left most node of the linked list    
LLNode h = new LLNode(19);  
  
// remaining nodes of the linked list    
h.nxt = new LLNode(56);    
h.nxt.nxt = new LLNode(45);    
h.nxt.nxt.nxt = new LLNode(32);    
h.nxt.nxt.nxt.nxt = new LLNode(10);    
h.nxt.nxt.nxt.nxt.nxt = new LLNode(70);    
int ans = obj.findNthFromEnd(h, n);  
System.out.println("For the following linked list");  
while(h != null)  
{  
    System.out.print(h.value + " ");  
    h = h.nxt;  
}  
System.out.println();  
System.out.println("The " + n + "nd node from the end is: " + ans);  
h = null;  
System.out.println( "\n");  
// input 2  
n = 5;  
// the first or the left most node of the linked list    
h = new LLNode(19);  
// remaining nodes of the linked list    
h.nxt = new LLNode(119);    
h.nxt.nxt = new LLNode(156);    
h.nxt.nxt.nxt = new LLNode(15);    
h.nxt.nxt.nxt.nxt = new LLNode(312);    
h.nxt.nxt.nxt.nxt.nxt = new LLNode(101);  
h.nxt.nxt.nxt.nxt.nxt.nxt = new LLNode(710);   
  
ans = obj.findNthFromEnd(h, n);  
System.out.println("For the following linked list");  
while(h != null)  
{  
    System.out.print(h.value + " ");  
    h = h.nxt;  
}  
System.out.println();  
System.out.println("The " + n + "th node from the end is: " + ans);  
}  
}  
