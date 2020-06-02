package shop.web.view;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import shop.domain.ShoppingCart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class PdfReport extends AbstractPdfView {


    @Override
    protected void buildPdfDocument(Map<String, Object> map,
                                    Document document,
                                    PdfWriter pdfWriter,
                                    HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse) throws Exception {

        List<ShoppingCart> cartList = (List<ShoppingCart>) map.get("shopcarts");
        // строим документ
        Table table = new Table(3);
        addTitleDoc(table);

        for (ShoppingCart cart : cartList) {
            addContent(table, cart);
        }
        document.add(table);
    }

    private void addContent(Table table, ShoppingCart cart) throws BadElementException {
        table.addCell(cart.getOwner());
        table.addCell(cart.getProduct().getName());
        table.addCell(cart.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

    }


    private void addTitleDoc(Table table) throws BadElementException {
        table.addCell("Name");
        table.addCell("Product");
        table.addCell("date");
    }


}
