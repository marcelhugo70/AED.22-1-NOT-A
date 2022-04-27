package arvores;
import java.security.InvalidParameterException;
public class NoArvoreBinaria<T>
{
    private T info;
    private NoArvoreBinaria<T> esq;
    private NoArvoreBinaria<T> dir;
    
    public NoArvoreBinaria(T info)
    {
        this.setInfo(info);
    }
    public NoArvoreBinaria(T info, NoArvoreBinaria<T> esq, NoArvoreBinaria<T> dir)
    {
        this(info);
        this.setEsq(esq);
        this.setDir(dir);
    }
    
    public T getInfo()
    {
        return info;
    }
    private void setInfo(T info)
    {
        if (info == null)
            throw new InvalidParameterException("Info não pode ser nulo");
        this.info = info;
    }
    public NoArvoreBinaria<T> getEsq()
    {
        return esq;
    }
    public void setEsq(NoArvoreBinaria<T> esq)
    {
        this.esq = esq;
    }
    public NoArvoreBinaria<T> getDir()
    {
        return dir;
    }
    public void setDir(NoArvoreBinaria<T> dir)
    {
        this.dir = dir;
    }
    
    public NoArvoreBinaria<T> pertenceDoNo(T info)
    {
        if (this.getInfo().equals(info))
            return this;
        
        if (this.esq != null)
        {
            NoArvoreBinaria<T> noEsq = this.esq.pertenceDoNo(info);
            if (noEsq != null)
                return noEsq;
        }
        if (this.dir != null)
        {
            NoArvoreBinaria<T> noDir = this.dir.pertenceDoNo(info);
            if (noDir != null)
                return noDir;
        }
        return null;
    }
    
    public String imprimePre()
    {
        String retorno = this.getInfo() + "<";
        if (this.getEsq() != null)
            retorno += this.getEsq().imprimePre();
        retorno += "><";
        if (this.getDir() != null)
            retorno += this.getDir().imprimePre();
        return retorno + ">";
    }
    
    public String toString()
    {
        return this.getInfo().toString();
    }
}
