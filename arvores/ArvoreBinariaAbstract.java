package arvores;

public abstract class ArvoreBinariaAbstract<T> {
    private NoArvoreBinaria<T> raiz;
    
    public ArvoreBinariaAbstract() {};
    
    public NoArvoreBinaria<T> getRaiz()
    {
        return raiz;
    }
    protected void setRaiz(NoArvoreBinaria<T> no)
    {
        this.raiz = no;
    }
    public NoArvoreBinaria<T> pertence(T info)
    {
        if (this.vazia())
            return null;
        return raiz.pertenceDoNo(info);
    }
    
    public boolean vazia()
    {
        return this.getRaiz() == null;
    }
    public String toString()
    {
        String retorno = "<";
        if (this.getRaiz() != null)
            retorno += this.getRaiz().imprimePre();
        return retorno + ">";
    }
}