package ChIP_Seq.bean;

/**
 * Created by Administrator on 2016/4/22 0022.
 */
public class Bowtie2Bean_pair {
    private String reference;
    private String reads_left;
    private String reads_right;
    private String path;
    private String option;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReads_left() {
        return reads_left;
    }

    public void setReads_left(String reads_left) {
        this.reads_left = reads_left;
    }

    public String getReads_right() {
        return reads_right;
    }

    public void setReads_right(String reads_right) {
        this.reads_right = reads_right;
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
