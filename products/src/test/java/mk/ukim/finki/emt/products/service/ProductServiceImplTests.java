package mk.ukim.finki.emt.products.service;

import mk.finki.ukim.emt.sharedkernel.domain.financial.Currency;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.products.domain.models.Product;
import mk.ukim.finki.emt.products.domain.valueobjects.Employee;
import mk.ukim.finki.emt.products.domain.valueobjects.EmployeeId;
import mk.ukim.finki.emt.products.services.ProductService;
import mk.ukim.finki.emt.products.services.form.ProductForm;
import mk.ukim.finki.emt.products.xport.client.EmployeeClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class ProductServiceImplTests {

    @Autowired
    private ProductService productService;

    @Autowired
    private EmployeeClient employeeClient;

    @Test
    public void createProduct() {
        LocalDateTime dateTime = LocalDateTime.of(2023, 5, 17, 13, 00);
        ProductForm productForm = new ProductForm();
        productForm.setName("Product1");
        productForm.setStorageDate(dateTime);
        productForm.setPurchasedPrice(Money.valueOf(Currency.USD, 10));
        productForm.setEmployeeId(EmployeeId.of("1111-2222"));

        Product product = this.productService.createProduct(productForm);
        Assertions.assertEquals("Product1", product.getName(), "Names do not match!");
        Assertions.assertEquals(dateTime, product.getStorageDate(), "Storage timestamps do not match!");
        Assertions.assertEquals(Money.valueOf(Currency.USD, 10), product.getPurchasedPrice(), "Purchase prices do not match!");
        Assertions.assertEquals(EmployeeId.of("1111-2222"), product.getEmployeeId(), "Names do not match!");
    }

    @Test
    public void testCreateProductNull() {
        Assertions.assertThrows(NullPointerException.class, () -> this.productService.createProduct(null));
    }

    // TODO
    @Test
    public void createProductWithRealData() {
        List<Employee> employees = employeeClient.findAll();
        LocalDateTime dateTime = LocalDateTime.of(2023, 5, 17, 13, 00);
        ProductForm productForm = new ProductForm();
        productForm.setName("Product1");
        productForm.setStorageDate(dateTime);
        productForm.setPurchasedPrice(Money.valueOf(Currency.USD, 10));
        productForm.setEmployeeId(employees.get(0).getId());

        Product product = this.productService.createProduct(productForm);
        Assertions.assertEquals("Product1", product.getName(), "Names do not match!");
        Assertions.assertEquals(dateTime, product.getStorageDate(), "Storage timestamps do not match!");
        Assertions.assertEquals(Money.valueOf(Currency.USD, 10), product.getPurchasedPrice(), "Purchase prices do not match!");
        Assertions.assertEquals(employees.get(0).getId(), product.getEmployeeId(), "Names do not match!");
    }
}
