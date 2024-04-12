package com.wf.spring;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 玉米排骨汤
 * @Date 2023/12/5 18:39
 * @Package com.wf.spring
 * @Version 1.0
 * @Since 1.0
 */
public class WfApplicationContext {

    private Class appConfig;
    private Map<String,BeanDefinition> beanDefinitionMap = new HashMap<>();
    private Map<String,Object> singletonObjects = new HashMap<>();
    private List<BeanPostProcessor> beanPostProcessorList = new ArrayList<>();
    public WfApplicationContext(Class appConfig){
        this.appConfig = appConfig;

        scan(appConfig);

        //遍历beanDefinitionMap  -》 将singleton放入单例池
        for(Map.Entry<String,BeanDefinition> entry : beanDefinitionMap.entrySet()){
            String beanName = entry.getKey();
            BeanDefinition beanDefinition = entry.getValue();
            if(beanDefinition.getScope().equals("Singleton")){
                Object bean = createBean(beanName,beanDefinition);
                singletonObjects.put(beanName,bean);
            }
        }
    }

    private Object createBean (String beanName, BeanDefinition beanDefinition){
        Class clazz = beanDefinition.getClazz();
        Object bean = null;
        try {
            bean = clazz.newInstance();
            //获取类中所有的属性
            for(Field field : clazz.getDeclaredFields()){
                //依赖注入
                if(field.isAnnotationPresent(Autowired.class)){
                    String name = field.getName();
                    Object object = getBean(name);
                    field.setAccessible(true);
                    field.set(bean,object);
                }
            }

            //初始化前
            for(BeanPostProcessor beanPostProcessor : beanPostProcessorList){
               bean =  beanPostProcessor.postProcessBeforeInitialization(bean,beanName);
            }
            //初始化
            if(bean instanceof InitializingBean){
                ((InitializingBean)bean).afterPropertiesSet();
            }
            //初始化后
            for(BeanPostProcessor beanPostProcessor : beanPostProcessorList){
               bean =  beanPostProcessor.postProcessAfterInitialization(bean,beanName);
            }

        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return bean;
    }



    private void scan(Class appConfig) {
        //获取配置类上的注解，获取扫描的包
        //配置雷山是否有组件扫描的注解
        if (appConfig.isAnnotationPresent(ComponentScan.class)){
            ComponentScan annotationScan = (ComponentScan) appConfig.getAnnotation(ComponentScan.class);
            String path = annotationScan.value();   //扫描包路径
            System.out.println("组件扫描路径："+path);

            //将路径的  . -> /
            path = path.replace(".","/");

            //扫描路径，获取带有Component注解的类，生成Bean对象
            ClassLoader classLoader = WfApplicationContext.class.getClassLoader();
            URL resource = classLoader.getResource(path);
            File file = new File(resource.getFile());
            //获取文件夹下的文件
            File[] files = file.listFiles();
            for (File f : files) {
                String absolutePath = f.getAbsolutePath();
                System.out.println("扫描路径下的文件：" + absolutePath);
                //判断包下是否是.class文件
                if(absolutePath.endsWith(".class")){
                    String classNamePath = absolutePath.substring(absolutePath.indexOf("com"), absolutePath.indexOf(".class"));
                    System.out.println("类的路径：" + classNamePath);
                    //替换  \  -> .
                    classNamePath = classNamePath.replace("\\",".");
                    System.out.println("(新)类的路径：" + classNamePath);

                    //加载类
                    try {
                        Class<?> aClass = classLoader.loadClass(classNamePath);
                        if(aClass.isAnnotationPresent(Component.class)){
                            System.out.println("获取到带有Component注解的类：" + aClass);

                            if(BeanPostProcessor.class.isAssignableFrom(aClass)){
                                BeanPostProcessor o = (BeanPostProcessor) aClass.newInstance();
                                beanPostProcessorList.add(o);
                            }

                            //添加Bean到BeanDefinition集合中
                            Component component = aClass.getAnnotation(Component.class);
                            String beanName = component.value();

                            BeanDefinition beanDefinition = new BeanDefinition();
                            beanDefinition.setClazz(aClass);

                            if(aClass.isAnnotationPresent(Scope.class)){
                                Scope scope = aClass.getAnnotation(Scope.class);
                                String scopeValue = scope.value();
                                beanDefinition.setScope(scopeValue);
                            }else{
                                beanDefinition.setScope("Singleton");
                            }

                            beanDefinitionMap.put(beanName,beanDefinition);
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        throw new RuntimeException(e);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public Object getBean(String beanName){
        if(beanDefinitionMap.containsKey(beanName)){
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if(beanDefinition.getScope().equals("Singleton")){
                //单例
                Object o = singletonObjects.get(beanName);
                return o;
            }else {
                //多例
                Object o = createBean(beanName, beanDefinition);
                return o;
            }
        }else {
            throw new NullPointerException();
        }
//        return o;
    }

}
