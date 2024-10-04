import java.util.Objects;

public class SLL<T> {
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
    public class SNode <T>{
        public T info;
        public SNode<T> next; //
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

    public SLL() {
        dummy = new SNode<>(null);
        // dummy; // even though the dummy will always serve as a head regardless of specifying that or not
    }

    public boolean isEmpty() { // completed
        return dummy.next == null;
    }

    public void addToHead(T el) { //completed
        if (!isEmpty()) {
            SNode<T> tmp = head;
            dummy.next =head = new SNode<T>(el);
            head.next = tmp;

            SNode<T> tmpForWhileLoop = dummy.next;
            // This is unnecessary but doesnt affect the code (just to make sure)
            while(tmpForWhileLoop.next!= null){
                tmpForWhileLoop = tmpForWhileLoop.next;
            }
            tail = tmpForWhileLoop;

        } else
            dummy.next =head = tail =new SNode<T>(el); //here dummy and head mean the same node
    }

    public void addToTail(T el) { // if there is only a dummy is that considered a tail so we just add to it
        //System.out.println("tail ="+ tail.info);
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
        if (head == tail)   // if only one node on the list;
            head = tail = null;
        else {              // if more than one node in the list;
            dummy.next = head.next;
            head = dummy.next;
        }
        return el;
    }

    public T deleteFromTail() { // completed
        if (isEmpty())
            return null;
        T el = tail.info;
        if (head == tail)   // if only one node on the list;
            head = tail = null;
        else {              // if more than one node in the list;
            SNode<T> tmpForWhileLoop = dummy;

            while(tmpForWhileLoop.next.next!= null){
                tmpForWhileLoop = tmpForWhileLoop.next;
            }
            tail = tmpForWhileLoop;
            tmpForWhileLoop.next =null;
        }
        return el;
    }
    public boolean search(T element){ //Completed probably // what does this return
        if (isEmpty())
            return false;
        else{
            SNode<T> tmp= dummy.next; // it is here and not in the for loop statement so that the if statement after it can access the variable
            while (tmp != null && !tmp.info.equals(element)){
                tmp = tmp.next;
            }
            return tmp!=null;
        }
    }

    public void printAll() { //completed
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