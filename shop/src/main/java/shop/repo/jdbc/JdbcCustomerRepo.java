package shop.repo.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import shop.domain.Customer;
import shop.repo.CustomerRepository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;


@Repository
public class JdbcCustomerRepo implements CustomerRepository {

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    private final JdbcTemplate jdbc;

    public JdbcCustomerRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    @Override
    public Customer add(Customer customer) {
        if (customer.getId() == null) {
            final String sql = "insert into customer (firstName , lastName) values (?,?)";
            GeneratedKeyHolder holder = new GeneratedKeyHolder();
            this.jdbc.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
                ps.setString(1, customer.getFirstName());
                ps.setString(2, customer.getLastName());
                return ps;
            }, holder);
            customer.setId(holder.getKey().longValue());
        }
        return null;
    }

    @Override
    public List<Customer> findAll() {
        final String SELECT_ALL_SQL = " SELECT * FROM customer ";
        return this.jdbc.query( SELECT_ALL_SQL,
                BeanPropertyRowMapper.newInstance(Customer.class));
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Customer findOne(int id) {
        return null;
    }
}
