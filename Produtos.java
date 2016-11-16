public class Produtos {
	private int idprodutos;
	private int produtosqtd;
	private String produtosdsc;
	private String produtosnome;
	
	public void setidprodutos(int idprodutos){
		   this.idprodutos = idprodutos;
		}

		public int getidprodutos(){
		   return this.idprodutos;
		}

		public void setprodutosnome(String produtosnome){
		   this.produtosnome = produtosnome;
		}

		public String getprodutosnome(){
		   return this.produtosnome;
		}

		public void setprodutosdsc(String  produtosdsc){
		   this.produtosdsc =  produtosdsc;
		}

		public String getprodutosdsc(){
		   return this.produtosdsc;
		}
		
		public void setprodutosqtd(int produtosqtd){
			   this.produtosqtd =  produtosqtd;
		}

		public int getprodutosqtd(){
		   return this.produtosqtd;
		}
	
}
