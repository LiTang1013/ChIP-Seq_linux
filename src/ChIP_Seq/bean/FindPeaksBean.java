package ChIP_Seq.bean;

/**
 * Created by lily on 7/19/16.
 */
public class FindPeaksBean {
    private String file;
    private int type;
    private String option;
    private String path;
    private String genesize;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public String getGenesize() {
        return genesize;
    }

    public void setGenesize(String genesize) {
        this.genesize = genesize;
    }
}
