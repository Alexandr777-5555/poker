package shop.web.view;


import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import shop.domain.Customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class PDFBuilder extends AbstractPdfView {


    @Override
    protected void buildPdfDocument(Map<String, Object> map,
                                    Document document,
                                    PdfWriter pdfWriter,
                                    HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse) throws Exception {


        List<Customer> cartList = (List<Customer>) map.get("customers");

        // строим документ
        Table table = new Table(3);
        addTitleDoc(table);



        document.add(table);
    }


    private void addContent(Table table , Customer customer){



    }


    private void addTitleDoc(Table table){


    }
}
