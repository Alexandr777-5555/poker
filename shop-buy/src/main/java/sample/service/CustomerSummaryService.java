package sample.service;


import sample.view.CustomerSummary;

import java.util.List;

public interface CustomerSummaryService {

    /**
     * выбрать всех покупателей по последней покупке ( т.е. дате)
     * @return
     */
    List<CustomerSummary> findAllLastDatePurchase();

}
