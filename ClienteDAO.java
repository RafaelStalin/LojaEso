import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;


public class ClienteDAO{

private Connection con;
public ClienteDAO(Connection con){
   this.con = con;
}

public void cadastrar(Clientes cliente) throws Exception {
   PreparedStatement c = con.prepareStatement("insert into clientes (clientesnome, clientesemail, clientescpf, clientestel) values (?,?,?,?)");
   c.setString(1, cliente.getclientesnome());
   c.setString(2, cliente.getclientesemail());
   c.setInt(3, cliente.getclientescpf());
   c.setInt(4, cliente.getclientestel());
   c.executeUpdate();
   c.close();
}

public void deletar(Clientes cliente) throws Exception {
   PreparedStatement c = con.prepareStatement("delete from clientes where idclientes = ?");
   c.setInt(1, cliente.getidclientes());
   c.executeUpdate();
   c.close();
}

public void update(Clientes cliente) throws Exception {
   PreparedStatement c = 
   con.prepareStatement("update clientes set clientesnome = ?, clientesemail = ?,  clientescpf = ?, clientestel = ? where idclientes = ?");
   c.setString(1, cliente.getclientesnome());
   c.setString(2, cliente.getclientesemail());
   c.setInt(3, cliente.getclientescpf());
   c.setInt(4, cliente.getclientestel());
   c.setInt(5, cliente.getidclientes());
   c.executeUpdate();
   c.close();
}


public List<Clientes> listarTodos() throws Exception{
   List<Clientes> listaClientes = new ArrayList<Clientes>();
   PreparedStatement c = con.prepareStatement("select * from clientes");
   ResultSet rs = c.executeQuery();
   while(rs.next()){
      Clientes cliente = new Clientes();
      cliente.setidclientes(rs.getInt("idclientes"));
      cliente.setclientesnome(rs.getString("clientesnome"));
      cliente.setclientesemail(rs.getString("clientesemail"));
      cliente.setclientescpf(rs.getInt("clientescpf"));
      cliente.setclientestel(rs.getInt("clientestel"));
      listaClientes.add(cliente);
   }
   rs.close();
   c.close();
   return listaClientes;
}

}
