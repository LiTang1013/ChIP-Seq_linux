package ChIP_Seq.bean;

/**
 * Created by Administrator on 2016/4/22 0022.
 */
public class BWABean_pair {
    private String input_BWA_reference;
    private String input_BWA_reads_pair1;
    private String input_BWA_reads_pair2;
    private String input_BWA_path;
    private int long_short;
    private String option;
    public String getInput_BWA_reference() {
        return input_BWA_reference;
    }

    public void setInput_BWA_reference(String input_BWA_reference) {
        this.input_BWA_reference = input_BWA_reference;
    }

    public String getInput_BWA_reads_pair1() {
        return input_BWA_reads_pair1;
    }

    public void setInput_BWA_reads_pair1(String input_BWA_reads_pair1) {
        this.input_BWA_reads_pair1 = input_BWA_reads_pair1;
    }

    public String getInput_BWA_reads_pair2() {
        return input_BWA_reads_pair2;
    }

    public void setInput_BWA_reads_pair2(String input_BWA_reads_pair2) {
        this.input_BWA_reads_pair2 = input_BWA_reads_pair2;
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
