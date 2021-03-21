package kr.co.sungbin.eatgo.application;

import kr.co.sungbin.eatgo.domain.Category;
import kr.co.sungbin.eatgo.domain.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public List<Category> getCategories() {

        return categoryRepository.findAll();
    }
}
