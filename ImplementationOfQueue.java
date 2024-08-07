ImplementationOfQueue.java

  package monika;

import java.util.Scanner;

public class ImplementationOfQueue {

    public static void main(String[] args) {
        Queue q = new Queue(5); // Set queue size to 5
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nSelect an operation:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Show Queue");
            System.out.println("4. Get Size");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to enqueue: ");
                    int element = scanner.nextInt();
                    q.enqueue(element);
                    break;
                case 2:
                    q.dequeue();
                    break;
                case 3:
                    q.show();
                    break;
                case 4:
                    System.out.println("The size of the current queue is " + q.size());
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}

Queue.java

  package monika;

public class Queue {
    int[] queue;
    int front, rear, size, capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = rear = size = 0;
    }

    public void enqueue(int data) {
        if (!isFull()) {
            queue[rear] = data;
            rear = (rear + 1) % capacity; // circular array logic
            size = size + 1;
        } else {
            System.out.println("The Queue is full....");
        }
    }

    public void dequeue() {
        if (!isEmpty()) {
            int data = queue[front];
            front = (front + 1) % capacity;
            size = size - 1;
            System.out.println("The dequeued element " + data);
        } else {
            System.out.println("The Queue is Empty");
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void show() {
        System.out.print("The Queue elements are ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
}
