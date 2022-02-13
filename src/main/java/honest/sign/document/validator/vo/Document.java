package honest.sign.document.validator.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = false)
public class Document {
    @NotBlank
    @Pattern(regexp = "^\\d{9}$",
            message = "Идентификатор продавца должен состоять из 9 цифр")
    private String seller;
    @NotBlank
    @Pattern(regexp = "^\\d{9}$",
            message = "Идентификатор покупателя должен состоять из 9 цифр")
    private String customer;
    @Valid
    @NotNull
    private List<Product> products;
}
