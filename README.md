## 주요기능 설명

1️⃣
<br>generateRandomNumbers(): 이 메서드는 1부터 9까지의 중복되지 않는 세 개의 난수를 생성하여 정답 배열로 반환합니다.
<br>Random 클래스를 사용하여 1부터 9까지의 난수를 생성하고, 생성된 난수가 이미 리스트에 존재하지 않을 경우에만 리스트에 추가합니다.
<br>마지막으로 리스트에 저장된 세 개의 난수를 정답 배열로 변환하여 반환합니다.
```java
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
```
<br><br><br>2️⃣
<br>playNumberBaseballGame(): 이 메서드는 숫자 야구 게임을 실행하는 메서드입니다. 게임 흐름은 전체적인 설명과 같습니다.
```java
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
```
<br><br><br>3️⃣
<br>contains(): 이 메서드는 배열에 특정 숫자가 포함되어 있는지 확인하는 메서드입니다.
<br>배열을 반복하면서 특정 숫자와 일치하는 경우 true를 반환하고, 일치하는 숫자를 찾지 못한 경우 false를 반환합니다.
```java
    public static boolean contains(int[] array, int number) {
        for (int num : array) {
            if (num == number) {
                return true;
            }
        }
        return false;
    }
```
<br><br><br>4️⃣
<br>isNumeric(): 이 메서드는 주어진 문자열이 숫자인지 확인하는 메서드입니다. 정규 표현식을 사용하여 숫자 형식에 맞는지 검사하고, 숫자인 경우 true를 반환합니다.
```java
public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
```
## 전체적인 설명
<br> playNumberBaseballGame가 실행되면
<br>:1-1.사용자로부터 세 자리 숫자를 입력받습니다.
<br>1-2.입력 형식이 잘못된 경우 에러 메시지를 출력하고 다시 입력을 받습니다.
<br>2.시도 횟수(count)를 증가시킵니다.
<br>3.입력된 숫자를 정수 배열로 변환합니다.
<br>4.정답과 사용자의 입력을 비교하여 스트라이크(strikes)와 볼(balls)의 개수를 계산합니다.
<br>5.스트라이크와 볼의 개수를 출력합니다.
<br>6-1.만약 세 숫자가 모두 일치하여 스트라이크가 3이 되면 축하 메시지를 출력하고 게임을 종료합니다.
<br>6-2.그렇지 않으면 다시 시도하라는 메시지를 출력하고 반복합니다.

## 결과
![image](https://github.com/yeonjuyeong/BaseBallGame/assets/123055714/aceb29c8-fe45-400c-9590-51af5641dfa6)

