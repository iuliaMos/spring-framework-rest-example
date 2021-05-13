package com.example.dao;

import com.example.dao.interfaces.AbstractJpaDAO;
import com.example.dao.interfaces.IDepartmentDao;
import com.example.dto.filter.DepartmentSearchCriteria;
import com.example.entity.Department;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class DepartmentDao extends AbstractJpaDAO<Department> implements IDepartmentDao {

    public DepartmentDao() {
        setClazz(Department.class);
    }

    public List<Department> findAll(final DepartmentSearchCriteria filter, Integer page, Integer size) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();

        CriteriaQuery<Department> cq = cb.createQuery(Department.class);
        Root<Department> root = cq.from(Department.class);

        List<Predicate> predicates = filterPredicate(filter, root, cb);

        cq.where(!CollectionUtils.isEmpty(predicates) ? cb.and(predicates.stream().toArray(Predicate[]::new)) : cb.conjunction());

        TypedQuery<Department> query = getEntityManager().createQuery(cq);
        query.setFirstResult(page == 0 ? 0 : page * size);
        query.setMaxResults(size);

        return query.getResultList();
    }

    private List<Predicate> filterPredicate(final DepartmentSearchCriteria filter, Root<Department> root, CriteriaBuilder cb) {
        final List<Predicate> predicates = new ArrayList<>();

        if (!Objects.isNull(filter.getId())) {
            predicates.add(cb.equal(root.get("id"), filter.getId()));
        }

        if (!Objects.isNull(filter.getName())) {
            predicates.add(cb.like(root.get("name"), "%" + filter.getName() + "%"));
        }

        return predicates;
    }

}
