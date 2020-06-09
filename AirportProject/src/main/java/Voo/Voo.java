package Voo;

/**
 * Esta classe representa um voo.
 * 
 * @author Antônio Hideto Borges Kotsubo.
 * @author Nícolas Maisonnette Duarte.
 */
public class Voo implements Cloneable, Comparable<Voo>
{

    protected int numero;
    protected String destino;
    
    /**
     * Construtor.
     * 
     * @param num          Representa o número do voo.
     * @param dest         Representa o a cidade destino do voo.
     * @throws Exception   Caso alguma operação dê errado.
     */
    
    public Voo(int num, String dest) throws Exception
    {
        this.setNumero(num);
        this.setDestino(dest);
    }
    
    /**
     * Este método insere/altera o número de um voo.
     * 
     * @param num           Representa o número do voo.
     * @throws Exception    Caso o número seja menor ou igual a zero.
     */
    public void setNumero(int num) throws Exception
    {
        if(num <= 0)
            throw new Exception("número do voo inválido!");
        
        this.numero = num;
    }
    
    /**
     * Este método insere/altera a cidade destino de um voo.
     * 
     * @param dest          Representa acidade destino de um voo.
     * @throws Exception    Caso a cidade destino seja nula ou igual a cadeia vazia.
     */
    public void setDestino(String dest) throws Exception
    {
        if(dest == null || dest.equals(""))
            throw new Exception("aeroporto de destino não fornecido!");
        
        this.destino = dest;
    }
    
    /**
     * Retorna o número de um voo.
     * 
     * @return  Retorna o número do voo.
     */
    
    public int getNumero()
    {
        return this.numero;
    }
    
    /**
     * Retorna a cidade destino de um voo.
     * 
     * @return  Retorna a cidade destino do voo.
     */
    
    public String getDestino()
    {
        return this.destino;
    }
    
    /**
     * Converte todos os atributos de um voo em uma cadeia de caractéres.
     * 
     * @return Retorna os atributos em formato de uma cadeia de caractéres.
     */
    
    @Override
    public String toString()
    {
        String ret = "";
        
        ret += "NÚMERO: " + this.numero + "\n";
        ret += "DESTINO: " + this.destino +"\n";
        
        return ret;
    }
    
    /**
     * Compara dois voos para ver se são iguais.
     * 
     * @param obj   Representa o outro voo a ser comparado.
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
        
        Voo voo = (Voo)obj;
        if(voo.getNumero() != this.getNumero() || !voo.getDestino().equals(this.getDestino()))
            return false;
        
        return true;
    }
    
    /**
     * Calcula o hashcode de um voo.
     * 
     * @return Retorna o valor do hashcode do voo.
     */
    
    @Override
    public int hashCode()
    {
        int ret = 666;
        
        ret = ret * 11 + new Integer(this.numero).hashCode();
        ret = ret * 11 + this.destino.hashCode();
        
        if(ret < 0)
            ret = -ret;
        
        return ret;
    }
    
    /**
     * Clona um voo.
     * 
     * @return Retorna uma cópia de um voo.
     */
    
    @Override
    public Object clone()
    {
        Voo ret = null;
        
        try
        {
            ret = new Voo(this);
        }
        catch(Exception erro)
        {
        }
        
        return ret;
    }
    
     /**
     * Construtor de cópia.
     * 
     * @param modelo       Representa um voo modelo que será copiado.
     * @throws Exception   Caso o voo modelo seja nulo.
     */
    
    public Voo(Voo modelo) throws Exception
    {
        if(modelo == null)
            throw new Exception("Modelo não fornecido");
        
        this.numero = modelo.numero;
        this.destino = modelo.destino;
    }
    
    /**
     * Compara dois voos através dos códigos.
     * 
     * @param outroVoo    Representa um outro voo cujo código será comparado.
     * @return            Retorna um inteiro menor que zero, maior que zero ou igual a zero.
     */
    
    @Override
    public int compareTo(Voo outroVoo)
    {
        int ret = new Integer(this.numero).compareTo(outroVoo.numero);
        
        return ret;
    }
}
