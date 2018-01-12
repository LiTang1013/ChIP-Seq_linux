package ChIP_Seq.service;

import ChIP_Seq.bean.Bowtie2Bean;
import ChIP_Seq.bean.Bowtie2Bean_pair;
import ChIP_Seq.execute.Bowtie2Execute;

/**
 * Created by Administrator on 2016/4/9 0009.
 */
public class Bowtie2Service {
    private Bowtie2Execute bowtie2Execute;
    private Bowtie2Bean bowtie2Bean;
    private Bowtie2Bean_pair bowtie2Bean_pair;
    public Bowtie2Execute getBowtie2Execute() {
        return bowtie2Execute;
    }

    public void setBowtie2Execute(Bowtie2Execute bowtie2Execute) {
        this.bowtie2Execute = bowtie2Execute;
    }

    public Bowtie2Bean getBowtie2Bean() {
        return bowtie2Bean;
    }

    public void setBowtie2Bean(Bowtie2Bean bowtie2Bean) {
        this.bowtie2Bean = bowtie2Bean;
    }

    public Bowtie2Bean_pair getBowtie2Bean_pair() {
        return bowtie2Bean_pair;
    }

    public void setBowtie2Bean_pair(Bowtie2Bean_pair bowtie2Bean_pair) {
        this.bowtie2Bean_pair = bowtie2Bean_pair;
    }

    public String Bowtie2(){
        bowtie2Execute.Bowtie2_build(bowtie2Bean);
        bowtie2Execute.Bowtie2_align(bowtie2Bean);
        return bowtie2Execute.getStdoutlist();
    }
    public String Bowtie2_pair(){
        bowtie2Execute.Bowtie2_build_pair(bowtie2Bean_pair);
        bowtie2Execute.Bowtie2_align_pair(bowtie2Bean_pair);
        return bowtie2Execute.getStdoutlist();
    }
    public String Bowtie2_noBuild(){
        bowtie2Execute.Bowtie2_align(bowtie2Bean);
        return bowtie2Execute.getStdoutlist();
    }
    public String Bowtie2_pair_noBuild(){
        bowtie2Execute.Bowtie2_align_pair(bowtie2Bean_pair);
        return bowtie2Execute.getStdoutlist();
    }
}
