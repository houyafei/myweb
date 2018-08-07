package com.houyafei.servlet;

import com.houyafei.annotation.MyController;
import com.houyafei.annotation.MyRequestMapping;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

/**
 * 事件分发所使用的servlet
 *
 * @author yafei.hou  on 2018/8/6
 */
public class MyDispatcherServlet extends HttpServlet {

    private static final Set<String> classNames = new HashSet<>();

    private static final Map<String, Class> ioc = new HashMap<>();

    private static final Map<String, Method> handlerMapping = new HashMap<>();

    private static final Map<String, Object> controllerMap = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatch(req, resp);
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取url
        String url = decodeUrl(req);
        //找出对应的实例类和实例方法
        Object object = controllerMap.get(url);
        Method method = handlerMapping.get(url);
        if (object == null || method == null) {
            resp.getWriter().write("i am so sorry<br> can not find");
            return;
        }
        //读取请求参数
        Class<?>[] parameterTypes = method.getParameterTypes();
        Map<String, String[]> parameterMap = req.getParameterMap();
        //保存参数值
        Object[] parameterValue = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            //
            String paramName = parameterTypes[i].getSimpleName();
            if (paramName.equals("HttpServletRequest")) {
                parameterValue[i] = req;
                continue;
            }
            if (paramName.equals("HttpServletResponse")) {
                parameterValue[i] = resp;
                continue;
            }
            if (paramName.equals("String")) {
                for (Map.Entry<String, String[]> param : parameterMap.entrySet()) {
                    String value = Arrays.toString(param.getValue())
                            .replace("\\[\\]", "")
                            .replace(",\\s", ",");
                    parameterValue[i] = value;
                }
            }
        }
        try {
            resp.getWriter().write(method.invoke(object,parameterValue).toString());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("初始化开始");
        //1、获取web.xml中配置的要扫描的包
        String resource = config.getInitParameter("configLocation");
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream(resource));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2、如果配置了多个包，按照逗号分隔
        String[] packages = properties.getProperty("scanPage").split(",");
        for (String aPackage : packages) {
            scanPackage(aPackage, classNames);
        }
        //3、实例化所有的注解类
        doInstance();
        //4、url映射器
        doHandlerMapping();
        System.out.println("ioc 容器：" + ioc);
        System.out.println("url映射器");
        System.out.println(handlerMapping);
        System.out.println("初始化结束");
    }

    private void doHandlerMapping() {
        if (ioc.isEmpty()) {
            return;
        }
        ioc.forEach((k, clazz) -> {
            if (!clazz.isAnnotationPresent(MyController.class)) {
                return;
            }
            //开始实现url拼接
            String baseUrl = "";
            if (clazz.isAnnotationPresent(MyRequestMapping.class)) {
                MyRequestMapping requestMapping = (MyRequestMapping) clazz.getAnnotation(MyRequestMapping.class);
                baseUrl = requestMapping.value();
            }
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(MyRequestMapping.class)) {
                    MyRequestMapping requestMapping = method.getAnnotation(MyRequestMapping.class);
                    String url = requestMapping.value();
                    url = (baseUrl + "/" + url).replaceAll("//+", "/");
                    handlerMapping.put(url, method);
                    try {
                        controllerMap.put(url, clazz.newInstance());
                    } catch (InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    /**
     * 将被标注的Controller进行实例化，存放到ioc容器中
     */
    private void doInstance() {
        classNames.forEach((className) -> {
            String name = className.toLowerCase();
            try {
                Class<?> clazz = Class.forName(className);
                if (clazz.isAnnotationPresent(MyController.class)) {
                    ioc.put(name, clazz);
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 扫描包
     */
    private void scanPackage(String packageName, Set<String> classNames) {
        URL url = this.getClass().getResource("/" + packageName.replaceAll("\\.", "/"));
        File baseFile = new File(url.getFile());
        File[] files = baseFile.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                scanPackage(packageName + "." + file.getName(), classNames);
            } else {
                classNames.add(packageName + "." + file.getName().replace(".class", ""));
            }
        }
    }


    /**
     * 从http请求中获得请求路径
     */
    private String decodeUrl(HttpServletRequest request) {
        String path = request.getContextPath() + "/";
        String requestUri = request.getRequestURI();
     //  String midUrl = requestUri.replace(path, "");
        String lastUrl = requestUri.replaceAll("//+","/");
        System.out.println("请求的url ： " + lastUrl);
        return lastUrl;
    }


}
