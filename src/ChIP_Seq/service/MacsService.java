package ChIP_Seq.service;

import ChIP_Seq.bean.MacsBean;
import ChIP_Seq.execute.MacsExecute;

/**
 * Created by lily on 4/15/16.
 */
public class MacsService {
    private MacsExecute macsExecute;
    private MacsBean macsBean;

    public MacsBean getMacsBean() {
        return macsBean;
    }

    public void setMacsBean(MacsBean macsBean) {
        this.macsBean = macsBean;
    }

    public MacsExecute getMacsExecute() {
        return macsExecute;
    }

    public void setMacsExecute(MacsExecute macsExecute) {
        this.macsExecute = macsExecute;
    }

    public String Macs(){
        macsExecute.Macs_execute(macsBean);
        return macsExecute.getStdoutlist();
    }
}
