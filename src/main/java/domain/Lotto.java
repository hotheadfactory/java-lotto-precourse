package domain;

import java.util.List;

/**
 * Lotto.java
 * 로또 한장을 의미하는 객체
 * 우아한테크코스 프리코스 3주차(1기) 복습
 * Original Code https://github.com/hotheadfactory/java-lotto-precourse
 * Version: v0.0., 2019.12.17 (c) 정회형
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    // 테스트 용
    public String lottoToStringTest() {
        return numbers.toString();
    }

    public Integer at(int index) {
        return numbers.get(index);
    }

    public boolean doesContain(int number) {
        return numbers.contains(number);
    }
}
