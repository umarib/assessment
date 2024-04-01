package com.example.assessment.persistence;

import com.example.assessment.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Component
public class PersistenceStore {

    private List<User> usersList = new ArrayList<>();

    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }

    @PostConstruct
    private void populateUserListWithDummyData() {
        usersList.addAll(DummyDataGenerator.getDummyEmployeeList());
        usersList.addAll(DummyDataGenerator.getDummyAffiliateList());
        usersList.addAll(DummyDataGenerator.getDummyCustomerList());
    }


}
