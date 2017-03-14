package org.btz.test.controller;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by User on 2017/3/12.
 */
@Controller
@RequestMapping("testController")
public class LogController {

    private static Logger logger = LogManager.getLogger(LogController.class.getName());

    @RequestMapping(params = "log")
    public String index(HttpServletRequest request, HttpServletResponse response){
        //打印日志1
        logger.debug("日志级别：DEBUG");
        logger.info("日志级别：INFO");
        logger.warn("日志级别：WARN");
        logger.error("日志级别：ERROR");
        logger.fatal("日志级别：FATAL");
        //打印日志2
        logger.log(Level.DEBUG, "日志级别：DEBUG");
        logger.log(Level.INFO, "日志级别：INFO");
        logger.log(Level.WARN, "日志级别：WARN");
        logger.log(Level.ERROR, "日志级别：ERROR");
        return "login/login";
    }
}
