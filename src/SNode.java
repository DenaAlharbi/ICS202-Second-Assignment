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
