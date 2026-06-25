


import main.java.com.rev.DAO.ProductDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public final class JdbcProductDao implements ProductDao {
    private final Connection connection;

    public JdbcProductDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public long insert(Product product) throws Exception {
        throw new UnsupportedOperationException("TODO: insert with RETURN_GENERATED_KEYS");
    }

    @Override
    public Optional<Product> findBySku(String sku) throws Exception {
        String sql = "SELECT id, sku, name, price, stock_qty FROM product WHERE sku = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, sku);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapRow(rs));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() throws Exception {
        List<Product> out = new ArrayList<>();
        String sql = "SELECT id, sku, name, price, stock_qty FROM product ORDER BY id";
        try (PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                out.add(mapRow(rs));
            }
        }
        return out;
    }

    @Override
    public void updateStock(String sku, int newQty) throws Exception {
        String sql = "UPDATE product set stock_qty = ? WHERE sku = ?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, newQty);
            ps.setString(2, sku);
            int n = ps.executeUpdate();
            if(n!=1){
                throw new IllegalStateException("expected 1 row updated, got "+n);
            }
        }
    }

    @Override
    public void deleteBySku(String sku) throws Exception {
        String sql = "DELETE FROM product where sku = ?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1,sku);
            ps.executeUpdate();
        }
    }

    private static Product mapRow(ResultSet rs) throws Exception {
        return new Product(
                rs.getLong("id"),
                rs.getString("sku"),
                rs.getString("name"),
                rs.getDouble("price"),
                rs.getInt("stock_qty"));
    }
}