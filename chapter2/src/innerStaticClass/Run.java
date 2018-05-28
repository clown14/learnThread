package innerStaticClass;

import innerClass.PublicClass;

public class Run {
    public static void main(String[] args) {
        PublicClass publicClass = new PublicClass();
        publicClass.setUsername("usernameValue");
        publicClass.setPassword("passwordValue");
        System.out.println(publicClass.getUsername() + " " +
                publicClass.getPassword());
        innerStaticClass.PublicClass.PrivateClass privateClass = new innerStaticClass.PublicClass.PrivateClass();
        privateClass.setAge("ageValue");
        privateClass.setAddress("addressValue");
        System.out.println(privateClass.getAge() + " " +
                privateClass.getAddress());
    }
}
