package ChIP_Seq.bean;

/**
 * Created by Administrator on 2017/1/11 0011.
 */
public class multiBamSummaryBean {
    private String bam1;
    private String bam2;
    private String bed;
    private String option;
    private String path;
    private int mode;

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getBam1() {
        return bam1;
    }

    public void setBam1(String bam1) {
        this.bam1 = bam1;
    }

    public String getBam2() {
        return bam2;
    }

    public void setBam2(String bam2) {
        this.bam2 = bam2;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}
