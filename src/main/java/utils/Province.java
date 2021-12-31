package utils;

/**
 * 省名
 */
public class Province extends Address{
    private static String province;

    /**
     * 通过编码查寻省名
     * @param code 编码
     * @return
     */
    public static String getProvince(String code){
        if(code.trim().length()==6){
            code=code.substring(0,2)+"0000";
        }else {
            System.err.println("输入错误!");
        }
        province=Address.getString(code);
        return province;
    }
}
