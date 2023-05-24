package bancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import aluno.Aluno;
import aluno.GerenciarAluno;
import endereco.Endereco;
import pessoa.Sexo;


public class bancoDados
{
    private String url,usuario,senha;
    private GerenciarAluno gerAluno;
    private boolean alunoPopulado = false;

    public bancoDados(String u, String us, String s)
    {
        url = u;
        usuario = us;
        senha = s;
    }

    public void setGerAluno(GerenciarAluno ga)
    {
        gerAluno = ga;
        ga.setBancoDados(this);
    }

    public void populaAluno()
    {
        if(!alunoPopulado)
        {
            try 
            {
                Connection conexao = DriverManager.getConnection(url, usuario, senha);
                PreparedStatement declaracao = conexao.prepareStatement
                    ("select * " +
                    "from aluno "            
                    );
                ResultSet resultado = declaracao.executeQuery();
                while(resultado.next())
                {
                    criaAluno(resultado.getString(1),resultado.getDate(3),resultado.getString(5),resultado.getString(6),resultado.getString(2),resultado.getInt(7),resultado.getString(8),resultado.getString(9),resultado.getString(4),resultado.getString(12),resultado.getString(10),resultado.getString(14),resultado.getInt(13),resultado.getString(11));
                    alunoPopulado = true;
                }
                declaracao.close();
                conexao.close();
            } 
            catch (Exception e) 
            {
                System.out.println(e);
            }
        }
    }

    public boolean insereAluno(Aluno aluno)
    {
        try 
            {
                Connection conexao = DriverManager.getConnection(url, usuario, senha);
                PreparedStatement declaracao = conexao.prepareStatement
                    ("insert into aluno values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                declaracao.setString(1,aluno.getNome());
                declaracao.setString(2,aluno.getEmail());
                declaracao.setDate(3,new java.sql.Date(aluno.getDataNascimento().getTime()));
                if(aluno.getSexo()== Sexo.MASCULINO)
                    declaracao.setString(4,"M");
                else
                    declaracao.setString(4,"F");
                declaracao.setString(5,aluno.getCpf());
                declaracao.setString(6,aluno.getRg());
                declaracao.setInt(7,aluno.getRa());
                declaracao.setString(8,aluno.getPeriodo());
                declaracao.setString(9,aluno.getAno());
                declaracao.setString(10,aluno.getEndereco().getCep());
                declaracao.setString(11,aluno.getEndereco().getRua());
                declaracao.setString(12,aluno.getEndereco().getBairro());
                declaracao.setInt(13,aluno.getEndereco().getNumero());
                declaracao.setString(14,aluno.getEndereco().getComplemento());
                declaracao.executeUpdate();
                declaracao.close();
                conexao.close();
                return true;
            } 
            catch (Exception e) 
            {
                System.out.println(e);
                return false;
            }
    }

    public boolean updateAluno(Aluno aluno)
    {
        try 
        {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            PreparedStatement declaracao = conexao.prepareStatement
                ("update aluno "+
                "set nome = ?, " +
                "email = ?, " +
                "data_nascimento = ?, " +
                "sexo = ?, " +
                "cpf = ?, " +
                "rg = ?, " +
                "ra = ?, " +
                "periodo = ?, " +
                "ano = ?, " +
                "cep = ?, " +
                "rua = ?, " +
                "bairro = ?, " +
                "numero = ?, " +
                "complemento = ? " +
                "where ra = " + aluno.getRa()
                );
            declaracao.setString(1,aluno.getNome());
            declaracao.setString(2,aluno.getEmail());
            declaracao.setDate(3,new java.sql.Date(aluno.getDataNascimento().getTime()));
            if(aluno.getSexo()== Sexo.MASCULINO)
                declaracao.setString(4,"M");
            else
                declaracao.setString(4,"F");
            declaracao.setString(5,aluno.getCpf());
            declaracao.setString(6,aluno.getRg());
            declaracao.setInt(7,aluno.getRa());
            declaracao.setString(8,aluno.getPeriodo());
            declaracao.setString(9,aluno.getAno());
            declaracao.setString(10,aluno.getEndereco().getCep());
            declaracao.setString(11,aluno.getEndereco().getRua());
            declaracao.setString(12,aluno.getEndereco().getBairro());
            declaracao.setInt(13,aluno.getEndereco().getNumero());
            declaracao.setString(14,aluno.getEndereco().getComplemento());
            //declaracao.setInt(15,aluno.getRa());
            declaracao.executeUpdate();
            declaracao.close();
            conexao.close();
            return true;
        } 
        catch (Exception e) 
        {
            System.out.println(e);
            return false;
        }
    }

    public boolean removeAluno(Aluno aluno)
    {
        try 
            {
                Connection conexao = DriverManager.getConnection(url, usuario, senha);
                PreparedStatement declaracao = conexao.prepareStatement
                    ("delete from aluno where ra = " + aluno.getRa());
                declaracao.executeUpdate();
                declaracao.close();
                conexao.close();
                return true;
            } 
            catch (Exception e) 
            {
                System.out.println(e);
                return false;
            }
    }

    public void criaAluno(String nome, Date nasc, String cpf, String rg, String email, int ra, String per, String ano, String sexo, String bairro, String cep, String compl, int numero, String rua)
    {
        Aluno aluno = new Aluno();
        Endereco endereco = new Endereco();
        aluno.setNome(nome);        
        aluno.setDataNascimento(nasc);
        aluno.setCpf(cpf);
        aluno.setRg(rg);
        aluno.setEmail(email);
        aluno.setRa(ra);
        aluno.setPeriodo(per);
        aluno.setAno(ano);
        if (sexo.equals("M")) {
            aluno.setSexo(Sexo.MASCULINO);
        } else {
            aluno.setSexo(Sexo.FEMININO);
        }
        endereco.setBairro(bairro);
        endereco.setCep(cep);
        endereco.setComplemento(compl);
        endereco.setNumero(numero);
        endereco.setRua(rua);
        endereco.setId(aluno.getId());
        aluno.setEndereco(endereco);
        gerAluno.create(aluno);
    }

    // public boolean busca(String id, Livro l)
    // {
    //     try 
    //     {
    //         Connection conexao = DriverManager.getConnection(url, usuario, senha);
    //         PreparedStatement declaracao = conexao.prepareStatement
    //             ("select * " +
    //             "from livros " +
    //             "where LIVRO_ID = ?"            
    //             );
    //         declaracao.setString(1, id);
    //         ResultSet resultado = declaracao.executeQuery();
    //         if(resultado.next())
    //         {
    //             l.setValores(resultado.getString(1),resultado.getString(2),resultado.getString(3),resultado.getString(4),resultado.getString(5),resultado.getString(6),resultado.getString(7),resultado.getString(8),resultado.getString(9),resultado.getString(10),resultado.getString(11));
    //             InputStream is = resultado.getBlob(12).getBinaryStream();
    //             l.setCapa(is);
    //         }
    //         declaracao.close();
    //         conexao.close();
    //         return true;
    //     } 
    //     catch (Exception e) 
    //     {
    //         System.out.println(e);
    //         return false;
    //     }
    // }

}

