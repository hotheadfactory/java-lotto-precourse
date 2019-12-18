package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static view.ConsoleOutput.printMessage;

/**
 * 로또 자판기 객체
 */
public class LottoVendingMachine {

    private LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    public LottoVendingMachine() {
    }

    public List<Lotto> issueNewLotto(int lottoMoney) {
        if (lottoMoney % 1000 != 0) {
            throw new IllegalArgumentException("로또 구매 금액은 1000원 단위여야 합니다!");
        }
        int lottoCount = lottoMoney / 1000;
        printMessage(lottoCount + "개를 구매했습니다.");
        return generateLottos(lottoCount);
    }

    private Lotto generateOneLotto() {
        return new Lotto(lottoNumberGenerator.runLottoMachine());
    }

    private List<Lotto> generateLottos(int count) {
        List<Lotto> purchasedLotto = new ArrayList<>();
        return Stream.iterate(0, i -> i).limit(count)
                .map(x -> generateOneLotto())
                .collect(Collectors.toList());
    }

    public void listLottos() {
    }
}
