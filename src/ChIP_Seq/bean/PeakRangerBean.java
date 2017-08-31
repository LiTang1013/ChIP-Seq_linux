package ChIP_Seq.bean;

/**
 * Created by Administrator on 2016/5/8 0008.
 */
public class PeakRangerBean {
    private String tagfile;
    private String controlfile;
    private String path;
    private String name;
    private String select_peakranger;
    private String option;
    private String formate;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getSelect_peakranger() {
        return select_peakranger;
    }

    public void setSelect_peakranger(String select_peakranger) {
        this.select_peakranger = select_peakranger;
    }

    public String getFormate() {
        return formate;
    }

    public void setFormate(String formate) {
        this.formate = formate;
    }
}
