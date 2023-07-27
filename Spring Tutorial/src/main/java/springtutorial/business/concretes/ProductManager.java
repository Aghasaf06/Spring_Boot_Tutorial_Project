package springtutorial.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import springtutorial.business.abstracts.ProductService;
import springtutorial.core.utilities.results.DataResult;
import springtutorial.core.utilities.results.Result;
import springtutorial.core.utilities.results.SuccessDataResult;
import springtutorial.core.utilities.results.SuccessResult;
import springtutorial.dataAccess.ProductDao;
import springtutorial.entities.concretes.Product;
import springtutorial.entities.dtos.ProductWithCategoryDto;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(), "Products are listed!");
    }

    @Override
    public DataResult<List<Product>> getAllByPage(int pageNumber, int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);

        return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent(), "Products are listed by page!");
    }

    @Override
    public DataResult<List<Product>> getAllBySorted(String direction) {

        Sort sort;
        String message;

        direction = direction.toUpperCase();

        if(direction.equals("ASC")) {
            sort = Sort.by(Sort.Direction.ASC, "productName");
            message = "Products are listed in ascending order!";
        } else {
            sort = Sort.by(Sort.Direction.DESC, "productName");
            message = "Products are listed in descending order!";
        }

        return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort), message);
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Product are added!");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>(this.productDao.getByProductName(productName), "Product are listed!");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId), "Product are listed!");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId), "Products are listed!");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByCategory_CategoryIdIn(categories), "Products are listed!");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName), "Products are listed!");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName), "Products are listed!");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByNameAndCategory(productName, categoryId), "Products are listed!");
    }

    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productDao.getProductWithCategoryDetails(), "Products are listed!");
    }
}
