package ru.itis.inform.dao.data;

import ru.itis.inform.models.Customer;
import ru.itis.inform.models.DiscountCard;

/**
 * Created by Kamil Karimov on 12.12.2016.
 */
public class CustomerTestData {
    public static Customer getCustomer1() {
        DiscountCard discountCard = new DiscountCard.Builder()
                .id(1)
                .discount(10)
                .registrationDate(11)
                .build();
        return new Customer.Builder()
                .id(1)
                .gender("M")
                .lastName("aaa")
                .firstName("aa")
                .middleName("aaaa")
                .discountCard(discountCard)
                .phone("987")
                .token("das")
                .hashPassword("nos")
                .build();
    }
}
