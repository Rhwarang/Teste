package persistencia;
import entidade.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao extends Dao{
    
    public void cadastrarFuncionario(Funcionario f) throws Exception{
        abrirConexao();
        
        String sql = "INSERT INTO funcionario VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?)";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, f.getNome());
        stmt.setString(2, f.getCargo());
        stmt.setString(3, f.getCpf());
        stmt.setString(4, f.getRg());
        stmt.setDate(5, f.getDataNascimento());                
        stmt.setString(6, f.getEmail());
        stmt.setString(7, f.getTelefone());
        stmt.setString(8, f.getCelular());
        stmt.execute();
        
        fecharConexao();
    }
    
    public List<Funcionario> listarFuncionario() throws Exception{
        abrirConexao();
        
        String sql = "SELECT * FROM funcionario";
        stmt = con.prepareStatement(sql);
        rs = stmt.executeQuery();
        
        List<Funcionario> dados = new ArrayList<>();
        
        while(rs.next()){
            Funcionario f = new Funcionario();
            f.setId(rs.getInt("id"));
            f.setNome(rs.getString("nome"));
            f.setCargo(rs.getString("cargo"));
            f.setCpf(rs.getString("cpf"));
            f.setRg(rs.getString("rg"));
            f.setDataNascimento(rs.getDate("dataNascimento"));
            f.setEmail(rs.getString("email"));
            f.setTelefone(rs.getString("telefone"));
            f.setCelular(rs.getString("celular"));
            dados.add(f);
        }
        
        fecharConexao();
        
        return dados;
    }
    
    public List<Funcionario> listarFuncionarioById(int id) throws Exception{
        abrirConexao();
        
        String sql = "SELECT * FROM funcionario WHERE ID = ?";
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();

        List<Funcionario> dados = new ArrayList<>();

        while(rs.next()){
            Funcionario f = new Funcionario();
            f.setId(rs.getInt("id"));
            f.setNome(rs.getString("nome"));
            f.setCargo(rs.getString("cargo"));
            f.setCpf(rs.getString("cpf"));
            f.setRg(rs.getString("rg"));
            f.setDataNascimento(rs.getDate("dataNascimento"));
            f.setEmail(rs.getString("email"));
            f.setTelefone(rs.getString("telefone"));
            f.setCelular(rs.getString("celular"));
            dados.add(f);
        }
        
        fecharConexao();
        
        return dados;
    }
    
    public List<Funcionario> listarFuncionarioByNome(String nome) throws Exception{
        abrirConexao();
        
        String sql = "SELECT * FROM funcionario WHERE nome LIKE ?%";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, nome);
        rs = stmt.executeQuery();

        List<Funcionario> dados = new ArrayList<>();

        while(rs.next()){
            Funcionario f = new Funcionario();
            f.setId(rs.getInt("id"));
            f.setNome(rs.getString("nome"));
            f.setCargo(rs.getString("cargo"));
            f.setCpf(rs.getString("cpf"));
            f.setRg(rs.getString("rg"));
            f.setDataNascimento(rs.getDate("dataNascimento"));
            f.setEmail(rs.getString("email"));
            f.setTelefone(rs.getString("telefone"));
            f.setCelular(rs.getString("celular"));
            dados.add(f);
        }
        
        fecharConexao();
        
        return dados;
    }
}
