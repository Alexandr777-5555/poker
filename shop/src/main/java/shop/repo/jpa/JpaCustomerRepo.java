package shop.repo.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shop.model.Customer;

@Repository("jpaCustomer")
public interface JpaCustomerRepo
      extends CrudRepository <Customer , Long >
 {

   // @Autowired
  //  private EntityManagerFactory entityManagerFactory;

//    @Autowired
//    public JpaCustomerRepo(EntityManagerFactory entityManagerFactory) {
//        this.entityManagerFactory = entityManagerFactory;
//    }

//    @Override
//    public Customer add(Customer customer) {
//        return null;
//    }
//
//    @Override
//    public List<Customer> findAll() {
//        return null;
//    }
//
//    @Override
//    public void remove(long id) {
//
//    }
//
//    @Override
//    public Customer findOne(long id) {
//        return null;
//    }
}
