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
