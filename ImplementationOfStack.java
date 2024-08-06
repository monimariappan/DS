//ImplementationOfStack.java

package monika;

import java.util.Scanner;

public class ImplementationOfStack {

	public static void main(String[] args) {
		Stack s = new Stack();
		Dstack stack = new Dstack();

		Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Show Stack");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int value = scanner.nextInt();
                    stack.push(value);
                    stack.show();
                    break;
                case 2:
                    stack.pop();
                    stack.show();
                    break;
                case 3:
                    stack.peek();
                    break;
                case 4:
                    stack.show();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
	}

}

//Stack.java - Using fixed array

package monika;

public class Stack {
	
    int stack[] = new int[5];
    int top=0;
	public void push(int i) {
		if(size()==5) {
			System.out.println("The stack is full");
		}
		else {
		stack[top] = i;
		top++;
		}
	}
    
	public void pop() {
		if(isEmpty()) {
			System.out.println("No elements to pop out");
		}
		else {
		top--;
		int a = stack[top];
		stack[top] = 0;
		System.out.println("The element got popped out " + a);
		}
		
	}

	public void peek() {
		int b = stack[top-1];
		System.out.println("The element at its peek " + b);
	}

	public void show() {
		for (int i : stack) {
			System.out.print(i+ " ");
		}
	
	
	}
	public boolean isEmpty() {
		return top<=0;
	}
	public int size() {
		int a =  top;
		return a;
	}

}

// DStack.java - Using Dynamic arrays for better memory usage

package monika;

public class Dstack {
	
    int stack[] = new int[2];
    int top=0;
	public void push(int i) {
		if (size() == stack.length) {
	        expand();  // Expands the array when it's full
	    }
	    System.out.println("Pushing element: " + i);
	    stack[top] = i;  // Adds the new element to the top of the stack
	    top++;  // Increments the top index
	    System.out.println("Stack size after push: " + size());
	}
    
	private void expand() {
	    int newSize = stack.length * 2; // Double the stack size
	    int[] newStack = new int[newSize];
	    System.arraycopy(stack, 0, newStack, 0, stack.length);
	    stack = newStack;
	    System.out.println("Stack expanded to size: " + newSize);
	}


	public void pop() {
		if(isEmpty()) {
			System.out.println("No elements to pop out");
		}
		else {
		top--;
		int a = stack[top];
		stack[top] = 0;
		System.out.println("The element got popped out " + a);
		shrink();
		}
		
	}

	private void shrink() {
	    if (top <= (stack.length / 4) && stack.length > 2) { // Shrink if stack is less than or equal to 25% full
	        int newSize = stack.length / 2;
	        int[] newStack = new int[newSize];
	        System.arraycopy(stack, 0, newStack, 0, top);
	        stack = newStack;
	        System.out.println("Stack shrunk to size: " + newSize);
	    }
	}


	public void peek() {
		int b = stack[top-1];
		System.out.println("The element at its peek " + b);
	}

	public void show() {
		for (int i : stack) {
			System.out.print(i+ " ");
		}
	
	
	}
	public boolean isEmpty() {
		return top<=0;
	}
	public int size() {
		
		return top;
	}

}
