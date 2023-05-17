package mk.finki.ukim.emt.sales.service;

import mk.finki.ukim.emt.sales.domain.config.ProfitPercentageHolder;
import mk.finki.ukim.emt.sales.domain.exceptions.InvalidSaleDateException;
import mk.finki.ukim.emt.sales.domain.models.Sale;
import mk.finki.ukim.emt.sales.domain.valueobjects.Employee;
import mk.finki.ukim.emt.sales.domain.valueobjects.Product;
import mk.finki.ukim.emt.sales.services.SaleService;
import mk.finki.ukim.emt.sales.services.form.SaleForm;
import mk.finki.ukim.emt.sales.xport.client.EmployeeClient;
import mk.finki.ukim.emt.sales.xport.client.ProductClient;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class SaleServiceImplTests {

    @Autowired
    private SaleService saleService;

    @Autowired
    private EmployeeClient employeeClient;

    @Autowired
    private ProductClient productClient;

    @Test
    public void testCreateSaleWithRealData() {
        List<Employee> employees = employeeClient.findAll();
        List<Product> products = productClient.findAll();
        LocalDateTime dateTime = LocalDateTime.of(2023, 5, 17, 16, 00);
        SaleForm form = new SaleForm();
        form.setSoldOn(dateTime);
        form.setQuantity(2);
        form.setEmployee(employees.get(0));
        form.setProduct(products.get(0));

        Sale sale = this.saleService.createSale(form);
        Money salePrice = products.get(0).getPurchasedPrice().increaseByPercentage(ProfitPercentageHolder.ORDINARY_PROFIT_PERCENTAGE);
        Assertions.assertEquals(dateTime, sale.getSoldOn(), "Sale timestamps do not match");
        Assertions.assertEquals(2, sale.getQuantity(), "Sale quantities do not match");
        Assertions.assertEquals(employees.get(0).getId(), sale.getEmployeeId(), "Sale employee ids do not match");
        Assertions.assertEquals(products.get(0).getId(), sale.getProductId(), "Sale product ids do not match");
        Assertions.assertEquals(salePrice.multiply(2), sale.subtotal(), "Sale subtotals do not match");
    }

    @Test
    public void testCreateSaleWithInvalidDate() {
        List<Employee> employees = employeeClient.findAll();
        List<Product> products = productClient.findAll();
        LocalDateTime dateTime = products.get(0).getStorageDate().minusDays(2);
        SaleForm form = new SaleForm();
        form.setSoldOn(dateTime);
        form.setQuantity(2);
        form.setEmployee(employees.get(0));
        form.setProduct(products.get(0));

        Assertions.assertThrows(InvalidSaleDateException.class, () -> this.saleService.createSale(form));
    }

    @Test
    public void testCreateSaleWithNull() {
        Assertions.assertThrows(NullPointerException.class, () -> this.saleService.createSale(null));
    }
}
