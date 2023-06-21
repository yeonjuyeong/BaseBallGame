package Base;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NumberBaseballGame {
    public static void main(String[] args) {
        int[] answer = generateRandomNumbers();
        playNumberBaseballGame(answer);
    }

    // 난수 생성하여 정답 배열 반환
    public static int[] generateRandomNumbers() {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 3) {
            int randomNumber = random.nextInt(9) + 1; // 1부터 9까지의 난수 생성
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        int[] answer = new int[3];
        for (int i = 0; i < 3; i++) {
            answer[i] = numbers.get(i);
        }

        return answer;
    }

    // 게임 실행
    public static void playNumberBaseballGame(int[] answer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자 야구 게임을 시작합니다!");
        int count = 0; // 시도 횟수를 저장하는 변수 count를 초기화

        while (true) {
            System.out.print("세 자리 숫자를 입력하세요 (중복되지 않는 숫자 예시 형식:123): ");
            String guessString = scanner.nextLine();
            if (guessString.length() != 3 || !isNumeric(guessString)) {
                System.out.println("잘못된 입력입니다. 예시 형식을 참고해주세요.");
                continue;
            }
            count++; // 시도 횟수를 증가시킴

            int[] guess = new int[3];
            for (int i = 0; i < 3; i++) {
                guess[i] = Character.getNumericValue(guessString.charAt(i));
            }

            int strikes = 0;
            int balls = 0;

            for (int i = 0; i < 3; i++) {
                if (guess[i] == answer[i]) {
                    strikes++;
                } else if (contains(answer, guess[i])) {
                    balls++;
                }
            }

            System.out.println("카운트: " + count); // 현재 시도 횟수를 출력
            System.out.println("결과: " + strikes + " 스트라이크, " + balls + " 볼");

            if (strikes == 3) {
                System.out.println("축하합니다! 숫자를 모두 맞추셨습니다.");
                break;
            } else {
                System.out.println("다시 시도하세요.");
                System.out.println();
            }
        }

        scanner.close();
    }

    // 배열에 특정 숫자 포함 여부 확인
    public static boolean contains(int[] array, int number) {
        for (int num : array) {
            if (num == number) {
                return true;
            }
        }
        return false;
    }

    // 문자열이 숫자인지 확인
    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}
