package sampleannotation;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface BaseTable {
    default void validate() throws Exception {
        Class<? extends BaseTable> clazz = this.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for(int i=0;i<fields.length;i++){
            fields[i].setAccessible(true);
            boolean nullable = fields[i].getAnnotation(Column.class).nullable();
            if(!nullable && fields[i].get(this) == null){
                String defaultValue = fields[i].getAnnotation(Column.class).defaultValue();
                if ("".equals(defaultValue)){
                    throw new Exception("Validate error");
                }else {
                    Class<?> type = fields[i].getType();
                    if (Integer.class == type){
                        fields[i].set(this,Integer.valueOf(defaultValue));
                    }else if (Date.class == type){
                        fields[i].set(this,new SimpleDateFormat("yyyy-MM-dd").parse(defaultValue));
                    }else {
                        fields[i].set(this,defaultValue);
                    }
                }
            }
        }
    }
}
