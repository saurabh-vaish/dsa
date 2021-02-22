package DSExample;

import java.util.NoSuchElementException;

public class SignlyLinkedList<T> {

    private Node<T> head;
    private static int length;

    private static class Node<T>{
        private T data;
        private Node<T> next;

        Node(T data){
            this.data = data;
            this.next = null;
            length++;
        }

        Node(T data ,Node<T> next){
            this.data = data;
            this.next = next;
            length++;
        }
    }

    public static void main(String[] args) {

        SignlyLinkedList<Integer> signlyLinkedList = new SignlyLinkedList<>();
        signlyLinkedList.addFirst(3);
        signlyLinkedList.add(5);
        signlyLinkedList.add(53);
        signlyLinkedList.add(77);
        signlyLinkedList.add(88);
        signlyLinkedList.addLast(33);
        signlyLinkedList.addAt(22,4);
        signlyLinkedList.print();
        System.out.println(signlyLinkedList.getFirst());
        System.out.println(signlyLinkedList.getLast());
        System.out.println(signlyLinkedList.getAt(5));
        System.out.println(signlyLinkedList.deleteFirst());
        System.out.println(signlyLinkedList.deleteLast());
        signlyLinkedList.print();
        System.out.println(signlyLinkedList.deleteAt(5));
        signlyLinkedList.print();
        System.out.println(length);

    }

    public boolean isEmpty(){
        return length == 0;
    }

    // add first

    public SignlyLinkedList<T> addFirst(T data){
        head = new Node<>(data);
        return this;
    }

    // add last
    public SignlyLinkedList<T> addLast(T data){
        if(isEmpty()){
            addFirst(data);
        }
        else {
            Node<T> temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = new Node<>(data,null);
        }
        return this;
    }

    // add
    public SignlyLinkedList<T> add(T data){
        return addLast(data);
    }


    // addAt
    public SignlyLinkedList addAt(T data, int location){
        if(isEmpty() || location==0 ){
            addFirst(data);
        }
        else if(location>length){
            return this;
        }
        else {
            Node<T> temp = head;
            int i=1;
            while(i<location-1){
                temp = temp.next;
                i++;
            }
            temp.next = new Node<>(data,temp.next);
        }
        return this;
    }

    // prT

    public void print(){
        if(isEmpty()){
            return;
        }
        StringBuilder sb = new StringBuilder();
        Node<T> temp = head;
        while (temp!=null && temp.next!=null){
            sb.append(temp.data).append(" ");
            temp = temp.next;
        }
        sb.append(temp.data).append(" ");
        System.out.println(sb.toString());
    }

    // get first

    public T getFirst(){
        if(isEmpty()){
            throw  new NoSuchElementException();
        }else
            return head.data;
    }

    // get last

    public T getLast(){
        if(isEmpty())throw new NoSuchElementException();
        else{
            Node<T> temp = head;
            while (temp!=null && temp.next!=null){
                temp = temp.next;
            }
            return temp.data;
        }
    }

    // getAt

    public T getAt(int location){
        if(isEmpty())throw new NoSuchElementException();
        else if (location>length)throw new IndexOutOfBoundsException();
        else{
            int i=1;
            Node<T> temp = head;
            while (i<location){
                temp = temp.next;
                i++;
            }
            return temp.data;
        }
    }

    // delete first

    public T deleteFirst(){
        if(isEmpty()){
            throw  new NoSuchElementException();
        }else {
            T data = head.data;
            head = head.next;
            length--;
            return data;
        }
    }

    // delete last

    public T deleteLast(){
        if(isEmpty())throw new NoSuchElementException();
        else{
            Node<T> temp = head;
            T data = getLast();
            while (temp!=null && temp.next!=null && temp.next.next!=null){
                temp = temp.next;
            }
            temp.next=null;
            length--;
            return data;
        }
    }

    // deleteAt

    public T deleteAt(int location){
        if(isEmpty())throw new NoSuchElementException();
        else if (location>length)throw new IndexOutOfBoundsException();
        else{
            int i=1;
            T data = getAt(location);
            Node<T> temp = head;
            Node<T> prev = null;
            while (i<location){
                prev = temp;
                temp = temp.next;
                i++;
            }
            temp = temp.next;
            prev.next=temp;
            length--;
            return data;
        }
    }

}
