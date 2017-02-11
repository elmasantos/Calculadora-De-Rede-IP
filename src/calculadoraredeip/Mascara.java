package calculadoraredeip;

/**
 * Classe da máscara de rede.
 * @author Elma Santos e Fabiana Marinheiro
 *
 */

public class Mascara extends ElementoDeRede {
	
	private String octetosConcatenados;
	
	/**
	 * Método construtor.
	 * @param elemento String - máscara de rede.
	 */
	public Mascara(String elemento) {
		super(elemento);
	}
	
	/**
	 * Método para concatenar octetos da máscara em uma única string.
	 * @return String - máscara concatenada.
	 */
	public void concatenarOctetos(){
		octetosConcatenados = primeiroOcteto + segundoOcteto + terceiroOcteto + quartoOcteto;
	}
	
	/**
	 * Método para validar máscara.
	 * @param zero boolean - indica os 0s da máscara.
	 * @param invalida boolean - indica se máscara é inválida.
	 * @param unsNaMascara String - quantidade de 1s no início da máscara.
	 */
	public void validarMascara(boolean zero, boolean invalida, String unsNaMascara){
		int tamanho = octetosConcatenados.length();
		for(int i = 0; i < tamanho; i++){
			if(octetosConcatenados.charAt(i) == '0'){
				zero = true;
			}
			else{
				if(zero){
					System.out.println("Máscara inválida");
					invalida = true;
					break;
				}
			}
		}
		if(octetosConcatenados.startsWith(unsNaMascara) && invalida == false){
			System.out.println("Máscara válida");
		}
		else{
			System.out.println("Máscara inválida");
			invalida = true;
			}
	}
	
	
	/**
	 * Método para verificar se máscara é válida.
	 * @param classe String - classe da máscara.
	 * @return boolean - validez da máscara.
	 */
	public boolean verificarMascara(String classe){
		
		concatenarOctetos();
		boolean zero = false; //boolean indicando existência de 0s na máscara
		boolean invalida = false; //boolean indicando máscara inválida
			switch (classe){
			//valida máscara de acordo com cada classe
				case "CLASSE A":
					validarMascara(zero, invalida, "11111111");					
					break;
					
				case "CLASSE B":
					validarMascara(zero, invalida, "1111111111111111");
					break;
				case "CLASSE C":
					validarMascara(zero, invalida, "111111111111111111111111");
					break;
				case "CLASSE D":
					System.out.println("Máscara Classe D");
					break;
				case "CLASSE E":
					System.out.println("Máscara Clase E");
					break;
				default:
					System.out.println("Classe inválida.");
			}
			return invalida;
	}
}
