package model;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cofradias")
public class CofradiaWrapper {
    private List<Cofradia> cofradias;

    public CofradiaWrapper() {}

    public CofradiaWrapper(List<Cofradia> cofradias) {
        this.cofradias = cofradias;
    }

    @XmlElement(name = "cofradia")
    public List<Cofradia> getCofradias() {
        return cofradias;
    }

    public void setCofradias(List<Cofradia> cofradias) {
        this.cofradias = cofradias;
    }
}

