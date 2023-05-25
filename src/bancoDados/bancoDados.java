package bancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import aluno.Aluno;
import aluno.GerenciarAluno;
import endereco.Endereco;
import java.sql.Statement;
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
                    ("select distinct nome,email,data_nascimento,sexo, pessoa.cpf,rg,ra,periodo,ano,cep,rua,bairro,numero,complemento\n" +
                    "from pessoa\n" +
                    "join aluno on pessoa.cpf = aluno.cpf\n" +
                    "join endereco on pessoa.cpf = endereco.cpf"           
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
        try(Connection conexao = DriverManager.getConnection(url, usuario, senha);
                Statement transacao = conexao.createStatement();)
            {
                transacao.execute("start transaction; ");
                PreparedStatement declaracao1 = conexao.prepareStatement
                    ("insert into pessoa(nome,email,data_nascimento,sexo,cpf,rg) values(?,?,?,?,?,?);");
                PreparedStatement declaracao2 = conexao.prepareStatement
                    ("insert into aluno(ra,periodo,ano,cpf) values(?,?,?,?);");
                PreparedStatement declaracao3 = conexao.prepareStatement
                    ("insert into endereco(cep,rua,bairro,numero,complemento,cpf) values(?,?,?,?,?,?);");
                declaracao1.setString(1,aluno.getNome());
                declaracao1.setString(2,aluno.getEmail());
                declaracao1.setDate(3,new java.sql.Date(aluno.getDataNascimento().getTime()));
                if(aluno.getSexo()== Sexo.MASCULINO)
                    declaracao1.setString(4,"M");
                else
                    declaracao1.setString(4,"F");
                declaracao1.setString(5,aluno.getCpf());
                declaracao1.setString(6,aluno.getRg());
                declaracao2.setInt(1,aluno.getRa());
                declaracao2.setString(2,aluno.getPeriodo());
                declaracao2.setString(3,aluno.getAno());
                declaracao2.setString(4,aluno.getCpf());
                declaracao3.setString(1,aluno.getEndereco().getCep());
                declaracao3.setString(2,aluno.getEndereco().getRua());
                declaracao3.setString(3,aluno.getEndereco().getBairro());
                declaracao3.setInt(4,aluno.getEndereco().getNumero());
                declaracao3.setString(5,aluno.getEndereco().getComplemento());
                declaracao3.setString(6,aluno.getCpf());
                declaracao1.executeUpdate();
                declaracao2.executeUpdate();
                declaracao3.executeUpdate();
                Statement commit = conexao.createStatement();
                commit.execute("COMMIT; ");
                transacao.close();
                declaracao1.close();
                declaracao2.close();
                declaracao3.close();
                commit.close();
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
        try(Connection conexao = DriverManager.getConnection(url, usuario, senha);
            Statement transacao = conexao.createStatement();)
        {
            transacao.execute("start transaction; ");
            PreparedStatement declaracao1 = conexao.prepareStatement
                ("update pessoa "+
                "set nome = ?, " +
                "email = ?, " +
                "data_nascimento = ?, " +
                "sexo = ?, " +
                "rg = ? " +
                "where cpf = '" + aluno.getCpf() + "' ");
            PreparedStatement declaracao2 = conexao.prepareStatement
                ("update aluno " +
                "set ra = ?, " +
                "periodo = ?, " +
                "ano = ? " +
                "where cpf = '" + aluno.getCpf() + "' ");
            PreparedStatement declaracao3 = conexao.prepareStatement
                ("update endereco " +
                "set cep = ?, " +
                "rua = ?, " +
                "bairro = ?, " +
                "numero = ?, " +
                "complemento = ? " +
                "where cpf = '" + aluno.getCpf() + "' ");
            declaracao1.setString(1,aluno.getNome());
            declaracao1.setString(2,aluno.getEmail());
            declaracao1.setDate(3,new java.sql.Date(aluno.getDataNascimento().getTime()));
            if(aluno.getSexo()== Sexo.MASCULINO)
                declaracao1.setString(4,"M");
            else
                declaracao1.setString(4,"F");
            declaracao1.setString(5,aluno.getRg());
            declaracao2.setInt(1,aluno.getRa());
            declaracao2.setString(2,aluno.getPeriodo());
            declaracao2.setString(3,aluno.getAno());
            declaracao3.setString(1,aluno.getEndereco().getCep());
            declaracao3.setString(2,aluno.getEndereco().getRua());
            declaracao3.setString(3,aluno.getEndereco().getBairro());
            declaracao3.setInt(4,aluno.getEndereco().getNumero());
            declaracao3.setString(5,aluno.getEndereco().getComplemento());
            declaracao3.executeUpdate();
            declaracao2.executeUpdate();
            declaracao1.executeUpdate();
            Statement commit = conexao.createStatement();
            commit.execute("COMMIT; ");
            transacao.close();
            declaracao1.close();
            declaracao2.close();
            declaracao3.close();
            commit.close();
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
        try(Connection conexao = DriverManager.getConnection(url, usuario, senha);
            Statement transacao = conexao.createStatement();)
            {
                transacao.execute("start transaction; ");
                PreparedStatement declaracao1 = conexao.prepareStatement
                    ("delete from pessoa where cpf = '" + aluno.getCpf() + "' ");
                PreparedStatement declaracao2 = conexao.prepareStatement
                    ("delete from aluno where cpf = '" + aluno.getCpf() + "' ");
                PreparedStatement declaracao3 = conexao.prepareStatement
                    ("delete from endereco where cpf = '" + aluno.getCpf() + "' ");
                declaracao3.executeUpdate();
                declaracao2.executeUpdate();
                declaracao1.executeUpdate();
                Statement commit = conexao.createStatement();
                commit.execute("COMMIT; ");
                transacao.close();
                declaracao1.close();
                declaracao2.close();
                declaracao3.close();
                commit.close();
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

