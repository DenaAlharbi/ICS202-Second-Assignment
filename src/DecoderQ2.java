import java.util.ArrayList;
import java.util.Scanner;


public class DecoderQ2 {
    public static void main(String[] args) {
        LabStack<Character> s = new LabStack<>();
        Scanner k = new Scanner(System.in);

        System.out.print("Enter a text> ");

        String input = k.nextLine();
        boolean reverseNext = false;
        for (char charInArray : input.toCharArray()) {
            if(charInArray == '}' ){
                reverseNext = false;
                while (!s.isEmpty()) {
                    System.out.print(s.pop());
                }
            }else if (charInArray == '{' ) {
                reverseNext = true;
            } else if (reverseNext) {
                s.push(charInArray);

            } else{
                System.out.print(charInArray);
            }

        }

    }
}

class LabStack<T> {
    ArrayList<T> pool;

    public LabStack() {
        pool = new ArrayList<T>();
    }


    public void clear() {
        pool.clear();
    }

    public boolean isEmpty() {
        return pool.isEmpty();
    }

    public T topEl() {
        if (isEmpty())
            throw new java.util.EmptyStackException();
        return pool.get(pool.size()-1);
    }

    public T pop() {
        if (isEmpty())
            throw new java.util.EmptyStackException();
        return pool.remove(pool.size()-1);
    }

    public void push(T el) {
        pool.add(el);
    }

    public String toString() {
        return pool.toString();
    }
}

