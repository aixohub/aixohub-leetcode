package com.aixohub.leetcode.simple.stack;

import java.util.EmptyStackException;

public class EasyStack {
    Object [] elementData ;
    int elementCount;
    int count = 0;

    public synchronized int size(){
        return elementCount;
    }

    public synchronized int capacity(){
        return elementData.length;
    }


    public EasyStack(Object[] elementData, int elementCount) {
        this.elementData = new Object[elementCount];
        this.elementCount = elementCount;
    }

    public synchronized void push(String element){
        if(count == elementCount){

        }
        count ++;
        elementData[count]= element;
    }

    public synchronized Object pop(){
        if(count == 0){
            throw new EmptyStackException();
        }
        Object peek = peek();
        elementData[count] = null;
        return peek;
    }

    public synchronized Object peek(){
        if(count == 0){
            throw new EmptyStackException();
        }

        return elementData[count];
    }
}
