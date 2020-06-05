package shop.repo.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import shop.domain.Customer;
import shop.repo.CustomerRepository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;


public class JdbcCustomerRepo implements CustomerRepository {

    private final JdbcTemplate jdbc;

    public JdbcCustomerRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    @Override
    public Customer add(Customer customer) {
        if (customer.getFirstName() == null) {
            final String sql = "insert into customer (firstName , lastName) values (?,?) ";
            GeneratedKeyHolder holder = new GeneratedKeyHolder();

            this.jdbc.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
                ps.setString(1, customer.getFirstName());
                ps.setString(2, customer.getLastName());
                return ps;
            }, holder);
            customer.setId(holder.getKey().intValue());
        }
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Customer findOne(int id) {
        return null;
    }
}
