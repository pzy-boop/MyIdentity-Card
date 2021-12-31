package utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * 示例：
 * <p>IdentityCard identityCard1=new IdentityCard("肖志雄","432524200008281414");</p>
 * <p>identityCard1.setAddress("湖南省新化县");</p>
 * <p>identityCard1.setBirthDate("2000/08/28");</p>
 * <p>identityCard1.setSex("男");</p>
 * <p>IdentityCardVerification identityCardVerification=new IdentityCardVerification();</p>
 * <p>identityCardVerification.addIdentityCard(identityCard1);</p>
 * <p>identityCardVerification.verificationIdentityCard();</p>
 */
public class IdentityCardVerification extends IdentityCardValidationTable{
    /**
     * 身份证 集合
     */
    private List<IdentityCard> identityCardList;

    /**
     * 实例化一个新的身份证校验
     */
    public IdentityCardVerification(){
        super();
        identityCardList =new ArrayList<IdentityCard>();
    }


    /**
     * 获取 身份证 集合
     * @return 身份证 集合
     */
    public List<IdentityCard> getIdentityCardList(){
        return identityCardList;
    }

    /**
     * 添加一个身份证信息
     * @param identityCard 身份证
     */
    public void addIdentityCard(IdentityCard identityCard){
        this.identityCardList.add(identityCard);
    }

    /**
     * 添加一个身份证信息
     * @param index 插入的位置索引
     * @param identityCard 身份证
     */
    public void addIdentityCard(int index,IdentityCard identityCard){
        this.identityCardList.add(index,identityCard);
    }

    /**
     * 添加多个身份证信息
     * @param identityCardCollection 多个身份证
     */
    public void addIdentityCard(Collection<IdentityCard> identityCardCollection){
        this.identityCardList.addAll(identityCardCollection);
    }
    /**
     * 添加多个身份证信息
     * @param index 插入的位置索引
     * @param identityCardCollection 多个身份证
     */
    public void addIdentityCard(int index,Collection<IdentityCard> identityCardCollection){
        this.identityCardList.addAll(index,identityCardCollection);
    }

    /**
     * 验证身份信息
     */
    public void verificationIdentityCard(){
        if(identityCardList.size()==0){
            System.err.println("未检测到身份证信息");
        }else {
            for(IdentityCard identityCard:identityCardList){
                String id=identityCard.getIdentityCard().toUpperCase().trim();
                if(id.length()==18){
                    String a=id.substring(0,6);
                    String address=County.getCounty(a);
                    if(identityCard.getAddress()!=null&&identityCard.getAddress().startsWith(address)){
                        identityCard.verification=true;
                    }else {
                        identityCard.verification=false;
                    }
                    if(identityCard.verification){
                        int year=Integer.parseInt(id.substring(6,10));
                        identityCard.verification= year==dateTOInt(identityCard.getBirthDate(),"yyyy");
                    }
                    int monday=Integer.parseInt(id.substring(10,12));
                    if(identityCard.verification){
                        identityCard.verification= monday==dateTOInt(identityCard.getBirthDate(),"MM");
                    }
                    if(identityCard.verification){
                        int day=Integer.parseInt(id.substring(12,14));
                        identityCard.verification= day==dateTOInt(identityCard.getBirthDate(),"dd");
                    }
                    if(identityCard.verification){
                        int sex=Integer.parseInt(id.substring(16,17))%2;
                        if(sex==1 && identityCard.getSex().equals("男")){
                            identityCard.verification=true;
                        }else if(sex==0 && identityCard.getSex().equals("女")){
                            identityCard.verification=true;
                        }else{
                            identityCard.verification=false;
                        }
                    }
                    if(identityCard.verification){
                        char[] identityCardCharArray=id.toCharArray();
                        int validation=0;
                        for(int i=0;i<identityCardCharArray.length-1;i++){
                            validation += (identityCardCharArray[i]-'0')*IdentityCardValidationTable.getCoefficient(i);
                        }
                        int validationValue=IdentityCardValidationTable.getValidationTable(validation%11);
                        if(validationValue==identityCardCharArray[17]){
                            identityCard.verification=true;
                        }else {
                            identityCard.verification=false;
                        }
                    }
                    if(identityCard.verification){
                        System.out.println(id+"身份证号正确");
                    }else {
                        System.err.println(id+"身份证号不符合身份证信息");
                    }
                }else if(id.length()==15){
                    String a=id.substring(0,6);
                    String address=County.getCounty(a);
                    if(identityCard.getAddress()!=null&&identityCard.getAddress().startsWith(address)){
                        identityCard.verification=true;
                    }else {
                        identityCard.verification=false;
                    }
                    if(identityCard.verification){
                        int year=Integer.parseInt(id.substring(6,8));
                        identityCard.verification= year==dateTOInt(identityCard.getBirthDate(),"yyyy");
                    }
                    int monday=Integer.parseInt(id.substring(8,10));
                    if(identityCard.verification){
                        identityCard.verification= monday==dateTOInt(identityCard.getBirthDate(),"MM");
                    }
                    if(identityCard.verification){
                        int day=Integer.parseInt(id.substring(10,12));
                        identityCard.verification= day==dateTOInt(identityCard.getBirthDate(),"dd");
                    }
                    if(identityCard.verification){
                        int sex=Integer.parseInt(id.substring(14,15))%2;
                        if(sex==1 && identityCard.getSex().equals("男")){
                            identityCard.verification=true;
                        }else if(sex==0 && identityCard.getSex().equals("女")){
                            identityCard.verification=true;
                        }else{
                            identityCard.verification=false;
                        }
                    }
                    if(identityCard.verification){
                        System.out.println(id+"身份证号是一个老号,请去及时去公安局跟新相关证件");
                    }else {
                        System.err.println(id+"身份证号不符合身份证信息");
                    }
                }else {
                    System.err.println(id+"身份证格式错误！");
                }
            }
        }
    }

    /**
     * 时间转换成int
     * @param data 时间类型
     * @param pattern 转换格式
     * @return
     */
    private int dateTOInt(Date data,String pattern){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);
        return Integer.parseInt(simpleDateFormat.format(data));
    }

}
