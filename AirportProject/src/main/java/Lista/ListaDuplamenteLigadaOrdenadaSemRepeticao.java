package Lista;

public class ListaDuplamenteLigadaOrdenadaSemRepeticao <X extends Comparable<X>> extends ListaDuplamenteLigadaOrdenada<X>
{

    // PASSADO
    // PARA
    // REVISAR
    // TUDO,
    // TUDINHO
    // MESMO,
    // DAQUI
    // PARA
    // FRENTE;
    // REVISADO!!!

	//construtores nunca sao herdados, exceto o construtor padrão, e isso quando não houver mais nenhum outro construtor
	public ListaDuplamenteLigadaOrdenadaSemRepeticao ()
	{
		super ();
	}
	
	public void insira (X i) throws Exception
	{
		if (super.tem(i))
		    throw new Exception ("Informacao repetida");
		    
		super.insira (i);
	}
		
	//métodos herdados de Object (toString, equals e hashCode) não precisam
	//ser reimplementados, pois a classe não tem nenhum atributo além dos
	//que foram herdados.

	//construtores nunca sao herdados, exceto o construtor padrão, e isso quando não houver mais nenhum outro construtor
	public ListaDuplamenteLigadaOrdenadaSemRepeticao (ListaDuplamenteLigadaOrdenadaSemRepeticao<X> modelo) throws Exception
	{
		super (modelo);
	}
	
	// clone precisa ser reimplementado em virtude do tipo do objeto retornado
    public Object clone ()
    {
        ListaDuplamenteLigadaOrdenadaSemRepeticao<X> ret=null;

        try
        {
            ret = new ListaDuplamenteLigadaOrdenadaSemRepeticao<X> (this);
        }
        catch (Exception erro)
        {} // sei que this NUNCA é null e o contrutor de copia da erro quando seu parametro é null

        return ret;
    }
}
