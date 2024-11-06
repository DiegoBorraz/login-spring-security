package com.loginspring.api.specification;

import com.loginspring.domain.entity.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class UserSpecification implements Specification<User> {
    private final String search;
    private final String[] fields;

    public UserSpecification(String search, String[] fields) {
        this.search = search;
        this.fields = fields;
    }

    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicateList = new ArrayList<>();
        if (!search.isEmpty() && fields != null) {
            for (String field : fields) {
                switch (field) {
                    case "name":
                        predicateList.add(criteriaBuilder.like(criteriaBuilder.upper(root.get("name")), "%" + search.toUpperCase() + "%"));
                        break;
                    case "email":
                        predicateList.add(criteriaBuilder.like(criteriaBuilder.upper(root.get("email")), "%" + search.toUpperCase() + "%"));
                        break;
                }
            }
        }
        return criteriaBuilder.or(predicateList.stream().toArray(Predicate[]::new));
    }
}
