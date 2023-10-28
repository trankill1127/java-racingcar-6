package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Leaderboard;
import racingcar.domain.NamesManager;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        NamesManager namesManager = new NamesManager();
        List<String> namesList = namesManager.separateNamesString(Console.readLine());
        if (namesManager.checkNamesException(namesList)){
            throw new IllegalArgumentException();
        }

        Leaderboard leaderboard = new Leaderboard(namesList);

        System.out.println("시도할 회수는 몇회인가요?");

        int roundNumber = Integer.parseInt(Console.readLine());

        System.out.println();
        System.out.println("실행 결과");

        while (roundNumber>0){
            round(leaderboard);

            leaderboard.status();

            roundNumber--;
        }

        leaderboard.winner();
    }

    public static void round(Leaderboard leaderboard){
        for (String name : leaderboard.board.keySet()){
            int currentPlace = leaderboard.board.get(name);

            if (new Car().engine()){
                leaderboard.board.put(name, currentPlace+1);
            }
        }
    }

}
