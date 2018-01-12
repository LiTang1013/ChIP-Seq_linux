package ChIP_Seq.service;

import ChIP_Seq.bean.SISSRBean;
import ChIP_Seq.execute.SISSRExecute;

/**
 * Created by lily on 7/18/16.
 */
public class SISSRService {
    private SISSRBean sissrBean;
    private SISSRExecute sissrExecute;

    public SISSRExecute getSissrExecute() {
        return sissrExecute;
    }

    public void setSissrExecute(SISSRExecute sissrExecute) {
        this.sissrExecute = sissrExecute;
    }

    public SISSRBean getSissrBean() {
        return sissrBean;
    }

    public void setSissrBean(SISSRBean sissrBean) {
        this.sissrBean = sissrBean;
    }
    public String  SISSR(){
        sissrExecute.SISSR_execute(sissrBean);
        return sissrExecute.getStdoutlist();
    }
}
