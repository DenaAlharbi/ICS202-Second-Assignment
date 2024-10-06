public class SLLQ1<T> {
    //This is for testing
    public static void main(String[] args) {
        SLLQ1<String> stringList = new SLLQ1<>();
        //Test the printAll method and that the empty lists have a dummy
        System.out.print("An Empty list was just created but has a dummy>> ");
        stringList.printAll(); //I am going to use this method in testing each of the other methods

        //Testing the add to head method
        System.out.print("Add 1 to head>> ");
        stringList.addToHead("1");
        stringList.printAll();

        //Testing add to head while there is already a head
        System.out.print("Add 0 to head>> ");
        stringList.addToHead("0");
        stringList.printAll();

        //Testing add to tail method
        System.out.print("Add 2 to tail>> ");
        stringList.addToTail("2");
        stringList.printAll();
        System.out.print("Add 3 to tail>> ");
        stringList.addToTail("3");
        stringList.printAll();

        //Test the reverse method - without affecting the dummy
        System.out.print("Reverse Method>> ");
        stringList.Reverse();
        stringList.printAll();
        System.out.print("Reverse the list back to how it was>> ");
        stringList.Reverse();
        stringList.printAll();

        //testing the search method
        System.out.print("Search method for (7)>> ");
        System.out.println(stringList.search("7"));
        System.out.print("Search method for (0)>> ");
        System.out.println(stringList.search("0"));

        //testing the delete from head method
        System.out.print("Delete from head>> ");
        stringList.deleteFromHead();
        stringList.printAll();

        //testing the delete from tail method
        System.out.print("Delete from tail>> ");
        stringList.deleteFromTail();
        stringList.printAll();
    }
    public class SNode <T>{
        public T info;
        public SNode<T> next;
        public SNode() {
            next = null;
        }
        public SNode(T el) {
            info = el; next = null;
        }
        public SNode(T el, SNode<T> n, SNode<T> p) {
            info = el;
            next = n;
        }
    }
    private SNode<T> head;
    private SNode<T> tail;
    private SNode<T> dummy;

    public SLLQ1() {
        dummy = new SNode<>(null);
    }

    public boolean isEmpty() { // completed
        return dummy.next == null;
    }

    public void addToHead(T el) {
        if (!isEmpty()) {
            SNode<T> tmp = head;
            dummy.next =head = new SNode<T>(el);
            head.next = tmp;

            SNode<T> tmpForWhileLoop = dummy.next;
            while(tmpForWhileLoop.next!= null){
                tmpForWhileLoop = tmpForWhileLoop.next;
            }
            tail = tmpForWhileLoop;

        } else
            dummy.next =head = tail =new SNode<T>(el);
    }

    public void addToTail(T el) {
        if(isEmpty()){
            dummy.next = head = tail = new SNode<>(el);
        }else{
        SNode<T> tmp = tail;
        tmp =tmp.next = new SNode<>(el);
        tail = tmp;}
    }

    public T deleteFromHead() { //completed
        if (isEmpty())
            return null;
        T el = head.info;
        if (head == tail)
            head = tail = null;
        else {
            dummy.next = head.next;
            head = dummy.next;
        }
        return el;
    }

    public T deleteFromTail() {
        if (isEmpty())
            return null;
        T el = tail.info;
        if (head == tail)
            head = tail = null;
        else {
            SNode<T> tmpForWhileLoop = dummy;

            while(tmpForWhileLoop.next.next!= null){
                tmpForWhileLoop = tmpForWhileLoop.next;
            }
            tail = tmpForWhileLoop;
            tmpForWhileLoop.next =null;
        }
        return el;
    }
    public String search(T element){ //Completed
        if (isEmpty())
            return "NULL";
        else{
            SNode<T> tmp= dummy.next; // it is here and not in the for loop statement so that the if statement after it can access the variable
            while (tmp != null && !tmp.info.equals(element)){
                tmp = tmp.next;
            }
            if (tmp == null)
                return "NULL";

            return tmp.toString();
        }
    }

    public void printAll() {
        // This will print null at the beginning because of the dummy - under this code is without the dummy
        for (SNode<T> tmp = dummy; tmp != null; tmp = tmp.next)
            System.out.print(tmp.info + " ");
        System.out.println();
        //to print it without the dummy
        /*for (SNode<T> tmp = head; tmp != null; tmp = tmp.next)
            System.out.print(tmp.info + " ");
        System.out.println();*/
    }



    public void Reverse() { // completed
        if(isEmpty())
            return;


        SNode<T> tmp =null;
        SNode<T> originalhead = dummy.next;
        SNode<T> lastChanged = dummy.next;
        SNode<T> linktonextnode= null ;

        while (lastChanged!=null){
            linktonextnode = lastChanged.next;
            lastChanged.next= tmp;
            tmp = lastChanged;
            lastChanged = linktonextnode;

        }dummy.next = tmp; tail = originalhead;

    }
}