package com.example.assessment.dao;

import com.example.assessment.model.Affiliate;
import com.example.assessment.model.Customer;
import com.example.assessment.model.Employee;
import com.example.assessment.model.User;
import com.example.assessment.persistence.PersistenceStore;
import com.example.assessment.util.UserTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private PersistenceStore persistenceStore;


    @Override
    public Optional<User> getUser(long id) {
        return persistenceStore.getUsersList().stream().filter(userItem -> userItem.getId() == id).findFirst();
    }

    @Override
    public Optional<Employee> getEmployee(long id) {
        Optional<User> userOpt = persistenceStore.getUsersList().stream().filter(userItem -> userItem.getId() == id && userItem.getUserRole() == UserTypes.EMPLOYEE).findFirst();
        return userOpt.isEmpty()?Optional.empty():Optional.of((Employee) userOpt.get());
    }

    @Override
    public Optional<Affiliate> getAffiliate(long id) {
        Optional<User> userOpt = persistenceStore.getUsersList().stream().filter(userItem -> userItem.getId() == id && userItem.getUserRole() == UserTypes.AFFILIATE).findFirst();
        return userOpt.isEmpty()?Optional.empty():Optional.of((Affiliate) userOpt.get());
    }



    @Override
    public List<Employee> getAllEmployees() {
        return persistenceStore.getUsersList().stream().filter(userItem -> userItem.getUserRole() == UserTypes.EMPLOYEE).map(Employee.class::cast)
                .toList();
    }

    @Override
    public List<Affiliate> getAllAffiliates() {
        return persistenceStore.getUsersList().stream().filter(userItem -> userItem.getUserRole() == UserTypes.AFFILIATE).map(Affiliate.class::cast)
                .toList();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return persistenceStore.getUsersList().stream().filter(userItem -> userItem.getUserRole() == UserTypes.CUSTOMER).map(Customer.class::cast)
                .toList();
    }

    @Override
    public List<Customer> getLongTermCustomers() {
        return persistenceStore.getUsersList()
                .stream()
                .filter(userItem -> userItem.getUserRole() == UserTypes.CUSTOMER && ((Customer) userItem).isLongTermCustomer())
                .map(Customer.class::cast)
                .toList();
    }
}