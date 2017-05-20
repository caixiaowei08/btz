package org.baron.framework.core.common.bootstrapTable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.baron.framework.core.common.hibernate.DataGrid;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by User on 2017/5/20.
 */
public class DataUtils {
    public static void datagrid(HttpServletResponse response, DataGrid dg) {
        response.setContentType("application/json");
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        try {
            PrintWriter pw=response.getWriter();
            pw.write(JSON.toJSONString(dg));
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
