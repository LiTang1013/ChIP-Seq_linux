package ChIP_Seq.service;

import ChIP_Seq.bean.BowtieBean;
import ChIP_Seq.execute.BowtieExecute;

/**
 * Created by lily on 5/6/16.
 */
public class BowtieService {
    private BowtieBean bowtieBean;
    private BowtieExecute bowtieExecute;

    public BowtieBean getBowtieBean() {
        return bowtieBean;
    }

    public void setBowtieBean(BowtieBean bowtieBean) {
        this.bowtieBean = bowtieBean;
    }

    public BowtieExecute getBowtieExecute() {
        return bowtieExecute;
    }

    public void setBowtieExecute(BowtieExecute bowtieExecute) {
        this.bowtieExecute = bowtieExecute;
    }

    public String Bowtie(){
        if(bowtieBean.getRead_type()==1){
            bowtieExecute.Bowtie_build(bowtieBean);
            bowtieExecute.Bowtie_align(bowtieBean);
        }
        else{
            bowtieExecute.Bowtie_build(bowtieBean);
            bowtieExecute.Bowtie_align_pair(bowtieBean);
        }
        return bowtieExecute.getStdoutlist();
    }

    public String Bowtie_unIndex(){
        if(bowtieBean.getRead_type()==1){
            bowtieExecute.Bowtie_align(bowtieBean);
        }
        else{
            bowtieExecute.Bowtie_align_pair(bowtieBean);
        }
        return bowtieExecute.getStdoutlist();
    }
}
