package ChIP_Seq.service;

import ChIP_Seq.bean.BWABean;
import ChIP_Seq.bean.BWABean_pair;
import ChIP_Seq.execute.BWAExecute;

/**
 * Created by Administrator on 2016/4/18 0018.
 */
public class BWAService {
    private BWABean bwaBean;
    private BWABean_pair bwaBean_pair;
    private BWAExecute bwaExecute;

    public BWABean getBwaBean() {
        return bwaBean;
    }

    public void setBwaBean(BWABean bwaBean) {
        this.bwaBean = bwaBean;
    }

    public BWAExecute getBwaExecute() {
        return bwaExecute;
    }
    public void setBwaExecute(BWAExecute bwaExecute) {
        this.bwaExecute = bwaExecute;
    }

    public BWABean_pair getBwaBean_pair() {
        return bwaBean_pair;
    }

    public void setBwaBean_pair(BWABean_pair bwaBean_pair) {
        this.bwaBean_pair = bwaBean_pair;
    }

    public String BWA(){
        bwaExecute.BWA_build(bwaBean);
        bwaExecute.BWA_corodinate(bwaBean);
        bwaExecute.BWA_aln(bwaBean);
        return bwaExecute.getStdoutlist();
    }
    public String BWA_pair(){
        bwaExecute.BWA_build_pair(bwaBean_pair);
        bwaExecute.BWA_corordinate_pair1(bwaBean_pair);
        bwaExecute.BWA_corordinate_pair2(bwaBean_pair);
        bwaExecute.BWA_aln_pair(bwaBean_pair);
        return bwaExecute.getStdoutlist();
    }
}
