package ChIP_Seq.service;

import ChIP_Seq.bean.BCPBean;
import ChIP_Seq.execute.BCPExecute;

/**
 * Created by lily on 7/12/16.
 */
public class BCPService {
    private BCPExecute bcpExecute;
    private BCPBean bcpBean;

    public BCPExecute getBcpExecute() {
        return bcpExecute;
    }

    public void setBcpExecute(BCPExecute bcpExecute) {
        this.bcpExecute = bcpExecute;
    }

    public BCPBean getBcpBean() {
        return bcpBean;
    }

    public void setBcpBean(BCPBean bcpBean) {
        this.bcpBean = bcpBean;
    }
    public String BCP(){
        bcpExecute.BCP_execute(bcpBean);
        return bcpExecute.getStdoutlist();
    }
}
