package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
    private static final int LOTTO_MINIMUM_NUMBER = 1;
    private static final int LOTTO_MAXIMUM_NUMBER = 45;
    private static final int LOTTO_BALL_PICK_COUNT = 6;

    private final List<Integer> lottoNumbers;

    public LottoNumberGenerator() {
        lottoNumbers = IntStream.rangeClosed(LOTTO_MINIMUM_NUMBER,LOTTO_MAXIMUM_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> runLottoMachine() {
        shuffleBalls();
        return lottoNumbers.stream()
                .limit(LOTTO_BALL_PICK_COUNT)
                .sorted()
                .collect(Collectors.toList());
    }

    private void shuffleBalls() {
        Collections.shuffle(lottoNumbers);
    }
}

