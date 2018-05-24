package az.cbar.convertor.domain;

public class Response
{
    private ValCurs ValCurs;

    public ValCurs getValCurs ()
    {
        return ValCurs;
    }

    public void setValCurs (ValCurs ValCurs)
    {
        this.ValCurs = ValCurs;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ValCurs = "+ValCurs+"]";
    }
}