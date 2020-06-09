package Aeroporto;

import Lista.*;
import Voo.*;

/**
 * Esta classe representa um aeroporto.
 * 
 * @author Antônio Hideto Borges Kotsubo.
 * @author Nícolas Maisonnette Duarte.
 */
public class Aeroporto implements Cloneable, Comparable<Aeroporto>
{
 
    /**
     * Variável String que indica o código do aeroporto.
     */
    protected String codigo;
    /**
     * Variável String que indica a cidade do aeroporto.
     */
    protected String cidade;
    /**
     * Variável ListaDuplamenteLigadaOrdenadaSemRepeticao que indica os voos do aeroporto.
     */
    protected ListaDuplamenteLigadaOrdenadaSemRepeticao<Voo> voos;
    
    /**
     * Construtor da classe.
     * 
     * @param cod         Representa o código do aeroporto, abreviação do nome do aeroporto.
     * @param cid         Representa a cidade na qual o aeroporto se localiza.
     * @param voos        Representa a lista de todos os voos desse aeroporto.
     * @throws Exception  Caso alguma operação de errado.
     */
    
    public Aeroporto(String cod, String cid, ListaDuplamenteLigadaOrdenadaSemRepeticao voos) throws Exception
    {
        this.setCodigo(cod);
        this.setCidade(cid);
        this.setVoos(voos);
    }
    
    /**
     * Este método insere/altera o código de um aeroporto.
     * 
     * @param cod         Representa o código de um aeroporto, abreviação do nome do aeroporto.
     * @throws Exception  Caso o código seja nulo ou igual a cadeia vazia.
     */
 
    public void setCodigo(String cod) throws Exception
    {
        if(cod == null || cod.equals(""))
            throw new Exception("código não fornecido!");
        
        this.codigo = cod;
    }
    
    /**
     * Este método insere/altera a cidade a qual um aeroporto pertence.
     * 
     * @param cid         Representa a cidade de um aeroporto.
     * @throws Exception  Caso o nome da cidade seja nulo ou igual a cadeia vazia.
     */
    
    public void setCidade(String cid) throws Exception
    {
        if(cid == null || cid.equals(""))
            throw new Exception("cidade não fornecida!");
        
        this.cidade = cid;
    }
    
    /**
     * Este método insere/altera a lista de voos de um aeroporto.
     * 
     * @param voos        Representa uma lista de voos.
     * @throws Exception  Caso a lista seja nula.
     */
    
    public void setVoos(ListaDuplamenteLigadaOrdenadaSemRepeticao<Voo> voos) throws Exception
    {
        if(voos == null)
            throw new Exception("lista de voos não fornecida!");
        
        this.voos = voos;
    }
    
    /**
     * Retorna um código de aeroporto.
     * 
     * @return Retorna o código do aeroporto.
     */
    
    public String getCodigo()
    {
        return this.codigo;
    }
    
    /**
     * Retorna o nome da cidade de um aeroporto.
     * 
     * @return Retorna o nome da cidade do aeroporto.
     */
    
    public String getCidade()
    {
        return this.cidade;
    }
    
    /**
     * Retorna a lista de voos de um aeroporto.
     * 
     * @return Retorna a lista de voos do aeroporto.
     */
    
    public ListaDuplamenteLigadaOrdenadaSemRepeticao<Voo> getVoos()
    {
        return this.voos;
    }
    
    /**
     * Converte todos os atributos de um aeroporto em uma cadeia de caractéres.
     * 
     * @return Retorna os atributos em formato de uma cadeia de caractéres.
     */
    
    @Override
    public String toString()
    {
        String ret = "";
        
        ret += "AEROPORTO: " + this.codigo + "\n";
        ret += "CIDADE: " + this.cidade + "\n";
        ret += "VOOS: " + this.voos + "\n";
        
        return ret;
    }
    
    /**
     * Compara dois aeroportos para ver se são iguais.
     * 
     * @param obj   Representa o outro aeroporto a ser comparado.
     * @return      Retorna true, se forem iguais; false, se forem diferentes.
     */
    
    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;
        
        if(obj == this)
            return true;
        
        if(obj.getClass() != this.getClass())
            return false;
        
        Aeroporto aero = (Aeroporto)obj;
        
        if(!aero.getCodigo().equals(this.getCodigo()) || !aero.getCidade().equals(this.getCidade()) || !aero.getVoos().equals(this.getVoos()))
             return false;
        
        return true;
    }
    
    /**
     * Calcula o hashcode de um aeroporto.
     * 
     * @return Retorna o valor do hashcode do aeroporto.
     */
    
    @Override
    public int hashCode()
    {
        int ret = 666;
        
        ret = ret * 11 + this.codigo.hashCode();
        ret = ret * 11 + this.cidade.hashCode();
        ret = ret * 11 + this.voos.hashCode();
        
       if(ret < 0)
           ret = -ret;
       
       return ret;
    }
    
    /**
     * Clona um aeroporto.
     * 
     * @return Retorna uma cópia de um aeroporto.
     */
    
    @Override
    public Object clone()
    {
        Aeroporto ret = null;
        
        try
        {
            ret = new Aeroporto(this);
        }
        catch(Exception erro)
        {
            
        }
        
        return ret;
    }
    
    /**
     * Construtor de cópia.
     * 
     * @param modelo       Representa um aeroporto modelo que será copiado.
     * @throws Exception   Caso o aeroporto modelo seja nulo.
     */
    
    public Aeroporto (Aeroporto modelo) throws Exception
    {
        if(modelo == null)
            throw new Exception("Modelo não fornecido");
        
        this.codigo = modelo.codigo;
        this.cidade = modelo.cidade;
        this.voos = modelo.voos;
    }
    
    /**
     * Compara dois aeroportos através dos códigos.
     * 
     * @param outroAeroporto    Representa um outro aeroporto cujo código será comparado.
     * @return                  Retorna um inteiro menor que zero, maior que zero ou igual a zero.
     */
    
    @Override
    public int compareTo(Aeroporto outroAeroporto)
    {
        int ret = this.codigo.compareTo(outroAeroporto.codigo);
        
        return ret;
    }
}
