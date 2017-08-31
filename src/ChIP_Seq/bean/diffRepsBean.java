package ChIP_Seq.bean;

/**
 * Created by lily on 7/15/16.
 */
public class diffRepsBean {
    private String tagfile;
    private String controlfile;
    private String option;
    private String path;
    private String gn;

    public String getTagfile() {
        return tagfile;
    }

    public void setTagfile(String tagfile) {
        this.tagfile = tagfile;
    }

    public String getControlfile() {
        return controlfile;
    }

    public void setControlfile(String controlfile) {
        this.controlfile = controlfile;
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

    public String getGn() {
        return gn;
    }

    public void setGn(String gn) {
        this.gn = gn;
    }
}
