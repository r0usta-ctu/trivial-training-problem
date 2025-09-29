import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[] numbers;

    private static boolean tryLoadData() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int tokensCount = tokenizer.countTokens();
        if (tokensCount < 2) {
            return false;
        } else {
            numbers = new int[tokensCount];
            for(int i = 0; i < tokensCount; ++i) {
                numbers[i] = Integer.parseInt(tokenizer.nextToken());
            }

            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        if (tryLoadData()) {
            Arrays.sort(numbers);
            StringBuilder builder = new StringBuilder();
            int lastNum = numbers[0];
            boolean hasDuplicates = false;
            for(int i = 1; i < numbers.length; ++i) {
                if (lastNum == numbers[i]) {
                    if (!hasDuplicates) {
                        builder.append(String.format(" %d", numbers[i]));
                        hasDuplicates = true;
                    }
                } else {
                    hasDuplicates = false;
                }

                lastNum = numbers[i];
            }

            System.out.println(builder);
        }
    }
}