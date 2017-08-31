package ChIP_Seq.bean;

/**
 * Created by lily on 7/24/16.
 */
public class SubreadBean {
    private String reference;
    private String read_single;
    private String read_1;
    private String read_2;
    private String path;
    private int read_type;
    private String option_index;
    private String option_align;
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getRead_single() {
        return read_single;
    }

    public void setRead_single(String read_single) {
        this.read_single = read_single;
    }

    public String getRead_1() {
        return read_1;
    }

    public void setRead_1(String read_1) {
        this.read_1 = read_1;
    }

    public String getRead_2() {
        return read_2;
    }

    public void setRead_2(String read_2) {
        this.read_2 = read_2;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getRead_type() {
        return read_type;
    }

    public void setRead_type(int read_type) {
        this.read_type = read_type;
    }

    public String getOption_index() {
        return option_index;
    }

    public void setOption_index(String option_index) {
        this.option_index = option_index;
    }

    public String getOption_align() {
        return option_align;
    }

    public void setOption_align(String option_align) {
        this.option_align = option_align;
    }
}
