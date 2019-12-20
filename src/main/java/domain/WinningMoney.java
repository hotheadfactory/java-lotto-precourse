package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningMoney {
    private static final List<String> grades = new ArrayList(Arrays.asList("FIRST", "SECOND", "THIRD", "FOURTH", "FIFTH"));
    private static Integer[] prizes = {0,0,0,0,0};

    private static int prizeMoney = 0;

    public static void checkPrize(Rank rank, String grade) {
        for (int i = 0; i < grades.size(); i++) {
            checkGrade(rank, grade, i);
        }
    }

    private static void checkGrade(Rank rank, String grade, int index) {
        if (grade.equals(grades.get(index))) {
            prizes[index]++;
            prizeMoney += rank.getWinningMoney();
        }
    }

    public static void displayPrize(int lottoCount) {
        System.out.println("당첨 통계\n--------");
        System.out.println("3개 일치 : ("+Rank.FIFTH.getWinningMoney()+") "+prizes[4]+"개");
        System.out.println("4개 일치 : ("+Rank.FOURTH.getWinningMoney()+") "+prizes[3]+"개");
        System.out.println("5개 일치 : ("+Rank.THIRD.getWinningMoney()+") "+prizes[2]+"개");
        System.out.println("5개 일치 + 보너스 일치 : ("+Rank.SECOND.getWinningMoney()+") "+prizes[1]+"개");
        System.out.println("6개 일치 : ("+Rank.FIRST.getWinningMoney()+") "+prizes[0]+"개");
        System.out.printf("총 수익률은 %.3f입니다.", (float) prizeMoney / (float) (lottoCount*1000));
    }
}
