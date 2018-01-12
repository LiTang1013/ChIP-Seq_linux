package ChIP_Seq.bean;

/**
 * Created by lily on 7/12/16.
 */
public class PePrBean {
    private String tagfile1;
    private String tagfile2;
    private String controlfile1;
    private String controlfile2;
    private String option;
    private String path;
    private String format;

    public String getTagfile1() {
        return tagfile1;
    }

    public void setTagfile1(String tagfile1) {
        this.tagfile1 = tagfile1;
    }

    public String getControlfile2() {
        return controlfile2;
    }

    public void setControlfile2(String controlfile2) {
        this.controlfile2 = controlfile2;
    }

    public String getControlfile1() {
        return controlfile1;
    }

    public void setControlfile1(String controlfile1) {
        this.controlfile1 = controlfile1;
    }

    public String getTagfile2() {
        return tagfile2;
    }

    public void setTagfile2(String tagfile2) {
        this.tagfile2 = tagfile2;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
