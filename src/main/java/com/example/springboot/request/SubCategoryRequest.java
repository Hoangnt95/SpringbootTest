package com.example.springboot.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoryRequest {
    @NotNull(message = "Không được để trống")
    @Pattern(regexp = "SA[0-9]{4}",message = "Code phải theo định dạng SA+4 SỐ")
    private String subCode;

    @NotNull(message = "Không được bỏ trống")
    @Pattern(regexp = "[a-zA-Z]+",message = "Name nhập vào chỉ là chữ")
    private String subName;

    @NotNull(message = "Không được bỏ trống")
    private Long cateId;
}
