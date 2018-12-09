import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LimpyZiv {
    static List<String> dictionary = new ArrayList<>();
    static {
        dictionary.add("A");
        dictionary.add("B");
        dictionary.add("C");
    }
    public static void main(String[] args) {
        var message = stringGenerator().toCharArray();
        String encodedMessage = "";
        for(int i = 0; i < message.length ;i++)
        {

            var currChar = message[i] + "";
            while (++i < message.length -1 && dictionary.contains(currChar + message[i]))
            {

                currChar += message[i];
            }
            i--;
            encodedMessage += dictionary.indexOf(currChar);

            if(i + 1 < message.length -1)
            {
                dictionary.add(currChar + message[i + 1]);
            }

        }
        System.out.println("Dictionary: ");
        for(int i = 0; i < dictionary.size(); i++)
        {
            System.out.println(i + " =  " + dictionary.get(i));
        }
        System.out.println(message);
        System.out.println(encodedMessage);
    }

    private static String stringGenerator() {
        Random random = new Random();
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < 10 ; i++)
        {
            char c = 'v';
            switch (random.nextInt(3))
            {
                case 1:
                    res.append('A');
                    break;
                case 2: res.append('B');
                    break;
                default:
                    res.append('C');

            }
        }
        return res.toString();
    }
}
