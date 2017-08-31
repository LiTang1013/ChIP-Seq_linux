package ChIP_Seq.bean;

/**
 * Created by lily on 7/27/16.
 */
public class BroadPeakBean {
    private String tagfile;
    private String controlfile;
    private String path;
    private String option;

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
