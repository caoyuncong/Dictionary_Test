package servlet;

import model.Detail;
import util.DB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/27.
 */
public class DetailAction extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if (action.equals("add")) {
            add(req, resp);
        }
        if (action.equals("queryByPosId")) {
            queryByPosId(req, resp);
        }
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int posId = Integer.parseInt(req.getParameter("posId"));
        String detail = req.getParameter("detail");

        Connection connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO dictionary.detail VALUES (NULL,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, detail);
            preparedStatement.setInt(2, posId);

            preparedStatement.executeUpdate();

            resp.sendRedirect("detail?action=queryByPosId&posId=" + posId);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close(null,preparedStatement,connection);
        }
    }

    protected void queryByPosId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int posId=Integer.parseInt(req.getParameter("posId"));
        Connection connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM dictionary.detail WHERE posId=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, posId);
            resultSet = preparedStatement.executeQuery();

            List<Detail> details = new ArrayList<>();
            while (resultSet.next()) {
                Detail detail = new Detail(resultSet.getInt("id"), resultSet.getString("detail"),
                        resultSet.getInt("posId"));
                details.add(detail);
            }
            req.getSession().setAttribute("details", details);
            req.getSession().setAttribute("posId", posId);

            resp.sendRedirect("detail.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close(resultSet,preparedStatement,connection);
        }

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
