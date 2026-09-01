package test.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    @Test(dataProvider = "userData")
    public void createData(User user) {
        System.out.println(user);

    }

    @DataProvider(name = "userData")
    public User[] username() {

        User user1 = new User("Teo", 16, false);
        User user2 = new User("Ti", 18, false);
        User user3 = new User("An", 11, true);

        return new User[]{user1, user2, user3};
    }

    public static class User {
        private String username;
        private int age;
        private boolean gender;

        public User(String username, int age, boolean gender) {
            this.username = username;
            this.age = age;
            this.gender = gender;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public boolean isGender() {
            return gender;
        }

        public void setGender(boolean gender) {
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "User{" +
                    "username='" + username + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    '}';
        }
    }
}
