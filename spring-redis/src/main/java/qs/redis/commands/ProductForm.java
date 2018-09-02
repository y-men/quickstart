package qs.redis.commands;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by jt on 1/10/17.
 */

@Getter
@Setter
public class ProductForm {
    private String id;
    private String description;
    private BigDecimal price;
    private String imageUrl;

}
