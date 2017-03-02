package servlet;

import model.Concise;
import util.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet
public class ConciseAction extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if (action.equals("add")) {
            add(req, resp);
        }
        if (action.equals("queryByPosId")) {
            add(req,resp);
        }

    }

    protected void queryByPosId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int posId = Integer.parseInt(req.getParameter("posId"));
        Connection connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM dictionary.concise WHERE posId=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, posId);
            resultSet = preparedStatement.executeQuery();

            List<Concise> concises = new ArrayList<>();
            while (resultSet.next()) {
                Concise concise = new Concise(resultSet.getInt("id"), resultSet.getString("chinese"), resultSet.getInt("posId"));
                concises.add(concise);
            }
            req.getSession().setAttribute("concises", concises);
            resp.sendRedirect("concise.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close(resultSet,preparedStatement,connection);
        }
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int posId = Integer.parseInt(req.getParameter("posId"));
        String chinese = req.getParameter("chinese");

        Connection connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO dictionary.concise VALUES (NULL ,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, chinese);
            preparedStatement.setInt(2, posId);

            preparedStatement.executeUpdate();

            resp.sendRedirect("concise.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
