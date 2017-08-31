package ChIP_Seq.bean;

/**
 * Created by Administrator on 2016/4/9 0009.
 */
public class Bowtie2Bean {
    private String reference;
    private String reads;
    private String path;
    private String option;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReads() {
        return reads;
    }

    public void setReads(String reads) {
        this.reads = reads;
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
}
