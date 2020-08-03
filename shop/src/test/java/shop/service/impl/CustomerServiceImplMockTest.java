package shop.service.impl;

import org.junit.Before;
import org.junit.Test;
import shop.model.Customer;
import shop.repo.CustomerRepository;
import shop.service.CustomerService;

import static org.mockito.Mockito.*;


public class CustomerServiceImplMockTest {

    private CustomerRepository repository;
    private CustomerService service;


    @Before
    public void init() {
        repository = mock(CustomerRepository.class);
        service = new CustomerServiceImpl(repository);
    }

  //  @Test
    public void callMethodFindInService() {
        Customer customer = new Customer();
        when(repository.find(customer)).thenReturn(customer);
        // выполняем поиск объекта
        service.find(customer);
        // проверяем что был репозиторий вызвал 1 раз
        verify(repository, times(1)).find(customer);
    }


 //   @Test
    public void callMethodCreateInService() {
        Customer customer = new Customer();
        when(repository.find(customer)).thenReturn(customer);
        //выполняем сохранение
        service.create(customer);
        // проверяем что было вызвано
        verify(repository, times(1)).create(customer);
    }



}