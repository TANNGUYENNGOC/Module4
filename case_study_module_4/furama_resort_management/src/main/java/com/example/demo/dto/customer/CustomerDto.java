package com.example.demo.dto.customer;

import com.example.demo.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.time.Period;

public class CustomerDto implements Validator {
    private int id;

    private CustomerType customerType;
    private String name;
    private String dateOfBirth;
    private boolean gender;
    private String idCard;
    private String phoneNumber;
    @Email
    private String email;
    private String address;
    private boolean flag;

    public CustomerDto() {
    }

    public CustomerDto(CustomerType customerType, String name, String dateOfBirth, boolean gender, String idCard, String phoneNumber, String email, String address) {
        this.customerType = customerType;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public CustomerDto(int id, CustomerType customerType, String name, String dateOfBirth, boolean gender, String idCard, String phoneNumber, String email, String address) {
        this.id = id;
        this.customerType = customerType;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public CustomerDto(int id, CustomerType customerType, String name, String dateOfBirth, boolean gender, String idCard, String phoneNumber, @Email String email, String address, boolean flag) {
        this.id = id;
        this.customerType = customerType;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        //Validate name
        if (customerDto.getName().matches("")) {
            errors.rejectValue("name", "name", "Tên khách hàng không được để trống.");
        } else if (!customerDto.getName().matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
            errors.rejectValue("name", "name", "Tên khách hàng không được chứa số. Và các kí tự đầu tiên của mỗi từ phải viết hoa.");
        }

        //Validate age of birth day
        String birthdayVal = customerDto.getDateOfBirth();
        if (birthdayVal.matches("")) {
            errors.rejectValue("dateOfBirth", "dateOfBirth", "Vui lòng chọn ngày sinh");
        } else {
            LocalDate dayOfBirth = LocalDate.parse(birthdayVal);
            LocalDate now = LocalDate.now();
            Period checkAge = Period.between(dayOfBirth, now);
            if (checkAge.getYears() < 18 | checkAge.getYears() > 100) {
                errors.rejectValue("dateOfBirth", "dateOfBirth", "Tuổi phải lớn hơn hoặc bằng 18 và nhỏ hơn 100");
            }
        }

        //Validate số điện thoại
        if (customerDto.getPhoneNumber().matches("")) {
            errors.rejectValue("phoneNumber", "phoneNumber", "Số điện thoại không được để trống");
        } else if (!customerDto.getPhoneNumber().matches("^0[0-9]{9}$")) {
            errors.rejectValue("phoneNumber", "phoneNumber", "Số điện thoại phải bắt đầu bằng 0 và có 10 số");
        }

        //Validate số CMND
        if (customerDto.getIdCard().matches("")) {
            errors.rejectValue("idCard", "idCard", "Số CMND phải không được để trống");
        } else if (!customerDto.getIdCard().matches("[0-9]{10}")) {
            errors.rejectValue("idCard", "idCard", "Số CMND phải là 10 số và không được chứa bất kì kí tự nào khác");
        }
        //Validate email
        if (customerDto.getEmail().matches("")) {
            errors.rejectValue("email", "email", "Email không được để trống");
        } else if (!customerDto.getEmail().matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            errors.rejectValue("email", "email", "Email không đúng định dạng");
        }

        // Validate địa chỉ
        if (customerDto.getAddress().matches("")) {
            errors.rejectValue("address", "address", "Bạn quịt nợ tôi biết tìm đâu");
        } else if (!customerDto.getAddress().matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
            errors.rejectValue("address", "address", "Ghi hoa chữ cái đầu");
        }
    }
}
