int[] numbers;

boolean tryLoadData() {
    StringTokenizer tokenizer = new StringTokenizer(IO.readln());

    int tokensCount = tokenizer.countTokens();
    if (tokensCount < 2) return false;

    numbers = new int[tokensCount];
    for (int i = 0; i < tokensCount; i++) {
        numbers[i] = Integer.parseInt(tokenizer.nextToken());
    }

    return true;
}

void main() {
    if (!tryLoadData())
        return;

    Arrays.sort(numbers);
    StringBuilder builder = new StringBuilder();

    int lastNum = numbers[0];
    boolean hasDuplicates = false;
    for (int i = 1; i < numbers.length; i++) {
        if (lastNum == numbers[i]) {
            if(!hasDuplicates) {
                builder.append(String.format(" %d", numbers[i]));
                hasDuplicates = true;
            }
        } else {
            hasDuplicates = false;
        }

        lastNum = numbers[i];
    }

    IO.println(builder.toString());
}