import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;


public class ProdutoDAO{

private Connection con;
public ProdutoDAO(Connection con){
   this.con = con;
}

public void cadastrar(Produtos produto) throws Exception {
   PreparedStatement p = con.prepareStatement("insert into produtos (produtosnome, produtosdsc, produtosqtd) values (?,?,?)");
   p.setString(1, produto.getprodutosnome());
   p.setString(2, produto.getprodutosdsc());
   p.setInt(3, produto.getprodutosqtd());
   p.executeUpdate();
   p.close();
}

public void deletar(Produtos produto) throws Exception {
   PreparedStatement p = con.prepareStatement("delete from produtos where idprodutos = ?");
   p.setInt(1, produto.getidprodutos());
   p.executeUpdate();
   p.close();
}

public void update(Produtos produto) throws Exception {
   PreparedStatement p = 
   con.prepareStatement("update produtos set produtosnome = ?, produtosdsc = ?,  produtosqtd = ? where idprodutos = ?");
   p.setString(1, produto.getprodutosnome());
   p.setString(2, produto.getprodutosdsc());
   p.setInt(3, produto.getprodutosqtd());
   p.setInt(4, produto.getidprodutos());
   p.executeUpdate();
   p.close();
}

public List<Produtos> listarTodos() throws Exception{
   List<Produtos> listaProdutos = new ArrayList<Produtos>();
   PreparedStatement p = con.prepareStatement("select * from produtos");
   ResultSet rs = p.executeQuery();
   while(rs.next()){
      Produtos produto = new Produtos();
      produto.setidprodutos(rs.getInt("idprodutos"));
      produto.setprodutosnome(rs.getString("produtosnome"));
      produto.setprodutosdsc(rs.getString("produtosdsc"));
      produto.setprodutosqtd(rs.getInt("produtosqtd"));
      listaProdutos.add(produto);
   }
   rs.close();
   p.close();
   return listaProdutos;
}

}
