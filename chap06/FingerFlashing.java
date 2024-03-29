// ジャンケン

import java.util.Scanner;
import java.util.Random;

class FingerFlashing {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		Random rand = new Random();
		String[] hands = {"グー", "チョキ", "パー"};
		int retry;						// もう一度行うか？

		do {
			int comp = rand.nextInt(3);	// コンピュータの手（0, 1, 2の乱数）
			int user;										// プレーヤの手（0, 1, 2で読み込む）

			do {
				System.out.print("じゃんけんポン");
				for (int i = 0; i < 3; i++)
					System.out.printf("(%d)%s ", i, hands[i]);
				System.out.print("：");
				user = stdIn.nextInt();
			} while (user < 0 || user > 2);

			// 両者の手を表示
			System.out.printf("私は%sで、あなたは%sです。\n", hands[comp], hands[user]);

			int judge = (user - comp + 3) % 3;			// 判定
			switch (judge) {
			 case 0: System.out.println("引分けです。");				break;
			 case 1: System.out.println("あなたの負けです。");	break;
			 case 2: System.out.println("あなたの勝ちです。");	break;
			}

			do {			// もう一度行うかどうかを確認
				System.out.print("もう一度？ (0)いいえ (1)はい：");
				retry = stdIn.nextInt();
			} while (retry != 0 && retry != 1);
		} while (retry == 1);
	}
}
