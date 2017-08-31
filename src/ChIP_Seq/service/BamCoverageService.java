package ChIP_Seq.service;

import ChIP_Seq.bean.BamCoverageBean;
import ChIP_Seq.execute.BamCoverageExecute;

/**
 * Created by lily on 11/27/16.
 */
public class BamCoverageService {
    private BamCoverageBean bamCoverageBean;
    private BamCoverageExecute bamCoverageExecute;

    public BamCoverageBean getBamCoverageBean() {
        return bamCoverageBean;
    }

    public void setBamCoverageBean(BamCoverageBean bamCoverageBean) {
        this.bamCoverageBean = bamCoverageBean;
    }

    public BamCoverageExecute getBamCoverageExecute() {
        return bamCoverageExecute;
    }

    public void setBamCoverageExecute(BamCoverageExecute bamCoverageExecute) {
        this.bamCoverageExecute = bamCoverageExecute;
    }
    public String BamCoverage(){
        bamCoverageExecute.BamCoverage_Execute(bamCoverageBean);
        return bamCoverageExecute.getStdoutlist();
    }
}
