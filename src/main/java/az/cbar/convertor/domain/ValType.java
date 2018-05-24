package az.cbar.convertor.domain;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "ValType")
@XmlAccessorType(XmlAccessType.FIELD)
public class ValType
{

    @XmlElement(name = "Valute")
    private List<Valute> valute;

    @XmlAttribute(name = "Type")
    private String Type;

    public List<Valute> getValute() {
        return valute;
    }

    public void setValute(List<Valute> valute) {
        this.valute = valute;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ValType{");
        sb.append("valute=").append(valute);
        sb.append(", Type='").append(Type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
