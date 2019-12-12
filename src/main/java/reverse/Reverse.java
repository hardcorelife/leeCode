package reverse;

/**
 * @author qiweigang
 * @date 2019-12-05 11:12
 */
public class Reverse {
    public void test() {
        char[] s = {'h', 'e', 'l', 'l', '0'};
        reverseString(s);
    }

    public void reverseString(char[] s) {
        int length = s.length;
        if (s == null || length == 0) {
            return;
        }
        for (int i = 0; i < length / 2; i++) {
            char temp = s[i];
            s[i] = s[length - 1 - i];
            s[length - 1 - i] = temp;
        }
        System.out.print(s);
    }
}
