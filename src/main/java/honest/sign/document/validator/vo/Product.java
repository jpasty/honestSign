package honest.sign.document.validator.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Product {
    @NotBlank
    private String name;
    @NotBlank
    @Pattern(regexp = "^\\d{13}$",
            message = "Идентификатор продукта должен состоять из 13 цифр")
    private String code;
}
