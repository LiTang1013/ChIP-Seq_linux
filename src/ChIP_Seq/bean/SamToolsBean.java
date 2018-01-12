package ChIP_Seq.bean;

/**
 * Created by lily on 4/14/16.
 */
public class SamToolsBean {
    private String input_sam;
    private String input_bam;
    private String input_samtools_sort;
    private String input_samtools_index;
    private int index_type;
    private int type;
    private String input_samtools_indexpath;

    public String getInput_sam() {
        return input_sam;
    }

    public void setInput_sam(String input_sam) {
        this.input_sam = input_sam;
    }

    public String getInput_bam() {
        return input_bam;
    }

    public void setInput_bam(String input_bam) {
        this.input_bam = input_bam;
    }


    public String getInput_samtools_sort() {
        return input_samtools_sort;
    }

    public void setInput_samtools_sort(String input_samtools_sort) {
        this.input_samtools_sort = input_samtools_sort;
    }

    public String getInput_samtools_index() {
        return input_samtools_index;
    }

    public void setInput_samtools_index(String input_samtools_index) {
        this.input_samtools_index = input_samtools_index;
    }

    public int getIndex_type() {
        return index_type;
    }

    public void setIndex_type(int index_type) {
        this.index_type = index_type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getInput_samtools_indexpath() {
        return input_samtools_indexpath;
    }

    public void setInput_samtools_indexpath(String input_samtools_indexpath) {
        this.input_samtools_indexpath = input_samtools_indexpath;
    }
}
