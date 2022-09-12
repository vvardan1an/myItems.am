package manager;

import database.DBConnectionProvider;
import model.Category;
import model.Item;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    private final Connection connection = DBConnectionProvider.getInstance().getConnection();

    private final CategoryManager categoryManager = new CategoryManager();

    private final UserManager userManager = new UserManager();

    public void add(Item item) {
        String sql = "insert into item(title,price,category_id,pic_url,user_id) VALUES (?,?,?,?,?)";
        try {

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, item.getTitle());
            ps.setDouble(2, item.getPrice());
            ps.setInt(3, Integer.parseInt(String.valueOf(item.getCategory())));
            ps.setString(4, item.getCatPic());
            ps.setInt(5, Integer.parseInt(String.valueOf(item.getUser())));

            ps.executeUpdate();
            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                item.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Item> getAll() {
        String sql = "select * from item";
        List<Item> books = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                books.add(getItemFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public Item getById(int id) {
        String sql = "select * from item where id = " + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                return getItemFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void removeItem(int id) {
        String sql = "delete from item where id =" + id;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Item getItemFromResultSet(ResultSet resultSet) throws SQLException {
        Item item = new Item();
        item.setId(resultSet.getInt("id"));
        item.setTitle(resultSet.getString("title"));
        item.setPrice(resultSet.getDouble("price"));
        int category = resultSet.getInt("category_id");
        item.setCatPic(resultSet.getString("pic_url"));
        int user = resultSet.getInt("user_id");
        Category category1 = categoryManager.getById(category);
        User user1 = userManager.getById(user);

        item.setCategory(category1);
        item.setUser(user1);

        return item;
    }
}
