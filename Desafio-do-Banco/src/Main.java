// Main.java
public class Main {
	public static void main(String[] args) {
		Cliente jacimar = new Cliente();
		jacimar.setNome("jacimar carlos tinelli");
		
		Conta cc = new ContaCorrente(jacimar);
		cc.depositar(100);

		Conta poupanca = new ContaPoupanca(jacimar);
		poupanca.depositar(555.12);
		
//		Conta cc = new ContaCorrente(jacimar);
//		cc.depositar(100);
//		Conta poupanca = new ContaPoupanca(jacimar);
//		poupanca.depositar(555.12);
		
		cc.transferir(100, poupanca);
		poupanca.transferir(655.12, cc);

		cc.imprimirExtrato();
		poupanca.imprimirExtrato();

	    // Utilizando os novos métodos
        cc.verificarSaldo();
        cc.pagarContas(50.0);
        cc.verificarSaldo();
        cc.gerarRelatorioMensal();		
	}
}
