package bancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import aluno.Aluno;
import aluno.GerenciarAluno;
import disciplina.Disciplina;
import disciplina.GerenciarDisciplina;
import endereco.Endereco;
import java.sql.Statement;
import pessoa.Sexo;
import professor.GerenciarProfessor;
import professor.Professor;


public class bancoDados
{
    private String url,usuario,senha;
    private GerenciarAluno gerAluno;
    private GerenciarProfessor gerProfessor;
    private GerenciarDisciplina gerDisciplina;
    private boolean alunoPopulado = false;
    private boolean professorPopulado = false;
    private boolean disciplinaPopulado = false;

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
    
    public void setGerProfessor(GerenciarProfessor gp)
    {
        gerProfessor = gp;
        gp.setBancoDados(this);
    }
    
    public void setGerDisciplina(GerenciarDisciplina gd)
    {
        gerDisciplina = gd;
        gd.setBancoDados(this);
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

    public void populaProfessor()
    {
        if(!professorPopulado)
        {
            try 
            {
                Connection conexao = DriverManager.getConnection(url, usuario, senha);
                PreparedStatement declaracao = conexao.prepareStatement
                    ("select distinct nome,email,data_nascimento,sexo, pessoa.cpf,rg,rp,formacao,salario,departamento,cep,rua,bairro,numero,complemento\n" +
                    "from pessoa\n" +
                    "join professor on pessoa.cpf = professor.cpf\n" +
                    "join endereco on pessoa.cpf = endereco.cpf"           
                    );
                ResultSet resultado = declaracao.executeQuery();
                while(resultado.next())
                {
                    criaProfessor(resultado.getString(1),resultado.getDate(3),resultado.getString(5),resultado.getString(6),resultado.getString(2),resultado.getInt(7),resultado.getString(8),resultado.getInt(9),resultado.getString(10),resultado.getString(4),resultado.getString(13),resultado.getString(11),resultado.getString(15),resultado.getInt(14),resultado.getString(12));
                    professorPopulado = true;
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
    
    public boolean insereProfessor(Professor professor)
    {
        try(Connection conexao = DriverManager.getConnection(url, usuario, senha);
                Statement transacao = conexao.createStatement();)
        {
            transacao.execute("start transaction; ");
            PreparedStatement declaracao1 = conexao.prepareStatement
                ("insert into pessoa(nome,email,data_nascimento,sexo,cpf,rg) values(?,?,?,?,?,?);");
            PreparedStatement declaracao2 = conexao.prepareStatement
                ("insert into professor(rp,formacao,salario,departamento,cpf) values(?,?,?,?,?);");
            PreparedStatement declaracao3 = conexao.prepareStatement
                ("insert into endereco(cep,rua,bairro,numero,complemento,cpf) values(?,?,?,?,?,?);");
            declaracao1.setString(1,professor.getNome());
            declaracao1.setString(2,professor.getEmail());
            declaracao1.setDate(3,new java.sql.Date(professor.getDataNascimento().getTime()));
            if(professor.getSexo()== Sexo.MASCULINO)
                declaracao1.setString(4,"M");
            else
                declaracao1.setString(4,"F");
            declaracao1.setString(5,professor.getCpf());
            declaracao1.setString(6,professor.getRg());
            declaracao2.setInt(1,professor.getRp());
            declaracao2.setString(2,professor.getFormacao());
            declaracao2.setInt(3,professor.getSalario());
            declaracao2.setString(4,professor.getDepartamento());
            declaracao2.setString(5,professor.getCpf());
            declaracao3.setString(1,professor.getEndereco().getCep());
            declaracao3.setString(2,professor.getEndereco().getRua());
            declaracao3.setString(3,professor.getEndereco().getBairro());
            declaracao3.setInt(4,professor.getEndereco().getNumero());
            declaracao3.setString(5,professor.getEndereco().getComplemento());
            declaracao3.setString(6,professor.getCpf());
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
    
    public boolean updateProfessor(Professor professor)
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
                "where cpf = '" + professor.getCpf() + "' ");
            PreparedStatement declaracao2 = conexao.prepareStatement
                ("update professor " +
                "set rp = ?, " +
                "formacao = ?, " +
                "salario = ?, " +
                "departamento = ? " +
                "where cpf = '" + professor.getCpf() + "' ");
            PreparedStatement declaracao3 = conexao.prepareStatement
                ("update endereco " +
                "set cep = ?, " +
                "rua = ?, " +
                "bairro = ?, " +
                "numero = ?, " +
                "complemento = ? " +
                "where cpf = '" + professor.getCpf() + "' ");
            declaracao1.setString(1,professor.getNome());
            declaracao1.setString(2,professor.getEmail());
            declaracao1.setDate(3,new java.sql.Date(professor.getDataNascimento().getTime()));
            if(professor.getSexo()== Sexo.MASCULINO)
                declaracao1.setString(4,"M");
            else
                declaracao1.setString(4,"F");
            declaracao1.setString(5,professor.getRg());
            declaracao2.setInt(1,professor.getRp());
            declaracao2.setString(2,professor.getFormacao());
            declaracao2.setInt(3,professor.getSalario());
            declaracao2.setString(4,professor.getDepartamento());
            declaracao3.setString(1,professor.getEndereco().getCep());
            declaracao3.setString(2,professor.getEndereco().getRua());
            declaracao3.setString(3,professor.getEndereco().getBairro());
            declaracao3.setInt(4,professor.getEndereco().getNumero());
            declaracao3.setString(5,professor.getEndereco().getComplemento());
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
    
    public boolean removeProfessor(Professor professor)
    {
        try(Connection conexao = DriverManager.getConnection(url, usuario, senha);
            Statement transacao = conexao.createStatement();)
        {
            transacao.execute("start transaction; ");
            PreparedStatement declaracao1 = conexao.prepareStatement
                ("delete from pessoa where cpf = '" + professor.getCpf() + "' ");
            PreparedStatement declaracao2 = conexao.prepareStatement
                ("delete from professor where cpf = '" + professor.getCpf() + "' ");
            PreparedStatement declaracao3 = conexao.prepareStatement
                ("delete from endereco where cpf = '" + professor.getCpf() + "' ");
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
    
    public void criaProfessor(String nome, Date nasc, String cpf, String rg, String email, int rp, String formacao, int salario, String departamento, String sexo, String bairro, String cep, String compl, int numero, String rua)
    {
        Professor professor = new Professor();
        Endereco endereco = new Endereco();
        professor.setNome(nome);        
        professor.setDataNascimento(nasc);
        professor.setCpf(cpf);
        professor.setRg(rg);
        professor.setEmail(email);
        professor.setRp(rp);
        professor.setFormacao(formacao);
        professor.setSalario(salario);
        professor.setDepartamento(departamento);
        if (sexo.equals("M")) {
            professor.setSexo(Sexo.MASCULINO);
        } else {
            professor.setSexo(Sexo.FEMININO);
        }
        endereco.setBairro(bairro);
        endereco.setCep(cep);
        endereco.setComplemento(compl);
        endereco.setNumero(numero);
        endereco.setRua(rua);
        endereco.setId(professor.getId());
        professor.setEndereco(endereco);
        gerProfessor.create(professor);
    }
    
     public void populaDisciplina()
    {
        if(!disciplinaPopulado)
        {
            try 
            {
                Connection conexao = DriverManager.getConnection(url, usuario, senha);
                PreparedStatement declaracao = conexao.prepareStatement
                    ("select nome,codigo,bloco,sala,cargaHoraria,ementa,bibliografia from disciplina");
                ResultSet resultado = declaracao.executeQuery();
                while(resultado.next())
                {
                    criaDisciplina(resultado.getString(1),resultado.getString(2),resultado.getString(3),resultado.getInt(4),resultado.getInt(5),resultado.getString(6),resultado.getString(7));
                    disciplinaPopulado = true;
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
    
    public boolean insereDisciplina(Disciplina disciplina)
    {
        try(Connection conexao = DriverManager.getConnection(url, usuario, senha);)
        {
            PreparedStatement declaracao = conexao.prepareStatement
                ("insert into disciplina(nome,codigo,bloco,sala,cargaHoraria,ementa,bibliografia) values(?,?,?,?,?,?,?);");
            declaracao.setString(1,disciplina.getNome());
            declaracao.setString(2,disciplina.getCodigo());
            declaracao.setString(3,String.valueOf(disciplina.getBloco()));
            declaracao.setInt(4,disciplina.getSala());
            declaracao.setInt(5,disciplina.getCargaHoraria());
            declaracao.setString(6,disciplina.getEmenta());
            declaracao.setString(7,disciplina.getBibliografia());
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
    
    public boolean updateDisciplina(Disciplina disciplina)
    {
        try(Connection conexao = DriverManager.getConnection(url, usuario, senha);)
        {
            PreparedStatement declaracao = conexao.prepareStatement
                ("update disciplina "+
                "set nome = ?, " +
                "bloco = ?, " +
                "sala = ?, " +
                "cargaHoraria = ?, " +
                "ementa = ?, " +
                "bibliografia = ? " +
                "where codigo = '" + disciplina.getCodigo() + "' ");
            declaracao.setString(1,disciplina.getNome());
            declaracao.setString(2,String.valueOf(disciplina.getBloco()));
            declaracao.setInt(3,disciplina.getSala());
            declaracao.setInt(4,disciplina.getCargaHoraria());
            declaracao.setString(5,disciplina.getEmenta());
            declaracao.setString(6,disciplina.getBibliografia());
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
    
    public boolean removeDisciplina(Disciplina disciplina)
    {
        try(Connection conexao = DriverManager.getConnection(url, usuario, senha);)
        {
            PreparedStatement declaracao = conexao.prepareStatement
                ("delete from disciplina where codigo = '" + disciplina.getCodigo() + "' ");
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
    
    public void criaDisciplina(String nome, String codigo, String bloco, int sala, int cargaHoraria, String ementa, String bibliografia)
    {
        Disciplina disciplina = new Disciplina();
        disciplina.setNome(nome);        
        disciplina.setCodigo(codigo);
        disciplina.setBloco(bloco.charAt(0));
        disciplina.setSala(sala);
        disciplina.setCargaHoraria(cargaHoraria);
        disciplina.setEmenta(ementa);
        disciplina.setBibliografia(bibliografia);
        gerDisciplina.create(disciplina);
    }
}

