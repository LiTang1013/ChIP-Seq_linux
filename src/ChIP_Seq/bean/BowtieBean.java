package ChIP_Seq.bean;

/**
 * Created by Administrator on 2016/5/6 0006.
 */
public class BowtieBean {
    private String reference;
    private String read_1;
    private String read_2;
    private String path;
    private int read_type;
    private String index_option;
    private String vn_option;
    private String best;
    private String input_option;
    private String ali_option;
    private String report_option;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getRead_1() {
        return read_1;
    }

    public void setRead_1(String read_1) {
        this.read_1 = read_1;
    }

    public String getRead_2() {
        return read_2;
    }

    public void setRead_2(String read_2) {
        this.read_2 = read_2;
    }

    public int getRead_type() {
        return read_type;
    }

    public void setRead_type(int read_type) {
        this.read_type = read_type;
    }

    public String getIndex_option() {
        return index_option;
    }

    public void setIndex_option(String index_option) {
        this.index_option = index_option;
    }

    public String getVn_option() {
        return vn_option;
    }

    public void setVn_option(String vn_option) {
        this.vn_option = vn_option;
    }

    public String getBest() {
        return best;
    }

    public void setBest(String best) {
        this.best = best;
    }

    public String getAli_option() {
        return ali_option;
    }

    public void setAli_option(String ali_option) {
        this.ali_option = ali_option;
    }

    public String getInput_option() {
        return input_option;
    }

    public void setInput_option(String input_option) {
        this.input_option = input_option;
    }

    public String getReport_option() {
        return report_option;
    }

    public void setReport_option(String report_option) {
        this.report_option = report_option;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
