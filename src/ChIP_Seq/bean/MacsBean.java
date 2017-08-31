package ChIP_Seq.bean;

/**
 * Created by lily on 4/15/16.
 */
public class MacsBean {
    private String input_tagfile;
    private String input_controlfile;
    private String setting;
    private String input_setting;
    private String option;
    private String input_macs_path;

    public String getInput_tagfile() {
        return input_tagfile;
    }

    public void setInput_tagfile(String input_tagfile) {
        this.input_tagfile = input_tagfile;
    }

    public String getInput_controlfile() {
        return input_controlfile;
    }

    public void setInput_controlfile(String input_controlfile) {
        this.input_controlfile = input_controlfile;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public String getInput_setting() {
        return input_setting;
    }

    public void setInput_setting(String input_setting) {
        this.input_setting = input_setting;
    }


    public String getOption() {
        return option;
    }

    public String getInput_macs_path() {
        return input_macs_path;
    }

    public void setInput_macs_path(String input_macs_path) {
        this.input_macs_path = input_macs_path;
    }

    public void setOption(String option) {
        this.option = option;
    }
}
