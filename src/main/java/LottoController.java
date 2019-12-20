import domain.*;
import view.UserInput;

import java.util.List;

import static view.ConsoleOutput.printMessage;

public class LottoController {


    public LottoController() {
        LottoVendingMachine lottoVendingMachine = new LottoVendingMachine();
        List<Lotto> purchasedLotto = buyLotto(getMoney(), lottoVendingMachine);
        WinningLotto winningLotto = inputWinningNumber();
        checkEachLotto(lottoVendingMachine, purchasedLotto, winningLotto);
    }

    private void checkEachLotto(LottoVendingMachine lottoVendingMachine, List<Lotto> purchasedLotto
            , WinningLotto winningLotto) {
        for (Lotto lotto : purchasedLotto) {
            Rank result = winningLotto.match(lotto);
            WinningMoney.checkPrize(result, result.name());
        }
        WinningMoney.displayPrize(lottoVendingMachine.getLottoCount());
    }


    private int getMoney() {
        printMessage("구입금액을 입력해 주세요: ");
        return UserInput.inputIntOnly();
    }

    private List<Lotto> buyLotto(int money, LottoVendingMachine lottoVendingMachine) {
        try {
            List<Lotto> purchasedLotto = lottoVendingMachine.issueNewLotto(money);
            purchasedLotto.forEach(x -> printMessage(x.lottoToStringTest()));
            return purchasedLotto;
        } catch (IllegalArgumentException ex) {
            printMessage(ex.getMessage());
            buyLotto(money, lottoVendingMachine);
        }
        return null;
    }

    public static WinningLotto inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> lottoNumbers = UserInput.inputLottoNumbers();
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = UserInput.inputIntOnly();
        return new WinningLotto(new Lotto(lottoNumbers), bonusNumber);
    }
}
