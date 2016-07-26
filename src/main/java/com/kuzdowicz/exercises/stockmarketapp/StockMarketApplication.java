package com.kuzdowicz.exercises.stockmarketapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kuzdowicz.exercises.stockmarketapp.config.AppConfig;
import com.kuzdowicz.exercises.stockmarketapp.database.StockMarketAppDB;
import com.kuzdowicz.exercises.stockmarketapp.services.StockMarketService;

public class StockMarketApplication {

	private static ApplicationContext application;

	public static void main(String[] args) {

		application = new AnnotationConfigApplicationContext(AppConfig.class);

		StockMarketAppDB db = application.getBean(StockMarketAppDB.class);
		db.loadStocksToDB();

		StockMarketService stockMarketService = application.getBean(StockMarketService.class);

		System.out.println("+--------+----------------+-----------+-------------+");
		System.out.println("| Symbol | Dividend yield | P/E ratio | Stock price |");
		System.out.println("+--------+----------------+-----------+-------------+");

		stockMarketService.getAllStocks().forEach(s -> System.out.println(s.getTickerSymbol()));

	}

}
