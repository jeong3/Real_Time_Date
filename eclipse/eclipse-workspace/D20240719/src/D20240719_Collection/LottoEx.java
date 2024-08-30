package D20240719_Collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> lottoNum = new ArrayList<Integer>();
		System.out.print("원하는 수량을 입력하세요 : ");
		int cnt = sc.nextInt();
		for (int k = 0; k < cnt; k++) {
			for (int i = 1; i <= 45; i++) {
				lottoNum.add(i);
			}

			for (int y = 1; y <= 6; y++) {
				int size = lottoNum.size();
				int idx = (int) (Math.random() * (size));
				int num = lottoNum.remove(idx);
				System.out.print(num + " ");

			}
			lottoNum.clear();
			System.out.println();
		}
	}

}
