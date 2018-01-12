package ChIP_Seq.bean;

/**
 * Created by Administrator on 2016/5/7 0007.
 */
public class PeakSeqBean {
    private int format;
    private String tagfile;
    private String controlfile;
    private String option;
    private String paht;
    private String output_name;

    public int getFormat() {
        return format;
    }

    public void setFormat(int format) {
        this.format = format;
    }

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

    public String getPaht() {
        return paht;
    }

    public void setPaht(String paht) {
        this.paht = paht;
    }

    public String getOutput_name() {
        return output_name;
    }

    public void setOutput_name(String output_name) {
        this.output_name = output_name;
    }
}
