package ChIP_Seq.bean;

/**
 * Created by lily on 11/3/16.
 */
public class iPAGEBean {
    private String expfile;
    private String species;
    private String type;

    public String getExpfile() {
        return expfile;
    }

    public void setExpfile(String expfile) {
        this.expfile = expfile;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
