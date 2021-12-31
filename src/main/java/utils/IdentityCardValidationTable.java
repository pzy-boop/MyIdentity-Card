package utils;

import java.util.HashMap;
import java.util.Map;

public class IdentityCardValidationTable{
    /**
     * 校验系数
     */
    static int[] coefficient;
    /**
     * 校验表
     */
    static Map<Integer,Character> validationTable;

    /**
     * 应用程序，不允许实例化
     */
    public IdentityCardValidationTable(){
        setCoefficient();
        setValidationTable();
    }

    private final static void setCoefficient(){
        coefficient=new int[]{7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
    }

    private final static void setValidationTable(){
        validationTable = new HashMap<Integer,Character>();
        validationTable.put(0,'1');
        validationTable.put(1,'0');
        validationTable.put(2,'X');
        validationTable.put(3,'9');
        validationTable.put(4,'8');
        validationTable.put(5,'7');
        validationTable.put(6,'6');
        validationTable.put(7,'5');
        validationTable.put(8,'4');
        validationTable.put(9,'3');
        validationTable.put(10,'2');
    }

    /**
     * 获取 校验系数
     * @return 校验系数
     */
    public static int getCoefficient(int i){

        return coefficient[i];
    }

    /**
     * 获取 校验表
     * @return 校验表
     */
    public static int getValidationTable(int i){
        return validationTable.get(i);

    }
}
