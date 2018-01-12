package ChIP_Seq.service;

import ChIP_Seq.bean.SubreadBean;
import ChIP_Seq.execute.SubreadExecute;

/**
 * Created by lily on 7/24/16.
 */
public class SubreadService {
    private SubreadBean subreadBean;
    private SubreadExecute subreadExecute;

    public SubreadExecute getSubreadExecute() {
        return subreadExecute;
    }

    public void setSubreadExecute(SubreadExecute subreadExecute) {
        this.subreadExecute = subreadExecute;
    }

    public SubreadBean getSubreadBean() {
        return subreadBean;
    }

    public void setSubreadBean(SubreadBean subreadBean) {
        this.subreadBean = subreadBean;
    }
    public String Subread(){
        subreadExecute.Subread_index(subreadBean);
        subreadExecute.Subread_align(subreadBean);
        return subreadExecute.getStdoutlist();
    }
    public String Subread_unBuild(){
        subreadExecute.Subread_align(subreadBean);
        return subreadExecute.getStdoutlist();
    }
}
