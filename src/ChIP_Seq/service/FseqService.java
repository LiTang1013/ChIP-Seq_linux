package ChIP_Seq.service;

import ChIP_Seq.bean.FseqBean;
import ChIP_Seq.execute.FseqExecute;

/**
 * Created by lily on 7/27/16.
 */
public class FseqService {
    private FseqBean fseqBean;
    private FseqExecute fseqExecute;

    public FseqBean getFseqBean() {
        return fseqBean;
    }

    public void setFseqBean(FseqBean fseqBean) {
        this.fseqBean = fseqBean;
    }

    public FseqExecute getFseqExecute() {
        return fseqExecute;
    }

    public void setFseqExecute(FseqExecute fseqExecute) {
        this.fseqExecute = fseqExecute;
    }
    public String Fseq(){
        fseqExecute.Fseq_execute(fseqBean);
        return fseqExecute.getStdoutlist();
    }
}
