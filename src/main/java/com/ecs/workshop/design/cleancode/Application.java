package com.ecs.workshop.design.cleancode;

import com.ecs.workshop.design.cleancode.core.BankService;
import com.ecs.workshop.design.cleancode.core.exceptions.OpenAccountFailedException;
import com.ecs.workshop.design.cleancode.domains.*;
import com.ecs.workshop.design.cleancode.view.BankView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.time.LocalDate;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private static final Logger Log =
		LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		final SpringApplicationBuilder builder =
			new SpringApplicationBuilder(Application.class);
		builder.headless(false).run(args);
	}

	private final BankService bankService;
	private final BankView bankView;

	@Autowired
	public Application(BankService bankService, BankView bankView) {
		this.bankService = bankService;
		this.bankView = bankView;
	}

	@Override
	public void run(String... args) {
		Log.info("Hey, Application started!");

		final Client fabio = null;
		try {
			this.bankService.openAccount(fabio);
		} catch (OpenAccountFailedException ex) {
			bankView.showWarningMessage(ex);
		}

		final Client joao = new Person("João");
		final Account joaoAccount = this.bankService.openAccount(joao);

		final Client maria = new Person("Maria");
		final Account mariaAccount = this.bankService.openAccount(maria, Amount.of(15000));

		final Receipt depositReceipt = this.bankService.deposit(joaoAccount, Amount.of(400));
		Log.info(depositReceipt.getInformativeText());

		final Person juliana = new Person("Juliana");
		final Account julianaAccount = mariaAccount.addClient(juliana);

		final Client appleCompany = new Company("Apple Inc");
		final Account appleAccount = this.bankService.openAccount(appleCompany, Amount.of(1000000));

		final Billet billetForJuliana =
			Billet.generateWith(
				appleAccount,
				Amount.of(180),
				LocalDate.of(2021, 6, 30));

		final Receipt billetPaidReceiptFromJuliana = this.bankService.pay(billetForJuliana, julianaAccount);
		Log.info(billetPaidReceiptFromJuliana.getInformativeText());

		final Client pedro = new Person("Pedro");
		final Account pedroAccount = this.bankService.openAccount(pedro);

		final Receipt transfersReceipt =
			this.bankService.transferFunds(joaoAccount, pedroAccount, Amount.of(200));
		Log.info(transfersReceipt.getInformativeText());

		final FinancialStatement mariaFinancialStatement = mariaAccount.describeStatement();
		Log.info(mariaFinancialStatement.getInformativeText());

		// mauricio transferiu p/ juliana
		this.bankService.deposit(julianaAccount, Amount.of(300));

		final Billet billetForJoao =
			Billet.generateWith(
				appleAccount,
				Amount.of(260),
				LocalDate.of(2021, 7, 5));

		final Receipt billetPaidReceiptFromJoao = this.bankService.pay(billetForJoao, joaoAccount);
		Log.info(billetPaidReceiptFromJoao.getInformativeText());

		final FinancialStatement joaoFinancialStatement = joaoAccount.describeStatement();
		Log.info(joaoFinancialStatement.getInformativeText());
	}

}
