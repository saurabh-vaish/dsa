package DSExample;

class Stack{

    Integer [] mainStack;
    Integer [] trackStack;
    int mtop = 0;

    Stack(int size){
        this.mainStack = new Integer[size];
        this.trackStack = new Integer[size];
    }

    public void push(int n){
        if(mtop== mainStack.length){
            System.out.println("Stack is full");
            return;
        }
        if(mtop == 0){
            this.mainStack[mtop]=n;
            mtop++;
            this.trackStack[mtop]=n;
        }
        else {
            if (this.trackStack[mtop]!=null && n > this.trackStack[mtop]){
                this.trackStack[mtop]=n;
            }
            this.mainStack[mtop] = n;
            mtop++;
        }
    }

    public Integer peek(){
        if(mtop==0){
            System.out.println("Stack is empty");
            return null;
        }else {
            return this.mainStack[mtop-1];
        }
    }

    public void pop(){
        if(mtop==0){
            System.out.println("Stack is empty");
            return;
        }else {
            this.mainStack[mtop-1]=null;
            mtop--;
        }
    }

    public Integer getMax(){
        return this.trackStack[mtop];
    }

}

public class UserStack {

    public static void main(String[] args) {
        Stack stack = new Stack(15);

        stack.push(5);
        stack.push(10);
        stack.push(8);
        stack.push(6);
        stack.push(8);
        stack.push(10);

        System.out.println(stack.peek());
        System.out.println(stack.getMax());
    }

}
