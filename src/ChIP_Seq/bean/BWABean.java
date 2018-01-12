package ChIP_Seq.bean;

/**
 * Created by Administrator on 2016/4/18 0018.
 */
public class BWABean {
    private String input_BWA_reference;
    private String input_BWA_reads_single;
    private String input_BWA_path;
    private String option;
    private int long_short;
    public String getInput_BWA_reference() {
        return input_BWA_reference;
    }

    public void setInput_BWA_reference(String input_BWA_reference) {
        this.input_BWA_reference = input_BWA_reference;
    }

    public String getInput_BWA_reads_single() {
        return input_BWA_reads_single;
    }

    public void setInput_BWA_reads_single(String input_BWA_reads_single) {
        this.input_BWA_reads_single = input_BWA_reads_single;
    }

    public String getInput_BWA_path() {
        return input_BWA_path;
    }

    public void setInput_BWA_path(String input_BWA_path) {
        this.input_BWA_path = input_BWA_path;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public int getLong_short() {
        return long_short;
    }

    public void setLong_short(int long_short) {
        this.long_short = long_short;
    }
}
