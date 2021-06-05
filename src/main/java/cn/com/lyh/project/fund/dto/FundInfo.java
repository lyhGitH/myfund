package cn.com.lyh.project.fund.dto;

/**
 * FundInfo
 *
 * @author liuyuhua
 * @date 2020-08-01 16:23
 */
public class FundInfo {

    private String fundCode;
    private String name;
    /**
     * 单位净值
     */
    private double dwjz;
    /**
     * 估算值
     */
    private double gsz;
    /**
     * 持有份额
     */
    private double cyfe;
    /**
     * 估算增长量
     */
    private double gszzl;

    /**
     * 预计盈利
     */
    private Double v;

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDwjz() {
        return dwjz;
    }

    public void setDwjz(double dwjz) {
        this.dwjz = dwjz;
    }

    public double getGsz() {
        return gsz;
    }

    public void setGsz(double gsz) {
        this.gsz = gsz;
    }

    public double getCyfe() {
        return cyfe;
    }

    public void setCyfe(double cyfe) {
        this.cyfe = cyfe;
    }

    public double getGszzl() {
        return gszzl;
    }

    public void setGszzl(double gszzl) {
        this.gszzl = gszzl;
    }

    public Double getV() {
        return v;
    }

    public void setV(Double v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "FundInfo{" +
                "fundCode='" + fundCode + '\'' +
                ", name='" + name + '\'' +
                ", dwjz=" + dwjz +
                ", gsz=" + gsz +
                ", cyfe=" + cyfe +
                ", gszzl=" + gszzl +
                '}';
    }
}
