package springtutorial.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springtutorial.business.abstracts.ProductService;
import springtutorial.core.utilities.results.DataResult;
import springtutorial.core.utilities.results.Result;
import springtutorial.entities.concretes.Product;
import springtutorial.entities.dtos.ProductWithCategoryDto;

import java.util.List;

@RestController
@RequestMapping(path = "/api/products")
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/getAll")
    public DataResult<List<Product>> getAll() {
        return this.productService.getAll();
    }

    @GetMapping(path = "/getAllByPage")
    public DataResult<List<Product>> getAllByPage(int pageNumber, int pageSize) {
        return this.productService.getAllByPage(pageNumber, pageSize);
    }

    @GetMapping(path = "/getAllBySorted")
    public DataResult<List<Product>> getAllBySorted(String direction) {
        return this.productService.getAllBySorted(direction);
    }

    @PostMapping(path = "/add")
    public Result add(@RequestBody Product product) {
        return this.productService.add(product);
    }

    @GetMapping(path = "/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam(name = "productName") String productName) {
        return this.productService.getByProductName(productName);
    }

    @GetMapping(path = "/getByProductNameAndCategoryId")
    public DataResult<Product> getByProductNameAndCategoryId(@RequestParam(name = "productName") String productName, @RequestParam(name = "categoryId") int categoryId) {
        return this.productService.getByProductNameAndCategoryId(productName, categoryId);
    }

    @GetMapping(path = "/getByProductNameOrCategoryId")
    public DataResult<List<Product>> getByProductNameOrCategoryId(@RequestParam(name = "productName") String productName, @RequestParam(name = "categoryId") int categoryId) {
        return this.productService.getByProductNameOrCategoryId(productName, categoryId);
    }

    @GetMapping(path = "/getByCategoryIdIn")
    public DataResult<List<Product>> getByCategoryIdIn(@RequestParam(name = "categoryId") List<Integer> categories) {
        return this.productService.getByCategoryIdIn(categories);
    }

    @GetMapping(path = "/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam(name = "productName") String productName) {
        return this.productService.getByProductNameContains(productName);
    }

    @GetMapping(path = "/getByProductNameStartsWith")
    public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam(name = "productName") String productName) {
        return this.productService.getByProductNameStartsWith(productName);
    }

    @GetMapping(path = "/getByNameAndCategory")
    public DataResult<List<Product>> getByNameAndCategory(@RequestParam(name = "productName") String productName, @RequestParam(name = "categoryId") int categoryId) {
        return this.productService.getByNameAndCategory(productName, categoryId);
    }

    @GetMapping(path = "/getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return this.productService.getProductWithCategoryDetails();
    }
}
