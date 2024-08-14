package com.example.challenge.dependencyInjection;

import com.example.challenge.dependencyInjection.entities.Order;
import com.example.challenge.dependencyInjection.services.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DependencyInjectionApplication implements CommandLineRunner {

	private OrderService orderService;

	public DependencyInjectionApplication(OrderService orderService) {
		this.orderService = orderService;
	}

	public static void main(String[] args) {
		SpringApplication.run(DependencyInjectionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite o código do pedido: ");
		int code = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Digite o valor básico do produto: ");
		double basic = Double.parseDouble(scanner.nextLine().replace(",", "."));

		System.out.print("Digite o valor do desconto (%): ");
		double discount = Double.parseDouble(scanner.nextLine().replace(",", "."));

		Order order = new Order();
		order.setCode(code);
		order.setBasic(basic);
		order.setDiscount(discount);

		double totalValue = orderService.total(order);
		String formattedTotal = String.format("%.2f", totalValue).replace(".", ",");

		System.out.println("\nCódigo do pedido: " + order.getCode());
		System.out.println("Valor total: R$" + formattedTotal);
	}

}
