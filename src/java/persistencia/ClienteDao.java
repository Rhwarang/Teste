package persistencia;
import entidade.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao extends Dao{
    
    public void cadastroCliente(Cliente c) throws Exception{
        abrirConexao();
        
        String sql = "INSERT INTO cliente VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
        stmt = con.prepareStatement(sql);
        stmt.setString  (1, c.getNome());
        stmt.setString  (2, c.getCpf());
        stmt.setString  (3, c.getRg());
        stmt.setDate    (4, c.getDataNascimento());
        stmt.setString  (5, c.getEmail());
        stmt.setString  (6, c.getTelefone());
        stmt.setString  (7, c.getCelular());
        stmt.execute();
        stmt.close();
        
        fecharConexao();
    }
    
    public List<Cliente> listarTodosCliente() throws Exception{
        abrirConexao();
        
        String sql = "SELECT * FROM cliente";
        stmt = con.prepareStatement(sql);
        rs = stmt.executeQuery();
        
        List<Cliente> dados = new ArrayList<>();
        
        while(rs.next()){
            Cliente c = new Cliente();
            c.setId                 (rs.getInt("id"));
            c.setNome               (rs.getString("nome"));
            c.setCpf                (rs.getString("cpf"));
            c.setRg                 (rs.getString("rg"));
            c.setDataNascimento     (rs.getDate("dataNascimento"));
            c.setEmail              (rs.getString("email"));
            c.setTelefone           (rs.getString("telefone"));
            c.setCelular            (rs.getString("celular"));
            dados.add(c);
        }
        fecharConexao();
        
        return dados;
    }
}
