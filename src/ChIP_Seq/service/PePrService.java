package ChIP_Seq.service;

import ChIP_Seq.bean.PePrBean;
import ChIP_Seq.execute.PePrExecute;

/**
 * Created by lily on 7/12/16.
 */
public class PePrService {
    private PePrExecute pePrExecute;
    private PePrBean pePrBean;

    public PePrBean getPePrBean() {
        return pePrBean;
    }

    public void setPePrBean(PePrBean pePrBean) {
        this.pePrBean = pePrBean;
    }

    public PePrExecute getPePrExecute() {
        return pePrExecute;
    }

    public void setPePrExecute(PePrExecute pePrExecute) {
        this.pePrExecute = pePrExecute;
    }
    public String PePr(){
        pePrExecute.PePr_execute(pePrBean);
        return pePrExecute.getStdoutlist();
    }
}
