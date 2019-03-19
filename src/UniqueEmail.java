import java.util.HashSet;
import java.util.Set;

class UniqueEmail {
    public int numUniqueEmails(String[] emails) {
        String[] result = new String[emails.length];
        Set<String> set = new HashSet<>();
        for(int i=0; i< emails.length; i++){
            String email = emails[i];
            String[] splited = email.split("@");
            String full_local = splited[0], admin = splited[1];
            String local1 = full_local.split("\\+")[0];
            String local = local1.replace(".", "");
            String new_email = local + admin;
            set.add(new_email);
        }
        return set.size();
    }

    public static void main(String[] args) {
        UniqueEmail u = new UniqueEmail();
        String[] emails = {
                "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"
        };
        System.out.print(u.numUniqueEmails(emails));

    }
}