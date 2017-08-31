package ChIP_Seq.service;

import ChIP_Seq.bean.multiBamSummaryBean;
import ChIP_Seq.execute.multiBamSummaryExecute;

/**
 * Created by Administrator on 2017/1/11 0011.
 */
public class multiBamSummaryService {
    private multiBamSummaryBean multiBamSummaryBean;
    private multiBamSummaryExecute multiBamSummaryExecute;

    public multiBamSummaryBean getMultiBamSummaryBean() {
        return multiBamSummaryBean;
    }

    public void setMultiBamSummaryBean(multiBamSummaryBean multiBamSummaryBean) {
        this.multiBamSummaryBean = multiBamSummaryBean;
    }

    public multiBamSummaryExecute getMultiBamSummaryExecute() {
        return multiBamSummaryExecute;
    }

    public void setMultiBamSummaryExecute(multiBamSummaryExecute multiBamSummaryExecute) {
        this.multiBamSummaryExecute = multiBamSummaryExecute;
    }
    public String multiBamSummary(){
        multiBamSummaryExecute.multi_execute(multiBamSummaryBean);
        return multiBamSummaryExecute.getStdoutlist();
    }
}
