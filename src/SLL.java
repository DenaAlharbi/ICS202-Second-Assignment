public class SLL<T> {
    private SNode<T> head, tail;
    public SLL() {
        head = tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void setToNull() {
        head = tail = null;
    }
    public T firstEl() {
        if (head != null)
            return head.info;
        else return null;
    }
    public void addToHead(T el) {
        if (head != null) {
            head = new SNode<T>(el,head,null);
            head.next.prev = head;
        }
        else head = tail = new SNode<T>(el);
    }
    public void addToTail(T el) {
        if (tail != null) {
            tail = new SNode<T>(el,null,tail);
            tail.prev.next = tail;
        }
        else head = tail = new SNode<T>(el);
    }
    public T deleteFromHead() {
        if (isEmpty())
            return null;
        T el = head.info;
        if (head == tail)   // if only one node on the list;
            head = tail = null;
        else {              // if more than one node in the list;
            head = head.next;
            head.prev = null;
        }
        return el;
    }
    public T deleteFromTail() {
        if (isEmpty())
            return null;
        T el = tail.info;
        if (head == tail)   // if only one node on the list;
            head = tail = null;
        else {              // if more than one node in the list;
            tail = tail.prev;
            tail.next = null;
        }
        return el;
    }
    public void printAll() {
        for (SNode<T> tmp = head; tmp != null; tmp = tmp.next)
            System.out.print(tmp.info + " ");
        System.out.println();
    }
    public T find(T el) {
        SNode<T> tmp;
        for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next);
        if (tmp == null)
            return null;
        else return tmp.info;
    }
    public void printReverse(){
        SNode<T> p = tail;
        while (p!= null) {
            System.out.print(p.info+" ");
            p =p.prev;
        }
    }
    public void delete7() {
        SNode<T> h = head;
        int count = 1;

        while (h != null && count < 7) {
            count++;
            h = h.next;
        }

        if (count == 7 && h != null) {
            if (h.prev != null) {
                h.prev.next = h.next;
            } else {
                head = h.next;
            }
            if (h.next != null) {
                h.next.prev = h.prev;
            }
        } else {
            SNode<T> p = tail;

            while (p.prev != null&& count!=7) {
                //System.out.println(count);
                p = p.prev;
                count++;
            }
            //System.out.println("hh"+count);
            p.prev.next = p.next;

            p.next.prev = p.prev;

        }
    }



    public void insertAlternate(SLL<T> newList) {
        SNode<T> current1 = head;
        SNode<T> current2 = newList.head;

        while (current1 != null && current2 != null) {
            SNode<T> next1 = current1.next;
            SNode<T> next2 = current2.next;

            current1.next = current2;
            current2.prev = current1;

            if (next1 != null) {
                current2.next = next1;
                next1.prev = current2;
            }

            current1 = next1;
            current2 = next2;
        }

        if (current2 != null) {
            if (current1 == null) {
                head = newList.head;
            } else {
                current1.next = current2;
                current2.prev = current1;
            }
        }
    }

}