package qs.redis.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.math.BigDecimal;

/**
 * Created by jt on 1/10/17.
 */
@Data
@RedisHash("products")
public class Product {
    @Id
    private String id;
    private String description;
    private BigDecimal price;
    private String imageUrl;


}
