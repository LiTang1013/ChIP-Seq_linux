package ChIP_Seq.service;

import ChIP_Seq.bean.NGMBean;
import ChIP_Seq.execute.NGMExecute;

/**
 * Created by lily on 7/26/16.
 */
public class NGMService {
    private NGMBean ngmBean;
    private NGMExecute ngmExecute;

    public NGMBean getNgmBean() {
        return ngmBean;
    }

    public void setNgmBean(NGMBean ngmBean) {
        this.ngmBean = ngmBean;
    }

    public NGMExecute getNgmExecute() {
        return ngmExecute;
    }

    public void setNgmExecute(NGMExecute ngmExecute) {
        this.ngmExecute = ngmExecute;
    }
    public String NGM(){
        ngmExecute.NGM_execute(ngmBean);
        return ngmExecute.getStdoutlist();
    }
}
