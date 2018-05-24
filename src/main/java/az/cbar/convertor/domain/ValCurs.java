package az.cbar.convertor.domain;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "ValCurs")
@XmlAccessorType(XmlAccessType.FIELD)
public class ValCurs
{
    @XmlAttribute(name = "Name")
    private String Name;
    @XmlAttribute(name = "Description")
    private String Description;

    @XmlElement(name = "ValType")
    private List<ValType> ValType;

    @XmlAttribute(name = "Date")
    private String Date;

    public ValCurs() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public List<az.cbar.convertor.domain.ValType> getValType() {
        return ValType;
    }

    public void setValType(List<az.cbar.convertor.domain.ValType> valType) {
        ValType = valType;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ValCurs{");
        sb.append("Name='").append(Name).append('\'');
        sb.append(", Description='").append(Description).append('\'');
        sb.append(", ValType=").append(ValType);
        sb.append(", Date='").append(Date).append('\'');
        sb.append('}');
        return sb.toString();
    }
}