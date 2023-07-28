package com.practice;

public class Solution12 {
    class Department{
        Integer deplId;
        public boolean equals(Object obj){
            Department other= (Department)obj;
            return this.deplId.equals(other.deplId);
         }
    }
}
