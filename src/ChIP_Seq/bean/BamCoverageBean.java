package ChIP_Seq.bean;

/**
 * Created by lily on 11/27/16.
 */
public class BamCoverageBean {
    private int convert_sam;
    private int convert_for;
    private String convert_file;
    private String convert_result;

    public int getConvert_sam() {
        return convert_sam;
    }

    public void setConvert_sam(int convert_sam) {
        this.convert_sam = convert_sam;
    }

    public int getConvert_for() {
        return convert_for;
    }

    public void setConvert_for(int convert_for) {
        this.convert_for = convert_for;
    }

    public String getConvert_file() {
        return convert_file;
    }

    public void setConvert_file(String convert_file) {
        this.convert_file = convert_file;
    }

    public String getConvert_result() {
        return convert_result;
    }

    public void setConvert_result(String convert_result) {
        this.convert_result = convert_result;
    }
}
