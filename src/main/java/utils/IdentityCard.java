package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IdentityCard{
    /**
     * 身份证姓名
     */
    private String name;
    /**
     * 身份证性别
     */
    private String sex;
    /**
     * 身份证出身日期
     */
    private Date birthDate;
    /**
     * 身份证住址
     */
    private String address;
    /**
     * 校验身份证是否正确
     */
    Boolean verification;

    /**
     * 身份证号
     */
    private String IdentityCard;

    /**
     * 实例化一个新的身份证信息
     */
    public IdentityCard(){
        this.name="";
        this.sex="男";
        this.birthDate=new Date();
        this.address=null;
        this.IdentityCard=IdentityCard;
        this.verification=false;
    }
    /**
     * 实例化一个新的身份证信息
     * @param name 身份证姓名
     */
    public IdentityCard( String name){
        this();
        this.name=name;
    }

    /**
     * 实例化一个新的身份证信息
     * @param name 身份证姓名
     * @param IdentityCard 身份证号
     */
    public IdentityCard( String name,String IdentityCard){
        this();
        this.name=name;
        this.IdentityCard=IdentityCard;
    }

    /**
     * 复制身份证信息
     * @param identityCard 旧的身份证信息
     */
    public IdentityCard(IdentityCard identityCard){
        this.name=identityCard.name;
        this.sex=identityCard.sex;
        this.birthDate=identityCard.birthDate;
        this.address=identityCard.address;
        this.IdentityCard=identityCard.IdentityCard;
        this.verification=identityCard.verification;
    }
    /**
     * 获取 身份证姓名
     * @return 身份证姓名
     */
    public String getName(){
        return name;
    }

    /**
     * 设置 身份证姓名
     * @param name 身份证姓名
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * 获取 身份证姓名
     * @return
     */
    public String getSex(){
        return sex;
    }

    /**
     * 设置 身份证姓名
     * @param sex 身份证姓名
     */
    public void setSex(String sex){
        this.sex = sex;
    }

    /**
     * 获取 身份证出身日期
     * @return 身份证出身日期
     */
    public Date getBirthDate(){
        return birthDate;
    }

    /**
     * 设置 身份证出身日期
     * @param birthDate 身份证出身日期
     */
    public void setBirthDate(Date birthDate){
        this.birthDate = birthDate;
    }
     /**
     * 设置 身份证出身日期
     * @param birthDate 身份证出身日期
     */
    public void setBirthDate(String birthDate) {
        SimpleDateFormat simpleDateFormat;
        if(birthDate.contains("-")){
            simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        }else if(birthDate.contains("/")){
            simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd");
        }else if(birthDate.contains(":")){
            simpleDateFormat=new SimpleDateFormat("yyyy:MM:dd");
        }else if(birthDate.contains(" ")){
            simpleDateFormat=new SimpleDateFormat("yyyy MM dd");
        }else{
            simpleDateFormat=new SimpleDateFormat("yyyyMMdd");
        }
        try{
            this.birthDate = simpleDateFormat.parse(birthDate);
        }catch(ParseException e){
            e.printStackTrace();
        }
    }

    /**
     * 获取 身份证住址
     * @return 身份证住址
     */
    public String getAddress(){
        return address;
    }

    /**
     * 设置 身份证住址
     * @param address 身份证住址
     */
    public void setAddress(String address){
        this.address = address;
    }

    /**
     * 获取 身份证号
     * @return 身份证号
     */
    public String getIdentityCard(){
        return IdentityCard;
    }

    /**
     * 设置 身份证号
     * @param identityCard 身份证号
     */
    public void setIdentityCard(String identityCard){
        IdentityCard = identityCard;
    }

    /**
     * 检查 身份证号是否正确
     * @return 如果是返回true,否则返回false
     */
    public Boolean getVerification(){
        if(verification==null){
            System.err.println("未检测到身份证信息");
            verification=false;
        }
        return verification;
    }

    /**
     * 设置 身份证号是否正确
     * @param verification
     */
    public void setVerification(Boolean verification){
        this.verification = verification;
    }
}
