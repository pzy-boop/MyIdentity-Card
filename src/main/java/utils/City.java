package utils;

public class City{
    private static String city;
    private static Province province;
    public City(){
         province=new Province();
    }
    /**
     * 通过编码查寻市名
     * @param code 编码
     * @return
     */
    public static String getCity(String code){
        if(code.trim().length()==6){
            code=code.substring(0,4)+"00";
        }else {
            System.err.println("输入错误!");
        }
        city=Address.getString(code);
        city=city.replace("地区","市");
        return city;
    }
    /**
     * 通过编码查寻市短名
     * @param code 编码
     * @return
     */
    public String getShortCity(String code){
        String city = "";
        if(!City.city.contains("!")){
            city= City.city.substring(Province.getProvince(code).length());
        }
        return city;
    }
}
