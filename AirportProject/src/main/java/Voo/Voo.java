/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Voo;

/**
 *
 * @author roger
 */
public class Voo implements Cloneable, Comparable<Voo>
{

    protected int numero;
    protected String destino;
    
    public Voo(int num, String dest) throws Exception
    {
        this.setNumero(num);
        this.setDestino(dest);
    }
    
    public void setNumero(int num) throws Exception
    {
        if(num <= 0)
            throw new Exception("número do voo inválido!");
        
        this.numero = num;
    }
    
    public void setDestino(String dest) throws Exception
    {
        if(dest == null || dest.equals(""))
            throw new Exception("aeroporto de destino não fornecido!");
        
        this.destino = dest;
    }
    
    public int getNumero()
    {
        return this.numero;
    }
    
    public String getDestino()
    {
        return this.destino;
    }
    
    @Override
    public String toString()
    {
        String ret = "";
        
        ret += "NÚMERO: " + this.numero + "\n";
        ret += "DESTINO: " + this.destino +"\n";
        
        return ret;
    }
    
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
    
    
    public Voo(Voo modelo) throws Exception
    {
        if(modelo == null)
            throw new Exception("Modelo não fornecido");
        
        this.numero = modelo.numero;
        this.destino = modelo.destino;
    }
    
    @Override
    public int compareTo(Voo outroVoo)
    {
        int ret = new Integer(this.numero).compareTo(outroVoo.numero);
        
        return ret;
    }
}
