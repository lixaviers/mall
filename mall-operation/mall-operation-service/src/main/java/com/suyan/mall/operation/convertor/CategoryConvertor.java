package com.suyan.mall.operation.convertor;

import com.google.common.collect.Lists;
import com.suyan.mall.operation.model.Category;
import com.suyan.mall.operation.req.CategoryDTO;
import com.suyan.mall.operation.resp.CategoryVO;
import com.suyan.query.QueryResultVO;
import com.suyan.utils.CollectionsUtil;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 * @jdk 1.8
 * @Version: <1.0>
 */
public abstract class CategoryConvertor {

    private static final BeanCopier beanCopierForCategoryVO = BeanCopier.create(Category.class, CategoryVO.class, false);
    private static final BeanCopier beanCopierForCategory = BeanCopier.create(CategoryDTO.class, Category.class, false);

    public static CategoryVO toCategoryVO(Category category) {
        if (category == null) {
            return null;
        }
        CategoryVO categoryVO = new CategoryVO();
        beanCopierForCategoryVO.copy(category, categoryVO, null);
        return categoryVO;
    }

    public static Category toCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        beanCopierForCategory.copy(categoryDTO, category, null);
        return category;
    }

    public static List<CategoryVO> toCategoryVOList(List<Category> categoryList) {
        if (categoryList == null || categoryList.isEmpty()) {
            return null;
        }
        List<CategoryVO> categoryInfoList = new ArrayList<CategoryVO>(categoryList.size());
        for (Category category : categoryList) {
            categoryInfoList.add(toCategoryVO(category));
        }
        return categoryInfoList;
    }

    public static List<Category> toCategoryList(List<CategoryDTO> categoryDTOList) {
        if (categoryDTOList == null || categoryDTOList.isEmpty()) {
            return null;
        }
        List<Category> categoryList = new ArrayList<Category>(categoryDTOList.size());
        for (CategoryDTO categoryDTO : categoryDTOList) {
            categoryList.add(toCategory(categoryDTO));
        }
        return categoryList;
    }

    public static QueryResultVO<CategoryVO> toQueryResult(QueryResultVO<Category> queryResult) {
        QueryResultVO<CategoryVO> queryResultInfo = new QueryResultVO<CategoryVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toCategoryVOList(queryResult.getRecords()));
        return queryResultInfo;
    }


    public static List<CategoryVO> toTree(List<Category> categoryList) {
        if (CollectionsUtil.isNotEmpty(categoryList)) {
            // 顶级类目
            List<CategoryVO> topCategoryList = toCategoryVOList(categoryList.stream().filter(bean -> bean.getParentId().equals(0)).sorted(Comparator.comparing(Category::getSortNumber)).collect(Collectors.toList()));
            List<CategoryVO> childCategoryList = toCategoryVOList(categoryList.stream().filter(bean -> !bean.getParentId().equals(0)).collect(Collectors.toList()));
            sort(topCategoryList, childCategoryList);

            return topCategoryList;
        }
        return null;
    }

    private static void sort(List<CategoryVO> topCategoryList, List<CategoryVO> childCategoryList) {
        List<CategoryVO> copyVos = Lists.newCopyOnWriteArrayList(childCategoryList);
        for (CategoryVO top : topCategoryList) {
            for (CategoryVO child : childCategoryList) {
                if (Objects.equals(top.getId(), child.getParentId())) {
                    top.addChildCategoryList(child);
                    copyVos.remove(child);
                }
            }
        }
        for (CategoryVO top : topCategoryList) {
            if (CollectionsUtil.isNotEmpty(top.getChildCategoryList())) {
                // 子类目排序
                top.setChildCategoryList(top.getChildCategoryList().stream().sorted(Comparator.comparing(CategoryVO::getSortNumber)).collect(Collectors.toList()));
                sort(top.getChildCategoryList(), copyVos);
            }
        }
    }


}