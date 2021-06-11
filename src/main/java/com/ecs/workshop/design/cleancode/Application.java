package com.ecs.workshop.design.cleancode;

import com.ecs.workshop.design.cleancode.domains.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private static final Logger Log =
		LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) {
		Log.info("Hey, Application started!");

		final Bank myBank = Bank.getInstance();

		final Client joao = new Person("João");
		final Account joaoAccount = myBank.openAccount(joao);

		final Client maria = new Person("Maria");
		final Account mariaAccount = myBank.openAccount(maria, Amount.of(15000));

		final Receipt depositReceipt = myBank.deposit(joaoAccount, Amount.of(400));
		Log.info(depositReceipt.getInformativeText());

		final Person juliana = new Person("Juliana");
		final Account julianaAccount = mariaAccount.addClient(juliana);

		final Client appleCompany = new Company("Apple Inc");
		final Account appleAccount = myBank.openAccount(appleCompany, Amount.of(1000000));

		final Billet billetForJuliana =
			Billet.generateWith(
				appleAccount,
				Amount.of(180),
				LocalDate.of(2021, 6, 30));

		final Receipt billetPaidReceiptFromJuliana = myBank.pay(billetForJuliana, julianaAccount);
		Log.info(billetPaidReceiptFromJuliana.getInformativeText());

		final Client pedro = new Person("Pedro");
		final Account pedroAccount = myBank.openAccount(pedro);

		final Receipt transfersReceipt =
			myBank.transferFunds(joaoAccount, pedroAccount, Amount.of(200));
		Log.info(transfersReceipt.getInformativeText());

		final FinancialStatement mariaFinancialStatement = mariaAccount.describeStatement();
		Log.info(mariaFinancialStatement.getInformativeText());

		// mauricio transferiu p/ juliana
		myBank.deposit(julianaAccount, Amount.of(300));

		final Billet billetForJoao =
			Billet.generateWith(
				appleAccount,
				Amount.of(260),
				LocalDate.of(2021, 7, 5));

		final Receipt billetPaidReceiptFromJoao = myBank.pay(billetForJoao, joaoAccount);
		Log.info(billetPaidReceiptFromJoao.getInformativeText());

		final FinancialStatement joaoFinancialStatement = joaoAccount.describeStatement();
		Log.info(joaoFinancialStatement.getInformativeText());
	}

}
