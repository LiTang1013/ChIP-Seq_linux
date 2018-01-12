package ChIP_Seq.service;

import ChIP_Seq.bean.Macs2Bean;
import ChIP_Seq.execute.Macs2Execute;

/**
 * Created by lily on 7/10/16.
 */
public class Macs2Service {
    private Macs2Execute macs2Execute;
    private Macs2Bean macs2Bean;

    public Macs2Execute getMacs2Execute() {
        return macs2Execute;
    }

    public void setMacs2Execute(Macs2Execute macs2Execute) {
        this.macs2Execute = macs2Execute;
    }

    public Macs2Bean getMacs2Bean() {
        return macs2Bean;
    }

    public void setMacs2Bean(Macs2Bean macs2Bean) {
        this.macs2Bean = macs2Bean;
    }
    public String Macs2(){
        macs2Execute.Macs2_execute(macs2Bean);
        return macs2Execute.getStdoutlist();
    }
}
