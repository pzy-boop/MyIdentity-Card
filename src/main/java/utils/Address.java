package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;


public abstract class Address{
    String file="utils/Address.properties";
    Map<String,String> address;
    static AddressMessages addressMessages;
    private static final String BUNDLE_NAME = "utils.Address"; //$NON-NLS-1$

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
    protected Address(){
        address=new HashMap<>();
    }

    /**
     * 通过编码查询地址
     * @param code 编码
     * @return 地址
     */
    public static String getString(String code) {
        try {
            return RESOURCE_BUNDLE.getString(code);
        } catch (MissingResourceException e) {
            return '!' + code + '!';
        }
    }
    public void addAddress(String key,String value){
        address.put(key,value);
    }
    public void addAddress(Map<String,String> map){
        address.putAll(map);
    }
    public Map<String,String> getAddress(){
        return address;
    }
    /**
     * 写入 properties 文件
     * 如果有key值不添加
     */
    protected void reader(){
        Properties properties=new Properties();
        for(Map.Entry<String,String> map:address.entrySet()){
            if(map.getKey().length() != 6 && map.getValue().isEmpty()){
                return;
            }else {
                if(getString(map.getKey()).contains("!")){
                    properties.setProperty(map.getKey(),map.getValue());
                }
            }
        }
        File file=new File("src/main/java/utils/Address.properties");
        try{
            //comment添加的时间
            properties.store( new FileOutputStream(file,true),null);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
