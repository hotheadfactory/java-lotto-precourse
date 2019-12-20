package view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class UserInput {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputIntOnly() {
        try {
            return SCANNER.nextInt();
        } catch (InputMismatchException e) {
            ConsoleOutput.printIntOnlyError();
            inputIntOnly();
        }
        return -1;
    }

    public static List<Integer> inputLottoNumbers() {
        SCANNER.nextLine();
        try {
            return Arrays.stream(SCANNER.nextLine().trim()
                    .replace(" ", "")
                    .split(","))
                    .map(x -> Integer.parseInt(x))
                    .sorted()
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            ConsoleOutput.printIntOnlyError();
            inputLottoNumbers();
        }
        return null;
    }
}
