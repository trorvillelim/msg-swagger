package main.app;

import main.annotation.DynamicData;
import main.annotation.Environment;
import main.annotation.OperationHidden;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class AppEnvironmentUtil {

    public String environment = "SIT";

    public Map<String, List> methods = null;
    public Map<String, List<String>> paths = null;
    public Map<String, Map<String, String>> dynamicDataList = null;

    public enum ENVIRONMENTS {
        SIT,
        UAT,
        PROD;

        // endpoints
        static String sitEndPoint = "http://msgsit.rpdata.com/ttsvr/msg?";
        static String prodEndPoint = "http://msg.rpdata.com/ttsvr/msg?";
        static String uatEndPoint = "http://msgstage.rpdata.com/ttsvr/msg?";

        // get end points
        public static String getSITendPoints() {
            return sitEndPoint;
        }

        public static String getProdEndPoints() {
            return prodEndPoint;
        }

        public static String getUatEndPoint() {
            return uatEndPoint;
        }
    }

    public String getEnvironment() {
        return environment;
    }


    public Map<String, List> getMethods() {
        return methods;
    }

    public Map<String, List<String>> getPaths() {
        return paths;
    }

    /**
     * called on ApiEnvFilterImpl Constructor
     */
    public void initializeEnvironmentApis() {

        if (methods == null || paths == null) {
            methods = new HashMap<String, List>();
            paths = new HashMap<String, List<String>>();
            dynamicDataList = new HashMap<String,  Map<String, String>>();

            Set<Class<?>> classes = scanApiClasses("main.api");
            Set<Class<?>> modelClasses = scanApiClasses("main.models");
            scanEnvironmentClasses(classes);
            scanOperationHiddenFieldsInClasses(modelClasses);
        }
    }

    /**
     * @param environment possible values: UAT, PROD, SIT
     */
    public static String getCurrentEndPointByString(String environment) {

        if (environment.equals(ENVIRONMENTS.PROD.toString())) {
            return  ENVIRONMENTS.getProdEndPoints();
        } else if (environment.equals(ENVIRONMENTS.UAT.toString())) {
            return ENVIRONMENTS.getUatEndPoint();
        } else {
            return ENVIRONMENTS.getSITendPoints();
        }
    }

    public Map<String, Map<String, String>> getDynamicDataList() {
        return dynamicDataList;
    }

    public void setDynamicDataList(Map<String, Map<String, String>> dynamicDataList) {
        this.dynamicDataList = dynamicDataList;
    }

    /**
     * Scans all the methods from main.Apis using reflection
     *
     *packageName example main.api
     */
    private Set<Class<?>> scanApiClasses(String packageName) {


        List<ClassLoader> classLoadersList = new LinkedList<ClassLoader>();
        classLoadersList.add(ClasspathHelper.contextClassLoader());
        classLoadersList.add(ClasspathHelper.staticClassLoader());

        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setScanners(new SubTypesScanner(false /* don't exclude Object.class */), new ResourcesScanner())
                .setUrls(ClasspathHelper.forClassLoader(classLoadersList.toArray(new ClassLoader[0])))
                .filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix(packageName))));

        Set<Class<?>> classes = reflections.getSubTypesOf(Object.class);

        return classes;

    }

    /**
     * scan API class for environment
     * @param classes
     */
    private void scanEnvironmentClasses(Set<Class<?>> classes) {
        for (Class c : classes) {

            for (Method m : c.getMethods()) {
                // if method has environment annotation put it on map
                if (m.getAnnotation(Environment.class) != null) {
                    Environment a = m.getAnnotation(Environment.class);
                    String[] env = a.environments() == null ? null : a.environments();
                    methods.put(m.getName(), Arrays.asList(env));
                }
            }
        }
    }

    /**
     * scan OperationHidden annotation
     * @param classes
     */
    private void scanOperationHiddenFieldsInClasses(Set<Class<?>> classes) {
        for (Class c : classes) {
            // map all fields with annotated OperationHidden
            for (Field field : c.getDeclaredFields()){
                if (field.getAnnotation(OperationHidden.class) != null){
                    OperationHidden op = field.getAnnotation(OperationHidden.class);
                    String[] ops = op.operations() == null ? null : op.operations();

                    for (String operationName : Arrays.asList(ops)){
                       if (paths.containsKey(operationName)){
                           paths.get(operationName).add(field.getName());
                           continue;
                       }
                        paths.put(operationName, new ArrayList<String>(Arrays.asList(field.getName())));
                    }
                }

                // map all fields with annotated DynamicData
                if (field.getAnnotation(DynamicData.class) != null){
                    DynamicData dynamicData = field.getAnnotation(DynamicData.class);
                    String operationName = dynamicData.methodName();

                    if (dynamicDataList.containsKey(operationName)){
                        dynamicDataList.get(operationName).put(field.getName(), dynamicData.type());
                        continue;
                    }

                    Map<String, String> map = new HashMap<>();
                    map.put(field.getName(), dynamicData.type());
                    dynamicDataList.put(operationName, map);
                }

            }
        }
    }

}
