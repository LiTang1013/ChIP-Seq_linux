package ChIP_Seq.service;

import ChIP_Seq.bean.FindPeaksBean;
import ChIP_Seq.execute.FindPeaksExecute;

/**
 * Created by lily on 7/19/16.
 */
public class FindPeaksService {
    private FindPeaksBean findPeaksBean;
    private FindPeaksExecute findPeaksExecute;

    public FindPeaksExecute getFindPeaksExecute() {
        return findPeaksExecute;
    }

    public void setFindPeaksExecute(FindPeaksExecute findPeaksExecute) {
        this.findPeaksExecute = findPeaksExecute;
    }

    public FindPeaksBean getFindPeaksBean() {
        return findPeaksBean;
    }

    public void setFindPeaksBean(FindPeaksBean findPeaksBean) {
        this.findPeaksBean = findPeaksBean;
    }
    public String FindPeaks(){
        findPeaksExecute.FindPeaks_execute(findPeaksBean);
        return findPeaksExecute.getStdoutlist();
    }
}
