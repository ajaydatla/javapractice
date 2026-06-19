package com.model;

class Parent{

 static void display(){

 System.out.println("Parent");

 }

 }

 class Child extends Parent{

 static void display(){

 System.out.println("Child");

 }

 }

 public class MainClass{

 public static void main(String[] args){

 Parent p =  new Child();

 p.display();

 }

 }