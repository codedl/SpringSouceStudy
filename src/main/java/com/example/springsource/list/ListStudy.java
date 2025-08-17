package com.example.springsource.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListStudy {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add("hello");

        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add("hello");

        LinkedList linkedList = new LinkedList();
        linkedList.add("hello");
        linkedList.get(1);
    }
}
