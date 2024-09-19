public class SNode <T>{
    public T info;
    public SNode<T> next, prev;
    public SNode() {
        next = null; prev = null;
    }
    public SNode(T el) {
        info = el; next = null; prev = null;
    }
    public SNode(T el, SNode<T> n, SNode<T> p) {
        info = el; next = n; prev = p;
    }
}
