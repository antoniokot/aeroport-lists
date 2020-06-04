/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aeroporto;

import Lista.*;
import Voo.*;

/**
 *
 * @author roger
 */
public class Aeroporto implements Cloneable, Comparable<Aeroporto>
{
 
    protected String codigo;
    protected String cidade;
    protected ListaDuplamenteLigadaOrdenadaSemRepeticao<Voo> voos;
    
    public Aeroporto(String cod, String cid, ListaDuplamenteLigadaOrdenadaSemRepeticao voos) throws Exception
    {
        this.setCodigo(cod);
        this.setCidade(cid);
        this.setVoos(voos);
    }
    
    public void setCodigo(String cod) throws Exception
    {
        if(cod.equals(""))
            throw new Exception("Código não fornecido");
        
        this.codigo = cod;
    }
    
    public void setCidade(String cid) throws Exception
    {
        if(cid.equals(""))
            throw new Exception("Cidade não fornecida");
        
        this.cidade = cid;
    }
    
    public void setVoos(ListaDuplamenteLigadaOrdenadaSemRepeticao<Voo> voos) throws Exception
    {
        if(voos == null)
            throw new Exception("Lista de voos não fornecida");
        
        this.voos = voos;
    }
    
    public String getCodigo()
    {
        return this.codigo;
    }
    
    public String getCidade()
    {
        return this.cidade;
    }
    
    public ListaDuplamenteLigadaOrdenadaSemRepeticao<Voo> getVoos()
    {
        return this.voos;
    }
    
    @Override
    public String toString()
    {
        String ret = "";
        
        ret += "AEROPORTO: " + this.codigo + "\n";
        ret += "CIDADE: " + this.cidade + "\n";
        ret += "VOOS: " + this.voos + "\n";
        
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
        
        Aeroporto aero = (Aeroporto)obj;
        
        if(!aero.getCodigo().equals(this.getCodigo()) || !aero.getCidade().equals(this.getCidade()) || !aero.getVoos().equals(this.getVoos()))
             return false;
        
        return true;
    }
    
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
    
    public Aeroporto (Aeroporto modelo) throws Exception
    {
        if(modelo == null)
            throw new Exception("Modelo não fornecido");
        
        this.codigo = modelo.codigo;
        this.cidade = modelo.cidade;
        this.voos = modelo.voos;
    }
    
    @Override
    public int compareTo(Aeroporto outroAeroporto)
    {
        int ret = this.codigo.compareTo(outroAeroporto.codigo);
        
        return ret;
    }
}
