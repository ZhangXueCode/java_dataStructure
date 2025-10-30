
public class Test {
    private String userName = "admin";
    private String password = "123456";
    public  void loginlnfo(String userName,String password) throws UserNameException,PasswordException {
        if(!this.password.equals(password)) {
            throw new PasswordException("密码错误");
        }
        if(!this.userName.equals(userName)) {
            throw new UserNameException("用户名字错误");
        }
        System.out.println("登录成功");
    }

    public static void main(String[] args) {
        Test test = new Test();
        try {
           test.loginlnfo("adin","12345");
        }
        catch (UserNameException e) {
            e.printStackTrace();
            System.out.println("用户名字错误");
        }
        catch (PasswordException e) {
            e.printStackTrace();
            System.out.println("密码错误");
        }
    }
}
