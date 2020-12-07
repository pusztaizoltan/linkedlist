package com.codecool.linkedlist;

public class Main {

    private static SinglyLinkedList list;

    public static void main(String[] args) {

//        SinglyLinkedList testList = new SinglyLinkedList();
        SinglyLinkedList<String> testList = new  SinglyLinkedList();
        testList.add("4");
        testList.add("5");
        testList.add("6");
        testList.insert(1, "2");
        System.out.println(testList.toString());
        System.out.println();
        SinglyLinkedList<Integer> listUnderTest = new  SinglyLinkedList();
        listUnderTest.insert(0, 123);
        listUnderTest.insert(1, 234);
        listUnderTest.insert(2, 345);
        listUnderTest.insert(3, 456);
        listUnderTest.insert(4, 567);
        listUnderTest.insert(5, 678);

        System.out.println(listUnderTest.toString());
        System.out.println(listUnderTest.indexOf(234));

        System.out.println("Your implementation is correct when there's no failing test after running mvn clean test.");
        if (args.length < 3) {
            terminate();
        }

        int numberOfElements = Integer.valueOf(args[0]);
        String command = args[1];

        list = new SinglyLinkedList();
        System.out.println("After you're done try these to get a feel for computational cost.");

        feedList(numberOfElements);

        long start = 0, end = 0;
        if ("access".equals(command)) {
            int i = Integer.valueOf(args[2]);

            start = System.currentTimeMillis();
            list.get(i);
            end = System.currentTimeMillis();
        } else if ("search".equals(command)) {
            int x = Integer.valueOf(args[2]);

            start = System.currentTimeMillis();
            list.indexOf(x);
            end = System.currentTimeMillis();

        } else if ("insert".equals(command)) {
            int i = Integer.valueOf(args[2]);
            int x = Integer.valueOf(args[3]);

            start = System.currentTimeMillis();
            list.insert(i, x);
            end = System.currentTimeMillis();

        } else if ("delete".equals(command)) {
            int i = Integer.valueOf(args[2]);

            start = System.currentTimeMillis();
            list.remove(i);
            end = System.currentTimeMillis();

        } else {
            terminate();
        }

        System.out.format("%s took: %sms\n", command, end - start);
    }

    private static void feedList(int numberOfElements) {
        System.out.println("Building the linked list ... this may take a while :)");
        for (int i = 0; i < numberOfElements; i++) {
            list.insert(i, i);
        }
    }

    private static void terminate() {
        System.out.println("Invalid operation!");
        printAvailableCommands();
        System.exit(1);
    }

    private static void printAvailableCommands() {
        System.out.println("The following operations available: access, search, insert, delete");
        System.out.println("You can run the application like follows:");

        String runPrefix = "java Main <number of elements>";
        System.out.format("%s access <index to access>\n", runPrefix);
        System.out.format("%s search <number to search for>\n", runPrefix);
        System.out.format("%s insert <index to insert at> <number to insert>\n", runPrefix);
        System.out.format("%s delete <index to delete at>\n", runPrefix);
    }
}
