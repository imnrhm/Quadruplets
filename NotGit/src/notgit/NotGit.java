/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notgit;

/**
 *
 * @author Quadruplets
 */
public class NotGit<E> {
    
    private Node<E> head;
    private Node<E> tail;
    private int size;
    
    public NotGit(){
        
        size = 0;
        this.head = null;
        this.tail = null;
    }
    
    public void addFirst(E element){
        
        Node<E> tmp = new Node(element, head, null);
        if(head != null){
            head.prev = tmp;
        }
        head = tmp;
        if(tail == null){
            tail = tmp;
        }
        size++;
        //System.out.println("adding: " + element);
      
    }
    
    public void addLast(E element){
        Node<E> tmp = new Node(element, null, tail);
        if(tail != null){
            tail.next = tmp;
        }
        tail = tmp;
        if(head == null){
            head = tmp;
        }
        size++;
        //System.out.println("adding " + element);
    }
    
    public void add(int index, E element){
        if(index < 0 || index > size){
            
        }
        if(index == 0){
            addFirst(element);
        }
        else if(index == size){
            addLast(element);
        }else{
            Node<E> temp = head;
            for(int i = 0; i < index; i++){
                temp = temp.next;
            }
            
            Node<E> insert = new Node(element, temp,temp.prev);
            temp.prev.next = insert;
            temp.prev = insert;
            size++;
        }
        
        Node<E> temp = head;
        for(int i = 0; i < index ; i++){
            temp = temp.next;
        }
        
        Node<E> insert = new Node(element, temp, temp.prev);
        temp.prev.next = insert;
        temp.prev = insert;
        size++;
     
    }
    
    public void iterateForward(){
        
        System.out.println("iterating forward..");
        Node<E> tmp = head;
        while(tmp != null){
            System.out.print(tmp.element);
            System.out.print(" ");
            tmp = tmp.next;
        }
    }
    
    public void iterateBackward(){
        System.out.println("iterating backward..");
        Node<E> tmp = tail;
        while(tmp != null){
            System.out.println(tmp.element );
            tmp = tmp.prev;
        }
    }
    
    public E removeFirst(){
        if(size == 0){
            
        }
        Node<E> tmp = head;
        head = head.next;
        head.prev = null;
        size--;
        System.out.println("deleted: " + tmp.element);
        return tmp.element;
        
    }
    
    public E removeLast(){
        if(size == 0){
            
        }
        Node<E> tmp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        System.out.println("deleted: " + tmp.element);
        return tmp.element;
    }
    
    public E remove(int index){
        E element = null;
        if(index < 0 || index >= size){
            
        }
        if(index == 0){
            removeFirst();
        }
        else if(index == size-1){
            removeLast();
        }
        else{
            Node<E> temp = head;
            for(int i = 0; i < index; i++){
                temp = temp.next;
            }
            element = temp.element;
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
            temp.next = null;
            temp.prev = null;
            size--;
            
        }
        return element;
    }
    
    public void clear(){
        Node<E> temp = head;
        while(head != null){
            temp = head.next;
            head.prev = head.next = null;
            head = temp;
        }
        temp = null;
        tail.prev = tail.next = null;
        size = 0;
    }
    
}
