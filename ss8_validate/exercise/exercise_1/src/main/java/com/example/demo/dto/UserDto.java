package com.example.demo.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = 5, max = 45, message = "tên có độ dài tối thiểu 5, tối đa 45 ký tự")
    @NotEmpty(message = "không được để trống")
    @Pattern(regexp = "^([A-Z][a-z]+[ ]+)*([A-Z][a-z]*)$", message = "Để tên + chữ lót hộ cái")
    private String firstName;

    @Size(min = 5, max = 45, message = "tên có độ dài tối thiểu 5, tối đa 45 ký tự")
    @NotEmpty(message = "không được để trống")
    @Pattern(regexp = "^[A-Z][a-z]+$", message = "Nhập tên cho đàng hoàng đi người ae")
    private String lastName;

    @NotEmpty(message = "Bạn trốn nợ mình biết gọi ai")
    @Pattern(regexp = "[0][1-9]{9}", message = "Số điện thoại phải có 10 số và bắt đầu bằng 0")
    private String phoneNumber;

    //    @NotNull(message = "tuổi ko được để trống")
    //có time tìm hiểu thêm
//    @NotEmpty
    @Min(value = 18, message = "tuổi của bạn phải lớn hơn hoặc bằng 18")
    private int age;

    @NotEmpty(message = "email ko được để trống")
    @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "email của người ae sai định dạng")
    private String email;

    public UserDto() {
    }

    public UserDto(String firstName, String lastName, String phoneNumber, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public UserDto(int id, String firstName, String lastName, String phoneNumber, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
