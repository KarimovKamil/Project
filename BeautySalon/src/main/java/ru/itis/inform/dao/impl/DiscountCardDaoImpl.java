package ru.itis.inform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.DiscountCardDao;
import ru.itis.inform.dao.mappers.DiscountCardMapper;
import ru.itis.inform.models.DiscountCard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kamil Karimov on 29.11.2016.
 */
@Repository
public class DiscountCardDaoImpl implements DiscountCardDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static String SQL_SAVE =
            "INSERT INTO discount_card (discount, registration_date) " +
            "VALUES (:discount, :registrationDate) RETURNING discount_card.card_id;";

    private static String SQL_DELETE =
            "DELETE FROM discount_card WHERE card_id = :cardId;";

    private static String SQL_UPDATE =
            "UPDATE discount_card SET (discount) = (:discount) " +
                    "WHERE card_id = :cardId;";

    private static String SQL_GET_BY_ID =
            "SELECT * FROM discount_card WHERE card_id = :cardId;";

    private static String SQL_GET_ALL =
            "SELECT * FROM discount_card;";

    @Override
    public int saveDiscountCard(DiscountCard discountCard) {
        Map<String, Object> params = new HashMap<>();
        params.put("discount", discountCard.getDiscount());
        params.put("registrationDate", System.currentTimeMillis());
        return namedParameterJdbcTemplate.queryForObject(SQL_SAVE, params, int.class);
    }

    @Override
    public void deleteDiscountCard(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("cardId", id);
        namedParameterJdbcTemplate.update(SQL_DELETE, params);
    }

    @Override
    public void updateDiscountCard(DiscountCard discountCard, int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("cardId", id);
        params.put("discount", discountCard.getDiscount());
        namedParameterJdbcTemplate.update(SQL_UPDATE, params);
    }

    @Override
    public DiscountCard getDiscountCardById(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("cardId", id);
        return (DiscountCard) namedParameterJdbcTemplate.queryForObject(SQL_GET_BY_ID, params, new DiscountCardMapper());
    }

    @Override
    public List<DiscountCard> getAll() {
        return namedParameterJdbcTemplate.query(SQL_GET_ALL, new DiscountCardMapper());
    }
}
