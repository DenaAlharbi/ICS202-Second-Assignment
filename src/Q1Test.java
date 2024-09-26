public class Q1Test {
    public static void main(String[] args) {
        SLL<String> stringList = new SLL<>();
        System.out.println("Empty list");
        stringList.printAll();
        System.out.println("Add to head");
        stringList.addToHead("1");
        stringList.printAll();
        System.out.println("Add to head");
        stringList.addToHead("0");
        stringList.printAll();
        System.out.println("Add to tail");
        stringList.addToTail("2");
        stringList.printAll();
        System.out.println("Add to tail");
        stringList.addToTail("3");
        stringList.printAll();
        System.out.println("Reverse");
        stringList.Reverse();
        stringList.printAll();
        System.out.println("Reverse");
        stringList.Reverse();
        stringList.printAll();
        System.out.println("Search");
        System.out.println(stringList.search("7"));
        System.out.println(stringList.search("0"));
        System.out.println("Delete from head");
        stringList.deleteFromHead();
        stringList.printAll();
        System.out.println("Delete from tail");
        stringList.deleteFromTail();
        stringList.printAll();
    }
}
