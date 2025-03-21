package Bank_Front;

import java.util.List;

import Bank.Request;
import Bank_Model.AccountDTO;
import Bank_Service.AccountListService;
import Bank_Service.AccountService;
import Bank_Service.AccountWriteService;
import Bank_Service.DepositService;
import Bank_Service.WithdrawService;
import Bank_View.AccountCreate;
import Bank_View.AccountDepositView;
import Bank_View.AccountListView;
import Bank_View.AccountWithdrawView;
import Bank_View.DepositView;
import Bank_View.MainPage;
import Bank_View.WithdrawView;

public class FrontController {
	public static void main(String[] args) {

		int pageNum = 0; // 메인페이지
		boolean run = true;
		Request request = null;
		while (run) {
			if (pageNum == 0) {
				MainPage mainPage = new MainPage();
				request = mainPage.view();
				pageNum = request.getPageNum();
			} else if (pageNum == 1) {// 계좌 생성 : 계좌 정보입력
				AccountCreate accountcreate = new AccountCreate();
				request = accountcreate.view();
				pageNum = request.getPageNum();
			} else if (pageNum == 6) {// 계좌생성 페이지
				AccountWriteService action = new AccountWriteService();
				action.execute(request); // 호출메서드
				pageNum = 0;
			} else if (pageNum == 2) {// 계좌 목록
				AccountListService action = new AccountListService();
				List<AccountDTO> list = action.execute();
				AccountListView accountListView = new AccountListView();
				accountListView.view(list);

				pageNum = 0;

			} else if (pageNum == 3) {// 입금
				DepositView depositView = new DepositView();
				request = depositView.view();
				pageNum = request.getPageNum();
			} else if (pageNum == 7) { // 계좌번호에 해당되는 계좌정보
				AccountService action = new AccountService();
				AccountDTO dto = action.execute(request);
				AccountDepositView accountDepositView = new AccountDepositView();
				request = accountDepositView.view(dto);
				pageNum = request.getPageNum();
			} else if (pageNum == 8) {
				DepositService action = new DepositService();
				action.execute(request);
				pageNum = 0;
			} else if (pageNum == 4) {// 출금
				WithdrawView withdrawView = new WithdrawView();
				request = withdrawView.view();
				pageNum = request.getPageNum();
				pageNum = request.getPageNum();

			} else if (pageNum == 9) {
				AccountService action = new AccountService();
				AccountDTO dto = action.execute(request);
				AccountWithdrawView accountWithdrawView = new AccountWithdrawView();
				request = accountWithdrawView.view(dto);
				pageNum = request.getPageNum();

			} else if (pageNum == 10) {
				WithdrawService action = new WithdrawService();
				action.execute(request);
				pageNum = 0;
			} else if (pageNum == 5) {// 프로그램 종료
				run = false;
				System.out.println("프로그램이 종료되었습니다.");

			}

		}
	}
}
