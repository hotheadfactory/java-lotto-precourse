package domain;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto userLotto) {
        return Rank.valueOf(calculateMatchNumbers(lotto, userLotto), isContainingBonusNumber(userLotto));
    }

    private int calculateMatchNumbers(Lotto winningLotto, Lotto userLotto) {
        int matchNumber = 0;
        for(int i = 0; i < 6; i++) {
            matchNumber += isContainingWinningNumber(winningLotto, userLotto, i);
        }
        System.out.println(matchNumber);
        return matchNumber;
    }

    private int isContainingWinningNumber(Lotto winningLotto, Lotto userLotto, int i) {
        if(userLotto.doesContain(winningLotto.at(i))) {
            return 1;
        }
        return 0;
    }

    private boolean isContainingBonusNumber(Lotto userLotto) {
        if(userLotto.doesContain(bonusNo)) {
            return true;
        }
        return false;
    }
}
