package sample.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.config.TestConfig;
import sample.service.CustomerSummaryService;
import sample.view.CustomerSummary;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@ActiveProfiles("test")
public class CustomerSummaryServiceImplTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CustomerSummaryService summaryService;

    @Test
    @Sql({"classpath:test/data.sql"})
    public void findAllSummary() {
        List<CustomerSummary> list = summaryService.findAllLastDatePurchase();
        assertEquals(3, list.size());
        listCustomerSummary(list);
    }

    private void listCustomerSummary(List<CustomerSummary> list) {
        logger.info("Customer Summary report start");
        for (CustomerSummary customer : list)
            logger.info(customer.toString());
        logger.info("Customer Summary report end");
    }


}