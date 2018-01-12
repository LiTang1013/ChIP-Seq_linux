package ChIP_Seq.bean;

/**
 * Created by lily on 7/26/16.
 */
public class NGMBean {
    private String reference;
    private String reads_single;
    private String reads_1;
    private String reads_2;
    private String path;
    private String option;
    private int type;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReads_single() {
        return reads_single;
    }

    public void setReads_single(String reads_single) {
        this.reads_single = reads_single;
    }

    public String getReads_1() {
        return reads_1;
    }

    public void setReads_1(String reads_1) {
        this.reads_1 = reads_1;
    }

    public String getReads_2() {
        return reads_2;
    }

    public void setReads_2(String reads_2) {
        this.reads_2 = reads_2;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
