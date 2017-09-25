package com.lilei.test;

import com.lilei.test.fieldtest.FieldTest;
import com.lilei.test.fieldtest.User;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 getType()： 获取属性声明时类型对象（返回class对象）

 getGenericType() ： 返回属性声的Type类型(返回Type类型的对象)

 getName() ： 获取属性声明时名字 return String

 getAnnotations() ： 获得这个属性上所有的注释

 getModifiers() ： 获取属性的修饰

 isEnumConstant() ： 判断这个属性是否是枚举类

 isSynthetic() ： 判断这个属性是否是 复合类

 get(Object obj) ： 取得obj对象这个Field上的值

 set(Object obj, Object value) ： 向obj对象的这个Field设置新值value

 JAVA 反射机制中，Field的getModifiers()方法返回int类型值表示该字段的修饰符。
 其中，该修饰符是java.lang.reflect.Modifier的静态属性。
 对应表如下：
 PUBLIC: 1
 PRIVATE: 2
 PROTECTED: 4
 STATIC: 8
 FINAL: 16
 SYNCHRONIZED: 32
 VOLATILE: 64
 TRANSIENT: 128
 NATIVE: 256
 INTERFACE: 512
 ABSTRACT: 1024
 STRICT: 2048
 */
public class Test {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String, String>();
        map.put("username","joe");
        map.put("userpassword","123456");
        User user = new User();
        user.setUsername("testUsrName");
        user.setUserpassword("123456");
        Class<?> cls = user.getClass();
        Field[] fields = cls.getDeclaredFields();//返回这个类或接口声明的所有字段
        for (Field field:fields){
//            System.out.println(field.getType());
//            System.out.println(field.getGenericType());
//            System.out.println(field.getName());
//            System.out.println(field.getAnnotations().toString());
//            Annotation[] annotations = field.getAnnotations();
//            for (int i=0;i<annotations.length;i++){
//                System.out.println(annotations[i]);
//            }
            System.out.println(field.getModifiers());
            String fieldName = field.getName();
//            map.get(fieldName);
            try {
                field.setAccessible(true);
                if (fieldName.equals("username")){
                    field.set(user,"update");
                }else{
                    field.set(user,"password");
                }

                Object obj = field.get(user);
                System.out.println(obj);
//                System.out.println(field.get(fieldName));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

//        FieldTest.setFieldValue(user, map);
//        System.out.println(user.getUsername()+":::"+user.getUserpassword());
    }
}
