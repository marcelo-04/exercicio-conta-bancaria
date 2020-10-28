package br.com.mclg.cursojava;

import java.util.Locale;
import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		System.out.println("*** Teste Da Conta Bancaria ***");
		
		ContaBancaria contaSimples = new ContaBancaria();
		contaSimples.setNomeCliente("Cliente Conta Simples");
		contaSimples.setNumConta("11111");
		
		contaSimples.depositar(100.0);
		
		realizarSaque(contaSimples, 50.0);
		realizarSaque(contaSimples, 70.0);
		
		System.out.println(contaSimples);
		
		System.out.println();
		System.out.println("*** Teste Da Conta Poupança ***");
		
		ContaPoupanca contaPoupanca = new ContaPoupanca();
		contaPoupanca.setNomeCliente("Cliente Conta Poupança");
		contaPoupanca.setNumConta("22222");
		contaPoupanca.setDiaRendimento(28);
		
		contaPoupanca.depositar(100.0);
		
		realizarSaque(contaPoupanca, 50.0);
		realizarSaque(contaSimples, 70.0);
		
		if(contaPoupanca.calcularNovoSaldo(0.5)) {
			System.out.println("Rendimento aplicado, novo saldo é de = "+ contaPoupanca.getSaldo());
		} else {
			System.out.println("Hoje não é dia rendimento, novo saldo não calculado");
		}
		
		System.out.println(contaPoupanca);
		
		System.out.println();
		System.out.println("*** Teste Da Conta Especial ***");
		
		ContaEspecial contaEspecial = new ContaEspecial();
		contaEspecial.setNomeCliente("Cliente Conta Especial");
		contaEspecial.setNumConta("33333");
		contaEspecial.setLimite(50.0);
		
		contaEspecial.depositar(100.0);
		
		realizarSaque(contaEspecial, 50.0);
		realizarSaque(contaEspecial, 70.0);
		realizarSaque(contaEspecial, 80.0);
		
		System.out.println(contaEspecial);
		scan.close();
	}
	
	private static void realizarSaque(ContaBancaria conta, double valor) {
		if(conta.sacar(valor)) {
			System.out.println("Saque efetuado com sucesso, novo saldo = "+ conta.getSaldo());
		} else {
			System.out.println("Saldo insuficiente para saque de "+ valor +"; saldo de = "+ conta.getSaldo());
		}
	}
}
