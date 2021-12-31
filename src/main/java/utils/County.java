package utils;

/**
 * 县名
 */
public class County{
   private static String county;
   private static City city;
    public County(){
        city=new City();
    }
    /**
     * 通过编码查寻县名
     * @param code 编码
     * @return
     */
    public static String getCounty(String code){
        if(code.trim().length()!=6){
            System.err.println("输入错误!");
            return null;
        }
        county=Address.getString(code);
        return county;
    }
    /**
     * 通过编码查寻县短名
     * @param code 编码
     * @return
     */
    public String getShortCity(String code){
        String county = "";
        if(!County.county.contains("!")){
            String city=City.getCity(code);
            if(County.county.startsWith(city)){
                county= County.county.substring(city.length());
            }else {
                county= County.county.substring(Province.getProvince(code).length());
            }
        }
        return county;
    }
}
