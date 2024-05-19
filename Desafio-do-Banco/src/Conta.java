// Conta.java
public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente; // ********************************************
	
	public Conta(Cliente cliente) {  //***************************************Cliente cliente
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
		saldo -=  valor;
	}

	@Override
	public void depositar(double valor) {
		saldo +=  valor;
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		if(saldo >= valor) {
		this.sacar(valor);
		contaDestino.depositar(valor);
		}else {
			System.out.println("Saldo insuficiente para transferência.");
		}
	}
	
	public void pagarContas(double valor) {
		if(saldo>= valor) {
			saldo -= valor;
			System.out.println("Pagamento realizado com sucesso.");
		}else {
			System.out.println("Saldo incuficiente para transferência.");
		}
	}
	
	public void verificarSaldo() {
		System.out.println(String.format("Saldo atual: %.2f", this.saldo));
	}
	
	public void gerarRelatorioMensal() {
		System.out.println("===Relatório mensal ===");
		this.imprimirInfosComuns();
	}
	
	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}
	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agência: %d", this.agencia));		
		System.out.println(String.format("Número: %d", this.numero));		
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
