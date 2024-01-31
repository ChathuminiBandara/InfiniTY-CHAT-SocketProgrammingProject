package lk.ijse.chatapplication.dto;

public class UserDto {
    private String pw;

    private String un;
    public UserDto(){}

    public UserDto(String pw, String un) {
        this.pw = pw;
        this.un = un;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getUn() {
        return un;
    }

    public void setUn(String un) {
        this.un = un;
    }

}
