package com.example.dao;

import com.example.dao.interfaces.AbstractJpaDAO;
import com.example.dao.interfaces.IEmployeeDao;
import com.example.dto.filter.EmployeeSearchCriteria;
import com.example.entity.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class EmployeeDao extends AbstractJpaDAO<Employee> implements IEmployeeDao {

    public EmployeeDao() {
        setClazz(Employee.class);
    }

    public List<Employee> findAll(final EmployeeSearchCriteria filter) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

        Root<Employee> root = cq.from(Employee.class);

        List<Predicate> predicates = filterPredicate(filter, root, cb);

        cq.where(!CollectionUtils.isEmpty(predicates) ? cb.and(predicates.stream().toArray(Predicate[]::new)) : cb.conjunction());

        cq.orderBy(cb.asc(root.get("department").get("name")));

        return getEntityManager().createQuery(cq).getResultList();
    }

    private List<Predicate> filterPredicate(EmployeeSearchCriteria filter, Root<Employee> root, CriteriaBuilder cb) {
        final List<Predicate> predicates = new ArrayList<>();

        if (!Objects.isNull(filter.getId())) {
            predicates.add(cb.equal(root.get("id"), filter.getId()));
        }

        if (!Objects.isNull(filter.getName())) {
            predicates.add(cb.like(root.get("name"), "%" + filter.getName() + "%"));
        }

        if (!Objects.isNull(filter.getDepartment())) {
            predicates.add(cb.like(root.get("department").get("name"), "%" + filter.getDepartment() + "%"));
        }

        return predicates;
    }
}
